package com.waste.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "complaint")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "complaint_id", unique = true, nullable = false)
    private String complaintId;

    @Column(nullable = false)
    private String issue;

    @Column(nullable = false)
    private String address;

    @Column(name = "requested_date", nullable = false)
    private String requestedDate;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String zone;

    public Complaint() {}

    public Integer getId() { return id; }
    public String getComplaintId() { return complaintId; }
    public String getIssue() { return issue; }
    public String getAddress() { return address; }
    public String getRequestedDate() { return requestedDate; }
    public String getStatus() { return status; }
    public String getCity() { return city; }
    public String getZone() { return zone; }

    public void setId(Integer id) { this.id = id; }
    public void setComplaintId(String complaintId) { this.complaintId = complaintId; }
    public void setIssue(String issue) { this.issue = issue; }
    public void setAddress(String address) { this.address = address; }
    public void setRequestedDate(String requestedDate) { this.requestedDate = requestedDate; }
    public void setStatus(String status) { this.status = status; }
    public void setCity(String city) { this.city = city; }
    public void setZone(String zone) { this.zone = zone; }
}
