package edu.utvt.attendance.persistence.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import edu.utvt.attendance.persistence.entities.Persona;

public interface PeronsaRepository extends JpaRepository<Persona, Long> {


}