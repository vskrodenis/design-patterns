package lt.mokslas.model;

import lt.mokslas.model.strategies.FlyStrategy;
import lt.mokslas.model.strategies.IActionStrategy;
import lt.mokslas.model.strategies.SneakStrategy;
import lt.mokslas.model.strategies.WalkStrategy;
import lt.mokslas.model.vo.Bird;
import lt.mokslas.model.vo.Cat;
import lt.mokslas.model.vo.Dog;
import lt.mokslas.model.vo.IAnimal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AnimalSingleton {

    private static AnimalSingleton instance;

    private AnimalSingleton() {

    }

    public static AnimalSingleton getInstance() {
        if (instance == null) {
            instance = new AnimalSingleton();
        }
        return instance;
    }


    private IAnimal[] animals;

    public void readAnimals() {
        int animalCount = 0;
        Scanner sc = null;
        try {

            sc = new Scanner(new File("data.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (sc != null) {
            while (sc.hasNext()) {
                animalCount++;
                sc.nextLine();
            }
            sc.close();
            try {

                sc = new Scanner(new File("data.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            animals = new IAnimal[animalCount];
            int i = 0;
            while (sc.hasNext()) {
                animals[i] = getAnimal(sc);
                i++;
            }
        }
    }

    private IAnimal getAnimal(Scanner sc) {
        String animal = sc.next();
        String type = sc.next();
        String name = sc.next();
        float weight = sc.nextFloat();
        float height = sc.nextFloat();
        String action = sc.next();
        IAnimal result = null;
        switch (animal.toLowerCase()) {
            case "cat":
                result = new Cat(getStrategy(action));
                break;
            case "dog":
                result = new Dog(getStrategy(action));
                break;
            case "pigeon":
                result = new Bird(getStrategy(action));
                break;

        }
        result.setName(name);
        result.setType(type);
        result.setHeight(height);
        result.setWeight(weight);
        return result;
    }

    private IActionStrategy getStrategy(String name) {
        switch (name.toLowerCase()) {
            case "walk":
                return new WalkStrategy();
            case "sneak":
                return new SneakStrategy();
            case "Fly":
                return new FlyStrategy();
        }
        return null;
    }

    public int getAnimalsCount(){
        return animals.length;
    }
    public IAnimal getAnimalByIndex(int index){
        return animals[index];
    }
}
