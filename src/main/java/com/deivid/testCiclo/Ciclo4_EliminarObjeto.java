package com.deivid.testCiclo;

import com.deivid.dao.GenericDAO;
import com.deivid.domain.Dispositivo;
import com.deivid.domain.Historial_dispositivo;
import com.deivid.domain.Turno_trabajo;
import com.deivid.domain.Usuario;

public class Ciclo4_EliminarObjeto extends GenericDAO {

    public static void main(String[] args) {
        // Crear una instancia de Ciclo4_EliminarObjeto para acceder al método eliminarUsuarioPorId
        Ciclo4_EliminarObjeto ciclo = new Ciclo4_EliminarObjeto();
        
        // Llamar al método eliminarUsuarioPorId para eliminar el usuario correspondiente
        ciclo.eliminarUsuarioPorId(10);
        
        // Llamar al método eliminarDispositivoPorId para eliminar el dispositivo correspondiente
        //ciclo.eliminarDispositivoPorId(6);
        
        // Llamar al método eliminarUsuarioPorId para eliminar el turno correspondiente
        //ciclo.eliminarTurnoTrabajoPorId(6);
        
        // Llamar al método eliminarUsuarioPorId para eliminar el historial correspondiente
        //ciclo.eliminarHistorialDispositivoPorId(6);
    }

    // Método para eliminar un usuario de la base de datos usando su ID
    public void eliminarUsuarioPorId(int id) {
        // Inicializar EntityManager
        em = null;
        try {
            // Obtener el EntityManager
            em = getEntityManager();

            // Buscar el usuario en la base de datos usando el ID proporcionado
            Usuario usuario = em.find(Usuario.class, id);

            // Verificar si se encontró el usuario
            if (usuario != null) {
                // Iniciar una transacción
                em.getTransaction().begin();

                // Eliminar el usuario de la base de datos
                em.remove(em.merge(usuario));

                // Confirmar la transacción
                em.getTransaction().commit();

                // Imprimir la información del usuario eliminado
                System.out.println("Datos eliminados = " + usuario);
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
            // Cerrar el EntityManagerFactory para liberar recursos adicionales
            closeEntityManagerFactory();
        }
    }
    
    // Método para eliminar un dispositivo de la base de datos usando su ID
    public void eliminarDispositivoPorId(int id) {
        // Inicializar EntityManager
        em = null;
        try {
            // Obtener el EntityManager
            em = getEntityManager();

            // Buscar el dispositivo en la base de datos usando el ID proporcionado
            Dispositivo dispositivo = em.find(Dispositivo.class, id);

            // Verificar si se encontró el dispositivo
            if (dispositivo != null) {
                // Iniciar una transacción
                em.getTransaction().begin();

                // Eliminar el dispositivo de la base de datos
                em.remove(em.merge(dispositivo));

                // Confirmar la transacción
                em.getTransaction().commit();

                // Imprimir la información del dispositivo eliminado
                System.out.println("Datos eliminados = \n" + dispositivo);
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
            // Cerrar el EntityManagerFactory para liberar recursos adicionales
            closeEntityManagerFactory();
        }
    }
    
    // Método para eliminar un turno de la base de datos usando su ID
    public void eliminarTurnoTrabajoPorId(int id) {
        // Inicializar EntityManager
        em = null;
        try {
            // Obtener el EntityManager
            em = getEntityManager();

            // Buscar el turno en la base de datos usando el ID proporcionado
            Turno_trabajo turno = em.find(Turno_trabajo.class, id);

            // Verificar si se encontró el turno
            if (turno != null) {
                // Iniciar una transacción
                em.getTransaction().begin();

                // Eliminar el turno de la base de datos
                em.remove(em.merge(turno));

                // Confirmar la transacción
                em.getTransaction().commit();

                // Imprimir la información del turno eliminado
                System.out.println("Datos eliminados = \n" + turno);
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
            // Cerrar el EntityManagerFactory para liberar recursos adicionales
            closeEntityManagerFactory();
        }
    }
    
    // Método para eliminar un historial de la base de datos usando su ID
    public void eliminarHistorialDispositivoPorId(int id) {
        // Inicializar EntityManager
        em = null;
        try {
            // Obtener el EntityManager
            em = getEntityManager();

            // Buscar el historial en la base de datos usando el ID proporcionado
            Historial_dispositivo historial = em.find(Historial_dispositivo.class, id);

            // Verificar si se encontró el historial
            if (historial != null) {
                // Iniciar una transacción
                em.getTransaction().begin();

                // Eliminar el historial de la base de datos
                em.remove(em.merge(historial));

                // Confirmar la transacción
                em.getTransaction().commit();

                // Imprimir la información del historial eliminado
                System.out.println("Datos eliminados = \n" + historial);
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
            // Cerrar el EntityManagerFactory para liberar recursos adicionales
            closeEntityManagerFactory();
        }
    }
}
