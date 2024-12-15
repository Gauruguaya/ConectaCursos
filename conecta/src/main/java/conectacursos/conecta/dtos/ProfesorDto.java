package conectacursos.conecta.dtos;

import jakarta.validation.constraints.NotBlank;

public class ProfesorDto {
 
    @NotBlank
    private String nombreProf;

    @NotBlank
    private String emailProf;

    @NotBlank
    private String fotoProf;

    // Constructor
    public ProfesorDto(@NotBlank String nombreProf, @NotBlank String emailProf, @NotBlank String fotoProf) {
        this.nombreProf = nombreProf;
        this.emailProf = emailProf;
        this.fotoProf = fotoProf;
    }

    // Getters and setters
    public String getNombreProf() {
        return nombreProf;
    }

    public void setNombreProf(String nombreProf) {
        this.nombreProf = nombreProf;
    }

    public String getEmailProf() {
        return emailProf;
    }

    public void setEmailProf(String emailProf) {
        this.emailProf = emailProf;
    }

    public String getFotoProf() {
        return fotoProf;
    }

    public void setFotoProf(String fotoProf) {
        this.fotoProf = fotoProf;
    }
   
}
