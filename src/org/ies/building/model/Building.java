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

    public Apartment findApartment(String door, int floor) {
        for (var apartment : apartments) {
            if (apartment.getFloor() == floor && apartment.getDoor().equals(door)) {
                return apartment;
            }
        }
        return null;
    }

    public boolean checkFloor(int floor) {
        boolean areThereApartments = false;
        for (var apartment : apartments) {
            if (apartment.getFloor() == floor) {
                areThereApartments = true;
                break;
            }
        }
        return areThereApartments;
    }

    public void showFloor(int floor) {
        if (checkFloor(floor)) {
            for (var apartment : apartments) {
                if (apartment.getFloor() == floor) {
                    apartment.showApartment();
                }
            }
        } else {
            System.out.println("No existe la planta, intentelo de nuevo");
        }
    }

    public Owner[] findOwners(String door, int floor) {
        var apartment = findApartment(door, floor);
        if (apartment != null) {
            return apartment.getOwners();
        } else {
            return null;
        }
    }

    public void showApartment(String door, int floor) {
        var apartment = findApartment(door, floor);
        if (apartment != null) {
            apartment.showApartment();
        } else {
            System.out.println("No existe el apartamento");
        }
    }

    public void showOwners(String door, int floor) {
        if (findApartment(door, floor) != null) {
            Owner[] owners = findOwners(door, floor);
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
