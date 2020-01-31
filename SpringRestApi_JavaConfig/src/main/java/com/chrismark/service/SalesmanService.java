/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chrismark.service;

import com.chrismark.entities.Salesman;
import java.util.List;

/**
 *
 * @author chris
 */
public interface SalesmanService {
    
    
    
    List<Salesman> getSalesmen();

    public Salesman getSalesmanById(int id);

    public List<Salesman> getSalesmanByCity(String city);

    public List<Salesman> getBetweenComm(double minComm, double maxComm);

    public void deleteSalesman(int id);

    public int createSalesman(Salesman s);

    public void updateSalesman(int id, Salesman s);
    
}
