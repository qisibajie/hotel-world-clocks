package com.qisibajie.katas.bdd.cucumber;

public class Moscow extends CityObserver {
    private static final int UTC_OFFSET = 4;

    public Moscow(TimeSubject timeSubject, DaylightSavingTime dstStatus) {
        super(timeSubject, dstStatus);
    }

    public static Moscow newInstance(DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        return new Moscow(timeSubject, dstStatus);
    }

    @Override
    public void setTimeToTimeSubject(int localHour) {
        super.localHour = localHour;
        super.timeSubject.setHourUtcZero(convertLocalTimeToUtcZeroTime(super.localHour, Moscow.UTC_OFFSET, super.dstStatus));
    }

    @Override
    public void updateTimeOfCity(int hourUtcZero) {
        super.localHour = convertUtcZeroTimeToLocalTime(hourUtcZero, Moscow.UTC_OFFSET, super.dstStatus);
    }

    @Override
    public String getLocalHour() {
        return Integer.toString(super.localHour);
    }
}
