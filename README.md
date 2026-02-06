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
## 🛠️ Requisitos

* **Java JDK 17** o superior.
* **MySQL Server** (Puerto 3307).
* **MongoDB** (Puerto 27017).
* **Maven 3.8+**.
* **IDE compatible** (IntelliJ IDEA, Eclipse o VS Code).
* **Postman** (Opcional para pruebas de endpoints).

---

## ⚙️ Instalación

1. **Clonar** el repositorio del proyecto.
2. **Crear** la base de datos `datoscine` en MySQL.
3. **Verificar** que MySQL esté escuchando en el puerto configurado (3307).
4. **Verificar** que MongoDB esté en ejecución.
5. **Configurar** el archivo `src/main/resources/application.properties` con los siguientes valores:

```properties
# Configuración de MySQL
spring.datasource.url=jdbc:mysql://localhost:3307/datoscine
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true

# Puerto del Servidor
server.port=8090

# Configuración de MongoDB
spring.data.mongodb.uri=mongodb://localhost:27017/cine_logs

## ⚙️ Ejecutar el proyecto desde la raíz:
mvn spring-boot:run

# La aplicación quedará disponible en: http://localhost:8090

---

## 🚀 Endpoints Principales (Postman)

La API corre en `http://localhost:8090/api` (o la ruta base que hayas definido).

| Entidad | Método | Endpoint | Descripción |
| :--- | :--- | :--- | :--- |
| **Empleados** | `GET` | `/empleados` | Listar todos los empleados (MySQL/Mongo) |
| | `POST` | `/empleados` | Crear nuevo empleado y sincronizar |
| **Películas** | `GET` | `/peliculas` | Listar cartelera |
| | `POST` | `/peliculas` | Registrar nueva película |
| **Entradas** | `POST` | `/entradas` | Registrar venta de entrada |
| **Proyecciones**| `GET` | `/proyecciones`| Ver horarios y salas |

> **Nota:** Para los `POST`, asegúrate de enviar el `Content-Type: application/json` en el header de Postman.
