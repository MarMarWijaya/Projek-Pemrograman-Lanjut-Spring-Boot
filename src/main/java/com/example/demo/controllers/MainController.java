/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.entities.TbBarang;
import com.example.demo.services.BarangService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Mario Wijaya
 */
@Controller
public class MainController {

    @Autowired
    BarangService barangService;

    @RequestMapping("")
    public String index() {
        List<TbBarang> barang = barangService.getAll();
        for (TbBarang brg : barang) {
            System.out.println(brg.getId());
            System.out.println(brg.getNama());
        }
        return "index";
    }

    //view
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("brg", new TbBarang());
        model.addAttribute("tb_barang", barangService.getAll());
        return "index";
    }
    
    @PostMapping("/save")
    public String save(TbBarang barang) {
        barangService.save(barang);
        return "redirect:/";
    }
    
//    @DeleteMapping("/delete/{id}")
//    public String deleteById(@PathVariable("id") int Id){
//        barangService.delete(Id);
//        return "redirect:/";
//    }
    
//    @DeleteMapping("/delete/{id}")
//    public String delete(TbBarang barang, @PathVariable("id") int Id) {       
//        barangService.delete(Id);
//        return "redirect:/";
//    }
  
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") int id) {
        barangService.delete(id);
        return "redirect:/";
    }
    
    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable("id") int id) {
        model.addAttribute("brg", barangService.getById(id));
        model.addAttribute("tb_barang", barangService.getAll());
        return "index";
    }
    
}
