package com.example.sample.Agencies;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String contact;
    private String region;
    private String certificationType;

    // Default constructor (required by JPA)
    public Agency() {
    }

    // Optional: Parameterized constructor
    public Agency(String name, String email, String contact, String region, String certificationType) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.region = region;
        this.certificationType = certificationType;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getContact() { return contact; }
    public String getRegion() { return region; }
    public String getCertificationType() { return certificationType; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setContact(String contact) { this.contact = contact; }
    public void setRegion(String region) { this.region = region; }
    public void setCertificationType(String certificationType) { this.certificationType = certificationType; }

    // Optional: toString()
    @Override
    public String toString() {
        return "Agency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", region='" + region + '\'' +
                ", certificationType='" + certificationType + '\'' +
                '}';
    }

}
