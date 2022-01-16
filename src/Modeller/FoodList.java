/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modeller;

/**
 *
 * @author samuel
 */
public class FoodList {
    private final Integer id;
    private final String namaProduk;
    private final Integer harga;
    private final String deskripsi;

    public FoodList(Integer id, String namaProduk, int harga, String deskripsi) {
        this.id = id;
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }

    public Integer getId() {
        return id;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public int getHarga() {
        return harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
    
    
}
