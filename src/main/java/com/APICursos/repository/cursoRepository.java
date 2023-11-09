package com.APICursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.APICursos.entities.cursos;

public interface cursoRepository extends JpaRepository<cursos, Long>{

}
