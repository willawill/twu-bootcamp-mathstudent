package com.twu.whatever;

/**
 * Created with IntelliJ IDEA.
 * User: mlam
 * Date: 10/08/12
 * Time: 10:35 AM
 * To change this template use File | Settings | File Templates.
 */
public enum VolumeUnit {
    LITER(1), GALLON(3.78);

    public double ratio;

    VolumeUnit(double ratio){
        this.ratio = ratio;
    }

}
