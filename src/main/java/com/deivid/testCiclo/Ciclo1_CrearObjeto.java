package com.deivid.testCiclo;

import com.deivid.dao.GenericDAO;
import com.deivid.domain.Rol;
import com.deivid.domain.Usuario;

public class Ciclo1_CrearObjeto extends GenericDAO {

    public static void main(String[] args) {
        // Crear una instancia de Ciclo1_CrearObjeto para acceder al método GuardarUsuario
        Ciclo1_CrearObjeto ciclo = new Ciclo1_CrearObjeto();

        // Llamar al método GuardarUsuario para guardar un nuevo usuario en la base de datos
        ciclo.GuardarUsuario();
    }

    // Método para crear y guardar un nuevo usuario en la base de datos
    public void GuardarUsuario() {
        // Crear una nueva instancia de Usuario
        Usuario usuario = new Usuario();

        // Configurar los atributos del usuario
        usuario.setCedula("1085303555"); // Número de identificación del usuario
        usuario.setContrasena("123456"); // Contraseña del usuario
        usuario.setDireccion("Calle 12 No. 3 - 23 Pasto"); // Dirección del usuario
        usuario.setEmail("david@gmail.com"); // Correo electrónico del usuario
        usuario.setNombre("David"); // Nombre del usuario
        usuario.setRol(Rol.Cliente); // Rol del usuario (enum Rol)
        usuario.setTelefono("3153335555"); // Número de teléfono del usuario

        try {
            // Obtener el EntityManager
            em = getEntityManager();

            // Iniciar una transacción
            em.getTransaction().begin();

            // Persistir (guardar) el nuevo usuario en la base de datos
            em.persist(usuario);

            // Confirmar la transacción
            em.getTransaction().commit();
        } catch (Exception e) {
            // Imprimir el error si ocurre una excepción
            if (em == null) {
                e.printStackTrace(System.out);
            }
        } finally {
            // Cerrar el EntityManager
            if (em != null && em.isOpen()) {
                em.close();
            }
        }

        // Imprimir los detalles del usuario guardado
        System.out.println("Usuario = " + usuario);

        // Cerrar el EntityManagerFactory para liberar recursos
        closeEntityManagerFactory();
    }
}
