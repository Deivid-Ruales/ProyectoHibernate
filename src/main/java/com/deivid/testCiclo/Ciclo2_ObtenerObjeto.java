package com.deivid.testCiclo;

import com.deivid.dao.GenericDAO;
import com.deivid.domain.Usuario;

public class Ciclo2_ObtenerObjeto extends GenericDAO {

    public static void main(String[] args) {
        // Crear una instancia de Ciclo2_ObtenerObjeto para acceder al método ObtenerUsuarioPorID
        Ciclo2_ObtenerObjeto ciclo = new Ciclo2_ObtenerObjeto();

        // Llamar al método ObtenerUsuarioPorID con el ID 1 para obtener y mostrar el usuario correspondiente
        ciclo.ObtenerUsuarioPorID(1);
    }

    // Método para obtener un usuario de la base de datos usando su ID
    public void ObtenerUsuarioPorID(int id) {
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
}
