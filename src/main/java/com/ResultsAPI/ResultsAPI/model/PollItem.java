package com.ResultsAPI.ResultsAPI.model;

import javax.persistence.*;

@Entity
@Table(name = "Poll")
public class PollItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "votes")
    private long votes;


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getVotes() {
        return votes;
    }
    public void setVotes(long votes) {
        this.votes = votes;
    }

}
