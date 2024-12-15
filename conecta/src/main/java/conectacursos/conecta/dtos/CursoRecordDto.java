package conectacursos.conecta.dtos;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoRecordDto (
    
    @NotBlank String nombreCurso,

    @NotBlank String descCurso,

    @NotNull Date fechaInicioCurso,

    @NotNull Date fechaFinCurso,

    @NotBlank String imagenCurso,

    @NotNull Integer idCategoria,

    @NotNull Integer idProfesor
){}
    