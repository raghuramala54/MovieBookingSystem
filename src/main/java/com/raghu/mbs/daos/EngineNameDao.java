package com.raghu.mbs.daos;

import com.raghu.mbs.entities.Engine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineNameDao extends JpaRepository<Engine,Integer> {
    //public Engine findMovieByEngineName(String engineName);
}
