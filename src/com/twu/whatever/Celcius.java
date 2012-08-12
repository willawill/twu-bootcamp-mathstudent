package com.twu.whatever;

public class Celcius implements Temperature {
    private double value;

    public Celcius(double value) {
        this.value = value;
    }
                 //Baseunit is F
    @Override
    public double calculateValueInBaseUnit() {
        return 1.8 * value + 32;
    }

    @Override
    public int compareTemperature(Temperature other) {
        if (calculateValueInBaseUnit() > other.calculateValueInBaseUnit()) return 1;
        if (calculateValueInBaseUnit() < other.calculateValueInBaseUnit()) return -1;
        return 0;
    }

    @Override
    public Object add(Temperature other, Class type) {
        if (type.isInstance(new Celcius(1)))
            return addHelper(other).convertToCelcius();

        else
            return addHelper(other);
    }



    private Fahrenheit addHelper(Temperature other) {
        return new Fahrenheit(this.calculateValueInBaseUnit() + other.calculateValueInBaseUnit());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Celcius celcius = (Celcius) o;

        if (Double.compare(celcius.value, value) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        long temp = value != +0.0d ? Double.doubleToLongBits(value) : 0L;
        return (int) (temp ^ (temp >>> 32));
    }
}
