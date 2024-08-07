package com.deivid.dao;

import com.deivid.domain.Turno_trabajo;
import java.util.List;
import javax.persistence.Query;

// DAO (Data Access Object) para la tabla 'turno_trabajo'
public class Turno_trabajoDAO extends GenericDAO {

    // Método para listar todos los registros de la tabla 'turno_trabajo'
    public List<Turno_trabajo> Mostrar() {
        em = null; // Inicializa el EntityManager como null
        try {
            em = getEntityManager(); // Obtiene el EntityManager
            String consulta = "SELECT t FROM Turno_trabajo t"; // Consulta JPQL para obtener todos los turnos de trabajo
            Query query = em.createQuery(consulta); // Crea la consulta
            return query.getResultList(); // Ejecuta la consulta y retorna la lista de turnos de trabajo
        } finally {
            // Cierra el EntityManager si está abierto
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    // Método para ingresar un nuevo turno de trabajo en la base de datos
    public void Ingresar(Turno_trabajo turno) {
        try {
            em = getEntityManager(); // Obtiene el EntityManager
            em.getTransaction().begin(); // Inicia la transacción
            em.persist(turno); // Persiste (guarda) el turno de trabajo en la base de datos
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

    // Método para modificar un turno de trabajo existente en la base de datos
    public void Modificar(Turno_trabajo turno) {
        try {
            em = getEntityManager(); // Obtiene el EntityManager
            em.getTransaction().begin(); // Inicia la transacción
            em.merge(turno); // Actualiza el turno de trabajo en la base de datos
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

    // Método para eliminar un turno de trabajo de la base de datos
    public void Eliminar(Turno_trabajo turno) {
        try {
            em = getEntityManager(); // Obtiene el EntityManager
            em.getTransaction().begin(); // Inicia la transacción
            em.remove(em.merge(turno)); // Elimina el turno de trabajo (después de asegurarse de que esté gestionado)
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

    // Método para buscar un turno de trabajo por su ID
    public Object buscarPorId(Turno_trabajo turno) {
        em = getEntityManager(); // Obtiene el EntityManager
        // Busca y retorna el turno de trabajo con el ID especificado
        return em.find(Turno_trabajo.class, turno.getId_turno());
    }
}
