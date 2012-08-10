package com.twu.whatever;

public class Volume extends Unit{

    private double value;
    private VolumeUnit type;

    public Volume(double value, VolumeUnit type) {
        this.value = value;
        this.type = type;
    }

    protected double calculateValueInBaseUnit() {
        return this.value*this.type.ratio;
    }

    private double calculateValueFromBaseUnit(double valueInBaseUnit){
        return valueInBaseUnit/type.ratio;

    }

    public Volume add(Volume another) {

        return new Volume(calculateValueFromBaseUnit(this.calculateValueInBaseUnit()+another.calculateValueInBaseUnit()), this.type);
    }


}
