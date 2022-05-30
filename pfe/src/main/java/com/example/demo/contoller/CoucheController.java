package com.example.demo.contoller;

import java.util.List;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employe;
import com.example.demo.entities.Formation;
import com.example.demo.entities.Site;
import com.example.demo.service.ICoucheService;

@RestController 
@CrossOrigin
@RequestMapping("/api/test")
public class CoucheController {

	@Autowired
	ICoucheService iService ;
	
	@PreAuthorize("hasRole('ROLE_USER' ) or hasRole('ROLE_ADMIN') ")
	@RequestMapping(value = "/employes", method = RequestMethod.GET)
	public List<Employe> findAllEmp() {
		return iService.findAllEmployes();

	}
	
	/*@RequestMapping(value = "/employes/site/{id}", method = RequestMethod.GET)
	public Site findSiteEmploye(@PathVariable Long id) {
		return iService.findSiteEmploye(id);	
	
	}*/
        @PreAuthorize("hasRole('ROLE_USER' ) or hasRole('ROLE_ADMIN') ")
	@RequestMapping(value = "/employes/formations/{id}", method = RequestMethod.GET)
	public List <Formation> findFormationsEmploye(@PathVariable Long id) {
		return iService.findFormationsdEmploye(id);	
	
	}

	@PreAuthorize("hasRole('ROLE_USER' ) or hasRole('ROLE_ADMIN') ")
	@PostMapping(value = "/employes/add")

	public Employe addEmploye(@RequestBody Employe e)
	{
		//System.out.println(e.toStringEmpl());
		return iService.addEmploye(e);
		
	}
	@PreAuthorize("hasRole('ROLE_USER' ) or hasRole('ROLE_ADMIN') ")
	@RequestMapping(value = "/employes/find/{id}", method = RequestMethod.GET)
	public Employe findEmployeByid(@PathVariable Long id) {
		return iService.findEmploye(id);	
	
	}

	@PreAuthorize("hasRole('ROLE_USER' ) or hasRole('ROLE_ADMIN') ")
	@DeleteMapping(value="/employes/delete/{id}")
	public void deleteEmploye(@PathVariable Long id)
	{
		iService.deleteEmploye(id);
	}
	
	@PreAuthorize("hasRole('ROLE_USER' ) or hasRole('ROLE_ADMIN') ")
	@RequestMapping(value = "/formations", method = RequestMethod.GET)
	public List<Formation> findAllFormations() {
		return iService.findAllFormations();
	}
	
	@PreAuthorize("hasRole('ROLE_USER' ) or hasRole('ROLE_ADMIN') ")
	@RequestMapping(value = "/formations/find/{id}", method = RequestMethod.GET)
	public Formation findFormation(@PathVariable Long id) {
		return iService.findFormation(id);	
	}
	
	@PreAuthorize("hasRole('ROLE_USER' ) or hasRole('ROLE_ADMIN') ")
	@PostMapping(value = "/formations/add")

	public Formation addFormation(@RequestBody Formation f)
	{
		return iService.addFormation(f);
	}
	
	@PreAuthorize("hasRole('ROLE_USER' ) or hasRole('ROLE_ADMIN') ")
	@DeleteMapping(value="/formations/delete/{id}")
	public void deleteFormation(@PathVariable Long id)
	{
		iService.deleteFormation(id);
	}
	
	@PreAuthorize("hasRole('ROLE_USER' ) or hasRole('ROLE_ADMIN') ")
	@PutMapping(value="/formation/update/{id}")
	public Formation updateFormation(@PathVariable Long id, @RequestBody Formation f)
	{
		f.setId(id);
		return iService.updateFormation(f);
	}

	@PreAuthorize("hasRole('ROLE_USER' ) or hasRole('ROLE_ADMIN') ")
	@RequestMapping(value = "/sites", method = RequestMethod.GET)
	public List<Site> findAllSites() {
		return iService.findAllSites();

	}
	
	@PreAuthorize("hasRole('ROLE_USER' ) or hasRole('ROLE_ADMIN') ")
	@RequestMapping(value = "/sites/find/{id}", method = RequestMethod.GET)
	public Site findSitesById(@PathVariable Long id) {
		return iService.findSite(id);

	}
	
	@PreAuthorize("hasRole('ROLE_USER' ) or hasRole('ROLE_ADMIN') ")
	@DeleteMapping(value="/sites/delete/{id}")
	public void deleteSite(@PathVariable Long id)
	{
		iService.deleteSite(id);
	}

	@PreAuthorize("hasRole('ROLE_USER' ) or hasRole('ROLE_ADMIN') ")
	@PostMapping(value = "/sites/add")

	public Site addSite(@RequestBody Site site)
	{
		return iService.addSite(site);
	}

	@PreAuthorize("hasRole('ROLE_USER' ) or hasRole('ROLE_ADMIN') ")
	@PutMapping(value="/sites/update/{id}")
	public Site updateSite(@PathVariable Long id, @RequestBody Site site)
	{
		site.setId(id);
		return iService.updateSite(site);
	}
	

	@PreAuthorize("hasRole('ROLE_USER' ) or hasRole('ROLE_ADMIN') ")
	@PutMapping(value = "/employes/{idemp}/formations/{idformation}")
	public void affecter(@PathVariable(value = "idemp")  Long idemp, @PathVariable(value = "idformation")  Long idformation) {
		 iService.affectuerFormationToEmploye(idemp, idformation);
	}
	
}
