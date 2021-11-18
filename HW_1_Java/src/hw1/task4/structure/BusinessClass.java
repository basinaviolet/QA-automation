package main.task4.structure;

import java.util.Arrays;
import java.util.Objects;

public class BusinessClass extends PassengerCar{

    int numberOfBusinessClass;

    public BusinessClass(String licensePlate, String brand, String taxiType, String bodyworkType,
                         float price, float fuelConsumption, int[] speed, int startCost,
                         int numberOfBusinessClass) {
        super(licensePlate, brand, taxiType, bodyworkType, price, fuelConsumption, speed, startCost);
        this.numberOfBusinessClass = numberOfBusinessClass;
    }

    public int getNumberOfBusinessClass() {
        return numberOfBusinessClass;
    }

    public void setNumberOfBusinessClass(int numberOfBusinessClass) {
        this.numberOfBusinessClass = numberOfBusinessClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusinessClass)) return false;
        if (!super.equals(o)) return false;
        BusinessClass that = (BusinessClass) o;
        return getNumberOfBusinessClass() == that.getNumberOfBusinessClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNumberOfBusinessClass());
    }

    @Override
    public String toString() {
        return "BusinessClass{" +
                "licensePlate='" + licensePlate + '\'' +
                ", brand='" + brand + '\'' +
                ", taxiType='" + taxiType + '\'' +
                ", bodyworkType='" + bodyworkType + '\'' +
                ", price=" + price +
                ", fuelConsumption=" + fuelConsumption +
                ", speed=" + Arrays.toString(speed) +
                ", startCost=" + startCost +
                "numberOfBusinessClass=" + numberOfBusinessClass +
                '}';
    }
}
