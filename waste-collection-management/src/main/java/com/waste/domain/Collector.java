package com.waste.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "collector")
public class Collector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "collector_name", nullable = false)
    private String collectorName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String zone;

    @Column(nullable = false)
    private String city;

    @Column(name = "contact_number")
    private String contactNumber;

    private String email;

    @Column(name = "employee_id", unique = true)
    private String employeeId;

    private Boolean approved;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public Collector() {}

    public Integer getId() { return id; }
    public String getCollectorName() { return collectorName; }
    public String getPassword() { return password; }
    public String getZone() { return zone; }
    public String getCity() { return city; }
    public String getContactNumber() { return contactNumber; }
    public String getEmail() { return email; }
    public String getEmployeeId() { return employeeId; }
    public Boolean getApproved() { return approved; }
    public Role getRole() { return role; }

    public void setId(Integer id) { this.id = id; }
    public void setCollectorName(String collectorName) { this.collectorName = collectorName; }
    public void setPassword(String password) { this.password = password; }
    public void setZone(String zone) { this.zone = zone; }
    public void setCity(String city) { this.city = city; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public void setEmail(String email) { this.email = email; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public void setApproved(Boolean approved) { this.approved = approved; }
    public void setRole(Role role) { this.role = role; }
}
