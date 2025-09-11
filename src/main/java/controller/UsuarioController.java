/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;
import model.Benefactor;
import model.Beneficiario;
import model.TipoUsuario;
import model.Usuario;

/**
 *
 * @author alex6
 */
public class UsuarioController{
    
    private static Usuario usuarioSesion;

    public static Usuario getUsuarioSesion() {
        return usuarioSesion;
    }

    public static void setUsuarioSesion(Usuario usuarioSesion) {
        UsuarioController.usuarioSesion = usuarioSesion;
    }
        
    public static void registrarUsuario(String id, String nombre, String direccion, String username, String clave, String tipoUsuario){
        switch(tipoUsuario) {
            //Estos son los valores como están escritos en el comboBox
            case "Beneficiario" -> new Beneficiario(id, nombre, direccion, username, clave, 0, TipoUsuario.BENEFICIARIO);
            case "Benefactor" -> new Benefactor(id, nombre, direccion, username, clave, TipoUsuario.BENEFACTOR);
        }
    }
    
    public static boolean inicioSesion(String username, String clave){
        
        if (DataController.getListaUsuario().containsKey(username)){
            Usuario usuarioEncontrado = DataController.getListaUsuario().get(username);
            if(clave.equals(usuarioEncontrado.getClave())) {
                usuarioSesion = usuarioEncontrado;
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Este usuario no existe");
        }
        
        return true;
    }
    
    
}
