package com.example.crud_cine.model;

import jakarta.persistence.*;

@Entity
@Table(name = "entradas")
public class Entradas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Long idEntrada;

    @Column(name = "id_proyeccion")
    private Integer idProyeccion;

    @Column(name = "fecha_hora")
    private String fechaHora;

    @Column(name = "asiento")
    private String asiento;

    @Column(name = "precio")
    private double precio;

    @Column(name = "vendida")
    private Boolean vendida;

    public Entradas(){ }

    public Entradas(Long idEntrada, Integer idProyeccion, String asiento, String fechaHora, double precio, Boolean vendida) {
        this.idEntrada = idEntrada;
        this.idProyeccion = idProyeccion;
        this.asiento = asiento;
        this.fechaHora = fechaHora;
        this.precio = precio;
        this.vendida = vendida;
    }

    public Integer getIdProyeccion() {
        return idProyeccion;
    }

    public void setIdProyeccion(Integer idProyeccion) {
        this.idProyeccion = idProyeccion;
    }

    public Long getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Long idEntrada) {
        this.idEntrada = idEntrada;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Boolean getVendida() {
        return vendida;
    }

    public void setVendida(Boolean vendida) {
        this.vendida = vendida;
    }

    @Override
    public String toString() {
        return "Entradas{" +
                "id_entrada=" + idEntrada +
                ", id_proyeccion=" + idProyeccion +
                ", fechaHora='" + fechaHora + '\'' +
                ", asiento='" + asiento + '\'' +
                ", precio=" + precio +
                ", vendida=" + vendida +
                '}';
    }
}
