package org.ies.building.model;

import java.util.Arrays;
import java.util.Objects;

public class Apartment {
    private int flat;
    private String door;
    private Owner[] owners;

    public Apartment(int flat, String door, Owner[] owners) {
        this.flat = flat;
        this.door = door;
        this.owners = owners;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public Owner[] getOwners() {
        return owners;
    }

    public void setOwners(Owner[] owners) {
        this.owners = owners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return flat == apartment.flat && Objects.equals(door, apartment.door) && Objects.deepEquals(owners, apartment.owners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flat, door, Arrays.hashCode(owners));
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "flat=" + flat +
                ", door='" + door + '\'' +
                ", owners=" + Arrays.toString(owners) +
                '}';
    }
}
