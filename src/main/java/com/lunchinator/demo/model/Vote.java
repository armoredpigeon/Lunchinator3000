package com.lunchinator.demo.model;

public class Vote {
    private final Voter voter;
    private int restaurantId;

    public Vote(Voter voter, int restaurantId){
        this.voter = voter;
        this.restaurantId = restaurantId;
    }

    public Voter getVoter() {
        return voter;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
}
