package com.crm;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TicketTaskRepository implements PanacheRepository<TicketTask> {

    /**
     * Finds a TicketTask by UUID.
     *
     * @param uuid the UUID of the task
     * @return the TicketTask if found, null otherwise
     */
    public TicketTask findByUuid(String uuid) {
        return find("uuidTask", uuid).firstResult();
    }

    /**
     * Deletes a TicketTask by UUID.
     *
     * @param uuid the UUID of the task to delete
     * @return true if the task was deleted, false otherwise
     */
    public boolean deleteByUuid(String uuid) {
        return delete("uuidTask", uuid) > 0;
    }
}
