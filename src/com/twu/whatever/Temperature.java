package com.twu.whatever;

public interface Temperature {
    double calculateValueInBaseUnit();

    int compareTemperature(Temperature other);


    public Object add(Temperature other, Class type);


}
