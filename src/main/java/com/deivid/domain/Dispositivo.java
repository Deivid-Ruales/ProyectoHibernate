package com.deivid.domain;

import java.io.Serializable;
import javax.persistence.*;

// Define que esta clase es una entidad que se mapeará a una tabla en la base de datos
@Entity
public class Dispositivo implements Serializable {

    // Define la clave primaria de la entidad
    @Id
    private int id_dispositivo;

    // Define las columnas de la tabla
    private String tipo;
    private String marca;
    private String referencia;
    private String serial_num;
    private String descripcion;

    // Define una relación muchos-a-uno con la entidad Usuario y la columna 'id_usuario' en la tabla
    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private Usuario id_usuario;

    // Constructor por defecto
    public Dispositivo() {
    }

    // Getters y Setters para cada atributo
    public int getId_dispositivo() {
        return id_dispositivo;
    }

    public void setId_dispositivo(int id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getSerial_num() {
        return serial_num;
    }

    public void setSerial_num(String serial_num) {
        this.serial_num = serial_num;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    // Método toString para imprimir la información del dispositivo
    @Override
    public String toString() {
        return "Dispositivo{" + "id_dispositivo=" + id_dispositivo + ", tipo=" + tipo + ", marca=" + marca + ", referencia=" + referencia + ", serial_num=" + serial_num + ", descripcion=" + descripcion + ", id_usuario=" + id_usuario + '}';
    }

    // Método hashCode para generar un código hash basado en 'id_dispositivo'
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id_dispositivo;
        return hash;
    }

    // Método equals para comparar dos objetos Dispositivo por 'id_dispositivo'
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
        final Dispositivo other = (Dispositivo) obj;
        if (this.id_dispositivo != other.id_dispositivo) {
            return false; // Si los 'id_dispositivo' son diferentes, retorna false
        }
        return true; // Si los 'id_dispositivo' son iguales, retorna true
    }
}
