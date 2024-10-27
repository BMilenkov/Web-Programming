package mk.finki.ukim.mk.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.servlet.IServletWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "eventBookingServlet", urlPatterns = "/eventBooking")
public class EventBookingServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;

    public EventBookingServlet(SpringTemplateEngine springTemplateEngine) {
        super();
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JakartaServletWebApplication application = JakartaServletWebApplication.buildApplication(req.getServletContext());
        IServletWebExchange exchange = application.buildExchange(req, resp);
        WebContext context = new WebContext(exchange);

        springTemplateEngine.process("bookingConfirmation.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
