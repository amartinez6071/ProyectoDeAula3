/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Donacion;
import model.Producto;
import model.datoDeTabla;

/**
 *
 * @author alex6
 */
public class ViewController {
    
    public static void cambiarMenu(JPanel contenedor, String nombreMenu) {
        CardLayout contenedorMenu = (CardLayout) contenedor.getLayout();
        contenedorMenu.show(contenedor, nombreMenu);
    }
    
    public static void mostrarTabla(JTable tabla, ArrayList<datoDeTabla> lista) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        
        modelo.setRowCount(0);
        
        for(datoDeTabla objeto : lista) {
            if(objeto instanceof Producto producto) {
                modelo.addRow(new Object[]{
                    producto.getAlimento(),
                    producto.getCantidad()
                });
            }
            else if(objeto instanceof Donacion donacion) {
                    String estado;
                    if (tabla.getName() != null && tabla.getName().equals("tabla_donaciones")) {
                        // Añade elemento a la tabla beneficiario
                        modelo.addRow(new Object[]{
                        donacion.getCodigo(),
                        donacion.getProveedor()
                        });
                    } else {
                        if(donacion.getEstado()) {
                            estado = "Disponible";
                        } else {
                            estado = "Reservado";
                        }
                        
                        // Añade elemento a la tabla de benefactor
                        modelo.addRow(new Object[]{
                        donacion.getCodigo(),
                        estado
                    });
                    }
                    
            }
        }
    }
    
    
    
    
}
