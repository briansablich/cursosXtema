package com.cursosxtema.cursosxtema.service;

import com.cursosxtema.cursosxtema.model.Tema;

public interface ITemaService {
    public void saveTema(Tema tem, Long idCurso);
    public Tema editTema(Tema tem);
}
