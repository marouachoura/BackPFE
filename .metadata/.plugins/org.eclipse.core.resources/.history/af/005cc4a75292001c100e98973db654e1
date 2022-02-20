package com.example.demo.contoller;

import java.util.List;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employe;
import com.example.demo.entities.Formation;
import com.example.demo.entities.Site;
import com.example.demo.service.ICoucheService;

@RestController 
@CrossOrigin
public class CoucheController {

	@Autowired
	ICoucheService iService ;
	
	@RequestMapping(value = "/employes", method = RequestMethod.GET)
	public List<Employe> findAllEmp() {
		return iService.findAllEmployes();

	}
	
	
	@PostMapping(value = "/employes/add")

	public Employe addEmploye(@RequestBody Employe e)
	{
		return iService.addEmploye(e);
	}
	@RequestMapping(value = "/employes/find/{id}", method = RequestMethod.GET)
	public Employe findEmployeByid(@PathVariable Long id) {
		return iService.findEmploye(id);	
		//Employe emp = iService.findEmploye(id);	
		//Site site = emp.getSite();
		//emp.setSite(site);
		// Collection<Formation> formation = emp.getFormations();
		// emp.setFormations(formation);
		//return emp ;
	}

	@RequestMapping(value = "/formations", method = RequestMethod.GET)
	public List<Formation> findAllFormations() {
		return iService.findAllFormations();
	}
	
	@RequestMapping(value = "/formations/find/{id}", method = RequestMethod.GET)
	public Formation findFormation(@PathVariable Long id) {
		return iService.findFormation(id);	
	}
	
	@PostMapping(value = "/formations/add")

	public Formation addFormation(@RequestBody Formation f)
	{
		return iService.addFormation(f);
	}
	
	@DeleteMapping(value="/formations/delete/{id}")
	public void deleteMembre(@PathVariable Long id)
	{
		iService.deleteFormation(id);
	}
	@PutMapping(value="/formation/update/{id}")
	public Formation updateFormation(@PathVariable Long id, @RequestBody Formation f)
	{
		f.setId(id);
		return iService.updateFormation(f);
	}

	@RequestMapping(value = "/sites", method = RequestMethod.GET)
	public List<Site> findAllSites() {
		return iService.findAllSites();

	}

	@RequestMapping(value = "/sites/{id}", method = RequestMethod.GET)
	public Site findSitesById(@PathVariable Long id) {
		return iService.findSite(id);

	}

	
}
