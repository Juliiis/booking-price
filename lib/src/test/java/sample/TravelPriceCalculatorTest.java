package sample;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class TravelPriceCalculatorTest {

    @Test
    void check_the_price_is_correct_for() {
        Integer travelId = 5;
        Integer timeOfTravelInSeconds = 300;
        Double travelRateInEurosPerSecond = 1.0;
        Double expectedResult = 300.0;

        TravelTimeCalculator travelTimeCalculator = mock(TravelTimeCalculator.class);
        TravelRateRepository travelRateRepository = mock(TravelRateRepository.class);
        TravelDiscountRepository travelDiscountRepository = mock(TravelDiscountRepository.class);
        TravelPriceCalculator travelPriceCalculator = new TravelPriceCalculator(travelTimeCalculator, travelRateRepository,travelDiscountRepository);
        when(travelTimeCalculator.getTravelTime(travelId.toString())).thenReturn(timeOfTravelInSeconds);
        when(travelRateRepository.getTravelRate(travelId.toString())).thenReturn(travelRateInEurosPerSecond);

        Double actualResult = travelPriceCalculator.getPrice(travelId.toString());


        Assertions.assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void check_if_the_travel_time_is_less_than_one_minute_the_return_is_zero(){
        Integer travelId = 15;
        Integer timeOfTravelInSeconds = 40;
        Double expectedResult = 0.0;

        TravelTimeCalculator travelTimeCalculator = mock(TravelTimeCalculator.class);
        TravelRateRepository travelRateRepository = mock(TravelRateRepository.class);
        TravelDiscountRepository travelDiscountRepository = mock(TravelDiscountRepository.class);
        TravelPriceCalculator travelPriceCalculator = new TravelPriceCalculator(travelTimeCalculator, travelRateRepository, travelDiscountRepository);
        when(travelTimeCalculator.getTravelTime(travelId.toString())).thenReturn(timeOfTravelInSeconds);

        Double actualResult = travelPriceCalculator.getPrice(travelId.toString());

        Assertions.assertThat(actualResult).isEqualTo(expectedResult);
    }


}