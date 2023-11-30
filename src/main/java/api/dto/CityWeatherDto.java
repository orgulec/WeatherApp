package api.dto;

import java.time.LocalDateTime;

public class CityWeatherDto {
    //klasa do ładowania danych z Jsona
    //nazwy pól muszą pokrywać się z nazwami pól w obiekcie Json!!!
	private final Long cityId;
	private final LocalDateTime date;
	private final Float temperature;
	private final Float windSpeed;
	private final Float pressure;
	private final Float cloudcover;
	
	public CityWeatherDto(Long cityId, LocalDateTime date, Float temperature, Float windSpeed, Float pressure, Float cloudcover) {
		this.cityId = cityId;
		this.date = date;
		this.temperature = temperature;
		this.windSpeed = windSpeed;
		this.pressure = pressure;
		this.cloudcover = cloudcover;
	}
	
	public Long getCityId() {
		return cityId;
	}
	
	public LocalDateTime getDate() {
		return date;
	}
	
	public Float getTemperature() {
		return temperature;
	}
	
	public Float getWindSpeed() {
		return windSpeed;
	}
	
	public Float getPressure() {
		return pressure;
	}
	
	public Float getCloudcover() {
		return cloudcover;
	}
}
