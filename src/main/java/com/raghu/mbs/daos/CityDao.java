package com.raghu.mbs.daos;

import com.raghu.mbs.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City,Integer> {
    public City findByCityName(String cityName);
}
