package com.cursosxtema.cursosxtema.service;

import com.cursosxtema.cursosxtema.model.Curso;
import com.cursosxtema.cursosxtema.model.Tema;
import com.cursosxtema.cursosxtema.repository.ICursoRepository;
import com.cursosxtema.cursosxtema.repository.ITemaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemaService implements ITemaService {
    
    @Autowired
    private ITemaRepository temaRepo;
    @Autowired
    private ICursoService cursoServ;

    public TemaService() {
    }

    public TemaService(ITemaRepository temaRepo, ICursoService cursoServ) {
        this.temaRepo = temaRepo;
        this.cursoServ = cursoServ;
    }

    @Override
    public void saveTema(Tema tem, Long idCurso) {
        temaRepo.save(tem);
        Curso curs = cursoServ.findCurso(idCurso);
        cursoServ.editCurso(curs);
    }

    @Override
    public List<Tema> getTemas(Curso curs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Tema editTema(Tema tem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
