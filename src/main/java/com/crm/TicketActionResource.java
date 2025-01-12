package com.crm;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/ticket-actions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TicketActionResource {

    @Inject
    TicketActionRepository ticketActionRepository;

    @GET
    @Transactional
    public List<TicketAction> getAllActions() {
        return ticketActionRepository.listAll();
    }

    @GET
    @Path("/{id}")
    @Transactional
    public TicketAction getAction(@PathParam("id") String uuid) {
        return ticketActionRepository.findByUuid(uuid);
    }

    @POST
    @Transactional
    public Response createAction(TicketAction action) {
        ticketActionRepository.persist(action);
        return Response.status(Response.Status.CREATED).entity(action).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateAction(@PathParam("id") String uuid, TicketAction updatedAction) {
        TicketAction action = ticketActionRepository.findByUuid(uuid);
        if (action == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        action.dateAction = updatedAction.dateAction;
        action.actionType = updatedAction.actionType;
        action.description = updatedAction.description;
        action.uuidUser = updatedAction.uuidUser;

        ticketActionRepository.persist(action);
        return Response.ok(action).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteAction(@PathParam("id") String uuid) {
        boolean deleted = ticketActionRepository.deleteByUuid(uuid);
        return deleted ? Response.noContent().build() : Response.status(Response.Status.NOT_FOUND).build();
    }
}
