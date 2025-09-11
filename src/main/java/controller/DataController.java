/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import model.Administrador;
import model.Benefactor;
import model.Beneficiario;
import model.Donacion;
import model.Producto;
import model.TipoUsuario;
import model.Usuario;

/**
 *
 * @author alex6
 */
public class DataController {
    
    private static HashMap<String,Usuario>listaUsuarios = new HashMap<>();
    private static HashMap<String, Donacion>listaDonativos = new HashMap<>();
    private static final String ARCHIVO_USUARIOS = "src/main/resources/data/Usuarios.csv";
    private static final String ARCHIVO_DONACIONES = "src/main/resources/data/Donaciones.csv";
    
    
    public static HashMap<String, Usuario> getListaUsuario(){
        return listaUsuarios;
    }
    
    public static void setListaUsuarios(HashMap<String,Usuario>listaUsuarios){
        DataController.listaUsuarios = listaUsuarios;
    }

    public static HashMap<String, Donacion> getListaDonativos() {
        return listaDonativos;
    }

    public static void setListaDonativos(HashMap<String, Donacion> listaDonativos) {
        DataController.listaDonativos = listaDonativos;
    }
    
    
    
    // Agrega los usuarios registrados a la lista de usuarios
    public static void agregarAListaUsuario(Usuario usario) {
        listaUsuarios.put(usario.getUsername(), usario);
    }
    
    
    //Esta clase nos permite guardar los usuarios en un mismo archivo teniendo en cuenta cuales se guardan como benefactor y/o beneficiario
    public static void guardarUsuarios (){
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO_USUARIOS))){
            //Encabezado
            pw.append("No. Identificacion,nombre,direccion,User name,clave,rol,cantidad Personas\n");
            for(Usuario usuario : listaUsuarios.values()) {
                //esto nos permite clasificar los valores entre los usuarios 
                if(usuario instanceof Beneficiario) {
                    pw.append(usuario.toString() + "\n");
                } else {
                    pw.append(usuario.toString() + ",null" + "\n");
                }
            }
            
            if(pw != null) {
                System.out.println("Se guardaron los usuarios");
            } else {
                System.out.println("No hay usuarios para guardar");
            }
        }
        
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al guardar los usuarios");
            //System.out.println(e.getCause());
        }
      
    }
    
    public static void guardarDonaciones(){
        try (PrintWriter pw = new PrintWriter (new FileWriter (ARCHIVO_DONACIONES))){
            pw.append("ID,Donativo,Proveedor,Observaciones,Estado \n");
            for (Donacion donacion : listaDonativos.values()){
                pw.append(donacion.toString() + "\n");
            }
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error al guardar Donativo");
        }
    }
    
    //Metodo para agregar a la lista HashMap asignando de una vez el codigo de la clase Donacion como la llave principal para el mapeo
    public static void agregarListaDonaciones(Donacion donacion){
        listaDonativos.put(donacion.getCodigo(), donacion);
    }
    
    public static void cargarUsuarios(){
        
        try(BufferedReader br = new BufferedReader (new FileReader (ARCHIVO_USUARIOS))){
            String linea;
            
            br.readLine(); // Lee la primera linea y la ignora
            
            while ((linea = br.readLine()) != null){
                
                String[] datosUsuario = linea.split(",");
                Usuario usuarioCargado;
                
                if(datosUsuario[5].equals("BENEFICIARIO")) {
                    //System.out.println("ESTA CARGANDO UN BENEFICIARIO");
                    usuarioCargado = new Beneficiario(datosUsuario[0], datosUsuario[1], datosUsuario[2], datosUsuario[3], datosUsuario[4], Integer.parseInt(datosUsuario[6]), TipoUsuario.BENEFICIARIO);
                } else if (datosUsuario[5].equals("BENEFACTOR")) {
                    //System.out.println("ESTA CARGANDO UN BENEFACTOR");
                    usuarioCargado = new Benefactor(datosUsuario[0], datosUsuario[1], datosUsuario[2], datosUsuario[3], datosUsuario[4],TipoUsuario.BENEFACTOR);
                } else {
                    //System.out.println("ESTA CARGANDO UN ADMINISTRADOR");
                    usuarioCargado = new Administrador(datosUsuario[0], datosUsuario[1], datosUsuario[2], datosUsuario[3], datosUsuario[4],TipoUsuario.ADMINISTRADOR);
                    //System.out.println(listaUsuarios.get("admin").getUsername());
                }
                
            }
            //System.out.println(listaUsuarios);
        }
        
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al cargar Usuarios");
        }
    }
    
    public static void cargarDonaciones(){
            try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_DONACIONES))){
                String linea;
                
                br.readLine();
                
                while ((linea=br.readLine()) != null){
                    // "001", "nombre,cantidad,nombre,cantidad", "fulano | algo
                    String [] datosDonacion =linea.split(",");
                    
                    String codigo = datosDonacion[0]; 
                    String[] productos = datosDonacion[1].split("-"); // "nombre,cantidad", "nombre,cantidad"
                    String proveedor = datosDonacion[2];
                    String observacion = datosDonacion[3];
                    boolean estado;
                    
                    switch (datosDonacion[4]) {
                        case "true" -> estado = true;
                        case "false" -> estado = false;
                        default -> estado = true;
                    }
                    
                    ArrayList<Producto>listaProducto = new ArrayList<>();
                    
                    for (String p : productos){
                        String[] datosProducto = p.split("\\|"); // "nombre","cantidad"
                        
                        double cantidad = Double.parseDouble(datosProducto[1]);
                        
                        listaProducto.add(new Producto(datosProducto[0], cantidad));
                    }
                    
                    new Donacion(codigo, listaProducto, proveedor, observacion, estado);
                }
                
                
            }
            catch (IOException e){
                JOptionPane.showMessageDialog(null, "Error al cargar el archivo");
            }
    }
    
    
    
    
    
}
