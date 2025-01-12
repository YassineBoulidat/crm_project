package com.crm;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket_tasks")
public class TicketTask extends PanacheEntityBase {

    @Id
    @Column(name = "uuid_task", nullable = false)
    public String uuidTask;

    @JoinColumn(name = "ticket", nullable = false)
    public String ticket;

    @Column(name = "date_reminder")
    public LocalDateTime dateReminder;

    @Column(name = "description")
    public String description;

    @Column(name = "uuid_user", nullable = false)
    public String uuidUser;

    // Getters and Setters
}
