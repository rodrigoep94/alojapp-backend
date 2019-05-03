package com.grupo1.alojapp.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Ubicacion")
public class Ubicacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String provincia;
    private String localidad;
    private String direccion;

    public Ubicacion(){}

    public Ubicacion(String provincia,String localidad,String direccion){
        this.provincia = provincia;
        this.localidad = localidad;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }
    public void setLocalidad(String localidad) { this.localidad = localidad; }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) { this.direccion = direccion; }
}
