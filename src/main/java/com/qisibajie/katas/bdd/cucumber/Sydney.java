package com.qisibajie.katas.bdd.cucumber;

public class Sydney extends CityObserver {
    private static final int UTC_OFFSET = 10;

    public Sydney(TimeSubject timeSubject, DaylightSavingTime dstStatus) {
        super(timeSubject, dstStatus);
    }

    public static Sydney newInstance(DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        return new Sydney(timeSubject, dstStatus);
    }

    @Override
    public void setTimeToTimeSubject(int localHour) {
        super.localHour = localHour;
        super.timeSubject.setHourUtcZero(convertLocalTimeToUtcZeroTime(super.localHour,
                Sydney.UTC_OFFSET, super.dstStatus));
    }

    @Override
    public void updateTimeOfCity(int hourUtcZero) {
        super.localHour = convertUtcZeroTimeToLocalTime(hourUtcZero, Sydney.UTC_OFFSET, super.dstStatus);
    }

    @Override
    public String getLocalHour() {
        return Integer.toString(super.localHour);
    }
}
