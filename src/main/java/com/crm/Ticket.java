package com.crm;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket extends PanacheEntityBase {

    @Id
    @Column(name = "uuid_ticket", nullable = false)
    public String uuidTicket;

    @Column(name = "uuid_client", nullable = false)
    public String uuidClient;

    @Column(name = "title", nullable = false)
    public String title;

    @Column(name = "description")
    public String description;

    @Column(name = "date_created", nullable = false)
    public LocalDateTime dateCreated;

    @Column(name = "date_update")
    public LocalDateTime dateUpdate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    public Status status;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority", nullable = false)
    public Priority priority;

    @Enumerated(EnumType.STRING)
    @Column(name = "request_type", nullable = false)
    public RequestType requestType;

    @Enumerated(EnumType.STRING)
    @Column(name = "source", nullable = false)
    public Source source;

    @Column(name = "comments", nullable = false)
    public String comments;

    // Getters and Setters (or use Lombok for brevity)

    public enum Status {
        UNSTARTED, IN_PROGRESS, ENDED, CANCELLED
    }

    public enum Priority {
        LOW, NORMAL, HIGH
    }

    public enum RequestType {
        SUPPORT, FEATURE_REQUEST, BUG_REPORT
    }

    public enum Source {
        EMAIL, PHONE, VISIT, WEB_FORM
    }
}
