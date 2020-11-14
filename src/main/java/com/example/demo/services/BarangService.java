/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import com.example.demo.entities.TbBarang;
import com.example.demo.repositories.BarangRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mario Wijaya
 */
@Service
public class BarangService {
    @Autowired
    BarangRepository repository;
    
    public List<TbBarang> getAll() {
        return repository.findAll();
    }

    public TbBarang getById(int id) {
//        return repository.getOne(id);
        return repository.findById(id).get();
    }

    public TbBarang save(TbBarang tbBarang) {
        return repository.save(tbBarang);
    }

    public void delete(int id) {
        //repository.delete(new TbBarang(id));
        repository.deleteById(id);
    }
}
