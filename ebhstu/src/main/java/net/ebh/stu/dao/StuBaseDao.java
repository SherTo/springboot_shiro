package net.ebh.stu.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by xh on 2017/3/15.
 */
public class StuBaseDao {
    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }
}