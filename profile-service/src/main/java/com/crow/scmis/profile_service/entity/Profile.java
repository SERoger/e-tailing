package com.crow.scmis.profile_service.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType = DiscriminatorType.STRING)
public class Profile {
    @Id
    @Column(length = 36)
    private String id;
    @Column(length = 45)
    private String name;
    @Column(length = 45)
    private String otherName;
    @Column(length = 50)
    private String email;
    @Column(length = 15)
    private String phoneNo;
    @Column(length = 100)
    private String address;

    public Profile() {
    }

    public Profile(String id, String name, String otherName, String email, String phoneNo, String address) {
        this.id = id;
        this.name = name;
        this.otherName = otherName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
