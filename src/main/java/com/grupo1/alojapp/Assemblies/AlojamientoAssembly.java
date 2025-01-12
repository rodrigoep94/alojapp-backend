package com.grupo1.alojapp.Assemblies;

import com.grupo1.alojapp.DTOs.AlojamientoDTO;
import com.grupo1.alojapp.DTOs.UbicacionDTO;
import com.grupo1.alojapp.Model.Alojamiento;
import com.grupo1.alojapp.Model.Ubicacion;
import org.modelmapper.ModelMapper;

public class AlojamientoAssembly extends ModelMapper {

    private UbicacionAssembly ubicacionAssembly = new UbicacionAssembly();

    public AlojamientoDTO map(Alojamiento alojamiento, Class<AlojamientoDTO> destinationType){
        AlojamientoDTO alojamientoDTO = super.map(alojamiento,destinationType);
        alojamientoDTO.setUbicacion(ubicacionAssembly.map(alojamiento.getUbicacion(), UbicacionDTO.class));
        return  alojamientoDTO;
    }

    public Alojamiento map(AlojamientoDTO alojamientoDTO, Class<Alojamiento> destinationType){
        Alojamiento alojamiento = super.map(alojamientoDTO, destinationType);
        alojamiento.setUbicacion(ubicacionAssembly.map(alojamientoDTO.getUbicacion(), Ubicacion.class));
        return alojamiento;
    }

}
