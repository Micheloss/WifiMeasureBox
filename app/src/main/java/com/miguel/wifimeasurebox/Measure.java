package com.miguel.wifimeasurebox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by MiguelAngel on 15/04/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Measure {

    @JsonProperty("name")
    private String name;
    @JsonProperty("furthest")
    private int furthest;
    @JsonProperty("middle")
    private int middle;
    @JsonProperty("door")
    private int door;

    public Measure(String name, int furthest, int middle, int door) {
        this.name = name;
        this.furthest = furthest;
        this.middle = middle;
        this.door = door;
    }

    public Measure() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFurthest() {
        return furthest;
    }

    public void setFurthest(int furthest) {
        this.furthest = furthest;
    }

    public int getMiddle() {
        return middle;
    }

    public void setMiddle(int middle) {
        this.middle = middle;
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }
}
