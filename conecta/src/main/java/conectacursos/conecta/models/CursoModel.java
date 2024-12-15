package conectacursos.conecta.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="curso")
public class CursoModel implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int idCurso;

	@NotBlank
	private String nombreCurso;

    @NotBlank
    private String descCurso;

    @NotBlank
    private Date fechaInicioCurso;

    @NotBlank
    private Date fechaFinCurso;

    @NotBlank
    private String imagenCurso;

    @ManyToOne
    @JoinColumn(name = "categoria_id_categoria")
    private CategoriaModel categoria;
    
    @ManyToOne
    @JoinColumn(name = "profesor_id_profesor")
    private ProfesorModel profesor;
	
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getNombreCurso() {
		return nombreCurso;
	}
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
    public String getDescCurso() {
        return descCurso;
    }
    public void setDescCurso(String descCurso) {
        this.descCurso = descCurso;
    }
    public Date getFechaInicioCurso() {
        return fechaInicioCurso;
    }
    public void setFechaInicioCurso(Date fechaInicioCurso) {
        this.fechaInicioCurso = fechaInicioCurso;
    }
    public Date getFechaFinCurso() {
        return fechaFinCurso;
    }
    public void setFechaFinCurso(Date fechaFinCurso) {
        this.fechaFinCurso = fechaFinCurso;
    }
    public String getImagenCurso() {
        return imagenCurso;
    }
    public void setImagenCurso(String imagenCurso) {
        this.imagenCurso = imagenCurso;
    }  
    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }

    public ProfesorModel getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorModel profesor) {
        this.profesor = profesor;
    }
}

