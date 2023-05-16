
package com.ArgentinaPrograma.porfolioWeb.repository;

import com.ArgentinaPrograma.porfolioWeb.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Long> {
    
}
