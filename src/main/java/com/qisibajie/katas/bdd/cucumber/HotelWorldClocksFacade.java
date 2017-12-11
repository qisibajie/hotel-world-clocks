package com.qisibajie.katas.bdd.cucumber;

public class HotelWorldClocksFacade {
    private static final WillLogger LOGGER = WillLogger.getLogger(WillLogger.LEVEL_OFF);
    private TimeSubject timeSubject;

    public static HotelWorldClocksFacade newInstance() {
        return new HotelWorldClocksFacade();
    }

    public void testInitialization() {
        timeSubject = TimeSubject.newInstance();
    }

    public void addACityWithDstStatus(String cityName, DaylightSavingTime dstStatus) {
        if (cityName.equals("Beijing")) {
            timeSubject.attach(cityName, Beijing.newInstance(dstStatus, timeSubject));
            LOGGER.info("attached Beijing");
        }
        if (cityName.equals("London")) {
            timeSubject.attach(cityName, London.newInstance(dstStatus, timeSubject));
            LOGGER.info("attached London");
        }
        if (cityName.equals("Moscow")) {
            timeSubject.attach(cityName, Moscow.newInstance(dstStatus, timeSubject));
            LOGGER.info("attached Moscow");
        }
        if (cityName.equals("Sydney")) {
            timeSubject.attach(cityName, Sydney.newInstance(dstStatus, timeSubject));
            LOGGER.info("attached Sydney");
        }
        if (cityName.equals("New York")) {
            timeSubject.attach(cityName, NewYork.newInstance(dstStatus, timeSubject));
            LOGGER.info("attached New York");
        }
    }

    public void adjustIncorrectTimeOfCity(int hour, String cityName) {
        LOGGER.info("in HotelWorldClocksFacade.adjustIncorrectTimeOfCity().");
        LOGGER.info("hour: " + hour);
        LOGGER.info("cityName: " + cityName);
        timeSubject.getCity(cityName).setTimeToTimeSubject(hour);
    }

    public String getResultHour(String cityName) {
        LOGGER.info("in HotelWorldClocksFacade.getResultHour().");
        LOGGER.info("201309111003 cityName: " + cityName + "this.timeSubject: " + timeSubject.toString());
        return timeSubject.getCity(cityName).getLocalHour();
    }
}
