package com.deivid.dao;

import com.deivid.domain.Historial_dispositivo;
import java.util.List;
import javax.persistence.Query;

// DAO (Data Access Object) para la tabla 'historial_dispositivo'
public class Historial_dispositivoDAO extends GenericDAO {

    // Método para listar todos los registros de la tabla 'historial_dispositivo'
    public List<Historial_dispositivo> Mostrar() {
        em = null; // Inicializa el EntityManager como null
        try {
            em = getEntityManager(); // Obtiene el EntityManager
            String consulta = "SELECT h FROM Historial_dispositivo h"; // Consulta JPQL para obtener todos los historiales de dispositivo
            Query query = em.createQuery(consulta); // Crea la consulta
            return query.getResultList(); // Ejecuta la consulta y retorna la lista de historiales de dispositivo
        } finally {
            // Cierra el EntityManager si está abierto
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    // Método para ingresar un nuevo historial de dispositivo en la base de datos
    public void Ingresar(Historial_dispositivo historial) {
        try {
            em = getEntityManager(); // Obtiene el EntityManager
            em.getTransaction().begin(); // Inicia la transacción
            em.persist(historial); // Persiste (guarda) el historial en la base de datos
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

    // Método para modificar un historial de dispositivo existente en la base de datos
    public void Modificar(Historial_dispositivo historial) {
        try {
            em = getEntityManager(); // Obtiene el EntityManager
            em.getTransaction().begin(); // Inicia la transacción
            em.merge(historial); // Actualiza el historial en la base de datos
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

    // Método para eliminar un historial de dispositivo de la base de datos
    public void Eliminar(Historial_dispositivo historial) {
        try {
            em = getEntityManager(); // Obtiene el EntityManager
            em.getTransaction().begin(); // Inicia la transacción
            em.remove(em.merge(historial)); // Elimina el historial (después de asegurarse de que esté gestionado)
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

    // Método para buscar un historial de dispositivo por su ID
    public Object buscarPorId(Historial_dispositivo historial) {
        em = getEntityManager(); // Obtiene el EntityManager
        // Busca y retorna el historial con el ID especificado
        return em.find(Historial_dispositivo.class, historial.getId_historial());
    }
}
