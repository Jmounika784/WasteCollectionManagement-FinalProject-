package com.waste.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "citizen")
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "citizen_name", nullable = false)
    private String citizenName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(name = "contact_number")
    private String contactNumber;

    private String email;

    @Column(name = "user_id", unique = true)
    private String userId;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public Citizen() {}

    public Integer getId() { return id; }
    public String getCitizenName() { return citizenName; }
    public String getPassword() { return password; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getContactNumber() { return contactNumber; }
    public String getEmail() { return email; }
    public String getUserId() { return userId; }
    public Role getRole() { return role; }

    public void setId(Integer id) { this.id = id; }
    public void setCitizenName(String citizenName) { this.citizenName = citizenName; }
    public void setPassword(String password) { this.password = password; }
    public void setAddress(String address) { this.address = address; }
    public void setCity(String city) { this.city = city; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public void setEmail(String email) { this.email = email; }
    public void setUserId(String userId) { this.userId = userId; }
    public void setRole(Role role) { this.role = role; }

	public String getZone() {
		// TODO Auto-generated method stub
		return null;
	}
}
