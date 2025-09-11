/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Donacion;
import model.Producto;

/**
 *
 * @author alex6
 */
public class ProductController {
    public static Producto crearProducto(String nombre, double cantidad) {
        return new Producto(nombre, cantidad);
    }
}
