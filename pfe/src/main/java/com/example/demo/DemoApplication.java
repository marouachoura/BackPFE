package com.example.demo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.dao.EmployeRepository;
import com.example.demo.dao.FormationRepository;
import com.example.demo.dao.SiteRepository;
import com.example.demo.entities.Employe;
import com.example.demo.entities.Formation;
import com.example.demo.entities.Site;
import com.example.demo.security.models.ERole;
import com.example.demo.security.models.Role;

import com.example.demo.security.repository.RoleRepository;

import com.example.demo.service.ICoucheService;

@SpringBootApplication

public class DemoApplication implements CommandLineRunner {

	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	FormationRepository formationRepository;
	@Autowired
	SiteRepository siteRepository;
	@Autowired
	ICoucheService coucheService;
	@Autowired
	RoleRepository roleRepository ;
	@Autowired
	PasswordEncoder encoder;
	
	
	 @Autowired
	 RepositoryRestConfiguration configuration ;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		// configuration.exposeIdsFor(Employe.class );
		// configuration.exposeIdsFor(Formation.class);
		Role admin = new Role(ERole.ROLE_ADMIN);
		Role roleUser = new Role(ERole.ROLE_USER);
		Role mod = new Role(ERole.ROLE_MODERATOR);
		roleRepository.save(roleUser);
		roleRepository.save(mod);
		roleRepository.save(admin);


		//User user = new User("admin2","admin.admin@enis.tn","123456789");
		//Set<Role> roles = new HashSet<>( ) ;
	//	roles.
        //user.setRoles(ERole.ROLE_ADMIN);
		
		Site site1 = new Site("Sfax");
		siteRepository.save(site1);

		Site site2 = new Site("tunis");
		siteRepository.save(site2);
		Formation formation1 = new Formation("deep Learning", "Ilyes manai", "M", "non certifier", new Date(3));
		formationRepository.save(formation1);
		Set <Role> setRole = new HashSet<>()  ;
		System.out.println(setRole.size());
		//setRole.add(roleUser);
		Set <Role> setRoleAdmin = new HashSet<>()  ;
		setRole.add(admin);
				
	//	Employe emp1 = new Employe("Maroua Choura", 111111, new Date(), "maroua", "login123");
	//	Employe emp2 = new Employe("toutou", 222222, new Date(), "toutou", "login123");
	//	Employe emp3 = new Employe("test", 222222, new Date(), "test", "login123");
		/*Employe emp1 = new Employe("Maroua Choura", 111111, new Date(), "maroua", "login123","Sfax");
		Employe emp2 = new Employe("toutou", 222222, new Date(), "toutou", "login123","tunis");
		Employe emp3 = new Employe("test", 222222, new Date(), "test", "login123","tunis");*/
	Employe emp1 = new Employe("maroua CHOURA", 111111, new Date(), "maroua2",  "maroua2", "maroua2.choura@enis.tn", encoder.encode("123456789"));
	Employe emp2 = new Employe("admin admin", 111111, new Date(), "admin",  "admin", "admin.admin@enis.tn", encoder.encode("123456789"));

	Employe emp3 = new Employe("toutou ", 111111, new Date(), "toutou",  "toutou", "toutou.toutou@enis.tn", encoder.encode("123456789"));

       emp1.setRoles(setRole);
        emp2.setRoles(setRoleAdmin);
        emp3.setRoles(setRole);
		System.out.println("marouaaa chouraaa1") ;
		emp1.setSite(site1);
		emp2.setSite(site1);
		emp3.setSite(site2);
		System.out.println("marouaaa chouraaa4") ;
		
	/*	emp1.setSite(site1);
		emp2.setSite(site2);
		employeRepository.save(emp1);
		employeRepository.save(emp2);*/
		//employeRepository.save(emp3);
		employeRepository.save(emp1);
		employeRepository.save(emp2) ;
		employeRepository.save(emp3);
		System.out.println("marouaaa chouraaa2") ;
		coucheService.affectuerFormationToEmploye(emp1.getId(), formation1.getId());
		//coucheService.affectuerFormationToEmploye(emp2.getId(), formation1.getId());
		
		System.out.println("marouaaa chouraaa3") ;
		//System.out.println(coucheService.findEmploye(emp1.getId())) ;
		// System.out.println(coucheService.findSiteEmploye(emp1.getId()).getNomSite());

		// coucheService.affectuerSiteToEmploye(emp1.getId(), site1.getId());
		// coucheService.affectuerSiteToEmploye(emp2.getId(), site1.getId());

	}

}
