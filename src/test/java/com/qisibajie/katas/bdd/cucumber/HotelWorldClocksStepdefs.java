package com.qisibajie.katas.bdd.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class HotelWorldClocksStepdefs {
    private HotelWorldClocksFacade hotelWorldClocksFacade;

    public HotelWorldClocksStepdefs() {
        hotelWorldClocksFacade = HotelWorldClocksFacade.newInstance();
    }

    @Given("^a hotel lobby has five clocks$")
    public void a_hotel_lobby_has_five_clocks() throws Throwable {
        hotelWorldClocksFacade.testInitialization();
    }

    @Given("^\"([^\"]*)\" is in the DST period$")
    public void is_in_the_DST_period(String cityName) throws Throwable {
        hotelWorldClocksFacade.addACityWithDstStatus(cityName, DaylightSavingTime.ACTIVE);
    }

    @Given("^\"([^\"]*)\" does not use the DST$")
    public void does_not_use_the_DST(String cityName) throws Throwable {
        hotelWorldClocksFacade.addACityWithDstStatus(cityName, DaylightSavingTime.INACTIVE);
    }

    @When("^I adjust the incorrect time of the clock of \"([^\"]*)\" to be (\\d+)$")
    public void I_adjust_the_incorrect_time_of_the_clock_of_to_be(String cityName, int hour) throws Throwable {
        hotelWorldClocksFacade.adjustIncorrectTimeOfCity(hour, cityName);
    }

    @Then("^the time of the clock of \"([^\"]*)\" should be (\\d+)$")
    public void the_time_of_the_clock_of_should_be(String cityName, int expectedHour) throws Throwable {
        assertEquals("The result hour is not the same with the expected hour", Integer.toString(expectedHour), hotelWorldClocksFacade.getResultHour(cityName));
    }

    @Given("^the DST period of \"([^\"]*)\" ends$")
    public void the_DST_period_of_ends(String cityName) throws Throwable {
        hotelWorldClocksFacade.addACityWithDstStatus(cityName, DaylightSavingTime.INACTIVE);
    }

    @Given("^the DST period of \"([^\"]*)\" does not end$")
    public void the_DST_period_of_does_not_end(String cityName) throws Throwable {
        hotelWorldClocksFacade.addACityWithDstStatus(cityName, DaylightSavingTime.ACTIVE);
    }

    @When("^I adjust the time of the clock of \"([^\"]*)\" to be (\\d+) due to the end of DST$")
    public void I_adjust_the_time_of_the_clock_of_to_be_due_to_the_end_of_DST(String cityName, int hour) throws Throwable {
        hotelWorldClocksFacade.adjustIncorrectTimeOfCity(hour, cityName);
    }

}
