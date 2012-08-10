package com.twu.whatever;

public enum LengthUnit {
    FEET (300),
    INCH(25),
    CENTIMETER(10),
    MILLIMETER(1);

    public double ratio;

    LengthUnit(double ratio){
        this.ratio = ratio;
    }

}
