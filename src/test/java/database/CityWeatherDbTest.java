package database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CityWeatherDbTest {
    private CityWeatherDb dataBase;
    private final Long cityId = 1L;
    @BeforeEach
    void generateDataBase(){
        dataBase = new CityWeatherDb();
        String cityName = "Warsaw";
        CityDataEntity cityDataEntity = new CityDataEntity();
        cityDataEntity.setId(cityId);
        cityDataEntity.setName(cityName);
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
        CityDataEntity newCityDataEntity = new CityDataEntity();
        newCityDataEntity.setId(2L);
        newCityDataEntity.setName("Krakow");

        //when
        dataBase.add(newCityDataEntity);
        Optional<CityDataEntity> resultOpt = dataBase.get(2L);
        String resultName = resultOpt.orElseThrow().getName();
        //then
        Assertions.assertEquals(resultName, cityName);
    }

    @Test
    void addDoubleKeyArg(){
        //given
        CityDataEntity doubleCityDataEntity = new CityDataEntity();
        doubleCityDataEntity.setId(cityId);
        doubleCityDataEntity.setName("Kraków");
        //when
        dataBase.add(doubleCityDataEntity);
        //then

    }

    @Test
    void removeMethodTest() {
        //given
        Optional<CityDataEntity> cityToRemoveOpt = dataBase.get(cityId);
        CityDataEntity cityToRemove = cityToRemoveOpt.orElseThrow();
        //when
        dataBase.remove(cityToRemove);
        //then
        assertNull(dataBase.get(1L));
    }

    @Test
    void shouldDeleteElementById() {
        //given

        //when
        dataBase.delete(cityId);
        //then
        assertNull(dataBase.get(cityId));
    }

    @Test
    void removeNoneMethodTest() {
        //given
        Long wrongId = 2L;
        //when
        dataBase.delete(wrongId);
        //then
        assertNull(dataBase.get(1L));
    }

    @Test
    void shouldGetEntityById() {
        //given
        //when
        Optional<CityDataEntity> resultOpt = dataBase.get(cityId);
        String resultName = resultOpt.orElseThrow().getName();
        //then
        Assertions.assertEquals(resultName, "Warsaw");
    }

    @Test
    void shouldChangeCityDataEntity() {
        //given

        CityDataEntity changedCityDataEntity = new CityDataEntity();
        changedCityDataEntity.setId(cityId);
        String newName = "WarsawAAA";
        changedCityDataEntity.setName("WarsawAAA");

        //when
        dataBase.change(changedCityDataEntity);
        Optional<CityDataEntity> resultOpt = dataBase.get(cityId);
        String resultName = resultOpt.orElseThrow().getName();
        //then
        Assertions.assertEquals(resultName, "WarsawAAA");
    }


}