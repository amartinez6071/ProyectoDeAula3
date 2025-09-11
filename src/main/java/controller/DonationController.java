/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Donacion;
import model.Producto;

/**
 *
 * @author alex6
 */
public class DonationController {
    public static String codigo;
    
    public static Donacion crearDonacion(ArrayList<Producto> productos, String proveedor, String observaciones){
        Donacion donacionNueva = new Donacion(crearCodigo(), productos, proveedor, observaciones, true);
        return donacionNueva;
    }
    
    private static String crearCodigo(){
        int codigoNumerico = DataController.getListaDonativos().size()+1;
        String codigo = "D" + String.format("%05d",codigoNumerico);
        
        DonationController.codigo = codigo;
        return codigo;
        
    }
}
