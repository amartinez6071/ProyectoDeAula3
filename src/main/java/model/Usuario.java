/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author alex6
 */
public abstract class Usuario {
    protected String id;
    protected String nombre;
    protected String direccion;
    protected String username;
    protected String clave;
    protected TipoUsuario rol;
    
    public Usuario (String id, String nombre, String direccion, String username, String clave, TipoUsuario rol){
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.username = username;
        this.clave  = clave;
        this.rol = rol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public TipoUsuario getRol() {
        return rol;
    }

    public void setRol(TipoUsuario rol) {
        this.rol = rol;
    }
        
}
