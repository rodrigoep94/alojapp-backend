package com.grupo1.alojapp;

import com.grupo1.alojapp.Model.Alojamiento;
import com.grupo1.alojapp.Repositories.AlojamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.ArrayList;
import java.util.List;

public class MainApplication implements CommandLineRunner {

    @Autowired
    private AlojamientoRepository alojamientoRepository;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Alojamiento alojamiento = new Alojamiento("alojamiento prueba","Esta es una descripcion sobre el alojamiento prueba");
        alojamientoRepository.save(alojamiento);
    }
}
