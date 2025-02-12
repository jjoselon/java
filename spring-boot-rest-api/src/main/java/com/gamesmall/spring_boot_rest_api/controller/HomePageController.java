package com.gamesmall.spring_boot_rest_api.controller;

import com.gamesmall.spring_boot_rest_api.bean.Student;
import com.gamesmall.spring_boot_rest_api.exception.HandleTimeoutException;
import com.gamesmall.spring_boot_rest_api.exception.ResourceNotFoundException;
import com.gamesmall.spring_boot_rest_api.model.User;
import com.gamesmall.spring_boot_rest_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomePageController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/")
    public String dashboard() {
        return "Hello World!";
    }

    @GetMapping("student")
    public Student getStudent() {
        return new Student("James", "Smith");
    }

    @GetMapping("students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("James", "Smith"));
        students.add(new Student("James", "Smith2"));
        return students;
    }

    @GetMapping("user/{id}")
    public ResponseEntity<User> studentPathVariable(@PathVariable Long id) {
        User user = userService.findUserById(id);
        if (user == null) {
            throw new ResourceNotFoundException("User not found", "id", id.toString());
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("timeout/{id}")
    public ResponseEntity<User> timeoutPath(@PathVariable Long id) {
        User user = userService.findUserById(id);
        if (user == null) {
            throw new HandleTimeoutException("Timeout", "id", id.toString());
        }
        return ResponseEntity.ok(user);
    }
}
