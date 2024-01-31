package model;

public enum SeasonType {

    WINTER(.75), SPRING(2.0), SUMMER(1.0), FALL(1.25);

    private final double rate;

    SeasonType(double rate) {
        this.rate = rate;
    }

    public double getValue() {
        return rate;
    }


}
