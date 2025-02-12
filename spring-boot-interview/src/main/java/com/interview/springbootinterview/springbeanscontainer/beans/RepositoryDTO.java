package com.interview.springbootinterview.springbeanscontainer.beans;

import com.interview.springbootinterview.springbeanscontainer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class RepositoryDTO {

    /* Injection by field */

    @Autowired
    private User user;

    /* Injection by constructor */

    /*
    @Autowired
    public RepositoryDTO(User user) {
        this.user = user;
    }
    */

    /* Setter injection */

    /*
    @Autowired
    public void setUser(User user) {
        this.user = user;
    }
     */

    public String create() {
        return "Created" + user.getName();
    }
}
