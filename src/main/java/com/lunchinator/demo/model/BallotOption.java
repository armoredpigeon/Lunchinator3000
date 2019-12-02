package com.lunchinator.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BallotOption implements Comparable<BallotOption>{
    @JsonProperty("Id")
    private final int id;
    @JsonProperty("restaurant")
    private final String name;
    @JsonProperty("rating")
    private int averageReview;
    @JsonProperty("review")
    private String Review;
    @JsonProperty("reviewer")
    private String TopReviewer;
    private LocalDateTime dateTime;
    private int votes;

    public BallotOption(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAverageReview() { return averageReview; }

    public String getReview() { return Review; }

    public String getTopReviewer() {
        return TopReviewer;
    }

    public void setTopReviewer(String topReviewer) {
        TopReviewer = topReviewer;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        BallotOption otherOption = (BallotOption) obj;
        return id == otherOption.getId() && (name != null && name.equals(otherOption.getName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        Integer idAsInteger = new Integer(id);
        result = prime * result + ((idAsInteger == null) ? 0 : idAsInteger.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public int compareTo(BallotOption otherOption){
        int idDiff = id - otherOption.getId();
        if(idDiff == 0){
            return 0;
        }
        return name.compareToIgnoreCase(otherOption.getName());
    }
}
