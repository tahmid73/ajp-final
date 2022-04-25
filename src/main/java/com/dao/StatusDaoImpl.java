package com.dao;

import com.model.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StatusDaoImpl implements StatusDao {

    private final SessionFactory sessionFactory;

    public StatusDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Status> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Status> statusQuery = session.createQuery("from Status", Status.class);
        List<Status> statuses = statusQuery.getResultList();
        return statuses == null ? new ArrayList<Status>() : statuses;
    }

    @Override
    public void save(Status status) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(status);
    }

    @Override
    public Status get(int status_id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Status.class, status_id);
    }

    @Override
    public void update(Status status) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(status);
    }

    @Override
    public void delete(int status_id) {
        Status status = get(status_id);
        sessionFactory.getCurrentSession().delete(status);
    }

    @Override
    public List<Status> getAll(int status_id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Status> statusQuery = session.createQuery("from Status where status_id like '%" + status_id + "%'", Status.class);
        return statusQuery.getResultList();
    }

    @Override
    public List<Status> sort(String sortKey) {
        Session session = sessionFactory.getCurrentSession();
        Query<Status> statusQuery = session.createQuery("from Status order by " + sortKey, Status.class);
        return statusQuery.getResultList();
    }
}
