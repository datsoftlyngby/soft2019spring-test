package tdddemo;

class ConstructorBasedCabAgency implements CabAgency {

    AirlineAgency airlineAgency = null;

    public ConstructorBasedCabAgency(AirlineAgency air) {
        airlineAgency = air;
    }

    @Override
    public void requestCab(String departingAddress, int flightNumber) {

    }
}
