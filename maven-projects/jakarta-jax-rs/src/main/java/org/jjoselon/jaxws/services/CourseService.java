package org.jjoselon.jaxws.services;

import jakarta.ejb.Local;
import org.jjoselon.jaxws.models.Course;

import java.util.List;
import java.util.Optional;

@Local
public interface CourseService {
    List<Course> list();
    Course save(Course course);
    Optional<Course> findById(Long id);
    void delete(Long id);
}
