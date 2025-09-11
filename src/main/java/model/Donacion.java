/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.DataController;
import java.util.ArrayList;

/**
 *
 * @author alex6
 */
public class Donacion implements datoDeTabla {
    
    private String codigo;
    private ArrayList<Producto> productos = new ArrayList<>();
    private String proveedor;
    private String observaciones;
    private boolean estado;
    
    public Donacion (String codigo, ArrayList<Producto> productos, String proveedor, String observaciones, boolean estado){
        this.codigo = codigo;
        this.productos = productos;
        this.proveedor = proveedor;
        this.observaciones = observaciones;
        this.estado = estado;
        DataController.agregarListaDonaciones(this);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        for (Producto producto : productos){
            sb.append(producto.toString()).append("-");
        }
        
        if (!productos.isEmpty()){
            sb.setLength(sb.length() - 1);
        }
        
        return String.format("%s,%s,%s,%s,%b",codigo, sb.toString(), proveedor, observaciones,estado);
    }
    
    //ID: 412 | ArrayList<> | proveedor: assaca | observaciones: aDSDSAD 
    
}
