package com.crm;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TicketRepository implements PanacheRepository<Ticket> {

    /**
     * Finds a Ticket by UUID.
     *
     * @param uuid the UUID of the ticket
     * @return the Ticket if found, null otherwise
     */
    public Ticket findByUuid(String uuid) {
        return find("uuidTicket", uuid).firstResult();
    }

    /**
     * Deletes a Ticket by UUID.
     *
     * @param uuid the UUID of the ticket to delete
     * @return true if the ticket was deleted, false otherwise
     */
    public boolean deleteByUuid(String uuid) {
        return delete("uuidTicket", uuid) > 0;
    }
}
