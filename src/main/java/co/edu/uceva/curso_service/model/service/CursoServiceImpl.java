package co.edu.uceva.curso_service.model.service;

import co.edu.uceva.curso_service.model.entities.Curso;
import co.edu.uceva.curso_service.model.dao.ICursoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase implementa el servicio de curso
 * Un servicio es un objeto controlado por el contenedor de Spring
 */
@Service
public class CursoServiceImpl implements ICursoService {

    @Autowired
    ICursoDao cursoDao;

    @Override
    public Curso save(Curso curso) {
        return cursoDao.save(curso);
    }

    @Override
    public void delete(Curso curso) {
        cursoDao.delete(curso);
    }

    @Override
    public Curso update(Curso curso) {
        return cursoDao.save(curso);
    }

    /**
     * Este metodo lista los cursos guardados y sus provincias
     * @return una lista de cursos
     */
    @Override
    @Transactional(readOnly = true)  //Para ejecutar en modo de solo lectura
    public List<Curso> findAll() {
        List<Curso> cursos = (List<Curso>) cursoDao.findAll(); //Traemos la lista de cursos

        return cursos;
    }

    /**
     * Este metodo busca un curso
     * @param id Llave primaria del curso que se quiere buscar
     * @return el curso identificado por el campo id
     */
    @Override
    public Curso findById(Long id) {
        return cursoDao.findById(id).get();
    }
}
