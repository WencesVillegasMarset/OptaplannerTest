package com.planner.firstoptaplanner;

//nuestro planning entity, que tiene un juez, room y timeslot.

public class Room {
    private Integer number;

    public Room(Integer number){
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
