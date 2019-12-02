package com.lunchinator.demo.model;

public class Voter implements Comparable<Voter> {
    private final String voterName;
    private final String emailAddress;
    private int choiceId;

    public Voter(String name, String emailAddress){
        this.voterName = name;
        this.emailAddress = emailAddress;
    }

    public String getVoterName(){
        return voterName;
    }

    public String getEmailAddress(){
        return emailAddress;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        Voter otherVoter = (Voter) obj;
        return (voterName != null && voterName.equals(otherVoter.getVoterName()))
                && (emailAddress != null && emailAddress.equals(otherVoter.getEmailAddress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((voterName == null) ? 0 : voterName.hashCode());
        result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
        return result;
    }

    @Override
    public int compareTo(Voter otherVoter){
        int nameDiff = voterName.compareToIgnoreCase(otherVoter.getVoterName());
        if(nameDiff != 0){
            return nameDiff;
        }
        return emailAddress.compareToIgnoreCase(otherVoter.getEmailAddress());
    }
}
