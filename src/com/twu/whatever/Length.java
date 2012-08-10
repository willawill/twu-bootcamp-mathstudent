package com.twu.whatever;

public class Length extends Unit{

    final double value;
    LengthUnit type;

      public Length(double value,LengthUnit type){
          this.value=value;
          this.type=type;
      }


    protected double calculateValueInBaseUnit() {
        return value*type.ratio;
    }

    private double calculateValueFromBaseUnit(double valueInBaseUnit){
        return valueInBaseUnit/type.ratio;

    }

    public Length add(Length another) {

        return new Length(calculateValueFromBaseUnit(this.calculateValueInBaseUnit()+another.calculateValueInBaseUnit()), this.type);
    }
}
