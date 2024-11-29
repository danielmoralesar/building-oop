package org.ies.building.components;

import org.ies.building.model.Owner;

import java.util.Scanner;

public class OwnerReader {
    private final Scanner scanner;

    public OwnerReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Owner read() {
        System.out.println("Ingrese los datos del propietario:");
        System.out.println("Ingrese el NIF del propietario:");
        String nif = scanner.nextLine();
        System.out.println("Ingrese los apellidos del propietario");
        String surname = scanner.nextLine();
        System.out.println("Ingrese el nombre del propietario");
        String name = scanner.nextLine();

        return new Owner(
                nif,
                surname,
                name
        );
    }
}
