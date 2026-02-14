package com.waste.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String message;

    private String zone;

    @ManyToOne
    @JoinColumn(name = "citizen_id")
    private Citizen citizen;

    public Feedback() {}

    public Integer getId() { return id; }
    public String getMessage() { return message; }
    public String getZone() { return zone; }
    public Citizen getCitizen() { return citizen; }

    public void setId(Integer id) { this.id = id; }
    public void setMessage(String message) { this.message = message; }
    public void setZone(String zone) { this.zone = zone; }
    public void setCitizen(Citizen citizen) { this.citizen = citizen; }
}
