package com.grupo1.alojapp.Controllers;

import com.grupo1.alojapp.Model.Ubicacion;
import com.grupo1.alojapp.Services.AlojamientoService;
import com.grupo1.alojapp.Model.Alojamiento;
import com.grupo1.alojapp.Services.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AlojamientoController {

    @Autowired
    private AlojamientoService alojamientoService;
    @Autowired
    private UbicacionService ubicacionService;

    @GetMapping("alojamiento/get")
    @ResponseBody
    public Alojamiento getAlojamiento(@RequestParam(name="id") Long id){
        return alojamientoService.getById(id);
    }

    @PostMapping("alojamiento/create")
    @ResponseBody
    public Alojamiento createAlojamiento(@RequestBody String nombre, @RequestBody String descripcion){
        return alojamientoService.InitializeAlojamiento(nombre,descripcion);
    }

    @PostMapping("alojamiento/addUbicacion")
    @ResponseBody
    public Alojamiento createAlojamiento(@RequestParam(name="idAlojamiento") Long idAlojamiento,@RequestBody String provincia, @RequestBody String localidad, @RequestBody String direccion){
        Ubicacion ubicacion = ubicacionService.InitializeUbicacion(provincia,localidad,direccion);
        Alojamiento alojamiento = getAlojamiento(idAlojamiento);
        return alojamientoService.AgregarUbicacion(alojamiento,ubicacion);
    }
}
