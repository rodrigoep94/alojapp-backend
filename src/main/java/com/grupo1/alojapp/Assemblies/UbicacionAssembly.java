package com.grupo1.alojapp.Assemblies;

import com.grupo1.alojapp.DTOs.UbicacionDTO;
import com.grupo1.alojapp.Model.Ubicacion;
import org.modelmapper.ModelMapper;

public class UbicacionAssembly extends ModelMapper {

    public UbicacionDTO map(Ubicacion ubicacion, Class<UbicacionDTO> destinationType){
        if(ubicacion == null) return null;
        UbicacionDTO ubicacionDTO = super.map(ubicacion, destinationType);
        return  ubicacionDTO;
    }

    public Ubicacion map(UbicacionDTO ubicacionDTO, Class<Ubicacion> destinationType){
        if(ubicacionDTO ==null) return null;
        Ubicacion ubicacion = super.map(ubicacionDTO, destinationType);
        return ubicacion;
    }

}
