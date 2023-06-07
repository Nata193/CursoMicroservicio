package co.edu.uceva.curso_service.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_curso")
    private Long id_curso;

    private String nombre;

    
}
