package com.example.demo.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.dao.EmployeRepository;
import com.example.demo.dao.FormationRepository;
import com.example.demo.dao.SiteRepository;
import com.example.demo.entities.Employe;
import com.example.demo.entities.Formation;
import com.example.demo.entities.Site;

@Service
@Transactional
@CrossOrigin
public class CoucheService implements ICoucheService {

	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	FormationRepository formationRepository;
	@Autowired
	SiteRepository siteRepository;
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

	
	@Override
	public Site addSite(Site site) {
		return siteRepository.save(site);
	}

	@Override
	public void deleteSite(Long id) {
		if (siteRepository.findById(id).isPresent())
			siteRepository.deleteById(id);		
	}

	@Override
	public Site updateSite(Site site) {
		return siteRepository.saveAndFlush(site);
	}

	@Override
	public Site findSite(Long id) {
		return siteRepository.findById(id).get();
	}

	@Override
	public List<Site> findAllSites() {
		return siteRepository.findAll();
	}
	@Override
	public void affectuerFormationToEmploye(Long idEmp, Long idFormation) {
		Employe emp = employeRepository.findById(idEmp).get();
		Formation formation = formationRepository.findById(idFormation).get();
		Collection<Formation> formations = emp.getFormations();
		formations.add(formation);

	}

	@Override
	public void affectuerSiteToEmploye(Long idEmp, Long idSite) {
		Employe emp = employeRepository.findById(idEmp).get();
		Site site = siteRepository.findById(idSite).get();
		emp.setSite(site);
		
	}





}
