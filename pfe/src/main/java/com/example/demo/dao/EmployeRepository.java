package com.example.demo.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long>{

	Employe findByNomPrenomContaining(String nomPrenom );
	Employe findByCin(int cin );
	Employe findByDateNais(Date date);
}
