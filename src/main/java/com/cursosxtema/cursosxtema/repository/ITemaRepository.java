package com.cursosxtema.cursosxtema.repository;

import com.cursosxtema.cursosxtema.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITemaRepository extends JpaRepository<Tema, Long>{

}
