package com.gamesmall.microservice.task.repositories;

import com.gamesmall.microservice.task.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<Task, Long> {
}
