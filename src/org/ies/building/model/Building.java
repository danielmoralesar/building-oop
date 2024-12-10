package org.ies.building.model;

import java.util.Arrays;
import java.util.Objects;

public class Building {
    private String address;
    private String town;
    private Apartment[] apartments;

    public Building(String address, String town, Apartment[] apartments) {
        this.address = address;
        this.town = town;
        this.apartments = apartments;
    }

    public void showBuilding() {
        System.out.println("Dirección: " + getAddress() + " Municipio: " + getTown() + " Apartamentos: ");
        for (var apartment : apartments) {
            apartment.showApartment();
        }
    }

    public Apartment findApartment(String door, int flat) {
        for (var apartment : apartments) {
            if (apartment.getFlat() == flat && apartment.getDoor().equals(door)) {
                return apartment;
            }
        }
        return null;
    }

    public void showFlat(int flat) {
        for (var apartment : apartments) {
            if (apartment.getFlat() == flat) {
                apartment.showApartment();
            }
        }
    }

    public Owner[] findOwners(String door, int flat) {
        var apartment = findApartment(door, flat);
        if (apartment != null) {
            return apartment.getOwners();
        } else {
            return null;
        }
    }

    public void showApartment(String door, int flat) {
        var apartment = findApartment(door, flat);
        if (apartment != null) {
            apartment.showApartment();
        } else {
            System.out.println("No existe el apartamento");
        }
    }

    public void showOwners(String door, int flat) {
        if (findApartment(door, flat) != null) {
            Owner[] owners = findOwners(door, flat);
            for (var owner : owners) {
                owner.showOwner();
            }
        } else {
            System.out.println("No existe el apartamento");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Apartment[] getApartments() {
        return apartments;
    }

    public void setApartments(Apartment[] apartments) {
        this.apartments = apartments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return Objects.equals(address, building.address) && Objects.equals(town, building.town) && Objects.deepEquals(apartments, building.apartments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, town, Arrays.hashCode(apartments));
    }

    @Override
    public String toString() {
        return "Building{" +
                "address='" + address + '\'' +
                ", town='" + town + '\'' +
                ", apartments=" + Arrays.toString(apartments) +
                '}';
    }
}
