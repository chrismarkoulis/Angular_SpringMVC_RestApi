/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chrismark.service;

import com.chrismark.dao.SalesmanDao;
import com.chrismark.entities.Salesman;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chris
 */
@Service
@Transactional
public class SalesmanServiceImpl implements SalesmanService {

    
    @Autowired
    SalesmanDao sdao;
    
    
    
    @Override
    public List<Salesman> getSalesmen() {
        
        List<Salesman> list = sdao.findAll();
        return list;
    }

    @Override
    public Salesman getSalesmanById(int id) {

        Salesman s = sdao.findById(id);
        return s;
    }

    @Override
    public List<Salesman> getSalesmanByCity(String city) {

       List<Salesman> list = sdao.findByCity(city);
       return list;
    }

    @Override
    public List<Salesman> getBetweenComm(double minComm, double maxComm) {
        
        List<Salesman> list = sdao.findBetweenCost(minComm, maxComm);
        return list;

    }

    @Override
    public void deleteSalesman(int id) {
        
        sdao.delete(id);
        /* int number = sdao.delete(id);
            if (number>0){
            return "Salesman deleted successfully";
        }else {
        
            return "Salesman not deleted";
        }
        
        */
    }

   
        

    

    @Override
    public int createSalesman(Salesman s) {
        
        return sdao.save(s);
    }

    @Override
    public void updateSalesman(int id, Salesman s) {
        
        sdao.update(id, s);
    }
    
}
