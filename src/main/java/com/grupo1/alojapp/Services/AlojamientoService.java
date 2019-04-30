package com.grupo1.alojapp.Services;

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

    public Alojamiento InitializeAlojamiento(String nombre, String descripcion){
        Alojamiento alojamiento = new Alojamiento(nombre, descripcion);
        alojamientoRepository.save(alojamiento);
        return alojamiento;
    }

    public Alojamiento AgregarUbicacion(Alojamiento alojamiento, Ubicacion ubicacion){
        alojamiento.setUbicacion(ubicacion);
        alojamientoRepository.save(alojamiento);
        return alojamiento;
    }

    public Alojamiento getById(long id){
        return alojamientoRepository.getOne(id);
    }
}
