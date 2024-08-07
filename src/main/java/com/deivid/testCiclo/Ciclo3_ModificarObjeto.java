package com.deivid.testCiclo;

import com.deivid.dao.GenericDAO;
import com.deivid.domain.Usuario;

public class Ciclo3_ModificarObjeto extends GenericDAO {

    public static void main(String[] args) {
        // Crear una instancia de Ciclo3_ModificarObjeto para acceder al método modificarUsuarioPorId
        Ciclo3_ModificarObjeto ciclo = new Ciclo3_ModificarObjeto();
        
        // Llamar al método modificarUsuarioPorId con el ID 1 para modificar el usuario correspondiente
        ciclo.modificarUsuarioPorId(1);
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
}
