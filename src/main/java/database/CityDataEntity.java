package database;

public class CityDataEntity {
    private static Long generatedCityId = 0L;
    private Long cityId;
    private final String cityName;
    private final WeatherDataEntity weatherDataEntity;
    // osobna klasa do trzymania statystyk pogody

    public CityDataEntity(String cityName, WeatherDataEntity weatherDataEntity) {
        this.cityId = generateCityId();
        this.cityName = cityName;
        this.weatherDataEntity = weatherDataEntity;
        this.weatherDataEntity.setCityId(cityId);
    }

    public static Long generateCityId() {
        generatedCityId++;
        return generatedCityId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public WeatherDataEntity getWeatherDataEntity() {
        return weatherDataEntity;
    }

    public void showWeatherDataEntity() {
        System.out.println("Id: " + cityId + ". " + cityName + weatherDataEntity.toString());
    }
}
