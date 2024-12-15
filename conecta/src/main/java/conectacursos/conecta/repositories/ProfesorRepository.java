package conectacursos.conecta.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import conectacursos.conecta.models.ProfesorModel;
@Repository
public interface ProfesorRepository extends JpaRepository<ProfesorModel, Integer>{
    public List<ProfesorModel> findByNombreProfContainingIgnoreCase(String nombreProf);
    Optional<ProfesorModel> findByIdProfesor(int id);

}