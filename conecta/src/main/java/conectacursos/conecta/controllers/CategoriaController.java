package conectacursos.conecta.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import conectacursos.conecta.dtos.CategoriaDto;
import conectacursos.conecta.models.CategoriaModel;
import conectacursos.conecta.models.CursoModel;
import conectacursos.conecta.repositories.CategoriaRepository;
import conectacursos.conecta.repositories.CursoRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    CategoriaRepository repository;

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping("/inserirCat")
    public String inserirCategoria(Model model) {
        List<CategoriaModel> categorias = repository.findAll();
        model.addAttribute("categorias", categorias);
        model.addAttribute("categoriaDto", new CategoriaDto("defaultName"));
        return "categoria/inserirCat";
    }

    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute @Valid CategoriaDto categoriaDto, BindingResult result, RedirectAttributes msg) {
        if (result.hasErrors()) {
            msg.addFlashAttribute("erroCadastrar", "Error al registrar nueva categoría");
            return "redirect:/categoria/inserirCat";
        }
        CategoriaModel categoriaModel = new CategoriaModel();
        BeanUtils.copyProperties(categoriaDto, categoriaModel);
        repository.save(categoriaModel);
        msg.addFlashAttribute("sucessoCadastrar", "Categoría registrada!");
        return "redirect:/categoria/listarCat";
    }

    @GetMapping("/listarCat")
    public String listarCategorias(Model model) {
        List<CategoriaModel> categorias = repository.findAll();
        model.addAttribute("categorias", categorias);
        return "categoria/listarCat";
    }

    @GetMapping("/detalles/{id}")
    public String getCursosPorCategoria(@PathVariable("id") int id, Model model) {
        List<CursoModel> cursos = cursoRepository.findByIdCategoria(id);
        CategoriaModel categoria = repository.findById(id).orElse(null);
        if (categoria != null) {
            model.addAttribute("cursos", cursos);
            model.addAttribute("nombreCat", categoria.getNombreCat());
        } else {
            model.addAttribute("nombreCat", "Categoría no encontrada");
        }
        return "categoria/categoria";
    }

    @GetMapping("/editar/{id}")
    public String editarCategoria(@PathVariable int id, Model model) {
        Optional<CategoriaModel> categoria = repository.findById(id);
        if (categoria.isPresent()) {
            model.addAttribute("id", categoria.get().getIdCategoria());
            model.addAttribute("descricao", categoria.get().getNombreCat());
            return "categoria/editarCat";
        }
        return "redirect:/categoria/listarCat";
    }

    @PostMapping("/editar/{id}")
    public String editarCategoria(@PathVariable int id, @ModelAttribute @Valid CategoriaDto categoriaDto, BindingResult result, RedirectAttributes msg) {
        if (result.hasErrors()) {
            msg.addFlashAttribute("erroEditar", "Error al editar categoría");
            return "redirect:/categoria/editar/" + id;
        }
        Optional<CategoriaModel> categoriaOpt = repository.findById(id);
        if (categoriaOpt.isPresent()) {
            CategoriaModel categoriaModel = categoriaOpt.get();
            BeanUtils.copyProperties(categoriaDto, categoriaModel);
            repository.save(categoriaModel);
            msg.addFlashAttribute("sucessoEditar", "Categoría editada!");
        }
        return "redirect:/categoria/listarCat";
    }

    @GetMapping("/excluir/{id}")
    public String excluirCategoria(@PathVariable int id, RedirectAttributes msg) {
        Optional<CategoriaModel> categoria = repository.findById(id);
        if (categoria.isPresent()) {
            repository.deleteById(id);
            msg.addFlashAttribute("sucessoExcluir", "Categoría eliminada!");
        } else {
            msg.addFlashAttribute("erroExcluir", "Error al eliminar categoría");
        }
        return "redirect:/categoria/listarCat";
    }
}
