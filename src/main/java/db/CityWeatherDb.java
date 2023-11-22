package db;

import java.util.HashMap;
import java.util.Map;

public class CityWeatherDb {
    private static final Map<Long, CityDataEntity> dataBase = new HashMap<>();  //dataBase


    public CityDataEntity get(Long id){
        return dataBase.get(id);
    }

    public void add(CityDataEntity entity){
        if(entity==null){
            throw new IllegalArgumentException();
        }
        dataBase.put(entity.getId(), entity);
    }
    public void remove(CityDataEntity entity){
        if(entity==null){
            throw new IllegalArgumentException();
        }
        dataBase.remove(entity.getId());
    }

    public CityDataEntity change(CityDataEntity newCityDataEntity){
        if(newCityDataEntity==null){
            throw new IllegalArgumentException();
        }
        Long id = newCityDataEntity.getId();
        dataBase.replace(id, newCityDataEntity);
        return newCityDataEntity;
    }

}
