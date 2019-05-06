package com.grupo1.alojapp.Repositories;


import com.grupo1.alojapp.Model.Alojamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlojamientoRepository extends JpaRepository<Alojamiento, Long> {

}