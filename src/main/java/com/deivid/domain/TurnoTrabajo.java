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
public class TurnoTrabajo implements Serializable{
    
    @Id
    @Column(name = "id_turno")
    private int idTurno;
    
    @Column(name = "fecha_hora_inicio")
    private String fechaHoraInicio;
    
    @Column(name = "fecha_hora_fin")
    private String fechaHoraFin;
    
    private String estado;
    
    @JoinColumn(name = "id_dispositivo")
    @ManyToOne
    private int dispositivo;
    
    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private int encargado;

    public TurnoTrabajo() {
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public String getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(String fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public String getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(String fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(int dispositivo) {
        this.dispositivo = dispositivo;
    }

    public int getEncargado() {
        return encargado;
    }

    public void setEncargado(int encargado) {
        this.encargado = encargado;
    }

    @Override
    public String toString() {
        return "TurnoTrabajo{" + "idTurno=" + idTurno + ", fechaHoraInicio=" + fechaHoraInicio + ", fechaHoraFin=" + fechaHoraFin + ", estado=" + estado + ", dispositivo=" + dispositivo + ", encargado=" + encargado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.idTurno;
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
        final TurnoTrabajo other = (TurnoTrabajo) obj;
        if (this.idTurno != other.idTurno) {
            return false;
        }
        return true;
    }
    
    
    
}
