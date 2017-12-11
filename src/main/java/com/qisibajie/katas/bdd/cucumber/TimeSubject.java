package com.qisibajie.katas.bdd.cucumber;

import java.util.HashMap;
import java.util.Iterator;

public class TimeSubject {

    private final HashMap<String, CityObserver> cityMap;
    private WillLogger LOGGER = WillLogger.getLogger(WillLogger.LEVEL_OFF);
    private int hourUtcZero;

    public TimeSubject() {
        this.cityMap = new HashMap<String, CityObserver>();
    }

    public static TimeSubject newInstance() {
        return new TimeSubject();
    }

    public void attach(String cityName, CityObserver cityObserver) {
        this.cityMap.put(cityName, cityObserver);
    }

    public CityObserver getCity(String cityName) {
        LOGGER.info("in TimeSubject.getCity().");
        if (this.cityMap.keySet().contains(cityName)) {
            LOGGER.info("contains: " + cityName);
            return this.cityMap.get(cityName);
        }
        throw new IllegalStateException("No city name in the city map.");
    }

    private void notifyAllCities() {
        LOGGER.info("in TimeSubject.notifyAllCities().");
        LOGGER.info("size of cityMap: " + this.cityMap.size());
        Iterator<String> cityNames = this.cityMap.keySet().iterator();
        LOGGER.info("cityNames.hasNext(): " + cityNames.hasNext());
        Iterator<CityObserver> cityObservers = this.cityMap.values().iterator();
        LOGGER.info("cityObservers.hasNext(): " + cityObservers.hasNext());
        while (cityObservers.hasNext()) {
            LOGGER.info("in loop");
            CityObserver cityObserver = cityObservers.next();
            cityObserver.updateTimeOfCity(this.hourUtcZero);
        }
    }

    public void setHourUtcZero(int hourUtcZero) {
        LOGGER.info("in TimeSubject.setHourUtcZero().");
        LOGGER.info("hourUtcZero: " + hourUtcZero);
        this.hourUtcZero = hourUtcZero;
        notifyAllCities();
    }
}
