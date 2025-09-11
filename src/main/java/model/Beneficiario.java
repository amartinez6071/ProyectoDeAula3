/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.DataController;

/**
 *
 * @author alex6
 */
public class Beneficiario extends Usuario{
    private int cantPersona;
    
    public Beneficiario (String id, String nombre, String direccion, String username, String clave, int cantPersona, TipoUsuario rol){
        super(id,nombre,direccion,username,clave, rol);
        this.cantPersona = cantPersona;
        DataController.agregarAListaUsuario(this);
    }

    public int getCantPersona() {
        return cantPersona;
    }

    public void setCantPersona(int cantPersona) {
        this.cantPersona = cantPersona;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%d", id, nombre, direccion, username, clave, rol.toString(), cantPersona);
    }
    
}
