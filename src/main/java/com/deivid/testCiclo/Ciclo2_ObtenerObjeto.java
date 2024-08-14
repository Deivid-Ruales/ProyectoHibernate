package com.deivid.testCiclo;

import com.deivid.dao.GenericDAO;
import com.deivid.domain.Dispositivo;
import com.deivid.domain.Historial_dispositivo;
import com.deivid.domain.Turno_trabajo;
import com.deivid.domain.Usuario;

public class Ciclo2_ObtenerObjeto extends GenericDAO {

    public static void main(String[] args) {
        // Crear una instancia de Ciclo2_ObtenerObjeto para acceder al método ObtenerUsuarioPorID
        Ciclo2_ObtenerObjeto ciclo = new Ciclo2_ObtenerObjeto();

        // Llamar al método ObtenerUsuarioPorID con el ID 1 para obtener y mostrar el usuario correspondiente
        ciclo.ObtenerUsuarioPorID(1);
        
        // Llamar al método ObtenerDispositivoPorID con el ID 1 para obtener y mostrar el Dispositivo correspondiente
        //ciclo.ObtenerDispositivoPorID(1);
        
        // Llamar al método ObtenerTurnoTrabajoPorID con el ID 1 para obtener y mostrar el Turno correspondiente
        //ciclo.ObtenerTurnoTrabajoPorID(1);
        
        // Llamar al método ObtenerHistorialDispositivoPorID con el ID 1 para obtener y mostrar el Historial correspondiente
        //ciclo.ObtenerHistorialDispositivoPorID(1);
    }

    // Método para obtener un usuario de la base de datos usando su ID
    public void ObtenerUsuarioPorID(int id) {
        System.out.println("_______Usuario_______");
        
        // Inicializar EntityManager a null
        em = null;
        try {
            // Obtener el EntityManager
            em = getEntityManager();

            // Buscar el usuario en la base de datos usando el ID proporcionado
            Usuario usuario = em.find(Usuario.class, id);

            // Verificar si se encontró el usuario
            if (usuario != null) {
                // Imprimir la información del usuario si se encuentra
                System.out.println("Usuario: " + usuario);
            } else {
                // Imprimir un mensaje si no se encuentra el usuario
                System.out.println("No se encontró un usuario con el ID " + id);
            }
        } catch (Exception e) {
            // Imprimir la excepción si ocurre un error
            e.printStackTrace(System.out);
        } finally {
            // Cerrar el EntityManager para liberar recursos
            if (em != null && em.isOpen()) {
                em.close();
            }
            // Cerrar el EntityManagerFactory para liberar recursos
            closeEntityManagerFactory();
        }
    }
    
    // Método para obtener un dispositivo de la base de datos usando su ID
    public void ObtenerDispositivoPorID(int id) {
        System.out.println("_______Dispositivo_______");
        
        // Inicializar EntityManager a null
        em = null;
        try {
            // Obtener el EntityManager
            em = getEntityManager();

            // Buscar el dispositivo en la base de datos usando el ID proporcionado
            Dispositivo dispositivo = em.find(Dispositivo.class, id);

            // Verificar si se encontró el dispositivo
            if (dispositivo != null) {
                // Imprimir la información del dispositivo si se encuentra
                System.out.println("Dispositivo: " + dispositivo);
            } else {
                // Imprimir un mensaje si no se encuentra el dispositivo
                System.out.println("No se encontró un dispositivo con el ID " + id);
            }
        } catch (Exception e) {
            // Imprimir la excepción si ocurre un error
            e.printStackTrace(System.out);
        } finally {
            // Cerrar el EntityManager para liberar recursos
            if (em != null && em.isOpen()) {
                em.close();
            }
            // Cerrar el EntityManagerFactory para liberar recursos
            closeEntityManagerFactory();
        }
    }
    
    // Método para obtener un dispositivo de la base de datos usando su ID
    public void ObtenerTurnoTrabajoPorID(int id) {
        System.out.println("_______Turno de trabajo_______");
        
        // Inicializar EntityManager a null
        em = null;
        try {
            // Obtener el EntityManager
            em = getEntityManager();

            // Buscar el turno en la base de datos usando el ID proporcionado
            Turno_trabajo turno = em.find(Turno_trabajo.class, id);

            // Verificar si se encontró el turno
            if (turno != null) {
                // Imprimir la información del turno si se encuentra
                System.out.println("Turno: " + turno);
            } else {
                // Imprimir un mensaje si no se encuentra el turno
                System.out.println("No se encontró un turno con el ID " + id);
            }
        } catch (Exception e) {
            // Imprimir la excepción si ocurre un error
            e.printStackTrace(System.out);
        } finally {
            // Cerrar el EntityManager para liberar recursos
            if (em != null && em.isOpen()) {
                em.close();
            }
            // Cerrar el EntityManagerFactory para liberar recursos
            closeEntityManagerFactory();
        }
    }
    
    // Método para obtener un historial de la base de datos usando su ID
    public void ObtenerHistorialDispositivoPorID(int id) {
        System.out.println("_______Historial de dispositivo_______");
        
        // Inicializar EntityManager a null
        em = null;
        try {
            // Obtener el EntityManager
            em = getEntityManager();

            // Buscar el historial en la base de datos usando el ID proporcionado
            Historial_dispositivo historial = em.find(Historial_dispositivo.class, id);

            // Verificar si se encontró el turno
            if (historial != null) {
                // Imprimir la información del turno si se encuentra
                System.out.println("Historial: " + historial);
            } else {
                // Imprimir un mensaje si no se encuentra el historial
                System.out.println("No se encontró un historial con el ID " + id);
            }
        } catch (Exception e) {
            // Imprimir la excepción si ocurre un error
            e.printStackTrace(System.out);
        } finally {
            // Cerrar el EntityManager para liberar recursos
            if (em != null && em.isOpen()) {
                em.close();
            }
            // Cerrar el EntityManagerFactory para liberar recursos
            closeEntityManagerFactory();
        }
    }
}
