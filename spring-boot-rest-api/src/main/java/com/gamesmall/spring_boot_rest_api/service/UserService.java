package com.gamesmall.spring_boot_rest_api.service;

import com.gamesmall.spring_boot_rest_api.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private static final Map<Long, User> usersDatabase = new HashMap<>();

    static {
        usersDatabase.put(1L, new User(1L, "John Doe"));
        usersDatabase.put(2L, new User(2L, "Jane Smith"));
    }

    public User findUserById(Long id) {
        return usersDatabase.get(id);  // Simula consulta a base de datos
    }
}
