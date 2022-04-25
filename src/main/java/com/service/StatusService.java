package com.service;

import com.model.Status;

import java.util.List;

public interface StatusService {

    public List<Status> getAll();

    public void save(Status status);

    public Status get(int status_id);

    public void update(Status status);

    public void delete(int status_id);

    public List<Status> getAll(int status_id);

    public List<Status> sort(int sortKey);
}
