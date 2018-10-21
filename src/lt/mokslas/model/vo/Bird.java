package lt.mokslas.model.vo;

import lt.mokslas.model.strategies.IActionStrategy;

public class Bird implements IAnimal{
    private String name;
    private String type;
    private float height;
    private float weight;
    private IActionStrategy strategy;


    public Bird(IActionStrategy parStrategy){
        strategy = parStrategy;

    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String parType) {
        type= parType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String parName) {
        name = parName;

    }

    @Override
    public float getWeight() {
        return weight;
    }

    @Override
    public void setWeight(float parWeight) {
        weight = parWeight;

    }

    @Override
    public float getHeight() {
        return height;
    }

    @Override
    public void setHeight(float parHeight) {
        height = parHeight;

    }

    @Override
    public void doAction() {
        strategy.doAction();

    }
    @Override
    public String toString(){
        doAction();
        return "Im a bird: " + super.toString();
    }
}
