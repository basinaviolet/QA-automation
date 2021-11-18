package main.task4.structure;

import java.util.Arrays;
import java.util.Objects;

public class EconomClass extends PassengerCar{

    int countOfPassengers;

    public EconomClass(String licensePlate, String brand, String taxiType, String bodyworkType,
                       float price, float fuelConsumption, int[] speed, int startCost,
                       int countOfPassengers) {
        super(licensePlate, brand, taxiType, bodyworkType, price, fuelConsumption, speed, startCost);
        this.countOfPassengers = this.countOfPassengers;
    }

    public int getCountOfPassengers() {
        return countOfPassengers;
    }

    public void setCountOfPassengers(int countOfPassengers) {
        this.countOfPassengers = countOfPassengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EconomClass)) return false;
        if (!super.equals(o)) return false;
        EconomClass that = (EconomClass) o;
        return getCountOfPassengers() == that.getCountOfPassengers();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCountOfPassengers());
    }

    @Override
    public String toString() {
        return "EconomClass{" +
                "licensePlate='" + licensePlate + '\'' +
                ", brand='" + brand + '\'' +
                ", taxiType='" + taxiType + '\'' +
                ", bodyworkType='" + bodyworkType + '\'' +
                ", price=" + price +
                ", fuelConsumption=" + fuelConsumption +
                ", speed=" + Arrays.toString(speed) +
                ", startCost=" + startCost +
                "countOfPassengers=" + countOfPassengers +
                '}';
    }
}
