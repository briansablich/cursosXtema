package com.cursosxtema.cursosxtema.service;

import com.cursosxtema.cursosxtema.model.Curso;
import com.cursosxtema.cursosxtema.model.Tema;
import com.cursosxtema.cursosxtema.repository.ITemaRepository;
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
        Curso curs = cursoServ.findCurso(idCurso);
        if(curs != null){
            //si el curso está definido lo setea en el tema
            //y lo adhiere a su lista de temas
            tem.setCurso(curs);
            curs.getListaTemas().add(tem);
            
            //luego guarda ambas cosas
            temaRepo.save(tem);
        } else {
            //si no está definido el curso guarda el tema sin la relacion
            temaRepo.save(tem);
        }
    }

    @Override
    public Tema editTema(Tema tem) {
        temaRepo.save(tem);
        return temaRepo.findById(tem.getIdTema()).orElse(null);
    }

    
}
