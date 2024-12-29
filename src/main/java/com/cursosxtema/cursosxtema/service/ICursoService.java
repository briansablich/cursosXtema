
package com.cursosxtema.cursosxtema.service;

import com.cursosxtema.cursosxtema.model.Curso;
import com.cursosxtema.cursosxtema.model.Tema;
import java.util.List;


public interface ICursoService {
    public void saveCurso(Curso curs);
    public List<Curso> getCursos();
    public List<Curso> getCursos(String cadena);
    public Curso editCurso(Curso curs);
    public Curso findCurso(Long idCurso);
    public List<Tema> listaTemas(Curso curs);
    
}
