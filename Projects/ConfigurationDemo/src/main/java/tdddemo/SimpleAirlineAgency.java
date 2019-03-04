package tdddemo;

import java.util.Date;

public class SimpleAirlineAgency implements AirlineAgency {

    public FlightSchedule bookTicket(String departingZipCode, String arrivalZipCode, Date preferredArrivalTime) {
        return new FlightSchedule();
    }
}
