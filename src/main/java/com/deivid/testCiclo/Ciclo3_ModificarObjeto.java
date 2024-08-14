package com.deivid.testCiclo;

import com.deivid.dao.GenericDAO;
import com.deivid.domain.Dispositivo;
import com.deivid.domain.Estado;
import com.deivid.domain.Historial_dispositivo;
import com.deivid.domain.Turno_trabajo;
import com.deivid.domain.Usuario;

public class Ciclo3_ModificarObjeto extends GenericDAO {

    public static void main(String[] args) {
        // Crear una instancia de Ciclo3_ModificarObjeto para acceder al método modificarUsuarioPorId
        Ciclo3_ModificarObjeto ciclo = new Ciclo3_ModificarObjeto();
        
        // Llamar al método modificarUsuarioPorId con el ID 1 para modificar el usuario correspondiente
        ciclo.modificarUsuarioPorId(1);
        
        // Llamar al método modificarDispositivoPorId con el ID 1 para modificar el dispositivo correspondiente
        //ciclo.modificarDispositivoPorId(1);
        
        // Llamar al método modificarTurnoTrabajoPorId con el ID 1 para modificar el turno correspondiente
        //ciclo.modificarTurnoTrabajoPorId(1);
        
        // Llamar al método modificarHistoriaDispositivoPorId con el ID 1 para modificar el historial correspondiente
        //ciclo.modificarHistoriaDispositivoPorId(1);
    }

    // Método para modificar un usuario en la base de datos usando su ID
    public void modificarUsuarioPorId(int id) {
        // Inicializar EntityManager
        em = null;
        try {
            // Obtener el EntityManager
            em = getEntityManager();

            // Buscar el usuario en la base de datos usando el ID proporcionado
            Usuario usuario = em.find(Usuario.class, id);

            // Verificar si se encontró el usuario
            if (usuario != null) {
                // Modificar los atributos del usuario
                usuario.setEmail("nuevoemail@gmail.com");
                usuario.setDireccion("NuevaDireccion");

                // Iniciar una transacción
                em.getTransaction().begin();

                // Actualizar el usuario en la base de datos
                em.merge(usuario);

                // Confirmar la transacción
                em.getTransaction().commit();

                // Imprimir la información del usuario modificado
                System.out.println("Usuario modificado: " + usuario);
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
    
     // Método para modificar un dispositivo en la base de datos usando su ID
    public void modificarDispositivoPorId(int id) {
        // Inicializar EntityManager
        em = null;
        try {
            // Obtener el EntityManager
            em = getEntityManager();

            // Buscar el dispositivo en la base de datos usando el ID proporcionado
            Dispositivo dispositivo = em.find(Dispositivo.class, id);

            // Verificar si se encontró el dispositivo
            if (dispositivo != null) {
                // Modificar los atributos del dispositivo
                dispositivo.setDescripcion("Sin sistema de tinta");

                // Iniciar una transacción
                em.getTransaction().begin();

                // Actualizar el dispositivo en la base de datos
                em.merge(dispositivo);

                // Confirmar la transacción
                em.getTransaction().commit();

                // Imprimir la información del dispositivo modificado
                System.out.println("Dispositivo modificado: \n" + dispositivo);
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
    
     // Método para modificar un turno de trabajo en la base de datos usando su ID
    public void modificarTurnoTrabajoPorId(int id) {
        // Inicializar EntityManager
        em = null;
        try {
            // Obtener el EntityManager
            em = getEntityManager();

            // Buscar el turno en la base de datos usando el ID proporcionado
            Turno_trabajo turno = em.find(Turno_trabajo.class, id);

            // Verificar si se encontró el turno
            if (turno != null) {
                // Modificar los atributos del turno
                turno.setEstado(Estado.En_Servicio);

                // Iniciar una transacción
                em.getTransaction().begin();

                // Actualizar el turno en la base de datos
                em.merge(turno);

                // Confirmar la transacción
                em.getTransaction().commit();

                // Imprimir la información del usuario modificado
                System.out.println("Turno modificado: \n" + turno);
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
    
     // Método para modificar un historial en la base de datos usando su ID
    public void modificarHistoriaDispositivoPorId(int id) {
        // Inicializar EntityManager
        em = null;
        try {
            // Obtener el EntityManager
            em = getEntityManager();

            // Buscar el historial en la base de datos usando el ID proporcionado
            Historial_dispositivo historial = em.find(Historial_dispositivo.class, id);

            // Verificar si se encontró el historial
            if (historial != null) {
                // Modificar los atributos del historial
                historial.setAlmohadillas("66%");

                // Iniciar una transacción
                em.getTransaction().begin();

                // Actualizar el historial en la base de datos
                em.merge(historial);

                // Confirmar la transacción
                em.getTransaction().commit();

                // Imprimir la información del historial modificado
                System.out.println("Historial modificado: \n" + historial);
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
