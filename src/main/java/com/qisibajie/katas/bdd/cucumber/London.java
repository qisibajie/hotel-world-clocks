package com.qisibajie.katas.bdd.cucumber;

public class London extends CityObserver {
    private static final WillLogger LOGGER = WillLogger.getLogger(WillLogger.LEVEL_OFF);
    private static final int UTC_OFFSET = 0;

    public London(TimeSubject timeSubject, DaylightSavingTime dstStatus) {
        super(timeSubject, dstStatus);
    }

    public static London newInstance(DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        return new London(timeSubject, dstStatus);
    }

    @Override
    public void setTimeToTimeSubject(int localHour) {
        LOGGER.info("in London.setTimeToTimeSubject().");
        LOGGER.info("localHour: " + localHour);
        super.localHour = localHour;
        super.timeSubject.setHourUtcZero(convertLocalTimeToUtcZeroTime(super.localHour,
                London.UTC_OFFSET, super.dstStatus));
    }

    @Override
    public void updateTimeOfCity(int hourUtcZero) {
        LOGGER.info("in London.updateTimeOfCity().");
        LOGGER.info("utcZeroHour: " + hourUtcZero);
        super.localHour = convertUtcZeroTimeToLocalTime(hourUtcZero, London.UTC_OFFSET, super.dstStatus);
        LOGGER.info("localHour: " + super.localHour);
    }

    @Override
    public String getLocalHour() {
        LOGGER.info("in London.getLocalHour().");
        LOGGER.info("this.localHour: " + super.localHour);
        return Integer.toString(super.localHour);
    }
}
