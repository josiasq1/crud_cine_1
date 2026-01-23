package com.example.crud_cine.repository;

import com.example.crud_cine.model.mongo.EmpleadoDoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoMongoRepository extends MongoRepository<EmpleadoDoc, String> {
}