package lt.mokslas.controller;

import lt.mokslas.model.AnimalSingleton;
import lt.mokslas.model.vo.IAnimal;
import lt.mokslas.view.Menu;

import java.util.Scanner;

public class Controller {

    public Controller() {
        int pasirinkimas = 0;
        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu();
        while (pasirinkimas != 3) {
            menu.showMenu();

            pasirinkimas = sc.nextInt();
            switch (pasirinkimas) {
                case 3:
                    break;
                case 1:
                    AnimalSingleton.getInstance().readAnimals();
                    System.out.println("Is viso yra "+AnimalSingleton.getInstance().getAnimalsCount()+ "guvunu");
                    break;
                case 2:
                    //info atvaizdavimas apie viena gyvuna
                    System.out.println("Iveskite gyvuno numeri nuo 0 iki "+(AnimalSingleton.getInstance().getAnimalsCount()-1));
                    int index = sc.nextInt();
                    IAnimal obj = AnimalSingleton.getInstance().getAnimalByIndex(index);
                    System.out.println(obj);
                    break;
            }


        }
    }
}
