package com.desafiolatam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.desafiolatam.models.Contacto;

@Repository
public interface ContactRepository extends JpaRepository<Contacto, Long> {

}
