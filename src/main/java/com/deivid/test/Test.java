package com.deivid.test;

import com.deivid.dao.DispositivoDAO;
import com.deivid.dao.UsuarioDAO;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        // Crear una instancia de UsuarioDAO para acceder a las operaciones CRUD de la entidad Usuario
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        System.out.println("______________Usuarios______________");
        
        // Obtener todos los usuarios de la base de datos y mostrarlos
        Imprimir(usuarioDAO.Mostrar(), "Usuario");

        // Crear una instancia de DispositivoDAO para acceder a las operaciones CRUD de la entidad Dispositivo
        DispositivoDAO dispositivoDAO = new DispositivoDAO();
        System.out.println("_____________Dispositivo____________");
        
        // Obtener todos los dispositivos de la base de datos y mostrarlos
        Imprimir(dispositivoDAO.Mostrar(), "Dispositivo");
    }

    // Método genérico para imprimir los elementos de una lista
    private static void Imprimir(List<?> coleccion, String tabla) {
        // Iterar sobre cada elemento de la colección y mostrarlo
        for (Object elemento : coleccion) {
            System.out.println(tabla + " : " + elemento);
        }
    }
}
