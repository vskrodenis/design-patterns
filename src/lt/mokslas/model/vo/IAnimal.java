package lt.mokslas.model.vo;

public interface IAnimal {

    String getType();
    void setType(String parType);

    String getName();
    void setName(String parName);


    float getWeight();
    void setWeight(float parWeight);


    float getHeight();

    void setHeight(float parHeight);


    void doAction();


}
