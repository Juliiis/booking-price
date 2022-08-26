package sample;

import java.util.Random;

public class TravelRateRepository {
    /**
     * this function return the rate of the travel.
     * Example: 0.20€ / seconds in the car.
     * @param travelId
     * @return this function return the rate of the travel
     */
    public Double getTravelRate(String travelId) {

        return new Random().nextDouble();

    }
}
