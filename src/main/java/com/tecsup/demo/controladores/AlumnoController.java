package com.tecsup.demo.controladores;

import com.tecsup.demo.modelo.documents.Alumno;
import com.tecsup.demo.servicios.AlumnoService;
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
@SessionAttributes("alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService servicio;

    // Cambiar la ruta para evitar conflicto
    @RequestMapping(value = "/alumno/form", method = RequestMethod.GET)
    public String crear(Map<String, Object> model) {
        Alumno alumno = new Alumno();
        model.put("alumno", alumno);
        model.put("titulo", "Formulario de Alumno");
        return "formViewAlumno";
    }

    @RequestMapping(value = "/alumno/form/{id}")
    public String editar(@PathVariable(value = "id") String id, Map<String, Object> model) {
        Alumno alumno = servicio.buscar(id);
        model.put("alumno", alumno);
        model.put("titulo", "Editar Alumno");
        return "formViewAlumno";
    }

    @RequestMapping(value = "/alumno/form", method = RequestMethod.POST)
    public String guardar(@Valid Alumno alumno, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Alumno");
            return "formViewAlumno";
        }
        servicio.grabar(alumno);
        status.setComplete();
        return "redirect:/alumnos";
    }

    @RequestMapping(value = "/alumno/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") String id) {
        if (id != null && id.length() > 0) {
            servicio.eliminar(id);
        }
        return "redirect:/alumnos";
    }

    @RequestMapping(value = "/alumnos", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de alumnos");
        model.addAttribute("alumnos", servicio.listar());
        return "listarViewAlumno";
    }
}
