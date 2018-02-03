package com.example.sinki.model;

/**
 * Created by Sinki on 9/9/2017.
 */

public class Contact {
    private String id;
    private String name;
    private Phone phone;

    public Contact(String id, String name, Phone phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Contact() {
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

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return this.id + "-" + this.name + "\n" + this.phone;
    }
}
