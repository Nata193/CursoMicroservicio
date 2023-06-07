package co.edu.uceva.curso_service.controller;

import co.edu.uceva.curso_service.model.entities.Curso;
import co.edu.uceva.curso_service.model.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*") //Se permite el Cross Origin a http://localhost:4200
@RequestMapping("/curso-service")
public class CursoRestController {

    @Autowired
    ICursoService cursoService;

    /**
     * Endpoint para recibir un saludo
     * @param nombre Es el nombre que envian desde la url
     * @return Un saludo
     */
    @GetMapping("/hola/{nombre}")
    public String holaMundo(@PathVariable("nombre") String nombre){
        return "Hola "+ nombre;
    }

    /**
     * Metodo que lista los cursos
     * @return Lista de cursos
     */
    @GetMapping("/cursos")
    public List<Curso> listar(){
        return cursoService.findAll();
    }

    @GetMapping("/cursos/{id_curso}")
    public Curso buscarCurso(@PathVariable("id_curso") Long id){
        return cursoService.findById(id);
    }

    @PostMapping("/cursos")
    public Curso crearCurso(@RequestBody Curso curso){
        return cursoService.save(curso);
    }

    @DeleteMapping("/cursos/{id_curso}")
    public void borrarCurso(@PathVariable("id_curso") Long id){
        Curso curso;
        curso = cursoService.findById(id);
        cursoService.delete(curso);
    }

    @PutMapping("/cursos")
    public Curso actualizarCurso(@RequestBody Curso curso){
        return cursoService.update(curso);
    }

}
