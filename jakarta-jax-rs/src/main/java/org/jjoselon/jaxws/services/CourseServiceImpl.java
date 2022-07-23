package org.jjoselon.jaxws.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.jjoselon.jaxws.models.Course;
import org.jjoselon.jaxws.repositories.CourseRepository;

import java.util.List;
import java.util.Optional;

@Stateless
public class CourseServiceImpl implements CourseService {

    @Inject
    private CourseRepository courseRepository;

    @Override
    public List<Course> list() {
        return courseRepository.list();
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Optional<Course> findById(Long id) {
        return Optional.ofNullable(courseRepository.findById(id));
    }

    @Override
    public void delete(Long id) {
        courseRepository.delete(id);
    }
}
