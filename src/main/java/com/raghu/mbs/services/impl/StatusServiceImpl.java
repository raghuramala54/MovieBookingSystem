package com.raghu.mbs.services.impl;

import com.raghu.mbs.daos.StatusDao;
import com.raghu.mbs.entities.Status;
import com.raghu.mbs.exceptions.StatusDetailsNotFoundException;
import com.raghu.mbs.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StatusServiceImpl implements StatusService {
    @Autowired //Dependency Injection
    private StatusDao statusDao;

    /**
     * Given a status , I should be able to store it into the db.
     * @param status
     * @return
     */
    @Override
    public Status acceptStatusDetails(Status status) {
        return statusDao.save(status);
    }

    /**
     * Based on the id, status should be returned
     * If valid id-> proper status should be returned
     * If invalid id-> StatusDetailsNotFoundException
     * @param id
     * @return
     */
    @Override
    public Status getStatusBasedOnId(int id) throws StatusDetailsNotFoundException {
        Status savedStatus = statusDao.findById(id).orElseThrow(()->
                new StatusDetailsNotFoundException("Status Not found for the provided id"+id));
        return savedStatus;
    }

    @Override
    public Status getStatusDetailsByStatusName(String statusName) throws StatusDetailsNotFoundException {
        Status savedStatus = statusDao.findByStatusName(statusName);
        if(savedStatus==null)
        {
            throw new StatusDetailsNotFoundException("Status Not found for the provided status name"+statusName);
        }
        return savedStatus;
    }

    /**
     * Return true if able to successfully delete
     * @param id
     * @return
     */
    @Override
    public boolean deleteStatus(int id) {
        statusDao.deleteById(id);
        return true;
    }

    @Override
    public List<Status> getAllStatuses() {
        List<Status> statuses = statusDao.findAll();
        return statuses;
    }
}
