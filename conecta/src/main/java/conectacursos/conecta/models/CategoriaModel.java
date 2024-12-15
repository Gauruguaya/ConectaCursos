package conectacursos.conecta.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="categoria")
public class CategoriaModel implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idCategoria;

    @NotBlank
    private String nombreCat;

    @OneToMany
    @JoinColumn(name="idCategoria")
    private List<CursoModel> cursos;

    // Getters and setters
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }

    public List<CursoModel> getCursos() {
        return cursos;
    }

    public void setCursos(List<CursoModel> cursos) {
        this.cursos = cursos;
    }
}