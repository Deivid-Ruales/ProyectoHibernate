package com.deivid.testCiclo;

import com.deivid.dao.GenericDAO;
import com.deivid.domain.Rol;
import com.deivid.domain.Usuario;
import com.deivid.domain.Dispositivo;
import com.deivid.domain.Estado;
import com.deivid.domain.Historial_dispositivo;
import com.deivid.domain.Turno_trabajo;
import java.time.LocalDateTime;

public class Ciclo1_CrearObjeto extends GenericDAO {

    public static void main(String[] args) {
        // Crear una instancia de Ciclo1_CrearObjeto para acceder al método GuardarUsuario
        Ciclo1_CrearObjeto ciclo = new Ciclo1_CrearObjeto();

        // Llamar al método GuardarUsuario para guardar un nuevo usuario en la base de datos
        //ciclo.GuardarUsuario();
        // Llamar al método GuardarDispositivo para guardar un nuevo dispositivo del usuario 3 en la base de datos
        //ciclo.GuardarDispositivo(3);
        // Llamar al método GuardarTurnoTrabajo para guardar un nuevo turno de trabajo asignado a un dispositivo y creado por un usuario
        //ciclo.GuardarTurnoTrabajo(2, 3);
        // Llamar al método GuardarHistorialDispositivo para guardar un nuevo historial de un dispositivo asignado en un turno de trabajo
        //ciclo.GuardarHistorialDispositivo(6, 2);
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

    // Método para crear y guardar un nuevo usuario en la base de datos
    public void GuardarDispositivo(int idUsuario) {
        em = getEntityManager();

        // Buscar el usuario en la base de datos utilizando su ID
        Usuario usuario = em.find(Usuario.class, idUsuario);

        // Crear una nueva instancia de Dispositivo
        Dispositivo dispositivo = new Dispositivo();

        // Configurar los atributos del dispositivo
        dispositivo.setTipo("Impresora multifuncional");
        dispositivo.setMarca("Epson");
        dispositivo.setReferencia("L3110");
        dispositivo.setSerial_num("asdf1234");
        dispositivo.setDescripcion("Con depósito de tinta");
        dispositivo.setId_usuario(usuario);

        try {
            // Obtener el EntityManager
            em = getEntityManager();

            // Iniciar una transacción
            em.getTransaction().begin();

            // Persistir (guardar) el nuevo dispositivo en la base de datos
            em.persist(dispositivo);

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
        System.out.println("Dispositivo = " + dispositivo);

        // Cerrar el EntityManagerFactory para liberar recursos
        closeEntityManagerFactory();
    }

    // Método para crear y guardar un nuevo turno de trabajo en la base de datos
    public void GuardarTurnoTrabajo(int idUsuario, int idDispositivo) {
        em = getEntityManager();

        // Buscar el usuario en la base de datos utilizando su ID
        Usuario usuario = em.find(Usuario.class, idUsuario);

        // Buscar el dispositivo en la base de datos utilizando su ID
        Dispositivo dispositivo = em.find(Dispositivo.class, idDispositivo);

        // Crear una nueva instancia de Turno de trabajo
        Turno_trabajo turnoTrabajo = new Turno_trabajo();

        // Configurar los atributos del turno de trabajo
        turnoTrabajo.setFecha_hora_inicio(LocalDateTime.now());
        turnoTrabajo.setEstado(Estado.En_Turno);
        turnoTrabajo.setId_dispositivo(dispositivo);
        turnoTrabajo.setId_usuario(usuario);

        try {
            // Obtener el EntityManager
            em = getEntityManager();

            // Iniciar una transacción
            em.getTransaction().begin();

            // Persistir (guardar) el nuevo turno de trabajo en la base de datos
            em.persist(turnoTrabajo);

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
        System.out.println("Turno de trabajo = " + turnoTrabajo);

        // Cerrar el EntityManagerFactory para liberar recursos
        closeEntityManagerFactory();
    }

    // Método para crear y guardar un nuevo turno de trabajo en la base de datos
    public void GuardarHistorialDispositivo(int idTurno, int idDispositivo) {
        em = getEntityManager();

        // Buscar el turno en la base de datos utilizando su ID
        Turno_trabajo turno = em.find(Turno_trabajo.class, idTurno);

        // Buscar el dispositivo en la base de datos utilizando su ID
        Dispositivo dispositivo = em.find(Dispositivo.class, idDispositivo);

        // Crear la instancia de Historial de dispositivo
        Historial_dispositivo historial = new Historial_dispositivo();

        // Configurar los atributos del historial de dispositivo
        historial.setId_dispositivo(dispositivo);
        historial.setId_turno(turno);
        historial.setObservaciones("Mantenimiento");
        historial.setAlmohadillas("12,33%");
        historial.setPaginas_adf("1500");
        historial.setPaginas_impresas("16500");

        try {
            // Obtener el EntityManager
            em = getEntityManager();

            // Iniciar una transacción
            em.getTransaction().begin();

            // Persistir (guardar) el nuevo turno de trabajo en la base de datos
            em.persist(historial);

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
        System.out.println("Historial de dispositivo = " + historial);

        // Cerrar el EntityManagerFactory para liberar recursos
        closeEntityManagerFactory();
    }
}
