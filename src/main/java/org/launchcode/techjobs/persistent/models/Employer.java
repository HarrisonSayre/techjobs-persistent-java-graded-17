package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    //ARE THESE CONSTRUCTORS RIGHT???
    public Employer(){}

    public Employer(String location){
        super();
        this.location = location;
    }

    //Passes tests. Hope it's right? HIBERNATE ERROR?
    @OneToMany//(mappedBy = "employer")
    @JoinColumn(name="employer_id")
    private final List<Job> jobs = new ArrayList<>();

        @NotNull
        @Size(max = 75, min =1)
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }
}
