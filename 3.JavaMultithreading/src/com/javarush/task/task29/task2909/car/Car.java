package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    protected final int MAX_TRUCK_SPEED = 80;
    protected final int MAX_SEDAN_SPEED = 120;
    protected final int MAX_CABRIOLET_SPEED = 90;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public static Car create(int type, int numberOfPassengers) {

        switch (type) {
            case TRUCK:
                return new Truck(numberOfPassengers);

            case SEDAN:
                return new Sedan(numberOfPassengers);

            default:
                return new Cabriolet(numberOfPassengers);
        }
    }

    private boolean canPassengersBeTransferred() {
        return isDriverAvailable() && fuel!=0;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
            throw new Exception();

        fuel += numberOfLiters;

    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        return date.before(summerEnd) && date.after(summerStart);
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

    public double getWinterConsumption (int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {

        if (!isSummer(date, SummerStart, SummerEnd)){
            return getWinterConsumption(length);
        }
        else return getSummerConsumption(length);

    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (!canPassengersBeTransferred())
            return 0;

        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        fastenDriverBelt();
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed(); //{


        //if (type == TRUCK)
        //    return MAX_TRUCK_SPEED;
        //if (type == SEDAN)
        //    return MAX_SEDAN_SPEED;
        //return MAX_CABRIOLET_SPEED;
    //}

}