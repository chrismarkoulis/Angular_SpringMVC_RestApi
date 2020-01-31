/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chrismark.dao;

import com.chrismark.entities.Salesman;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chris
 */
@Repository
public class SalesmanDaoImpl implements SalesmanDao {

    
    @Autowired
    SessionFactory sessionFactory;
    
    
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    
    
    @Override
    public List<Salesman> findAll() {
            Query q = getSession().createQuery("from Salesman");
            List<Salesman> list = q.list(); //list() same with getResultList()
            return list;
    }

    @Override
    public Salesman findById(int id) {
        Session session = getSession();
        Salesman s = session.byId(Salesman.class).load(id);
        return s;

    }

//    @Override
//    public List<Salesman> findByCity(String city) {
//       Session session = getSession();
//       Salesman s = session.byNaturalId(Salesman.class).using("scity",city).load();
//       List<Salesman> list = new ArrayList();
//       list.add(s);
//       return list;
//        
//    }

    @Override
    public List<Salesman> findByCity(String city) {
        
         Query q = getSession().createNativeQuery("select * from salesman where scity like '%"+city+"%'");
         List<Salesman> list = q.getResultList();
         return list;
    }

//    @Override
//    public List<Salesman> findBetweenCost(double minComm, double maxComm) {
//
//         Query q = getSession().createNativeQuery("select * from salesman where scomm between '%"+minComm+"%' and '%"+maxComm+"%'");
//         List<Salesman> list = q.getResultList();
//         return list;
//
//
//    }
    
    @Override
    public List<Salesman> findBetweenCost(double minComm, double maxComm) {
        Query q = getSession().createQuery("SELECT s From Salesman s WHERE s.scomm BETWEEN :min AND :max"); //jpql :onoma metablitis | JDBC : ?
        q.setParameter("min", minComm);
        q.setParameter("max", maxComm);
        List<Salesman> list = q.getResultList();
        return list;
    }

    @Override
    public void delete(int id) {
        //kanei ena parapanw query
        Session session = getSession();
        Salesman s = session.byId(Salesman.class).load(id);
        session.delete(s);

    }
    
    /*
        public int delete(int id){
        Query q = getSession().createQuery(DELETE FROM Salesman s WHERE s.scode)
        
    
    
    }
    
    */

    @Override
    public int save(Salesman s) {
       
        Session session = getSession();
        session.save(s);
        return s.getScode();

    }

    @Override
    public void update(int id, Salesman s) {
        Session session = getSession();
        Salesman s2 = session.byId(Salesman.class).load(id);
        s2.setSname(s.getSname());
        s2.setScity(s.getScity());
        s2.setScomm(s.getScomm());
        session.update(s2);

    }
    
    
    
    
    
}
