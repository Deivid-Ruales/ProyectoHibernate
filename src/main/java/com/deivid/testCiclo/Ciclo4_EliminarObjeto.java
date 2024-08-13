package com.deivid.testCiclo;

import com.deivid.dao.GenericDAO;
import com.deivid.domain.Usuario;

public class Ciclo4_EliminarObjeto extends GenericDAO {

    public static void main(String[] args) {
        // Crear una instancia de Ciclo4_EliminarObjeto para acceder al método eliminarUsuarioPorId
        Ciclo4_EliminarObjeto ciclo = new Ciclo4_EliminarObjeto();
        
        // Llamar al método eliminarUsuarioPorId con el ID 7 para eliminar el usuario correspondiente
        ciclo.eliminarUsuarioPorId(10);
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
}
