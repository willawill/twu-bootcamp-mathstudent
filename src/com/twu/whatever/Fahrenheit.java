package com.twu.whatever;

public class Fahrenheit implements Temperature {
    private double value;
    public Fahrenheit(double value) {
        this.value = value;
    }

    @Override
    public double calculateValueInBaseUnit() {
        return value ;
    }

    public Celcius convertToCelcius(){
        return new Celcius((value - 32) * 5/9);
    }

    @Override
    public int compareTemperature(Temperature other) {
        if(calculateValueInBaseUnit() > other.calculateValueInBaseUnit()) return 1;
        if(calculateValueInBaseUnit() < other.calculateValueInBaseUnit()) return -1;
        return 0;
    }

    @Override
    public Object add(Temperature other, Class type) {
        if(type.isInstance(new Fahrenheit(1)))
        return addHelper(other);

        else
        return addHelper(other).convertToCelcius();
    }

    private Fahrenheit addHelper(Temperature other){
        return new Fahrenheit(this.calculateValueInBaseUnit() + other.calculateValueInBaseUnit()) ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fahrenheit that = (Fahrenheit) o;

        if (Double.compare(that.value, value) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        long temp = value != +0.0d ? Double.doubleToLongBits(value) : 0L;
        return (int) (temp ^ (temp >>> 32));
    }
}
