package conectacursos.conecta.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import conectacursos.conecta.models.CategoriaModel;
import conectacursos.conecta.models.CursoModel;
import conectacursos.conecta.models.ProfesorModel;
import conectacursos.conecta.repositories.CategoriaRepository;
import conectacursos.conecta.repositories.CursoRepository;
import conectacursos.conecta.repositories.ProfesorRepository;

@Controller
@RequestMapping("/")
public class MainController {
   
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @GetMapping("/")
    public String index(Model model) {
        //return new ModelAndView("index").addObject()
        List<CategoriaModel> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);
        return "index";
    }

    @GetMapping("/buscarCurso")
    public String buscar(@RequestParam("query") String query, Model model) {
        List<CursoModel> cursos = cursoRepository.findByNombreCursoContainingIgnoreCase(query);
        List<ProfesorModel> profesores = profesorRepository.findByNombreProfContainingIgnoreCase(query);
        model.addAttribute("cursos", cursos);
        model.addAttribute("profesores", profesores);
        return "buscarCurso";
    }

    @GetMapping("/categoria/{id}")
    public String cursosPorCategoria(@PathVariable("id") Integer id, Model model) {
        List<CursoModel> cursos = cursoRepository.findByIdCategoria(id);
        model.addAttribute("cursos", cursos);
        return "categoria/categoria";
    }

    @GetMapping("/curso/{id}")
    public String detalleCurso(@PathVariable("id") Integer id, Model model) {
        CursoModel curso = cursoRepository.findById(id).orElse(null);
        model.addAttribute("cursos", curso);
        return "curso/curso";
    }

    @GetMapping("/listarCat")
    public String listarCategorias(Model model) {
        List<CategoriaModel> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);
        return "categoria/listarCat";
    }

    @GetMapping("/listarProf")
    public String listarProfesores(Model model) {
        List<ProfesorModel> profesores = profesorRepository.findAll();
        model.addAttribute("profesores", profesores);
        return "profesor/listarProf";
    } 
}
