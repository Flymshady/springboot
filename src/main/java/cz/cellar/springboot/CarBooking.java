package cz.cellar.springboot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String carName;
    private double pricePerDay;
    private int numberOfDays;

    public CarBooking(){};

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

    public long getId(){
        return id;
    }

}
