package com.gamesmall.microservice.task.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public String title;
    public String description;
    public boolean done;

    public Task() {

    }

    public Task(String hacerLaComida, String noSeHace, boolean b) {
    }
}
