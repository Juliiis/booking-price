package sample;

import java.util.Random;

public class TravelDiscountRepository {

    public Integer getTravelDiscount(String travelId) {

        return new Random().nextInt(30);

    }



}
