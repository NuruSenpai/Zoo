import Manager.ZooConsoleUI;
import Manager.ZooParkManager;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        ZooParkManager manager = new ZooParkManager();
        ZooConsoleUI ui = new ZooConsoleUI(manager);
        ui.start();


    }


}
