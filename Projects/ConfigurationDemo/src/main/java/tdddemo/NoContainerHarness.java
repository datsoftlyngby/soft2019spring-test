package tdddemo;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class NoContainerHarness extends AbstractHarness{

    public static void main(String[] args) throws Exception {
        NoContainerHarness harness = new NoContainerHarness();
        harness.runHarness();
    }

      //returtype er redundant
    @Override
    TripPlanner configure() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, IOException {
       
        Properties prop = new Properties();
        prop.load(this.getClass().getResourceAsStream("/nocontainer-agency.properties"));
        String airline = prop.getProperty("airline-agency-class");
        String cab = prop.getProperty("cab-agency-class");
        String trip = prop.getProperty("trip-planner-class");
        
        Class airlineAgencyClass = Class.forName(airline);
        Class cabAgencyClass = Class.forName(cab);
        Class tripPlannerClass = Class.forName(trip);

        if (AirlineAgency.class.isAssignableFrom(airlineAgencyClass)) {
            // Instantiate airline agency
            airlineAgency = (AirlineAgency) airlineAgencyClass.newInstance();
        }
        if (CabAgency.class.isAssignableFrom(cabAgencyClass)) {
            // Instantiate CabAgency, and satisfy its dependency on an airlineagency.

            Constructor constructor = cabAgencyClass.getConstructor(new Class[]{AirlineAgency.class});
            cabAgency = (CabAgency) constructor.newInstance(new Object[]{airlineAgency});
        }
        if (TripPlanner.class.isAssignableFrom(tripPlannerClass)) {
            Constructor constructor = tripPlannerClass.getConstructor(new Class[]{AirlineAgency.class, CabAgency.class});
            tripPlanner = (TripPlanner) constructor.newInstance(new Object[]{airlineAgency, cabAgency});
        }
        return tripPlanner;

    }
}
