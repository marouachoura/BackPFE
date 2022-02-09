package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.*;

public interface ICoucheService {

	// Crud sur les employes 
		public Employe addEmploye(Employe emp);
		public void deleteEmploye(Long id);
		public Employe updateEmploye(Employe emp);
		public Employe findEmploye(Long id);
		public List<Employe> findAllEmployes();

		// Filtrage par propriété Formations
		public Employe findByNomPrenom(String NomPrenom);
		public Employe findByDateNais(Date DateNais);
		public Employe findByCin(int cin);

		
		
		// Crud sur les Formations 
		public Formation addFormation(Formation formation);
		public void deleteFormation(Long id);
		public Formation updateFormation(Formation formation);
		public Formation findFormation(Long id);
		public List<Formation> findAllFormations();
		// Filtrage par propriété Formations
		public Formation findByNomFormation(String nomFormation);
		public Formation findByNomFormateur(String nomFormateur);
		public List<Formation> findByNiveau(String nom);

}
