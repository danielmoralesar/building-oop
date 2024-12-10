import org.ies.building.components.ApartmentReader;
import org.ies.building.components.BuildingApp;
import org.ies.building.components.BuildingReader;
import org.ies.building.components.OwnerReader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var ownerReader = new OwnerReader(scanner);
        var apartmentReader = new ApartmentReader(scanner, ownerReader);
        var buildingReader = new BuildingReader(scanner, apartmentReader);
        var buildingApp = new BuildingApp(buildingReader, scanner);

        System.out.println("¡Bienvenido!");
        buildingApp.run();
    }
}