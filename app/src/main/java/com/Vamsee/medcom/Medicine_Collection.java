package com.Vamsee.medcom;

public class Medicine_Collection {

    String Address, City,Details, Mobile, Name, Resource;

    public Medicine_Collection() {}

    public Medicine_Collection(String address, String city, String details, String mobile, String name, String resource) {
        Address = address;
        City = city;
        Details = details;
        Mobile = mobile;
        Name = name;
        Resource = resource;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getResource() {
        return Resource;
    }

    public void setResource(String resource) {
        Resource = resource;
    }
}
