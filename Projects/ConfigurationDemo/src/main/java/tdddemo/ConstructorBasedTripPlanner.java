package tdddemo;

import java.util.Date;

class ConstructorBasedTripPlanner implements TripPlanner {

    AirlineAgency airlineAgency = null;
    CabAgency cabAgency = null;

    public ConstructorBasedTripPlanner(AirlineAgency air, CabAgency cab) {
        airlineAgency = air;
        cabAgency = cab;
    }

    @Override
    public void planTrip(String departingAddress, String departingZipCode,
            String arrivalZipCode, Date preferredArrivalTime) {

        //ticket booking scheduling activity 
        FlightSchedule schedule = airlineAgency.bookTicket(departingZipCode, arrivalZipCode, preferredArrivalTime);
        //cab pickup scheduling activity
        cabAgency.requestCab(departingAddress, schedule.getFlightNumber());
        
        //Test output
        System.out.println("Test output: trip planned");
    }

}
