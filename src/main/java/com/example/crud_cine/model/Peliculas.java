package com.example.crud_cine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

    @Entity
    @Table(name = "peliculas")
    public class Peliculas {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_pelicula")
        private Integer idPelicula;

        @Column(name = "titulo")
        private String titulo;

        @Column(name = "duracion_minutos")
        private String duracionMinutos;

        @Column(name = "genero")
        private String genero;

        @Column(name = "clasificacion")
        private String clasificacion;

        @Column(name = "director")
        private String director;

        @Column(name = "sinopsis", columnDefinition = "Text")
        private String sinopsis;

        @Column(name = "fecha_estreno")
        String fechaEstreno;

        @Column(name = "popularidad")
        String popularidad;

        @JsonIgnore
        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        @Column(name = "activa")
        private boolean activa;


        @Column(name = "fecha_baja")
        String fechaBaja;

        public Peliculas() {} // Constructor vacío necesario para Hibernate

        public Peliculas(Integer idPelicula, String titulo, String duracionMinutos, String genero, String clasificacion, String director, String sinopsis, String fechaEstreno, String popularidad, boolean activa, String fechaBaja) {
            this.idPelicula = idPelicula;
            this.titulo = titulo;
            this.duracionMinutos = duracionMinutos;
            this.genero = genero;
            this.clasificacion = clasificacion;
            this.director = director;
            this.sinopsis = sinopsis;
            this.fechaEstreno = fechaEstreno;
            this.popularidad = popularidad;
            this.activa = activa;
            this.fechaBaja = fechaBaja;
        }

        public Integer getIdPelicula() {
            return idPelicula;
        }

        public void setIdPelicula(Integer idPelicula) {
            this.idPelicula = idPelicula;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getDuracionMinutos() {
            return duracionMinutos;
        }

        public void setDuracionMinutos(String duracionMinutos) {
            this.duracionMinutos = duracionMinutos;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public String getClasificacion() {
            return clasificacion;
        }

        public void setClasificacion(String clasificacion) {
            this.clasificacion = clasificacion;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getSinopsis() {
            return sinopsis;
        }

        public void setSinopsis(String sinopsis) {
            this.sinopsis = sinopsis;
        }

        public String getFechaEstreno() {
            return fechaEstreno;
        }

        public void setFechaEstreno(String fechaEstreno) {
            this.fechaEstreno = fechaEstreno;
        }

        public String getPopularidad() {
            return popularidad;
        }

        public void setPopularidad(String popularidad) {
            this.popularidad = popularidad;
        }

        public boolean isActiva() {
            return activa;
        }

        public void setActiva(boolean activa) {
            this.activa = activa;
        }

        public String getFechaBaja() {
            return fechaBaja;
        }

        public void setFechaBaja(String fechaBaja) {
            this.fechaBaja = fechaBaja;
        }

        @Override
        public String toString() {
            return "Peliculas{" +
                    "idPelicula=" + idPelicula +
                    ", titulo='" + titulo + '\'' +
                    ", duracionMinutos='" + duracionMinutos + '\'' +
                    ", genero='" + genero + '\'' +
                    ", clasificacion='" + clasificacion + '\'' +
                    ", director='" + director + '\'' +
                    ", sinopsis='" + sinopsis + '\'' +
                    ", fechaEstreno='" + fechaEstreno + '\'' +
                    ", popularidad='" + popularidad + '\'' +
                    ", activa=" + activa +
                    ", fechaBaja='" + fechaBaja + '\'' +
                    '}';
        }


    }