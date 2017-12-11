package com.qisibajie.katas.bdd.cucumber;

public class NewYork extends CityObserver {
    private static final int UTC_OFFSET = -5;

    public NewYork(TimeSubject timeSubject, DaylightSavingTime dstStatus) {
        super(timeSubject, dstStatus);
    }

    public static NewYork newInstance(DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        return new NewYork(timeSubject, dstStatus);
    }

    @Override
    public void setTimeToTimeSubject(int localHour) {
        super.localHour = localHour;
        super.timeSubject.setHourUtcZero(convertLocalTimeToUtcZeroTime(super.localHour,
                NewYork.UTC_OFFSET, super.dstStatus));
    }

    @Override
    public void updateTimeOfCity(int hourUtcZero) {
        super.localHour = convertUtcZeroTimeToLocalTime(hourUtcZero, NewYork.UTC_OFFSET, super.dstStatus);
    }

    @Override
    public String getLocalHour() {
        return Integer.toString(super.localHour);
    }
}
