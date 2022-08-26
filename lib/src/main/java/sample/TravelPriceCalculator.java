package sample;

public class TravelPriceCalculator {

    private final TravelTimeCalculator travelTimeCalculator;
    private final TravelRateRepository travelRateRepository;
    private final TravelDiscountRepository travelDiscountRepository;

    public TravelPriceCalculator(TravelTimeCalculator travelTimeCalculator,
                                 TravelRateRepository travelRateRepository,
                                 TravelDiscountRepository travelDiscountRepository) {

        this.travelTimeCalculator = travelTimeCalculator;
        this.travelRateRepository = travelRateRepository;
        this.travelDiscountRepository = travelDiscountRepository;
    }

    public Double getPrice(String travelId) {

        Integer travelTimeInSeconds = travelTimeCalculator.getTravelTime(travelId);
        Double travelRate = travelRateRepository.getTravelRate(travelId);
        Integer travelDiscount = (travelDiscountRepository.getTravelDiscount(travelId)) / 100;

        if (travelTimeInSeconds >= 60) {
            return travelTimeInSeconds * travelRate;
        } else if (travelTimeInSeconds < 60) {
            return 0.0;
        }
        throw new RuntimeException("");
    }


}
