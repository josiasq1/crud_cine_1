package com.example.crud_cine;

import com.example.crud_cine.model.Empleado;
import com.example.crud_cine.model.mongo.EmpleadoDoc;
import com.example.crud_cine.repository.EmpleadoRepository;
import com.example.crud_cine.repository.EmpleadoMongoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProyectoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoApplication.class, args);
    }
}
/*
    @Bean
    public CommandLineRunner syncData(EmpleadoRepository sqlRepo, EmpleadoMongoRepository mongoRepo) {
        return args -> {
            System.out.println("--- SINCRONIZANDO BASES DE DATOS ---");
            sqlRepo.findAll().forEach(emp -> {
                // Creamos el documento usando el ID de MySQL para que sean idénticos
                EmpleadoDoc doc = new EmpleadoDoc(emp);
                mongoRepo.save(doc);
            });
            System.out.println("--- TODO SINCRONIZADO ---");
        };
    }

/*
    @Bean
    public CommandLineRunner testPersistencia(EmpleadoRepository sqlRepo, EmpleadoMongoRepository mongoRepo) {
        return args -> {
            System.out.println("--- INICIANDO PRUEBA DE CONEXIÓN ---");

            try {
                // 1. Creamos el objeto Empleado con TODOS los campos obligatorios
                Empleado e = new Empleado();
                e.setNombre("Chatrererere Tesdwdwt");
                e.setPuesto("Desarerrroewffdwdwdllador");
                e.setSalarioHora(523340.0);
                e.setActivo(true);

                // AÑADIMOS LOS CAMPOS QUE FALTABAN:
                e.setEmail("teeweerrefdfdffdfdefrwest@cine.com");
                e.setTelefono("123456789");
                e.setTipoJornada("Completa");
                // Si tienes fechaContratacion, asegúrate de que el modelo la maneje o ponla aquí
                // e.setFechaContratacion(LocalDate.now());

                // 2. Guardamos en MySQL
                Empleado guardado = sqlRepo.save(e);
                System.out.println("✅ Registro en MySQL exitoso. ID: " + guardado.getIdEmpleado());

                // 3. Guardamos en MongoDB
                EmpleadoDoc doc = new EmpleadoDoc(guardado);
                mongoRepo.save(doc);
                System.out.println("✅ Registro en MongoDB (JSON) exitoso.");

                System.out.println("--- PRUEBA FINALIZADA CORRECTAMENTE ---");

            } catch (Exception ex) {
                System.err.println("❌ Error en la prueba: " + ex.getMessage());
                // No lanzamos la excepción para que la app no se detenga si falla la prueba
            }
        };
    }
}
*/