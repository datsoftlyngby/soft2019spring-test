package tdddemo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public abstract class AbstractHarness {

    AirlineAgency airlineAgency = null;
    CabAgency cabAgency = null;
    TripPlanner tripPlanner = null;

    abstract TripPlanner configure() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException;

    public void runHarness() throws Exception {
        this.configure();
        this.getPlanner().planTrip(
                "1, Acme Street",
                "11111",
                "22222",
                new Date(System.currentTimeMillis() + 7200000));
    }

    TripPlanner getPlanner() {
        return tripPlanner;
    }

}
