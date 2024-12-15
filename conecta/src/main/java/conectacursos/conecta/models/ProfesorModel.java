package conectacursos.conecta.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="profesor")
public class ProfesorModel implements Serializable{
    
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int idProfesor;

    @NotBlank
    private String nombreProf;

    @NotBlank
    private String emailProf;

    @NotBlank
    private String fotoProf;
    
    @Column(name = "fotoProf")
    @OneToMany(mappedBy = "profesor")
    private List<CursoModel> cursos;
    
    public int getIdProfesor() {
        return idProfesor;
    }
    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }
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
    public List<CursoModel> getCursos() {
        return cursos;
    }

    public void setCursos(List<CursoModel> cursos) {
        this.cursos = cursos;
    }
}
