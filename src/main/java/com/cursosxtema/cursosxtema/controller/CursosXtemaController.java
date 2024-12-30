package com.cursosxtema.cursosxtema.controller;

import com.cursosxtema.cursosxtema.model.Curso;
import com.cursosxtema.cursosxtema.model.Tema;
import com.cursosxtema.cursosxtema.service.ICursoService;
import com.cursosxtema.cursosxtema.service.ITemaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursosXtemaController {
    
    @Autowired
    private final ICursoService cursoServ;
    @Autowired
    private final ITemaService temaServ;

    public CursosXtemaController(ICursoService cursoServ, ITemaService temaServ) {
        this.cursoServ = cursoServ;
        this.temaServ = temaServ;
    }
    
    @PostMapping("/cursos/crear")
    public String nuevoCurso(@RequestBody Curso cur){
        cursoServ.saveCurso(cur);
        return cur.toString();
    }
    
    @PostMapping("/temas/crear/{idCurso}")
    public String nuevoTema(@RequestBody Tema tem, @PathVariable Long idCurso){
        temaServ.saveTema(tem, idCurso);
        return tem.toString() + " Id Curso: " + idCurso;
    }
    
    @GetMapping("/cursos/traer")
    @ResponseBody
    public List<Curso> traerCursos(){
        return cursoServ.getCursos();
    }
    
    @GetMapping("/temas/traerxcurso")
    @ResponseBody
    public List<Tema> traerTemasXcurso(@RequestParam Long idCurso){
        return cursoServ.listaTemas(cursoServ.findCurso(idCurso));
    }
    
    @GetMapping("/cursos/cursoxpalabra")
    @ResponseBody
    public List<Curso> traerCursoXpalabra(@RequestParam String palabra){
        return cursoServ.getCursos(palabra);
    }
    
    @PutMapping("/curso/edit/{idCurso}")
    @ResponseBody
    public Curso editarCurso(@PathVariable Long idCurso, @RequestBody Curso cur){
        cur.setIdCurso(idCurso);
        return cursoServ.editCurso(cur);
    }
    
    @PutMapping("/tema/edit/{idTema}")
    @ResponseBody
    public Tema editarTema(@PathVariable Long idTema, @RequestBody Tema tem){
        tem.setIdTema(idTema);
        return temaServ.editTema(tem);
    }

}
