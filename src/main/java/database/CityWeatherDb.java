package database;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CityWeatherDb {
    private static final Map<Long, CityDataEntity> dataBase = new HashMap<>();  //dataBase
    private static Long generatedId = 1L;
    private Long generateId(){
        generatedId++;
        return generatedId;
    }

    public Optional<CityDataEntity> get(Long id) {
        return Optional.ofNullable(dataBase.get(id));
    }

    public void add(CityDataEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }
        dataBase.put(generateId(), entity);
//        dataBase.put(entity.getId(), entity);
    }

    public void remove(CityDataEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }
        dataBase.remove(entity.getId());
    }

    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        dataBase.remove(id);
    }

    public CityDataEntity change(CityDataEntity newCityDataEntity) {
        if (newCityDataEntity == null) {
            throw new IllegalArgumentException();
        }
        Long id = newCityDataEntity.getId();
        dataBase.replace(id, newCityDataEntity);
        return newCityDataEntity;
    }

    public void clear() {
        dataBase.clear();
    }

}
