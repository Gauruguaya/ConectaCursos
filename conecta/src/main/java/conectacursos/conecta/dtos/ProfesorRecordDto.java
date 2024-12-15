package conectacursos.conecta.dtos;

import jakarta.validation.constraints.NotBlank;

public record ProfesorRecordDto(@NotBlank String nombreProf, @NotBlank String emailProf, @NotBlank String fotoProf) {}
