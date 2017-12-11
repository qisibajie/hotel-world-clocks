package com.qisibajie.katas.bdd.cucumber;

public class Beijing extends CityObserver {
    private static final WillLogger LOGGER = WillLogger.getLogger(WillLogger.LEVEL_OFF);
    private static final int UTC_OFFSET = 8;

    public Beijing(DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        super(timeSubject, dstStatus);
    }

    public static Beijing newInstance(DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        return new Beijing(dstStatus, timeSubject);
    }

    @Override
    public void setTimeToTimeSubject(int localHour) {
        LOGGER.info("in Beijing.setTimeToTimeSubject().");
        LOGGER.info("localHour: " + localHour);
        super.localHour = localHour;
        super.timeSubject.setHourUtcZero(convertLocalTimeToUtcZeroTime(super.localHour,
                Beijing.UTC_OFFSET, super.dstStatus));
    }

    @Override
    public void updateTimeOfCity(int hourUtcZero) {
        LOGGER.info("in Beijing.updateTimeOfCity()");
        LOGGER.info("hourUtcZero: " + hourUtcZero);
        super.localHour = convertUtcZeroTimeToLocalTime(hourUtcZero, Beijing.UTC_OFFSET, super.dstStatus);
    }

    @Override
    public String getLocalHour() {
        LOGGER.info("in Beijing.getLocalHour().");
        LOGGER.info("this.localHour: " + super.localHour);
        return Integer.toString(super.localHour);
    }
}
