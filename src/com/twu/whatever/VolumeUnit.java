package com.twu.whatever;

public enum VolumeUnit {
    LITER(1), GALLON(3.78);

    public double ratio;

    VolumeUnit(double ratio){
        this.ratio = ratio;
    }

}
