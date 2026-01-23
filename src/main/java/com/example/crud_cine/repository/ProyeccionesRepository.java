package com.example.crud_cine.repository;

import com.example.crud_cine.model.Proyecciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyeccionesRepository extends JpaRepository<Proyecciones, Long> {
}
