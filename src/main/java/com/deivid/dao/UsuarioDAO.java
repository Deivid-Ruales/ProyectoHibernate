package com.deivid.dao;

import com.deivid.domain.Usuario;
import java.util.List;
import javax.persistence.Query;

// DAO (Data Access Object) para la tabla 'usuario'
public class UsuarioDAO extends GenericDAO {

    // Método para listar todos los registros de la tabla 'usuario'
    public List<Usuario> Mostrar() {
        em = null; // Inicializa el EntityManager como null
        try {
            em = getEntityManager(); // Obtiene el EntityManager
            String consulta = "SELECT u FROM Usuario u"; // Consulta JPQL para obtener todos los usuarios
            Query query = em.createQuery(consulta); // Crea la consulta
            return query.getResultList(); // Ejecuta la consulta y retorna la lista de usuarios
        } finally {
            // Cierra el EntityManager si está abierto
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    // Método para ingresar un nuevo usuario en la base de datos
    public void Ingresar(Usuario usuario) {
        try {
            em = getEntityManager(); // Obtiene el EntityManager
            em.getTransaction().begin(); // Inicia la transacción
            em.persist(usuario); // Persiste (guarda) el usuario en la base de datos
            em.getTransaction().commit(); // Confirma la transacción
        } catch (Exception e) {
            e.printStackTrace(System.out); // Imprime cualquier error que ocurra
        } finally {
            // Cierra el EntityManager
            if (em != null) {
                em.close();
            }
        }
    }

    // Método para modificar un usuario existente en la base de datos
    public void Modificar(Usuario usuario) {
        try {
            em = getEntityManager(); // Obtiene el EntityManager
            em.getTransaction().begin(); // Inicia la transacción
            em.merge(usuario); // Actualiza el usuario en la base de datos
            em.getTransaction().commit(); // Confirma la transacción
        } catch (Exception e) {
            e.printStackTrace(System.out); // Imprime cualquier error que ocurra
        } finally {
            // Cierra el EntityManager
            if (em != null) {
                em.close();
            }
        }
    }

    // Método para eliminar un usuario de la base de datos
    public void Eliminar(Usuario usuario) {
        try {
            em = getEntityManager(); // Obtiene el EntityManager
            em.getTransaction().begin(); // Inicia la transacción
            em.remove(em.merge(usuario)); // Elimina el usuario (después de asegurarse de que esté gestionado)
            em.getTransaction().commit(); // Confirma la transacción
        } catch (Exception e) {
            e.printStackTrace(System.out); // Imprime cualquier error que ocurra
        } finally {
            // Cierra el EntityManager
            if (em != null) {
                em.close();
            }
        }
    }

    // Método para buscar un usuario por su ID
    public Object buscarPorId(Usuario usuario) {
        em = getEntityManager(); // Obtiene el EntityManager
        // Busca y retorna el usuario con el ID especificado
        return em.find(Usuario.class, usuario.getId_usuario());
    }
}
