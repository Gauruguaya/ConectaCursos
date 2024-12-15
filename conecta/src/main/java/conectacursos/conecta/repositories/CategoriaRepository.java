package conectacursos.conecta.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import conectacursos.conecta.models.CategoriaModel;
@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Integer>{
    public List<CategoriaModel> findByNombreCatContainingIgnoreCase(String nombreCat);
}
