package com.deivid.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

// Define que esta clase es una entidad JPA, correspondiente a una tabla en la base de datos
@Entity
public class Historial_dispositivo implements Serializable {

    // Define la clave primaria de la entidad
    // Se define el generador automático para el id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_historial;

    // Define una relación muchos-a-uno con la entidad Dispositivo
    @JoinColumn(name = "id_dispositivo")
    @ManyToOne
    @NotNull(message = "El dispositivo no puede ser nulo")
    private Dispositivo id_dispositivo;

    // Define una relación muchos-a-uno con la entidad Turno_trabajo
    @JoinColumn(name = "id_turno")
    @ManyToOne
    @NotNull(message = "El turno de trabajo no puede ser nulo")
    private Turno_trabajo id_turno;

    // Define las columnas adicionales en la tabla
    // Se definen todas las validaciones necesarias
    @Pattern(
            regexp = "^[0-9]+$",
            message = "Las almohadillas solo pueden contener números")
    private String almohadillas;

    @Pattern(
            regexp = "^[0-9]+$",
            message = "Las páginas impresas solo pueden contener números")
    private String paginas_impresas;

    @Pattern(
            regexp = "^[0-9]+$",
            message = "Las páginas ADF solo pueden contener números")
    private String paginas_adf;

    @Size(max = 500, message = "Las observaciones no pueden exceder los 500 caracteres")
    private String observaciones;

    // Constructor por defecto
    public Historial_dispositivo() {
    }

    // Getters y Setters para cada atributo
    public int getId_historial() {
        return id_historial;
    }

    public void setId_historial(int id_historial) {
        this.id_historial = id_historial;
    }

    public Dispositivo getId_dispositivo() {
        return id_dispositivo;
    }

    public void setId_dispositivo(Dispositivo id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }

    public Turno_trabajo getId_turno() {
        return id_turno;
    }

    public void setId_turno(Turno_trabajo id_turno) {
        this.id_turno = id_turno;
    }

    public String getAlmohadillas() {
        return almohadillas;
    }

    public void setAlmohadillas(String almohadillas) {
        this.almohadillas = almohadillas;
    }

    public String getPaginas_impresas() {
        return paginas_impresas;
    }

    public void setPaginas_impresas(String paginas_impresas) {
        this.paginas_impresas = paginas_impresas;
    }

    public String getPaginas_adf() {
        return paginas_adf;
    }

    public void setPaginas_adf(String paginas_adf) {
        this.paginas_adf = paginas_adf;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    // Método toString para mostrar la información del historial del dispositivo
    @Override
    public String toString() {
        return "Historial_dispositivo{\n"
                + "id_historial=" + id_historial
                + ",\n id_dispositivo=" + id_dispositivo
                + ",\n id_turno=" + id_turno
                + ",\n almohadillas=" + almohadillas
                + ",\n paginas_impresas=" + paginas_impresas
                + ",\n paginas_adf=" + paginas_adf
                + ",\n observaciones=" + observaciones
                + '}';
    }

    // Método hashCode para generar un código hash basado en 'id_historial'
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id_historial;
        return hash;
    }

    // Método equals para comparar dos objetos Historial_dispositivo por 'id_historial'
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
        final Historial_dispositivo other = (Historial_dispositivo) obj;
        if (this.id_historial != other.id_historial) {
            return false; // Si los 'id_historial' son diferentes, retorna false
        }
        return true; // Si los 'id_historial' son iguales, retorna true
    }
}
