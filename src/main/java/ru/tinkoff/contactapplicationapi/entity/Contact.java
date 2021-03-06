package ru.tinkoff.contactapplicationapi.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CONTACT")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CONTACT_ID")
    private long id;

    @OneToMany(mappedBy = "contact")
    private Set<Applications> applications;

    public Contact() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Applications> getApplications() {
        return applications;
    }

    public void setApplications(Set<Applications> applications) {
        this.applications = applications;
    }
}