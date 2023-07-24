package com.speckyfox.performanceevent.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String companyName;
    private String designation;
    private String mobileNumber;
    private boolean isPtNeeded;
    private boolean isAnyPtToolUsed;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_event",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private Set<Events> events = new HashSet<>();

    public Users(Long id, String firstName, String lastName, String email, String companyName, String designation, String mobileNumber, boolean isPtNeeded, boolean isAnyPtToolUsed) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.companyName = companyName;
        this.designation = designation;
        this.mobileNumber = mobileNumber;
        this.isPtNeeded = isPtNeeded;
        this.isAnyPtToolUsed = isAnyPtToolUsed;
    }

    public Users() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public boolean isPtNeeded() {
        return isPtNeeded;
    }

    public void setPtNeeded(boolean ptNeeded) {
        isPtNeeded = ptNeeded;
    }

    public boolean isAnyPtToolUsed() {
        return isAnyPtToolUsed;
    }

    public void setAnyPtToolUsed(boolean anyPtToolUsed) {
        isAnyPtToolUsed = anyPtToolUsed;
    }

    public Set<Events> getEvents() {
        return events;
    }

    public void setEvents(Set<Events> events) {
        this.events = events;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                ", designation='" + designation + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", isPtNeeded=" + isPtNeeded +
                ", isAnyPtToolUsed=" + isAnyPtToolUsed +
                ", events=" + events +
                '}';
    }
}
