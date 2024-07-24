/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deivid.domain;

//import jakarta.persistence.*;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author david
 */
@Entity
public class Dispositivo implements Serializable{
    
    @Id
    @Column(name="id_dispositivo")
    private int idDispositivo;
    
    private String tipo;
    private String marca;
    private String referencia;
    
    @Column(name = "serial_num")
    private String serialNum;
    
    private String descripcion;
    
    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private int propietario;

    public Dispositivo() {
    }

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
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

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPropietario() {
        return propietario;
    }

    public void setPropietario(int propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "Dispositivo{" + "idDispositivo=" + idDispositivo + ", tipo=" + tipo + ", marca=" + marca + ", referencia=" + referencia + ", serialNum=" + serialNum + ", descripcion=" + descripcion + ", propietario=" + propietario + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idDispositivo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dispositivo other = (Dispositivo) obj;
        if (this.idDispositivo != other.idDispositivo) {
            return false;
        }
        return true;
    }
    
    
    
}
