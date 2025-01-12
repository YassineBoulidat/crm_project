package com.crm;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TicketActionRepository implements PanacheRepository<TicketAction> {

    /**
     * Finds a TicketAction by UUID.
     *
     * @param uuid the UUID of the action
     * @return the TicketAction if found, null otherwise
     */
    public TicketAction findByUuid(String uuid) {
        return find("uuidAction", uuid).firstResult();
    }

    /**
     * Deletes a TicketAction by UUID.
     *
     * @param uuid the UUID of the action to delete
     * @return true if the action was deleted, false otherwise
     */
    public boolean deleteByUuid(String uuid) {
        return delete("uuidAction", uuid) > 0;
    }
}
