package com.interview.springbootinterview.springbeanscontainer.inyeccionporcampo;

import com.interview.springbootinterview.springbeanscontainer.beans.RepositoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Index {

    @Autowired
    private RepositoryDTO repositoryDTO;

    public String execute() {
        return repositoryDTO.create();
    }

}
