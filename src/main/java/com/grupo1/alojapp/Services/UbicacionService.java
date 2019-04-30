package com.grupo1.alojapp.Services;

import com.grupo1.alojapp.Model.Ubicacion;
import com.grupo1.alojapp.Repositories.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UbicacionService {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    public Ubicacion InitializeUbicacion(String provincia, String localidad, String direccion){
        Ubicacion ubicacion = new Ubicacion(provincia,localidad,direccion);
        ubicacionRepository.save(ubicacion);
        return ubicacion;
    }

}
