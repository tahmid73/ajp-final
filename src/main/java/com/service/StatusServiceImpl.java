package com.service;

import com.dao.StatusDao;
import com.model.Status;
import com.util.SortUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StatusServiceImpl implements StatusService {

    private final StatusDao statusDao;

    public StatusServiceImpl(StatusDao statusDao) {
        this.statusDao = statusDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Status> getAll() {
        return statusDao.getAll();
    }

    @Override
    public void save(Status status) {
        statusDao.save(status);
    }

    @Override
    public Status get(int status_id) {
        return statusDao.get(status_id);
    }

    @Override
    public void update(Status status) {statusDao.update(status);
    }

    @Override
    public void delete(int status_id) {
        statusDao.delete(status_id);
    }

    @Override
    public List<Status> getAll(int status_id) {
        return statusDao.getAll(status_id);
    }

    @Override
    public List<Status> sort(int sortKey) {
        String key = "";
        switch (sortKey) {
            case SortUtils.status:
                key = "status";
                break;
            case SortUtils.statusId:
                key = "status_id";
                break;
            default:
                key = "status";
        }
        return statusDao.sort(key);
    }
}
