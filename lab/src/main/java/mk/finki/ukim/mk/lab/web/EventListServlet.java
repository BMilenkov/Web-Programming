package mk.finki.ukim.mk.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import mk.finki.ukim.mk.lab.service.EventService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.servlet.IServletWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "eventListServlet", urlPatterns = "/events")
public class EventListServlet extends HttpServlet {
    private final EventService eventService;
    private final EventBookingService eventBookingService;
    private final SpringTemplateEngine springTemplateEngine;

    public EventListServlet(EventService eventService, EventBookingService eventBookingService,
                            SpringTemplateEngine springTemplateEngine) {
        this.eventService = eventService;
        this.eventBookingService = eventBookingService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JakartaServletWebApplication application = JakartaServletWebApplication.buildApplication(req.getServletContext());
        IServletWebExchange exchange = application.buildExchange(req, resp);
        WebContext context = new WebContext(exchange);

        context.setVariable("events", this.eventService.listAll());

        springTemplateEngine.process("listEvents.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JakartaServletWebApplication application = JakartaServletWebApplication.buildApplication(req.getServletContext());
        IServletWebExchange exchange = application.buildExchange(req, resp);
        WebContext context = new WebContext(exchange);

        String search = req.getParameter("search");
        if (search != null && !search.isEmpty()) {
            context.setVariable("events", this.eventService.searchEvents(search));
            springTemplateEngine.process("listEvents.html", context, resp.getWriter());
        } else {
            String name = req.getParameter("event");
            String attName = req.getParameter("attName");
            String address = req.getRemoteAddr();
            int numTickets = Integer.parseInt(req.getParameter("numTickets"));
            req.getSession().setAttribute("myBooking", eventBookingService.placeBooking(name, attName, address, numTickets));
            resp.sendRedirect("/eventBooking");
        }
    }
}
