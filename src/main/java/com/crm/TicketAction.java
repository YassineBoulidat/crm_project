package com.crm;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket_actions")
public class TicketAction extends PanacheEntityBase {

    @Id
    @Column(name = "uuid_action", nullable = false)
    public String uuidAction;

    @JoinColumn(name = "ticket", nullable = false)
    public String ticket;

    @Column(name = "date_action")
    public LocalDateTime dateAction;

    @Enumerated(EnumType.STRING)
    @Column(name = "action_type", nullable = false)
    public ActionType actionType;

    @Column(name = "description")
    public String description;

    @Column(name = "uuid_user", nullable = false)
    public String uuidUser;

    public enum ActionType {
        CREATION, UPDATE, DELETION
    }
}
