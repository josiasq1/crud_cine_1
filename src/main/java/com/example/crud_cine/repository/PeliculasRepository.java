package com.example.crud_cine.repository;

import com.example.crud_cine.model.Peliculas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculasRepository extends JpaRepository<Peliculas, Integer> {
}
