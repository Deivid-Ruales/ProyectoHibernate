package com.deivid.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

// Define la entidad JPA que representa la tabla Turno_trabajo en la base de datos
@Entity
public class Turno_trabajo implements Serializable {
    
    // Define la clave primaria de la entidad
    // // Se define el generador automático para el id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_turno;

    // Se ponen las validaciones necesarias para los ingresos
    // Define la columna que almacena la fecha y hora de inicio del turno
    @NotNull(message = "La fecha y hora de inicio no pueden ser nulas")
    private LocalDateTime fecha_hora_inicio;

    // Define la columna que almacena la fecha y hora de fin del turno
    @NotNull(message = "La fecha y hora de fin no pueden ser nulas")
    private LocalDateTime fecha_hora_fin;

    // Define la columna que almacena el estado del turno, usando el enum Estado
    @Enumerated(EnumType.STRING)
    @NotNull(message = "El estado del turno no puede ser nulo")
    private Estado estado;

    // Define una relación muchos-a-uno con la entidad Dispositivo
    @JoinColumn(name = "id_dispositivo")
    @ManyToOne
    @NotNull(message = "El dispositivo no puede ser nulo")
    private Dispositivo id_dispositivo;

    // Define una relación muchos-a-uno con la entidad Usuario
    @JoinColumn(name = "id_usuario")
    @ManyToOne
    @NotNull(message = "El usuario no puede ser nulo")
    private Usuario id_usuario;

    // Constructor por defecto
    public Turno_trabajo() {
    }

    // Getter y Setter para el id del turno
    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    // Getter y Setter para la fecha y hora de inicio del turno
    public LocalDateTime getFecha_hora_inicio() {
        return fecha_hora_inicio;
    }

    public void setFecha_hora_inicio(LocalDateTime fecha_hora_inicio) {
        this.fecha_hora_inicio = fecha_hora_inicio;
    }

    // Getter y Setter para la fecha y hora de fin del turno
    public LocalDateTime getFecha_hora_fin() {
        return fecha_hora_fin;
    }

    public void setFecha_hora_fin(LocalDateTime fecha_hora_fin) {
        this.fecha_hora_fin = fecha_hora_fin;
    }

    // Getter y Setter para el estado del turno
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    // Getter y Setter para el dispositivo asociado con el turno
    public Dispositivo getId_dispositivo() {
        return id_dispositivo;
    }

    public void setId_dispositivo(Dispositivo id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }

    // Getter y Setter para el usuario asociado con el turno
    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    // Método toString para proporcionar una representación en cadena del turno de trabajo
    @Override
    public String toString() {
        return "Turno_trabajo{" + 
            "id_turno=" + id_turno + 
            ", fecha_hora_inicio=" + fecha_hora_inicio + 
            ", fecha_hora_fin=" + fecha_hora_fin + 
            ", estado=" + estado + 
            ", id_dispositivo=" + id_dispositivo + 
            ", id_usuario=" + id_usuario + 
            '}';
    }

    // Método hashCode para generar un código hash basado en 'id_turno'
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id_turno;
        return hash;
    }

    // Método equals para comparar dos objetos Turno_trabajo por 'id_turno'
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
        final Turno_trabajo other = (Turno_trabajo) obj;
        if (this.id_turno != other.id_turno) {
            return false; // Si los 'id_turno' son diferentes, retorna false
        }
        return true; // Si los 'id_turno' son iguales, retorna true
    }
}
