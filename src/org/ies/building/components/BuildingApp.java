package org.ies.building.components;

import java.util.Scanner;

public class BuildingApp {
    private final BuildingReader buildingReader;
    private final Scanner scanner;

    public BuildingApp(BuildingReader buildingReader, Scanner scanner) {
        this.buildingReader = buildingReader;
        this.scanner = scanner;
    }

    public void run() {
        System.out.println("Ingrese los datos del edificio");
        var building = buildingReader.read();

        int option;
        do {
            option = askOption();

            if (option == 1) {
                building.showBuilding();
            } else if (option == 2) {
                int floor = askFloor();
                String door = askDoor();
                building.showApartment(door, floor);
            } else if (option == 3) {
                int floor = askFloor();
                building.showFloor(floor);
            } else if (option == 4) {
                int floor = askFloor();
                String door = askDoor();
                building.showOwners(door, floor);
            } else if (option == 5) {
                System.out.println("¡Hasta luego!");
            }

        } while (option != 5);
    }

    public int askFloor() {
        System.out.println("Ingrese el número de una planta:");
        int floor = scanner.nextInt();
        scanner.nextLine();
        return floor;
    }

    public String askDoor() {
        System.out.println("Ingrese la letra/número de una puerta:");
        return scanner.nextLine();
    }

    public int askOption() {
        int option;
        do {
            System.out.println("Elija una opción:");
            System.out.println("1. Mostrar toda la información del edificio");
            System.out.println("2. Buscar un apartamento");
            System.out.println("3. Buscar apartamentos en una planta");
            System.out.println("4. Buscar a los propietarios de un apartamento");
            System.out.println("5. Salir");
            option = scanner.nextInt();
            if (option < 1 || option > 5) {
                System.out.println("Opción inválida, inténtelo de nuevo");
            }
        } while (option < 1 || option > 5);
        return option;
    }
}
