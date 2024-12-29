package com.cursosxtema.cursosxtema.service;

import com.cursosxtema.cursosxtema.model.Curso;
import com.cursosxtema.cursosxtema.model.Tema;
import java.util.List;

public interface ITemaService {
    public void saveTema(Tema tem, Long idCurso);
    public List<Tema> getTemas(Curso curs);
    public Tema editTema(Tema tem);
}
