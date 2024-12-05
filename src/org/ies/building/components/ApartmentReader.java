package org.ies.building.components;

import org.ies.building.model.Apartment;
import org.ies.building.model.Owner;

import java.util.Scanner;

public class ApartmentReader {
    private final Scanner scanner;
    private final OwnerReader OwnerReader;

    public ApartmentReader(Scanner scanner, org.ies.building.components.OwnerReader ownerReader) {
        this.scanner = scanner;
        OwnerReader = ownerReader;
    }

    public Apartment read() {
        System.out.println("Ingrese los datos del apartamento");
        System.out.println("¿Cuál es la planta del piso?");
        int flat = scanner.nextInt();
        scanner.nextLine();
        System.out.println("¿Cuál es la puerta?");
        String door = scanner.nextLine();

        int howManyOwners;
        do {
            System.out.println("¿Cúantos propietarios tiene el piso?");
            howManyOwners = scanner.nextInt();
            scanner.nextLine();
            if (howManyOwners < 1) {
                System.out.println("El piso debe tener al menos un propietario");
            }
        } while (howManyOwners < 1);

        Owner[] owners = new Owner[howManyOwners];
        for (int i = 0; i < howManyOwners; i++) {
            owners[i] = OwnerReader.read();
        }

        return new Apartment(
                flat,
                door,
                owners
        );
    }
}
