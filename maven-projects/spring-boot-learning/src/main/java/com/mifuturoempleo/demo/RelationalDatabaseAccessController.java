package com.mifuturoempleo.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.mifuturoempleo.resourcerepresentationclass.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/relationaldatabaseaccess")
public class RelationalDatabaseAccessController {

    String customerName = "";

    @Autowired
    JdbcTemplate JdbcTemplate;

    @GetMapping(path = "/customer")
    public String findCustomer(Model model, @RequestParam(name = "name", required = true) String nameToFind) {
        JdbcTemplate.execute("DROP TABLE customers");
        JdbcTemplate
                .execute("CREATE TABLE customers (" + "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255) )");
        List<Object[]> splitUpNames = Arrays.asList("Jhon A", "Jeff B", "Josh C", "Jean D").stream()
                .map(name -> name.split(" ")).collect(Collectors.toList());

        JdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?, ?)", splitUpNames);

        JdbcTemplate.query(
            "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { nameToFind },
            (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
        ).forEach(customer -> customerName = customer.toString());

        model.addAttribute("customer", customerName);

        return "jdbc/customer";
    }

}
