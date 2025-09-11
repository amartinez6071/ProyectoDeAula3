/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author alex6
 */
public class ValidateDataController {
    
    public static boolean validarCampos(Container contenedor){
        
        //Este metodo nos permite validar todos los componentes dentro del contenedor y realizar el recorrido por el ciclo for entrarndo en cada uno
        for(Component c : contenedor.getComponents()) {
            //Verifico si el txt está en blanco 
            if(c instanceof JTextField txtBox) {
                if(txtBox.getText().isBlank()) {
                    return false;
                }
            }
            //Verifico si el txtPassword está en blanco convirtiendo los caracteres en String
            else if (c instanceof JPasswordField txtPassword){
                if(String.valueOf(txtPassword.getPassword()).isBlank()){
                    return false;
                }
            }

            //Validamos que el combo box no esté con un valor predeterminado
            else if (c instanceof JComboBox cbx){
                //Este nos permite invalidar la información del espacio en blanco utilizado
                if (String.valueOf(cbx.getSelectedItem()).equals(" ")){
                    return false;
                }
            }
        }
                
        return true; // La entrada no esta en blanco
        
    }
    
    public static boolean validarRegistro(String id, String nombre, String username, String clave, String confirmClave){
        if(id.length() != 10) {
            JOptionPane.showMessageDialog(null, "Numero de identificacion invalido");
            return false;
        }
        else if(nombre.length() < 3){
            JOptionPane.showMessageDialog(null, "nombre invalido");
            return false;
        }
        else if (DataController.getListaUsuario().containsKey(username)){
            JOptionPane.showMessageDialog(null, "Username ya existe");
            return false;
        }
        else if (!clave.equals(confirmClave)){
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            return false;
        }
        return true;
    }
    
//    public static boolean validarProducto(String nombre, double cantidad) {
//        
//        if (){
//            
//        }
//        
//        return true;
//    }
}
