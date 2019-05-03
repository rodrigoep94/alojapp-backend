package com.grupo1.alojapp.Services;

import com.grupo1.alojapp.Assemblies.AlojamientoAssembly;
import com.grupo1.alojapp.DTOs.AlojamientoDTO;
import com.grupo1.alojapp.Model.Alojamiento;
import com.grupo1.alojapp.Repositories.AlojamientoRepository;
import com.grupo1.alojapp.Model.Ubicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlojamientoService {

    @Autowired
    private AlojamientoRepository alojamientoRepository;

    private AlojamientoAssembly alojamientoAssembly = new AlojamientoAssembly();

    public AlojamientoDTO saveAlojamientoFromDTO(AlojamientoDTO alojamientoDTO){
        Alojamiento alojamiento = alojamientoAssembly.map(alojamientoDTO, Alojamiento.class);
        alojamientoRepository.save(alojamiento);
        alojamientoDTO.setId(alojamiento.getId());
        return alojamientoDTO;
    }

    public Alojamiento AgregarUbicacion(Alojamiento alojamiento, Ubicacion ubicacion){
        alojamiento.setUbicacion(ubicacion);
        alojamientoRepository.save(alojamiento);
        return alojamiento;
    }

    public AlojamientoDTO getById(Long id){
        Alojamiento alojamiento = alojamientoRepository.getOne(id);
        return alojamientoAssembly.map(alojamiento, AlojamientoDTO.class);
    }
}
