package cz.cellar.springboot;

public class CarBooking {

    private String carName;
    private double pricePerDay;
    private int numberOfDays;

    public CarBooking(String carName, double pricePerDay, int nbOfDays) {
        this.carName = carName;
        this.pricePerDay = pricePerDay;
        this.numberOfDays = nbOfDays;
    }

    public String getCarName() {
        return carName;
    }



    public double getPricePerDay() {
        return pricePerDay;
    }



    public int getNumberOfDays() {
        return numberOfDays;
    }

    public double getTotalPrice(){
        return pricePerDay * getNumberOfDays();
    }

}
