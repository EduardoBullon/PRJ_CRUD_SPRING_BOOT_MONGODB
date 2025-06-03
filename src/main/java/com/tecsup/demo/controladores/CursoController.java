package com.tecsup.demo.controladores;

import com.tecsup.demo.modelo.documents.Curso;
import com.tecsup.demo.servicios.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Map;

@Controller
@SessionAttributes("curso")
public class CursoController {

    @Autowired
    private CursoService servicio;

    // Cambiar la ruta para evitar conflicto
    @RequestMapping(value = "/curso/form", method = RequestMethod.GET)
    public String crear(Map<String, Object> model) {
        Curso curso = new Curso();
        model.put("curso", curso);
        model.put("titulo", "Formulario de Curso");
        return "formView";
    }

    @RequestMapping(value = "/curso/form/{id}")
    public String editar(@PathVariable(value = "id") String id, Map<String, Object> model) {
        Curso curso = servicio.buscar(id);
        model.put("curso", curso);
        model.put("titulo", "Editar Curso");
        return "formView";
    }

    @RequestMapping(value = "/curso/form", method = RequestMethod.POST)
    public String guardar(@Valid Curso curso, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Curso");
            return "formView";
        }
        servicio.grabar(curso);
        status.setComplete();
        return "redirect:/listar";
    }

    @RequestMapping(value = "/curso/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") String id) {
        if (id != null && id.length() > 0) {
            servicio.eliminar(id);
        }
        return "redirect:/listar";
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de cursos");
        model.addAttribute("cursos", servicio.listar());
        return "listarView";
    }
}
