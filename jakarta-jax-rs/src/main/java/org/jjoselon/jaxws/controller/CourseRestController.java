package org.jjoselon.jaxws.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jjoselon.jaxws.services.CourseService;
import org.jjoselon.jaxws.models.Course;

import java.util.Optional;

@RequestScoped
@Path("/courses")
@Produces(value = MediaType.APPLICATION_XML)
public class CourseRestController {

    @Inject
    private CourseService service;

    @GET
    public Response list() {
        return Response.ok(service.list()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam(value = "id") Long id) {
        Optional<Course> courseOptional = service.findById(id);

        if (courseOptional.isPresent()) {
            return Response.ok(courseOptional.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_XML)
    public Response save(Course course) {
        try {
            Course course1 = service.save(course);
            return Response.ok(course1).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(value = MediaType.APPLICATION_XML)
    public Response edit(@PathParam("id") Long id, Course course) {
        Optional<Course> courseOptional = service.findById(id);
        if (courseOptional.isPresent()) {
            Course course1 = courseOptional.get();
            course1.setName(course.getName());
            course1.setDescription(course.getDescription());
            course1.setPrice(course.getPrice());
            course1.setDuration(course.getDuration());
            course1.setInstructor(course.getInstructor());

            try {
                service.save(course1);
                return Response.ok(course1).build();
            } catch (Exception e) {
                e.printStackTrace();
                return Response.serverError().build();
            }
        }

        return Response.status(Response.Status.NOT_FOUND).build();

    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam(value = "id") Long id) {
        Optional<Course> courseOptional = service.findById(id);
        if (courseOptional.isPresent()) {
            try {
                service.delete(courseOptional.get().getId());
                return Response.noContent().build();
            } catch (Exception e) {
                e.printStackTrace();
                return Response.serverError().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
