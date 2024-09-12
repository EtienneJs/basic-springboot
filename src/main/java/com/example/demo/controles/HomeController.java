package com.example.demo.controles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// Decoration for controllers
@Controller
//Crea una ruta por defecto para las demas rutas.
@RequestMapping("/")
public class HomeController {

    // env
    @Value("${etienne.valor.greatings}")
    private String etienneValorGreatings;
    //    Method Get
    @GetMapping("/")
    @ResponseBody

    public String home(){
        return "home";
    }

    @GetMapping("/nosotros")
    @ResponseBody
    public  String nosotros(){
        return "desde nostros";
    }

    @GetMapping("/parametros/{id}/{slug}")
    @ResponseBody
    public String parametros(@PathVariable("id") Long id, @PathVariable("slug") String slug){
        return "id="+id+"| slug="+slug;
    }

    @GetMapping("/query")
    @ResponseBody
    public String query_string(@RequestParam("id") Long id, @RequestParam("slug") String slug){
//        /ruta?clave1=valor1&clave2=valor2
        return "id="+id+"| slug="+slug;
    }

//    Variables de entorno
    @GetMapping("/env")
    @ResponseBody
    public String env(){
        return this.etienneValorGreatings;
    }
}
