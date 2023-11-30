package services;

import api.HttpClientService;
import api.WeatherApiService;
import api.dto.CityWeatherDto;
//import api.open_weather.CityOwResponse;
//import api.weatherbit.CityWbResponse;
//import api.weatherstack.CityWsResponse;

//public class ApiWeatherService<T> {

/*    public T getWeatherFromWeatherApi(String cityName, Class<T> responseClass) {
//        String baseUrl = "";
//        String appIsQuery = "";
//        String cityNameQuery = "";
//        String unitsQuery = "";

//        if (responseClass.equals(CityOwResponse.class)) {
//            baseUrl = "https://api.openweathermap.org/data/2.5/weather?";
//            appIsQuery = "appid=716238e6166ce6e1315daf3232959cd3";
//            cityNameQuery = "q=" + cityName;
//            unitsQuery = "units=metric";
//        } else if (responseClass.equals(CityWsResponse.class)) {
//            baseUrl = "http://api.weatherstack.com/current?";
//            appIsQuery = "access_key=0265d146105fc401377ecbfca92e4fb0";
//            cityNameQuery = "query=" + cityName;
//            unitsQuery = "";
//        } else if (responseClass.equals(CityWbResponse.class)){
//            //http://api.weatherbit.io/v2.0/current?key=d74a3b255a1d411bae7fa4029a91e696&lang=en&units=metrics&city=Warsaw
//            baseUrl = "http://api.weatherbit.io/v2.0/current?";
//            appIsQuery = "key=d74a3b255a1d411bae7fa4029a91e696&lang";
//            cityNameQuery = "&city=" + cityName;
//            unitsQuery = "&units=metrics";
//        }

//        String openWeatherUrl = baseUrl + appIsQuery + "&" + cityNameQuery + "&" + unitsQuery;

        WeatherApiService weatherApiService = new WeatherApiService();
        CityWeatherDto dataFromOpenWeather = weatherApiService.getDataFromOpenWeather(cityName);
        CityWeatherDto dataFromWeatherStack = weatherApiService.getDataFromWeatherStack(cityName);
        CityWeatherDto dataFromWeatherBit = weatherApiService.getDataFromWeatherBit(cityName);


//        var httpClientService = new HttpClientService<T>();
//        T response = httpClientService.getWeather(
//                openWeatherUrl,
//                responseClass
//                );
//
//        try {
//            return response;
//        } catch (NullPointerException e) {
//            throw new RuntimeException(e);
//        }
//    }
}*/

//    public CityOwResponse getWeatherFromNewApi() {
//        var url = "http-new-url";
//        var httpClientService = new HttpClientService<CityOwResponse>();
//        final CityOwResponse response = httpClientService.getWeather(
//                url,
//                CityOwResponse.class,
//                jsonElement -> {
//                    final LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(jsonElement.getAsJsonPrimitive().getAsLong()), ZoneId.systemDefault());
//                    return localDateTime;
//                }
//        );
//
//        return response;
//    }

// return LocalDateTime.ofInstant(Instant.ofEpochMilli(jsonElement.getAsJsonPrimitive().getAsLong()), ZoneId.systemDefault());

//return LocalDateTime.ofInstant(Instant.ofEpochMilli(dateTimeJson), ZoneId.systemDefault());

//LocalDateTime.ofInstant(Instant.ofEpochMilli(jsonElement.getAsJsonPrimitive().getAsLong()), ZoneId.systemDefault())   //OW

/*,jsonElement -> {
                    var dateTimeJson = jsonElement.getAsJsonPrimitive().getAsLong();
                    final LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(dateTimeJson), ZoneId.systemDefault());
                    return localDateTime;
                }*/

/*
public class WeatherService {

    public CityOwResponse getWeatherFromOpenWeather(String cityName) {
       String baseUrl = "https://api.openweathermap.org/data/2.5/weather?";
       String appIdQuery = "appid=716238e6166ce6e1315daf3232959cd3";
       String cityNameQuery = "q=" + cityName;
       String unitsQuery = "units=metric";

//     String openWeatherUrl = "https://api.openweathermap.org/data/2.5/weather?appid=716238e6166ce6e1315daf3232959cd3&q=Warsaw&units=metric";
       String openWeatherUrl = baseUrl + appIdQuery + "&" + cityNameQuery + "&" + unitsQuery;

       var httpClientService = new HttpClientService<CityOwResponse>();
       final CityOwResponse response = httpClientService.getWeather(
             openWeatherUrl,
             CityOwResponse.class,
             jsonElement -> {
                var dateTimeJson = jsonElement.getAsJsonPrimitive().getAsLong();
                final LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(dateTimeJson), ZoneId.systemDefault());
                return localDateTime;
             }
       );

       return response;
    }

    public CityOwResponse getWeatherFromNewApi() {
       var url = "http-new-url";
       var httpClientService = new HttpClientService<CityOwResponse>();
       final CityOwResponse response = httpClientService.getWeather(
             url,
             CityOwResponse.class,
             jsonElement -> {
                final LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(jsonElement.getAsJsonPrimitive().getAsLong()), ZoneId.systemDefault());
                return localDateTime;
             }
       );

       return response;
    }

}
 */