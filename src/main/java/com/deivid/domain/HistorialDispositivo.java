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
//Se etiqueta como entidad igual a la tabla de la base de datos
@Entity
public class HistorialDispositivo implements Serializable{
    
    //Se etiqueta la columna que define el id de la tabla
    @Id
    @Column(name = "id_historial")
    private int idHistorial;
    
    @JoinColumn(name = "id_dispositivo")
    @ManyToOne
    private int dispositivo;
    
    @JoinColumn(name = "id_turno")
    @ManyToOne
    @Column(name = "turno_trabajo")
    private int turnoTrabajo;
    
    private String almohadillas;
    
    @Column(name = "paginas_impresas")
    private String paginasImpresas;
    
    @Column(name = "paginas_adf")
    private String paginasAdf;
    
    private String observaciones;

    public HistorialDispositivo() {
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(int dispositivo) {
        this.dispositivo = dispositivo;
    }

    public int getTurnoTrabajo() {
        return turnoTrabajo;
    }

    public void setTurnoTrabajo(int turnoTrabajo) {
        this.turnoTrabajo = turnoTrabajo;
    }

    public String getAlmohadillas() {
        return almohadillas;
    }

    public void setAlmohadillas(String almohadillas) {
        this.almohadillas = almohadillas;
    }

    public String getPaginasImpresas() {
        return paginasImpresas;
    }

    public void setPaginasImpresas(String paginasImpresas) {
        this.paginasImpresas = paginasImpresas;
    }

    public String getPaginasAdf() {
        return paginasAdf;
    }

    public void setPaginasAdf(String paginasAdf) {
        this.paginasAdf = paginasAdf;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "HistorialDispositivo{" + "idHistorial=" + idHistorial + ", dispositivo=" + dispositivo + ", turnoTrabajo=" + turnoTrabajo + ", almohadillas=" + almohadillas + ", paginasImpresas=" + paginasImpresas + ", paginasAdf=" + paginasAdf + ", observaciones=" + observaciones + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.idHistorial;
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
        final HistorialDispositivo other = (HistorialDispositivo) obj;
        if (this.idHistorial != other.idHistorial) {
            return false;
        }
        return true;
    }
    
    
    
}
