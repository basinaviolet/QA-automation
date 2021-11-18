package main.task4.structure;

import java.util.Arrays;
import java.util.Objects;

public class PassengerCar implements Taxi, Comparable<PassengerCar> {


    String licensePlate;
    String brand;
    String taxiType = "passenger";
    String bodyworkType;
    float price;
    float fuelConsumption;
    int[] speed;
    int startCost;

    public PassengerCar(String licensePlate,
                        String brand,
                        String taxiType,
                        String bodyworkType,
                        float price,
                        float fuelConsumption,
                        int[] speed,
                        int startCost) {
        super();
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.taxiType = taxiType;
        this.bodyworkType = bodyworkType;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.speed = speed;
        this.startCost = startCost;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTaxiType() {
        return taxiType;
    }

    public void setTaxiType(String taxiType) {
        this.taxiType = taxiType;
    }

    public String getBodyworkType() {
        return bodyworkType;
    }

    public void setBodyworkType(String bodyworkType) {
        this.bodyworkType = bodyworkType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int[] getSpeed() {
        return speed;
    }

    public void setSpeed(int[] speed) {
        this.speed = speed;
    }

    public int getStartCost() {
        return startCost;
    }

    public void setStartCost(int startCost) {
        this.startCost = startCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerCar)) return false;
        PassengerCar that = (PassengerCar) o;
        return Float.compare(that.getPrice(), getPrice()) == 0 && Float.compare(that.getFuelConsumption(), getFuelConsumption()) == 0 && getLicensePlate().equals(that.getLicensePlate()) && getBrand().equals(that.getBrand()) && getTaxiType().equals(that.getTaxiType()) && getBodyworkType().equals(that.getBodyworkType()) && Arrays.equals(getSpeed(), that.getSpeed());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getLicensePlate(), getBrand(), getTaxiType(), getBodyworkType(), getPrice(), getFuelConsumption());
        result = 31 * result + Arrays.hashCode(getSpeed());
        return result;
    }

    @Override
    public String toString() {
        return "PassengerCar{" +
                "licensePlate='" + licensePlate + '\'' +
                ", brand='" + brand + '\'' +
                ", taxiType='" + taxiType + '\'' +
                ", bodyworkType='" + bodyworkType + '\'' +
                ", price=" + price +
                ", fuelConsumption=" + fuelConsumption +
                ", speed=" + Arrays.toString(speed) +
                ", startCost=" + startCost +
                '}';
    }

    @Override
    public int compareTo(PassengerCar o) {
        return 0;
    }


}

