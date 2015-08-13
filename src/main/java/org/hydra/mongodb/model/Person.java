package org.hydra.mongodb.model;

import org.springframework.data.annotation.Id;

public class Person {
 
    //id will be used for storing MongoDB _id
    @Id
    private String id;
     
    private String name;
    private Address address;
     
    public Person(){}
    public Person(String n, Address a){
        this.name=n;
        this.address=a;
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
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
     
    @Override
    public String toString(){
        return id+"::"+name+"::"+address;
    }
}