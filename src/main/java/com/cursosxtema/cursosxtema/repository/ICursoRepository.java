package com.cursosxtema.cursosxtema.repository;

import com.cursosxtema.cursosxtema.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, Long>{
    
}
