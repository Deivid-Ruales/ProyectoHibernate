package com.deivid.dao;

import javax.persistence.*;

// Clase abstracta GenericDAO que proporciona métodos comunes para la gestión de la entidad
public abstract class GenericDAO {
    // EntityManager se encarga de las operaciones CRUD en la base de datos
    protected static EntityManager em;
    
    // EntityManagerFactory se utiliza para crear EntityManagers
    private static EntityManagerFactory emf;
    
    // Nombre de la unidad de persistencia (debe coincidir con el definido en persistence.xml)
    private static final String PU = "sari";
    
    // Constructor de GenericDAO
    public GenericDAO(){
        // Si la fábrica de EntityManager no ha sido creada, la crea usando la unidad de persistencia
        if(emf == null){
            emf = Persistence.createEntityManagerFactory(PU);
        }
    }
    
    // Método para obtener el EntityManager
    protected EntityManager getEntityManager() {
        // Si el EntityManager no ha sido creado, lo crea usando la fábrica de EntityManager
        if (em == null) {
            em = emf.createEntityManager();
        }
        return em;
    }

    // Método para cerrar el EntityManager
    protected void closeEntityManager() {
        // Si el EntityManager está abierto, lo cierra
        if (em != null && em.isOpen()) {
            em.close();
        }
    }

    // Método para cerrar la fábrica de EntityManager
    protected void closeEntityManagerFactory() {
        // Si la fábrica de EntityManager está abierta, la cierra
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
