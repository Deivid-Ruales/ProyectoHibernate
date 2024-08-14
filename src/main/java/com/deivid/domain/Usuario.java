package com.deivid.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

// Marca la clase como una entidad JPA que se mapea a una tabla en la base de datos
@Entity
public class Usuario implements Serializable {

    // Define la clave primaria de la entidad
    // Se define el generador automático para el id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;

    // Define otras columnas en la tabla
    // Se ponen las validaciones necesarias para el ingreso de datos que no sean nulos y que correspondan al atributo elegido
    @NotNull(message = "Debe ingresar un nombre válido")
    private String nombre;

    @NotNull(message = "Debe ingresar un número de cédula válido")
    private String cedula;

    @NotNull(message = "Debe ingresar un email válido")
    @Email(message = "El email debe tener un formato válido")
    private String email;

    @NotNull(message = "Debe ingresar una dirección válida")
    private String direccion;

    @NotNull(message = "Debe ingresar un número de teléfono válido")
    private String telefono;

    @NotNull(message = "Debe ingresar una contraseña")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$",
            message = "La contraseña debe contener al menos una letra mayúscula, una minúscula, un número y un carácter especial")
    private String contrasena;

    // Define una columna que almacena el rol del usuario usando el enum Rol
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Debe ingresar un rol válido")
    private Rol rol;

    // Constructor por defecto
    public Usuario() {
    }

    // Getter y Setter para el id del usuario
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    // Getter y Setter para el nombre del usuario
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para la cédula del usuario
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    // Getter y Setter para el email del usuario
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter y Setter para la dirección del usuario
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Getter y Setter para el teléfono del usuario
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Getter y Setter para el rol del usuario (usando el enum Rol)
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    // Getter y Setter para la contraseña del usuario
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // Método toString para proporcionar una representación en cadena del usuario
    @Override
    public String toString() {
        return "Usuario{\n"
                + "id_usuario=" + id_usuario
                + ",\n nombre=" + nombre
                + ",\n cedula=" + cedula
                + ",\n email=" + email
                + ",\n direccion=" + direccion
                + ",\n telefono=" + telefono
                + ",\n rol=" + rol
                + ",\n contrasena=" + contrasena
                + '}';
    }

    // Método hashCode para generar un código hash basado en 'id_usuario'
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id_usuario;
        return hash;
    }

    // Método equals para comparar dos objetos Usuario por 'id_usuario'
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Si los objetos son iguales, retorna true
        }
        if (obj == null) {
            return false; // Si el objeto comparado es null, retorna false
        }
        if (getClass() != obj.getClass()) {
            return false; // Si los objetos son de clases diferentes, retorna false
        }
        final Usuario other = (Usuario) obj;
        if (this.id_usuario != other.id_usuario) {
            return false; // Si los 'id_usuario' son diferentes, retorna false
        }
        return true; // Si los 'id_usuario' son iguales, retorna true
    }

}
