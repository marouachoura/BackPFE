package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Formation;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long>{
	Formation findByNomFormationContaining(String NomFormation );
	Formation findByNomFormateurContaining(String NomFormateur );
	List<Formation> findByNiveauContaining(String Niveau );
	Formation findByDureeContaining(Date Duree );
	Formation findByCertificationContaining(String Certification );


}
