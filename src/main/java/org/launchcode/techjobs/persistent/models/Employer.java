package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Employer extends AbstractEntity {

    //ARE THESE CONSTRUCTORS RIGHT???
    public Employer(){}

    public Employer(String location){
        super();
        this.location = location;
    }

    @NotNull
    @Size(max = 125)
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
