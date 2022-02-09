package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmployeRepository;
import com.example.demo.dao.FormationRepository;
import com.example.demo.entities.Employe;
import com.example.demo.entities.Formation;

@Service @Transactional
public class CoucheService implements ICoucheService {

	@Autowired
	EmployeRepository employeRepository ;
	@Autowired
	FormationRepository formationRepository ;
	@Override
	public Employe addEmploye(Employe emp) {
		return employeRepository.save(emp);
	}
	@Override
	public void deleteEmploye(Long id) {
		if (employeRepository.findById(id).isPresent())
			employeRepository.deleteById(id);		
	}
	@Override
	public Employe updateEmploye(Employe emp) {
		return employeRepository.saveAndFlush(emp);
	}
	@Override
	public Employe findEmploye(Long id) {
		return employeRepository.findById(id).get();
	}
	@Override
	public List<Employe> findAllEmployes() {
		return employeRepository.findAll();
	}
	@Override
	public Employe findByNomPrenom(String NomPrenom) {
		return employeRepository.findByNomPrenomContaining(NomPrenom);
	}
	@Override
	public Employe findByDateNais(Date DateNais) {
		return employeRepository.findByDateNais(DateNais);
	}
	@Override
	public Employe findByCin(int cin) {
		return employeRepository.findByCin(cin);
	}
	@Override
	public Formation addFormation(Formation formation) {
		return formationRepository.save(formation);
	}
	@Override
	public void deleteFormation(Long id) {
		if (formationRepository.findById(id).isPresent())
			formationRepository.deleteById(id);			
	}
	@Override
	public Formation updateFormation(Formation formation) {
		return formationRepository.saveAndFlush(formation);
	}
	@Override
	public Formation findFormation(Long id) {
		return formationRepository.findById(id).get();
	}
	@Override
	public List<Formation> findAllFormations() {
		return formationRepository.findAll();
	}
	@Override
	public Formation findByNomFormation(String nomFormation) {
		return formationRepository.findByNomFormationContaining(nomFormation);
	}
	@Override
	public Formation findByNomFormateur(String nomFormateur) {
		return formationRepository.findByNomFormateurContaining(nomFormateur);
	}
	@Override
	public List<Formation> findByNiveau(String nom) {
		return formationRepository.findByNiveauContaining(nom);
	}
	
	}


