//package services;
//
//import api.open_weather.CityOwResponse;
//import api.weatherstack.CityWsResponse;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class WeatherServiceTest {
//
//    @Test
//    void getWeatherFromOpenWeather() {
//        //given
//        final String cityNameToFind = "Warsaw";
//        //when
//        final CityOwResponse response = (CityOwResponse) new ApiWeatherService().getWeatherFromWeatherApi(cityNameToFind,CityOwResponse.class);
//        //then
//        final String resultCityName = response.getName();
//        Assertions.assertEquals(resultCityName, cityNameToFind);
//    }
//    @Test
//    void shouldNotGetWeatherFromOpenWeather() {
//        //given
//        final String cityNameToFind = "111";
//        //when
//        final CityOwResponse response = (CityOwResponse) new ApiWeatherService().getWeatherFromWeatherApi(cityNameToFind, CityOwResponse.class);
//        //then
//        final String resultCityName = response.getName();
//        Assertions.assertEquals(resultCityName, cityNameToFind);
//    }
//
//
//}