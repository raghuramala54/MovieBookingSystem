package com.raghu.mbs.daos;
import com.raghu.mbs.entities.MovieTheatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MovieTheatreDao extends JpaRepository<MovieTheatre, Integer>{
}
