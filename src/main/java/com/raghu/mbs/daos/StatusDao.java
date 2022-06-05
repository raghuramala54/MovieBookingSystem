package com.raghu.mbs.daos;

import com.raghu.mbs.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusDao extends JpaRepository<Status,Integer> {
    public Status findByStatusName(String statusName);
}
