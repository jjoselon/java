package org.jjoselon.jaxws.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import org.jjoselon.jaxws.models.Course;
import java.util.List;

@RequestScoped
public class CourseRepositoryImpl implements CourseRepository {

    @Inject
    private EntityManager em;

    @Override
    public List<Course> list() {
        return em.createQuery("from course", Course.class).getResultList();
    }

    @Override
    public Course save(Course course) {
        if (course.getId() > 0) {
            em.merge(course);
        } else {
            em.persist(course);
        }
        return course;
    }

    @Override
    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    @Override
    public void delete(Long id) {
        Course c = findById(id);
        em.remove(c);
    }
}
