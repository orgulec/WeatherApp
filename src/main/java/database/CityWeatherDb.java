package database;

import java.util.*;
import java.util.stream.Collectors;

public class CityWeatherDb {
    private static final Map<Long, CityDataEntity> dataBase = new HashMap<>();  //dataBase
    private static Long generatedId = 0L;

    public static Long generateId(){
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
        Long newId = generateId();
        dataBase.put(newId, entity);
    }

    public void remove(CityDataEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }
        dataBase.remove(entity.getCityId());
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

        Long id = newCityDataEntity.getCityId();
        dataBase.replace(id, newCityDataEntity);
        return newCityDataEntity;
    }

//    public static List<CityDataEntity> getCitiesFromDb(CityDataEntity cityDataEntity){
    public static List<CityDataEntity> getCitiesFromDb(String cityName){
        return dataBase.values()
                .stream()
                .filter(
//                        a -> Objects.equals(a.getCityId(), cityDataEntity.getCityId())
                        a -> a.getCityName().equalsIgnoreCase(cityName)
                ).collect(Collectors.toList());
    }

//    public boolean checkIfDbContainsCityName(CityDataEntity cityDataEntity){
    public static boolean checkIfDbContainsCityName(String cityName){
        return dataBase.values()
                .stream()
                .anyMatch(
                        a-> a.getCityName().equalsIgnoreCase(cityName)
//                        a-> a.getCityName().equalsIgnoreCase(cityDataEntity.getCityName())
                );
    }

    public CityDataEntity changeCityIdWhenDoubleCityName(CityDataEntity newCityDataEntity){
        Optional<CityDataEntity> foundedCityOpt = dataBase.values()
                .stream()
                .filter(
                        a -> a.getCityName().equalsIgnoreCase(newCityDataEntity.getCityName())
                )
                .findAny();
        if(foundedCityOpt.isPresent()){
            Long id = foundedCityOpt.get().getCityId();
            newCityDataEntity.setCityId(id);
            newCityDataEntity.getWeatherDataEntity().setCityId(id);
        }
        return newCityDataEntity;
    }

    public void printAllDataEntities(){
        Set<Map.Entry<Long, CityDataEntity>> entries = dataBase.entrySet();
            entries.forEach(a -> {
                a.getValue().showWeatherDataEntity();
            });
    }

    public void clear() {
        dataBase.clear();
    }


}
