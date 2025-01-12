package com.crm;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/ticket-tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TicketTaskResource {

    @Inject
    TicketTaskRepository ticketTaskRepository;

    @GET
    @Transactional
    public List<TicketTask> getAllTasks() {
        return ticketTaskRepository.listAll();
    }

    @GET
    @Path("/{id}")
    @Transactional
    public TicketTask getTask(@PathParam("id") String uuid) {
        return ticketTaskRepository.findByUuid(uuid);
    }

    @POST
    @Transactional
    public Response createTask(TicketTask task) {
        ticketTaskRepository.persist(task);
        return Response.status(Response.Status.CREATED).entity(task).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateTask(@PathParam("id") String uuid, TicketTask updatedTask) {
        TicketTask task = ticketTaskRepository.findByUuid(uuid);
        if (task == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        task.dateReminder = updatedTask.dateReminder;
        task.description = updatedTask.description;
        task.uuidUser = updatedTask.uuidUser;

        ticketTaskRepository.persist(task);
        return Response.ok(task).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteTask(@PathParam("id") String uuid) {
        boolean deleted = ticketTaskRepository.deleteByUuid(uuid);
        return deleted ? Response.noContent().build() : Response.status(Response.Status.NOT_FOUND).build();
    }
}
