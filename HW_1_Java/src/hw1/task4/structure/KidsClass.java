package main.task4.structure;

import java.util.Arrays;
import java.util.Objects;

public class KidsClass extends EconomClass{

    boolean kidsPlace = true;
    int countOfKidsPlace;

    public KidsClass(String licensePlate, String brand, String taxiType, String bodyworkType,
                     float price, float fuelConsumption, int[] speed, int startCost,
                     int countOfPassengers,
                     boolean kidsPlace, int countOfKidsPlace) {
        super(licensePlate, brand, taxiType, bodyworkType, price, fuelConsumption, speed, startCost,
                countOfPassengers);
        this.kidsPlace = kidsPlace;
        this.countOfKidsPlace = countOfKidsPlace;
    }

    public boolean isKidsPlace() {
        return kidsPlace;
    }

    public void setKidsPlace(boolean kidsPlace) {
        this.kidsPlace = kidsPlace;
    }

    public int getCountOfKidsPlace() {
        return countOfKidsPlace;
    }

    public void setCountOfKidsPlace(int countOfKidsPlace) {
        this.countOfKidsPlace = countOfKidsPlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KidsClass)) return false;
        if (!super.equals(o)) return false;
        KidsClass kidsClass = (KidsClass) o;
        return isKidsPlace() == kidsClass.isKidsPlace() && getCountOfKidsPlace() == kidsClass.getCountOfKidsPlace();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isKidsPlace(), getCountOfKidsPlace());
    }

    @Override
    public String toString() {
        return "KidsClass{" +
                "licensePlate='" + licensePlate + '\'' +
                ", brand='" + brand + '\'' +
                ", taxiType='" + taxiType + '\'' +
                ", bodyworkType='" + bodyworkType + '\'' +
                ", price=" + price +
                ", fuelConsumption=" + fuelConsumption +
                ", speed=" + Arrays.toString(speed) +
                ", startCost=" + startCost +
                "countOfPassengers=" + countOfPassengers +
                "kidsPlace=" + kidsPlace +
                ", countOfKidsPlace=" + countOfKidsPlace +
                '}';
    }
}
