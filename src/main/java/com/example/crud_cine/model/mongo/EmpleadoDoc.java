package com.example.crud_cine.model.mongo;

import org.springframework.data.annotation.Id; // <-- ASEGÚRATE QUE SEA ESTA
import org.springframework.data.mongodb.core.mapping.Document;
import com.example.crud_cine.model.Empleado;

@Document(collection = "empleados_json")
public class EmpleadoDoc {

    @Id
    private String id; // Aquí se guardará el número de MySQL
    private String nombre;
    private String puesto;
    private String tipoJornada;
    private String email;
    private String telefono;
    private String fechaContratacion;
    private double salarioHora;
    private boolean activo;

    // Constructor vacío obligatorio
    public EmpleadoDoc() {}

    // Constructor para sincronizar
    public EmpleadoDoc(Empleado e) {
        // Esta línea es la que quita el ObjectId y pone el número
        this.id = (e.getIdEmpleado() != null) ? String.valueOf(e.getIdEmpleado()) : null;
        this.nombre = e.getNombre();
        this.puesto = e.getPuesto();
        this.tipoJornada = e.getTipoJornada();
        this.email = e.getEmail();
        this.telefono = e.getTelefono();
        this.fechaContratacion = (e.getFechaContratacion() != null) ? e.getFechaContratacion().toString() : null;
        this.salarioHora = e.getSalarioHora();
        this.activo = e.isActivo();
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }
    public String getTipoJornada() { return tipoJornada; }
    public void setTipoJornada(String tipoJornada) { this.tipoJornada = tipoJornada; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(String fechaContratacion) { this.fechaContratacion = fechaContratacion; }
    public double getSalarioHora() { return salarioHora; }
    public void setSalarioHora(double salarioHora) { this.salarioHora = salarioHora; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}