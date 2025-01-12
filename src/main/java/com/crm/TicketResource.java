package com.crm;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/tickets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TicketResource {

    @Inject
    TicketRepository ticketRepository;

    @GET
    @Transactional
    public List<Ticket> getAllTickets() {
        return ticketRepository.listAll();
    }

    @GET
    @Path("/{id}")
    @Transactional
    public Ticket getTicket(@PathParam("id") String uuid) {
        return ticketRepository.findByUuid(uuid);
    }

    @POST
    @Transactional
    public Response createTicket(Ticket ticket) {
        ticketRepository.persist(ticket);
        return Response.status(Response.Status.CREATED).entity(ticket).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateTicket(@PathParam("id") String uuid, Ticket updatedTicket) {
        Ticket ticket = ticketRepository.findByUuid(uuid);
        if (ticket == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        ticket.title = updatedTicket.title;
        ticket.description = updatedTicket.description;
        ticket.dateUpdate = updatedTicket.dateUpdate;
        ticket.status = updatedTicket.status;
        ticket.priority = updatedTicket.priority;
        ticket.requestType = updatedTicket.requestType;
        ticket.source = updatedTicket.source;
        ticket.comments = updatedTicket.comments;

        ticketRepository.persist(ticket);
        return Response.ok(ticket).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteTicket(@PathParam("id") String uuid) {
        boolean deleted = ticketRepository.deleteByUuid(uuid);
        return deleted ? Response.noContent().build() : Response.status(Response.Status.NOT_FOUND).build();
    }
}
