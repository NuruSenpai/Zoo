package Manager;

import enums.Area;
import enums.Color;
import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ZooParkManager {
    public List<Animal> animals;
    private static final String FILENAME = "animals.txt";

    public ZooParkManager() {
        animals = new ArrayList<>();
        loadAnimalsFromFile();
    }

    private void loadAnimalsFromFile() {
        try (Scanner scanner = new Scanner(new File(FILENAME))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 6) {
                    String type = parts[0];
                    switch (type) {
                        case "wolf":
                            animals.add(new Wolf(parts[1], Integer.parseInt(parts[2]), Boolean.parseBoolean(parts[3]), Color.valueOf(parts[4]), Area.valueOf(parts[5])));
                            break;
                        case "bear":
                            animals.add(new Bear(parts[1], Integer.parseInt(parts[2]), Boolean.parseBoolean(parts[3]), Color.valueOf(parts[4]), Area.valueOf(parts[5])));
                            break;
                        case "kangaroo":
                            animals.add(new Kangaroo(parts[1], Integer.parseInt(parts[2]), Boolean.parseBoolean(parts[3]), Color.valueOf(parts[4]), Area.valueOf(parts[5])));
                            break;
                        case "penguin":
                            animals.add(new Penguin(parts[1], Integer.parseInt(parts[2]), Boolean.parseBoolean(parts[3]), Color.valueOf(parts[4]), Area.valueOf(parts[5])));
                            break;
                        case "tiger":
                            animals.add(new Tiger(parts[1], Integer.parseInt(parts[2]), Boolean.parseBoolean(parts[3]), Color.valueOf(parts[4]), Area.valueOf(parts[5])));
                            break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + FILENAME);
        }
    }

    public void saveAnimalsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Animal animal : animals) {
                writer.println(animal.getType() + "," + animal.getName() + "," + animal.getLegsCount() + "," + animal.isPredator() + "," + animal.color + "," + animal.area);
            }
        } catch (IOException e) {
            System.out.println("Error saving animals to file: " + e.getMessage());
        }
    }


    public void printAllAnimals() {
        animals.forEach(animal -> System.out.println(animal.toString()));
    }

    public void printAnimalsByType(String type) {
        for (Animal animal : animals) {
            if (animal.getType().equalsIgnoreCase(type)) {
                System.out.println(animal);
            }
        }
    }

    public void printAnimalsByAttribute(String attribute, String value) {
        for (Animal animal : animals) {
            switch (attribute) {
                case "legs":
                    if (animal.getLegsCount() == Integer.parseInt(value)) {
                        System.out.println(animal);
                    }
                    break;
                case "predator":
                    if (animal.isPredator() == Boolean.parseBoolean(value)) {
                        System.out.println(animal);
                    }
                    break;
                case "color":
                    if (animal.getColor() == Color.valueOf(value)) {
                        System.out.println(animal);
                    }
                    break;
                case "area":
                    if (animal.getArea() == Area.valueOf(value)) {
                        System.out.println(animal);
                    }
                    break;
                default:
                    System.out.println("Invalid attribute: " + attribute);
            }
        }
    }

    public Animal getAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }

    public Animal getAnyAnimalByType(String type) {
        for (Animal animal : animals) {
            if (animal.getType().equalsIgnoreCase(type)) {
                return animal;
            }
        }
        return null;
    }

    public void removeAnimalByName(String name) {
        animals.removeIf(animal -> animal.getName().equalsIgnoreCase(name));
        saveAnimalsToFile();

    }

    public void updateAnimalName(String oldName, String newName) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(oldName)) {
                animal.name = newName;
                saveAnimalsToFile();
                return;
            }
        }
        System.out.println("Animal with name '" + oldName + "' not found.");
    }

    public void compareTwoAnimals(String animal1Name, String animal2Name) {
        try {
            String[] animal1 = String.valueOf(getAnimalByName(animal1Name)).split(",");
            String[] animal2 = String.valueOf(getAnimalByName(animal2Name)).split(",");
            System.out.println(Arrays.toString(animal1));
            System.out.println(Arrays.toString(animal2));
            System.out.println();
            System.out.println("The type: " + (animal1[0].equals(animal2[0]) ? "matches" : "mismatch"));
            System.out.println("The number of legs: " + (animal1[2].equals(animal2[2]) ? "matches" : "mismatch"));
            System.out.println("The predator or not: " + (animal1[3].equals(animal2[3]) ? "matches" : "mismatch"));
            System.out.println("The color: " + (animal1[4].equals(animal2[4]) ? "matches" : "mismatch"));
            System.out.println("The area: " + (animal1[5].equals(animal2[5]) ? "matches" : "mismatch"));
            System.out.println();
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("One of the names is entered incorrectly: " + animal1Name + "or" + animal2Name);
        }

    }

}
