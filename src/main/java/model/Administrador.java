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
public class Administrador extends Usuario {
    public Administrador(String id, String nombre, String direccion, String username, String clave, TipoUsuario rol) {
        super(id, nombre, direccion, username, clave, rol);
        DataController.agregarAListaUsuario(this);
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s",id,nombre,direccion,username,clave,rol.toString());
    }
    
    
    
}
