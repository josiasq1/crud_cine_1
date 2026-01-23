package com.example.crud_cine.model;

import jakarta.persistence.*;

@Entity
@Table(name = "proyecciones")
public class Proyecciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  idProyeccion;

    @Column(name = "id_pelicula")
    private int idPelicula;

    @Column(name = "id_sala")
    private int idSala;

    @Column(name = "fecha_hora_inicio")
    private String fechaHoraInicio;

    @Column(name = "fecha_hora_fin")
    private String fechaHoraFin;

    @Column(name = "precio_entrada")
    private double precioEntrada;

    @Column(name = "asientos_disponibles")
    private int asientosDisponibles;

    public Proyecciones() {
    }

    public Proyecciones(int idProyeccion, int idPelicula, int idSala, String fechaHoraInicio, String fechaHoraFin, int asientosDisponibles, double precioEntrada) {
        this.idProyeccion = idProyeccion;
        this.idPelicula = idPelicula;
        this.idSala = idSala;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.asientosDisponibles = asientosDisponibles;
        this.precioEntrada = precioEntrada;
    }

    public int getIdProyeccion() {
        return idProyeccion;
    }

    public void setIdProyeccion(int idProyeccion) {
        this.idProyeccion = idProyeccion;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
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

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(int asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }

    @Override
    public String toString() {
        return "Proyecciones{" +
                "idProyeccion=" + idProyeccion +
                ", idPelicula=" + idPelicula +
                ", idSala=" + idSala +
                ", fecha_hora_inicio='" + fechaHoraInicio + '\'' +
                ", fecha_hora_fin='" + fechaHoraFin + '\'' +
                ", precio_entrada=" + precioEntrada +
                ", asientos_disponibles=" + asientosDisponibles +
                '}';
    }
}
