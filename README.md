# 🎬 CRUD CINE - Sistema de Gestión Cinematográfica

Este proyecto es una aplicación **Spring Boot** para la gestión integral de un cine. Permite administrar empleados, películas, proyecciones y entradas, implementando una arquitectura de persistencia dual:

* **MySQL** como base de datos relacional principal (fuente de verdad).
* **MongoDB** como almacenamiento de documentos (logs y sincronización de empleados).

---

## 📂 Estructura del Proyecto

Basado en la estructura de paquetes definida:

```text
com.example.crud_cine
│
├── CrudCineApplication.java
│
├── conexion
│   └── ConexionBD.java
│
├── controller
│   ├── EmpleadoController.java
│   ├── EntradasController.java
│   ├── PeliculasController.java
│   └── ProyeccionesController.java
│
├── model
│   ├── mysql
│   │   ├── Empleado.java
│   │   ├── Entradas.java
│   │   ├── Peliculas.java
│   │   └── Proyecciones.java
│   │
│   └── mongo
│       └── EmpleadoDoc.java
│
├── repository
│   ├── EmpleadoRepository.java
│   ├── EntradasRepository.java
│   ├── PeliculasRepository.java
│   ├── ProyeccionesRepository.java
│   └── EmpleadoDocRepository.java
│
└── service
    ├── EmpleadoService.java
    ├── EntradasService.java
    ├── PeliculasService.java
    └── ProyeccionesService.java
