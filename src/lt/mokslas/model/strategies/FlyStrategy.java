package lt.mokslas.model.strategies;

public class FlyStrategy implements IActionStrategy {


    @Override
    public void doAction() {
        System.out.println("I Fly");
    }
}
