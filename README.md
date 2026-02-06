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

🛠️ Requisitos
Java JDK 17 o superior.

MySQL Server (Puerto 3306 por defecto o 3307 según tu configuración).

MongoDB (Puerto 27017).

Maven 3.8+.

IDE compatible (IntelliJ IDEA, Eclipse o VS Code).

Postman (Opcional para pruebas de endpoints).

⚙️ Instalación
Clonar el repositorio del proyecto.

Crear la base de datos datoscine en MySQL.

Verificar que los servicios de MySQL y MongoDB estén en ejecución.

Configurar el archivo src/main/resources/application.properties con tus credenciales locales:

Properties
# Configuración de MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/datoscine
spring.datasource.username=root
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Puerto del Servidor
server.port=8090

# Configuración de MongoDB
spring.data.mongodb.uri=mongodb://localhost:27017/cine_logs
Ejecutar el proyecto desde la raíz con Maven:

Bash
mvn spring-boot:run
La aplicación quedará disponible en: http://localhost:8090
