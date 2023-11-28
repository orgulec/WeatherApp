package database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CityWeatherDbTest {
    private CityWeatherDb dataBase;
    private final Long cityId = 1L;
    @Mock WeatherDataEntity weatherDataEntity;
    @BeforeEach
    void generateDataBase(){
        dataBase = new CityWeatherDb();
//            Mockito.when(weatherDataEntity.getCityId()).thenReturn(1L);
//            Mockito.when(weatherDataEntity.getTemperature()).thenReturn(20f);
//            Mockito.when(weatherDataEntity.getWindSpeed()).thenReturn(5f);
//            Mockito.when(weatherDataEntity.getPressure()).thenReturn(999f);
        String cityName = "Warsaw";
        CityDataEntity cityDataEntity = new CityDataEntity(
                cityName,weatherDataEntity
        );

        dataBase.add(cityDataEntity);
    }
    @AfterEach
    void clearDatabase(){
        dataBase.clear();
    }

    @Test
    void addMethodTest() {
        //given
        Long id = 2L;
        String cityName = "Krakow";
        CityDataEntity newCityDataEntity = new CityDataEntity(cityName,weatherDataEntity);
        //when
        dataBase.add(newCityDataEntity);
        Optional<CityDataEntity> resultOpt = dataBase.get(2L);
        //then
        assertNotNull(resultOpt.orElseThrow().getCityName());
    }

    @Test
    void addDoubleKeyArg(){
        //given
        CityDataEntity doubleCityDataEntity = new CityDataEntity("Kraków",weatherDataEntity);
//        doubleCityDataEntity.setId(cityId);
//        doubleCityDataEntity.setName("Kraków");
        //when
        dataBase.add(doubleCityDataEntity);
        //then
    }

    @Test
    void removeCityDataEntityMethodTest() {
        //given
        Optional<CityDataEntity> cityToRemoveOpt = dataBase.get(cityId);
        CityDataEntity cityToRemove = new CityDataEntity(
                cityToRemoveOpt.get().getCityName(),weatherDataEntity
        );
        //when
        dataBase.removeCityDataEntity(cityToRemove);
        //then
        Optional<CityDataEntity> result = dataBase.get(cityId);
        assertNull(result.orElseThrow());
    }

    @Test
    void shouldDeleteElementById() {
        //given

        //when
        dataBase.deleteById(cityId);
        //then
        assertNull(dataBase.get(cityId));
    }

    @Test
    void removeNoneMethodTest() {
        //given
        Long wrongId = 2L;
        //when
        dataBase.deleteById(wrongId);
        //then
        assertNull(dataBase.get(1L));
    }

    @Test
    void shouldGetEntityById() {
        //given
        //when
        Optional<CityDataEntity> resultOpt = dataBase.get(cityId);
        String resultName = resultOpt.orElseThrow().getCityName();
        //then
        Assertions.assertEquals(resultName, "Warsaw");
    }

    @Test
    void shouldChangeCityDataEntity() {
        //given

        CityDataEntity changedCityDataEntity = new CityDataEntity("WarsawAAA",weatherDataEntity);
        changedCityDataEntity.setCityId(cityId);
//        String newName = "WarsawAAA";
//        changedCityDataEntity.setName("WarsawAAA");

        //when
        dataBase.change(changedCityDataEntity);
        Optional<CityDataEntity> resultOpt = dataBase.get(cityId);
        String resultName = resultOpt.orElseThrow().getCityName();
        //then
        Assertions.assertEquals(resultName, "WarsawAAA");
    }


}