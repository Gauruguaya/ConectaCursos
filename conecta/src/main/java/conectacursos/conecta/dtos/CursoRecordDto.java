package conectacursos.conecta.dtos;

import java.sql.Date;

import conectacursos.conecta.models.CategoriaModel;
import conectacursos.conecta.models.ProfesorModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoRecordDto (
    
    @NotBlank String nombreCurso,

    @NotBlank String descCurso,

    @NotNull Date fechaInicioCurso,

    @NotNull Date fechaFinCurso,

    @NotBlank String imagenCurso,

    CategoriaModel categoria,

    ProfesorModel profesor

){}
    