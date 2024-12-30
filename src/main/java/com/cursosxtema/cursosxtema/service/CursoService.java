package com.cursosxtema.cursosxtema.service;

import com.cursosxtema.cursosxtema.model.Curso;
import com.cursosxtema.cursosxtema.model.Tema;
import com.cursosxtema.cursosxtema.repository.ICursoRepository;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements ICursoService{
    
    @Autowired
    private ICursoRepository cursoRepo;

    public CursoService() {
    }

    public CursoService(ICursoRepository cursoRepo) {
        this.cursoRepo = cursoRepo;
    }

    @Override
    public void saveCurso(Curso curs) {
        cursoRepo.save(curs);
    }

    @Override
    public List<Curso> getCursos() {
        List<Curso> listaCursos = cursoRepo.findAll();
        return listaCursos;
    }

    @Override
    public List<Curso> getCursos(String cadena) {
        List<Curso> listaCursos = cursoRepo.findAll();
        listaCursos.removeIf(c -> !c.getNombre().toLowerCase().contains(cadena.toLowerCase()));
        return listaCursos;
    }

    @Override
    public Curso editCurso(Curso curs) {
        cursoRepo.save(curs);
        return cursoRepo.findById(curs.getIdCurso())
                        .orElse(null);
    }

    @Override
    public Curso findCurso(Long idCurso) {
        return cursoRepo.findById(idCurso)
                        .orElse(null);
    }

    @Override
    public List<Tema> listaTemas(Curso curs) {
        return cursoRepo.findById(curs.getIdCurso())
                    .map(Curso::getListaTemas)
                    .orElse(Collections.emptyList());
    }

}
