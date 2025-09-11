/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author alex6
 */
public class Producto implements datoDeTabla{
    
    private String alimento;
    private double cantidad;
    
    
    public Producto (String alimento, double cantidad){
        this.alimento = alimento;
        this.cantidad = cantidad;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        String cantidadTexto = String.valueOf(cantidad).replace(",", ".");
        return String.format("%s|%s",alimento, cantidadTexto);
    }
    
    
}
