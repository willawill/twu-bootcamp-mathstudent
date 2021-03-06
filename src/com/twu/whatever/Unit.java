package com.twu.whatever;

public abstract class Unit<Type> {

    public int compareTemperature(Unit another) {
//        if(this.getClass() != another.getClass())
//            throw new IllegalArgumentException("Cannot compareTemperature Length & Volume");
        if(calculateValueInBaseUnit() > another.calculateValueInBaseUnit()) return 1;
        if(calculateValueInBaseUnit() < another.calculateValueInBaseUnit()) return -1;
        return 0;
    }

    protected abstract double calculateValueInBaseUnit();


//    public abstract <T> Unit add()
}
