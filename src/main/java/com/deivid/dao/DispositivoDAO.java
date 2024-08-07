package com.deivid.dao;

import com.deivid.domain.Dispositivo;
import java.util.List;
import javax.persistence.Query;

// DAO (Data Access Object) para la tabla 'dispositivo'
public class DispositivoDAO extends GenericDAO {

    // Método para listar todos los registros de la tabla 'dispositivo'
    public List<Dispositivo> Mostrar() {
        em = null; // Inicializa el EntityManager como null
        try {
            em = getEntityManager(); // Obtiene el EntityManager
            String consulta = "SELECT d FROM Dispositivo d"; // Consulta JPQL para obtener todos los dispositivos
            Query query = em.createQuery(consulta); // Crea la consulta
            return query.getResultList(); // Ejecuta la consulta y retorna la lista de dispositivos
        } finally {
            // Cierra el EntityManager si está abierto
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    // Método para ingresar un nuevo dispositivo en la base de datos
    public void Ingresar(Dispositivo dispositivo) {
        try {
            em = getEntityManager(); // Obtiene el EntityManager
            em.getTransaction().begin(); // Inicia la transacción
            em.persist(dispositivo); // Persiste (guarda) el dispositivo en la base de datos
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

    // Método para modificar un dispositivo existente en la base de datos
    public void Modificar(Dispositivo dispositivo) {
        try {
            em = getEntityManager(); // Obtiene el EntityManager
            em.getTransaction().begin(); // Inicia la transacción
            em.merge(dispositivo); // Actualiza el dispositivo en la base de datos
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

    // Método para eliminar un dispositivo de la base de datos
    public void Eliminar(Dispositivo dispositivo) {
        try {
            em = getEntityManager(); // Obtiene el EntityManager
            em.getTransaction().begin(); // Inicia la transacción
            em.remove(em.merge(dispositivo)); // Elimina el dispositivo (después de asegurarse de que esté gestionado)
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

    // Método para buscar un dispositivo por su ID
    public Object buscarPorId(Dispositivo dispositivo) {
        em = getEntityManager(); // Obtiene el EntityManager
        // Busca y retorna el dispositivo con el ID especificado
        return em.find(Dispositivo.class, dispositivo.getId_dispositivo());
    }
}
