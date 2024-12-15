package conectacursos.conecta.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import conectacursos.conecta.models.CursoModel;

@Repository
public interface CursoRepository extends JpaRepository<CursoModel, Integer> {
    List<CursoModel> findByNombreCursoContainingIgnoreCase(String nombreCurso);

    @Query("SELECT c FROM CursoModel c WHERE c.nombreCurso LIKE %:keyword%")
    List<CursoModel> searchByKeyword(@Param("keyword") String keyword);

    @Query("SELECT c FROM CursoModel c WHERE " +
           "LOWER(c.nombreCurso) LIKE LOWER(CONCAT('%', :keyword1, '%')) OR " +
           "LOWER(c.nombreCurso) LIKE LOWER(CONCAT('%', :keyword2, '%'))")
    List<CursoModel> searchByMultipleKeywords(@Param("keyword1") String keyword1, @Param("keyword2") String keyword2);

    @Query("SELECT c FROM CursoModel c WHERE c.categoria.idCategoria = :idCategoria")
    List<CursoModel> findByIdCategoria(@Param("idCategoria") Integer idCategoria);

    @Query("SELECT c FROM CursoModel c WHERE c.profesor.idProfesor = :idProfesor")
    List<CursoModel> findByIdProfesor(@Param("idProfesor") Integer idProfesor);
}