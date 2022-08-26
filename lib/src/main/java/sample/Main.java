package sample;

public class Main {
    public static void main(String[] args) {
        Integer travelId = 5;

        TravelTimeCalculator travelTimeCalculator = new TravelTimeCalculator();
        TravelRateRepository travelRateRepository = new TravelRateRepository();
        TravelDiscountRepository travelDiscountRepository = new TravelDiscountRepository();

        TravelPriceCalculator travelPriceCalculator = new TravelPriceCalculator(travelTimeCalculator, travelRateRepository, travelDiscountRepository);

        Double result = travelPriceCalculator.getPrice(travelId.toString());
        System.out.println(result);

    }
}
