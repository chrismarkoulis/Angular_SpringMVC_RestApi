/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chrismark.dao;

import com.chrismark.entities.Salesman;
import java.util.List;

/**
 *
 * @author chris
 */
public interface SalesmanDao {

    
    List<Salesman> findAll();

    public Salesman findById(int id);

    public List<Salesman> findByCity(String city);

    public List<Salesman> findBetweenCost(double minComm, double maxComm);

    public void delete(int id);

    public int save(Salesman s);

    public void update(int id, Salesman s);
    
    
}
