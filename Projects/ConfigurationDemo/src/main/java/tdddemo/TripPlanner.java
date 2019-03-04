package tdddemo;

import java.util.Date;

interface TripPlanner {
    public void planTrip(String departingAddress, String departingZipCode, String arrivalZipCode, Date preferredArrivalTime);
}
