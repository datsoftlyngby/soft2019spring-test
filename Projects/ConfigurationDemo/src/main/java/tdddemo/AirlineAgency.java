package tdddemo;

import java.util.Date;

interface AirlineAgency {

    public FlightSchedule bookTicket(String departingZipCode, String arrivalZipCode, Date preferredArrivalTime);
    
}
