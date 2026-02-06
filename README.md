# 🎬 CRUD CINE — Sistema de Gestión Cinematográfica

Descripción
Una aplicación backend construida con Spring Boot para gestionar empleados, películas, proyecciones y ventas de entradas. Usa MySQL como base de datos relacional principal y MongoDB para documentos/logs (sincronización de empleados).

Índice
- [Tecnologías](#tecnologías)
- [Requisitos](#requisitos)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Instalación y configuración](#instalación-y-configuración)
- [Ejecución](#ejecución)
- [Endpoints principales](#endpoints-principales)
- [Notas](#notas)

Tecnologías
- Java 17+
- Spring Boot
- MySQL
- MongoDB
- Maven

Requisitos
- Java JDK 17 o superior
- MySQL Server (puerto 3306 o 3307)
- MongoDB (puerto 27017)
- Maven 3.8+
- IDE (VS Code, IntelliJ, Eclipse)
- Postman (opcional)

Estructura del proyecto
```text
com.example.crud_cine
│
├── CrudCineApplication.java
├── conexion/ConexionBD.java
├── controller/
│   ├── EmpleadoController.java
│   ├── EntradasController.java
│   ├── PeliculasController.java
│   └── ProyeccionesController.java
├── model/
│   ├── mysql/
│   │   ├── Empleado.java
│   │   ├── Entradas.java
│   │   ├── Peliculas.java
│   │   └── Proyecciones.java
│   └── mongo/
│       └── EmpleadoDoc.java
├── repository/
│   ├── EmpleadoRepository.java
│   ├── EntradasRepository.java
│   ├── PeliculasRepository.java
│   ├── ProyeccionesRepository.java
│   └── EmpleadoDocRepository.java
└── service/
    ├── EmpleadoService.java
    ├── EntradasService.java
    ├── PeliculasService.java
    └── ProyeccionesService.java
```

Instalación y configuración
1. Clonar el repositorio.
2. Crear la base de datos MySQL llamada `datoscine`.
3. Asegurarse de que MySQL y MongoDB estén activos.
4. Actualizar `src/main/resources/application.properties` con tus credenciales. Ejemplo:

```properties
# Configuración de MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/datoscine
spring.datasource.username=root
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Puerto del servidor
server.port=8090

# Configuración de MongoDB
spring.data.mongodb.uri=mongodb://localhost:27017/cine_logs
```

Ejecución
Desde la raíz del proyecto (Windows PowerShell o CMD):
```bash
mvn spring-boot:run
```
La API quedará disponible en: http://localhost:8090/api

Endpoints principales
- Empleados
  - GET  /api/empleados  — Listar empleados (MySQL/Mongo)
  - POST /api/empleados  — Crear empleado y sincronizar con Mongo
- Películas
  - GET  /api/peliculas  — Listar cartelera
  - POST /api/peliculas  — Registrar película
- Proyecciones
  - GET  /api/proyecciones — Listar horarios y salas
- Entradas
  - POST /api/entradas — Registrar venta de entrada
 Todo echo con IA

Notas
- En peticiones POST usar header `Content-Type: application/json`.
- Ajustar puertos/credenciales en `application.properties` según tu entorno.
- Si MySQL usa un puerto distinto, modificar la URL de conexión.
