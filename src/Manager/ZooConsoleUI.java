package Manager;

import enums.*;
import model.*;

import java.util.Scanner;


public class ZooConsoleUI {
    private final ZooParkManager manager;
    private final Scanner scanner;

    public ZooConsoleUI(ZooParkManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void start() throws IllegalStateException {
        while (true) {
            System.out.println("Enter a command:");
            System.out.println("1. List all animals");
            System.out.println("2. List animals by type");
            System.out.println("3. List animals by attribute");
            System.out.println("4. Get animal by name");
            System.out.println("5. Get any animal by type");
            System.out.println("6. Remove animal by name");
            System.out.println("7. Add an animal");
            System.out.println("8. Update animal name");
            System.out.println("9. Compare two animals");
            System.out.println("10. Save and exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manager.printAllAnimals();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Enter animal type:");
                    String type = scanner.nextLine();
                    manager.printAnimalsByType(type);
                    break;
                case 3:
                    System.out.println("Enter attribute (legs, predator, color, area):");
                    String attribute = scanner.nextLine();
                    System.out.println("Enter value:");
                    String value = scanner.nextLine();
                    manager.printAnimalsByAttribute(attribute, value);
                    break;
                case 4:
                    System.out.println("Enter animal name:");
                    String name = scanner.nextLine();
                    Animal animal = manager.getAnimalByName(name);
                    if (animal != null) {
                        System.out.println(animal);
                    } else {
                        System.out.println("Animal not found.");
                    }
                    break;
                case 5:
                    System.out.println("Enter animal type:");
                    String animalType = scanner.nextLine();
                    Animal anyAnimal = manager.getAnyAnimalByType(animalType);
                    if (anyAnimal != null) {
                        System.out.println(anyAnimal);
                    } else {
                        System.out.println("Animal not found.");
                    }
                    break;
                case 6:
                    System.out.println("Enter animal name to remove:");
                    String removeName = scanner.nextLine();
                    manager.removeAnimalByName(removeName);
                    manager.saveAnimalsToFile();
                    break;
                case 7:
                    System.out.println("Enter and choice animal details (type, name, legs, predator, color, area):");
                    boolean validInput = true;
                    String typeAdd = null;
                    do {
                        validInput = true;
                        System.out.println("Choice type \n1.bear \n2.kangaroo \n3.penguin \n4.tiger \n5.wolf");
                        switch (scanner.nextInt()) {
                            case 1 -> typeAdd = Type.BEAR.getValue();
                            case 2 -> typeAdd = Type.KANGAROO.getValue();
                            case 3 -> typeAdd = Type.PENGUIN.getValue();
                            case 4 -> typeAdd = Type.TIGER.getValue();
                            case 5 -> typeAdd = Type.WOLF.getValue();
                            default -> {
                                System.out.println("Unexpected value");
                                validInput = false;
                            }
                        }
                    }while (!validInput);
                    scanner.nextLine();
                    System.out.println("Enter name");
                    String nameAdd = scanner.nextLine();
                    System.out.println("Enter legs");
                    int legsAdd = scanner.nextInt();
                    System.out.println("Is Predator? \n1.Yes \n2.No");
                    boolean predatorAdd = switch (scanner.nextInt()) {
                        case 1 -> true;
                        default -> false;
                    };
                    System.out.println("Choice color: \n 1.Black \n 2.Gray \n 3.Yellow \n 4.White");
                    String colorAdd = switch (scanner.nextInt()) {
                        case 1 -> Color.BLACK.getValue();
                        case 2 -> Color.GRAY.getValue();
                        case 3 -> Color.YELLOW.getValue();
                        case 4 -> Color.WHITE.getValue();
                        default -> throw new IllegalStateException("Unexpected value");
                    };
                    System.out.println("Choice area: \n1.eurasia \n2.Africa \n3.North America \n4.South America \n5.Australia \n6.Antarctica");
                    String areaAdd = switch (scanner.nextInt()) {
                        case 1 -> Area.EURASIA.getValue();
                        case 2 -> Area.AFRICA.getValue();
                        case 3 -> Area.NORTH_AMERICA.getValue();
                        case 4 -> Area.SOUTH_AMERICA.getValue();
                        case 5 -> Area.AUSTRALIA.getValue();
                        case 6 -> Area.ANTARCTICA.getValue();
                        default -> throw new IllegalStateException("Unexpected value");
                    };
                    switch (typeAdd) {
                        case "wolf":
                            manager.animals.add(new Wolf(nameAdd, legsAdd, predatorAdd, Color.valueOf(colorAdd), Area.valueOf(areaAdd)));
                            break;
                        case "bear":
                            manager.animals.add(new Bear(nameAdd, legsAdd, predatorAdd, Color.valueOf(colorAdd), Area.valueOf(areaAdd)));
                            break;
                        case "kangaroo":
                            manager.animals.add(new Kangaroo(nameAdd, legsAdd, predatorAdd, Color.valueOf(colorAdd), Area.valueOf(areaAdd)));
                            break;
                        case "penguin":
                            manager.animals.add(new Penguin(nameAdd, legsAdd, predatorAdd, Color.valueOf(colorAdd), Area.valueOf(areaAdd)));
                            break;
                        case "tiger":
                            manager.animals.add(new Tiger(nameAdd, legsAdd, predatorAdd, Color.valueOf(colorAdd), Area.valueOf(areaAdd)));
                            break;
                    }
                    manager.saveAnimalsToFile();
                    break;
                case 8:
                    System.out.println("Enter old animal name:");
                    String oldName = scanner.nextLine();
                    System.out.println("Enter new animal name:");
                    String newName = scanner.nextLine();
                    manager.updateAnimalName(oldName, newName);
                    manager.saveAnimalsToFile();
                    break;
                case 9:
                    System.out.println("Enter name of first animal:");
                    String animal1Name = scanner.nextLine();
                    System.out.println("Enter name of second animal:");
                    String animal2Name = scanner.nextLine();
                    manager.compareTwoAnimals(animal1Name, animal2Name);
                    break;
                case 10:
                    manager.saveAnimalsToFile();
                    System.out.println("Animals saved. Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
