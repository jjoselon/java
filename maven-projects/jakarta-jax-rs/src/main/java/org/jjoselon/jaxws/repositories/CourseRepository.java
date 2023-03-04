package org.jjoselon.jaxws.repositories;

import java.util.List;
import org.jjoselon.jaxws.models.Course;

public interface CourseRepository {
    List<Course> list();
    Course save(Course course);
    Course findById(Long id);
    void delete(Long id);

}
