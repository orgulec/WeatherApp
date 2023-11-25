package database;

public class CityDataEntity {
    private static Long generatedCityId =0L;
    private Long cityId;
    private String cityName;
    private WeatherDataEntity weatherDataEntity;
    // osobna klasa do trzymania statystyk pogody

    public CityDataEntity(String cityName, WeatherDataEntity weatherDataEntity) {
        this.cityId = generateCityId();
        this.cityName = cityName;
        this.weatherDataEntity = weatherDataEntity;
        this.weatherDataEntity.setCityId(cityId);
    }

    public static Long generateCityId(){
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

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setWeatherDataEntity(WeatherDataEntity weatherDataEntity) {
        this.weatherDataEntity = weatherDataEntity;
    }
    public void showWeatherDataEntity() {
         System.out.println("City Id: "+ cityId + ". " + cityName + weatherDataEntity.toString());
    }
}
