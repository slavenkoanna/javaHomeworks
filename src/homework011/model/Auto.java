package homework011;

import java.util.List;

public class Auto implements homework011.CarsRepository {
    private String number;
    private String model;
    private String color;
    private int mileage;
    private int cost;

    public Auto(){


    }

    public Auto(String number, String model, String color, int mileage, int cost){
        this.number = number;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.cost = cost;

    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number){ this.number = number;
    }

    public String getModel(){ return model;}
    public void  setModel(String model){ this.model = model;}

    public String getColor(){ return color;}
    public void  setColor(String color){ this.color = color;}

    public int getMileage(){ return mileage;}
    public void  setMileage(int run){ this.mileage = mileage;}

    public int getCost(){ return cost;}
    public void  setCost(int cost){ this.cost = cost;}

    @Override
    public void modelToFind(String model) {

    }

    @Override
    public List<Auto> getAll() {
        return List.of();
    }

    public String toString() {
        return "Автомобиль{" +
                " номер: " + number +
                ", модель: " + model +
                ", цвет: " + color +
                ", пробег: " + mileage +
                ", стоимость: " + cost +
                " }";
    }

}
