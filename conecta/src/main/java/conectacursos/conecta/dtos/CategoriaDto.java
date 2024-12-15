package conectacursos.conecta.dtos;

import jakarta.validation.constraints.NotBlank;

public class CategoriaDto {
 
    @NotBlank
    private String nombreCat;

    // Constructor
    public CategoriaDto(@NotBlank String nombreCat) {
        this.nombreCat = nombreCat;
    }

    // Getters and setters
    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }
   
}
