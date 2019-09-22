package com.grupo1.alojapp.Controllers;

import com.grupo1.alojapp.DTOs.AlojamientoDTO;
import com.grupo1.alojapp.Exceptions.AlojamientoEliminadoException;
import com.grupo1.alojapp.Model.Ubicacion;
import com.grupo1.alojapp.Services.AlojamientoService;
import com.grupo1.alojapp.Model.Alojamiento;
import com.grupo1.alojapp.Services.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT })
public class AlojamientoController {

    @Autowired
    private AlojamientoService alojamientoService;

    @GetMapping("alojamiento")
    @ResponseBody
    public ResponseEntity<List<AlojamientoDTO>> getAlojamientosVigentes(){
        List<AlojamientoDTO> alojamientosDTO = alojamientoService.getAllVigentes();
        return ResponseEntity.ok(alojamientosDTO);
    }

    @GetMapping("alojamiento/{id}")
    @ResponseBody
    public ResponseEntity<AlojamientoDTO> getAlojamiento(@PathVariable Long id) throws AlojamientoEliminadoException {
        AlojamientoDTO alojamientoDTO = alojamientoService.getById(id);
        return ResponseEntity.ok(alojamientoDTO);
    }

    @PostMapping("alojamiento")
    @ResponseBody
    public ResponseEntity<AlojamientoDTO> saveOrUpdateAlojamiento(@RequestBody AlojamientoDTO alojamientoDTO){
        alojamientoService.saveAlojamientoFromDTO(alojamientoDTO);
        return ResponseEntity.ok(alojamientoDTO);
    }

    @PutMapping("alojamiento")
    @ResponseBody
    public ResponseEntity<AlojamientoDTO> updateAlojamiento(@RequestBody AlojamientoDTO alojamientoDTO){
        return saveOrUpdateAlojamiento(alojamientoDTO);
    }

    @DeleteMapping("alojamiento/{id}")
    @ResponseBody
    public void deleteAlojamiento(@PathVariable Long id) throws AlojamientoEliminadoException{
        alojamientoService.deleteAlojamientoById(id);
    }

}
