/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mario Wijaya
 */
@Entity
@Table(name = "tb_barang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbBarang.findAll", query = "SELECT t FROM TbBarang t")
    , @NamedQuery(name = "TbBarang.findById", query = "SELECT t FROM TbBarang t WHERE t.id = :id")
    , @NamedQuery(name = "TbBarang.findByNama", query = "SELECT t FROM TbBarang t WHERE t.nama = :nama")
    , @NamedQuery(name = "TbBarang.findByStok", query = "SELECT t FROM TbBarang t WHERE t.stok = :stok")
    , @NamedQuery(name = "TbBarang.findByHargaSatuan", query = "SELECT t FROM TbBarang t WHERE t.hargaSatuan = :hargaSatuan")})
public class TbBarang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @Column(name = "stok")
    private int stok;
    @Basic(optional = false)
    @Column(name = "harga_satuan")
    private int hargaSatuan;

    public TbBarang() {
    }

    public TbBarang(Integer id) {
        this.id = id;
    }

    public TbBarang(Integer id, String nama, int stok, int hargaSatuan) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.hargaSatuan = hargaSatuan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(int hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbBarang)) {
            return false;
        }
        TbBarang other = (TbBarang) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.entities.TbBarang[ id=" + id + " ]";
    }
    
}
