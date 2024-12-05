package org.ies.building.components;

import org.ies.building.model.Apartment;
import org.ies.building.model.Building;

import java.util.Scanner;

public class BuildingReader {
    private final Scanner scanner;
    private final ApartmentReader apartmentReader;

    public BuildingReader(Scanner scanner, ApartmentReader apartmentReader) {
        this.scanner = scanner;
        this.apartmentReader = apartmentReader;
    }

    public Building read() {
        System.out.println("Ingrese los datos del edificio");
        System.out.println("Dirección: ");
        String address = scanner.nextLine();
        System.out.println("Municipio: ");
        String town = scanner.nextLine();

        int howManyApartments;
        do {
            System.out.println("¿Cúantos pisos hay en el edificio?");
            howManyApartments = scanner.nextInt();
            scanner.nextLine();
            if (howManyApartments < 1) {
                System.out.println("El edificio no puede tener menos de un apartamento");
            }
        } while (howManyApartments < 1);

        Apartment[] apartments = new Apartment[howManyApartments];
        for (int i = 0; i < howManyApartments; i++) {
            apartments[i] = apartmentReader.read();
        }

        return new Building(
                address,
                town,
                apartments
        );
    }
}
