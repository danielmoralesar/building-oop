package org.ies.building.components;

import java.util.Scanner;

public class BuildingApp1 {
    private final BuildingReader buildingReader;
    private final Scanner scanner;

    public BuildingApp1(BuildingReader buildingReader, Scanner scanner) {
        this.buildingReader = buildingReader;
        this.scanner = scanner;
    }

    public void run() {
        var building = buildingReader.read();
        System.out.println("Consulte un apartamento");
        System.out.print("Ingrese un piso: ");
        int floor = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese una puerta: ");
        String door = scanner.nextLine();
        var apartment = building.findApartment(door, floor);
        if (apartment != null) {
            apartment.showApartment();
        } else {
            System.out.println("No se ha encontrado el apartamento");
        }
        building.showFloor(2);
    }
}
