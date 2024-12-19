package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.User;

import java.util.Optional;

public interface AuthService {

    User login(String username, String password);

    User findByUsername(String username);
}
