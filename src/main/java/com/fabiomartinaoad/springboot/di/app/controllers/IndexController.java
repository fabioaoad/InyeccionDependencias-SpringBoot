package com.fabiomartinaoad.springboot.di.app.controllers;

import com.fabiomartinaoad.springboot.di.app.models.service.IServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    //Sin inyección de dependencia
    //private MiServicio servicio = new MiServicio();

    //Con inyección de dependencia. Se añade anotacion @Autowired

    @Autowired
    @Qualifier("miServicioComplejo")  // inyecto explicitamente por el nombre de mi servicio
    private IServicio servicio;

//    @Autowired
//    public IndexController(IServicio servicio) {
//        this.servicio = servicio;
//    }

    @GetMapping({"/", "","/index"})
    public String index(Model model){
        model.addAttribute("objeto", servicio.operacion());
        return "index";
    }

//    @Autowired
//    public void setServicio(IServicio servicio) {
//        this.servicio = servicio;
//    }
}
