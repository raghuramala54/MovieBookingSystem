package com.raghu.mbs.daos;

import com.raghu.mbs.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDao extends JpaRepository<Car,Integer> {
    //public Car findMovieByCarName(String carName);
}
