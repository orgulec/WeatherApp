package db;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityWeatherDbTest {
    private CityWeatherDb dataBase;// = new CityWeatherDb();
    private final Long cityDataEntity = 1L;
    @BeforeEach
    void generateDataBase(){
        dataBase = new CityWeatherDb();
        long id = 1L;
        String cityName = "Warsaw";
        CityDataEntity cityDataEntity = new CityDataEntity();
        cityDataEntity.setId(id);
        cityDataEntity.setName(cityName);
        dataBase.add(cityDataEntity);
    }
    @AfterEach
    void clearDatabase(){

    }

    @Test
    void addMethodTest() {
        //given
        long id = 2L;
        String cityName = "Krakow";
        CityDataEntity newCityDataEntity = new CityDataEntity();
        newCityDataEntity.setId(2L);
        newCityDataEntity.setName("Krakow");

        //when
        dataBase.add(newCityDataEntity);
        CityDataEntity result = dataBase.get(2L);
        //then
        Assertions.assertEquals(result.getName(), cityName);
    }

    @Test
    void removeMethodTest() {
        //given
        CityDataEntity cityToRemove = dataBase.get(cityDataEntity);
        //when
        dataBase.remove(cityToRemove);
        //then
        assertNull(dataBase.get(1L));
    }

    @Test
    void removeNoneMethodTest() {
        //given
        CityDataEntity cityToRemove = dataBase.get(cityDataEntity);
        //when
        dataBase.remove(cityToRemove);
        //then
        assertNull(dataBase.get(1L));
    }

    @Test
    void shouldGetEntityById() {
        //given
        //when

        CityDataEntity result = dataBase.get(cityDataEntity);
        //then
        Assertions.assertEquals(result.getName(), "Warsaw");
    }

    @Test
    void shouldChangeCityDataEntity() {
        //given

        CityDataEntity changedCityDataEntity = new CityDataEntity();
        changedCityDataEntity.setId(cityDataEntity);
        String newName = "WarsawAAA";
        changedCityDataEntity.setName("WarsawAAA");

        //when
        dataBase.change(changedCityDataEntity);
        CityDataEntity result = dataBase.get(cityDataEntity);

        //then
        Assertions.assertEquals(result.getName(), "WarsawAAA");
    }
}