package org.ies.building.model;

import java.util.Objects;

public class Owner {
    private String nif;
    private String surname;
    private String name;

    public Owner(String nif, String surname, String name) {
        this.nif = nif;
        this.surname = surname;
        this.name = name;
    }

    public void showOwner() {
        System.out.println("        NIF: " + nif + " Nombre completo: " + name + " " + surname);
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(nif, owner.nif) && Objects.equals(surname, owner.surname) && Objects.equals(name, owner.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, surname, name);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "nif='" + nif + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
