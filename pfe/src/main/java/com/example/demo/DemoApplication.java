package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.dao.EmployeRepository;
import com.example.demo.dao.FormationRepository;
import com.example.demo.dao.SiteRepository;
import com.example.demo.entities.Employe;
import com.example.demo.entities.Formation;
import com.example.demo.entities.Site;
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
	 RepositoryRestConfiguration configuration ;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		// configuration.exposeIdsFor(Employe.class );
		// configuration.exposeIdsFor(Formation.class);

		Site site1 = new Site("Sfax");
		siteRepository.save(site1);

		Site site2 = new Site("tunis");
		siteRepository.save(site2);
		Employe emp1 = new Employe("Maroua Choura", 111111, new Date(), "maroua", "login123","Sfax");
		Employe emp2 = new Employe("toutou", 222222, new Date(), "toutou", "login123","tunis");
		Employe emp3 = new Employe("test", 222222, new Date(), "test", "login123","tunis");

		Formation formation1 = new Formation("deep Learning", "Ilyes manai", "M", "non certifier", new Date(3));

		//emp1.setSite(site1);
		//emp2.setSite(site2);
		employeRepository.save(emp1);
		employeRepository.save(emp2);
		employeRepository.save(emp3);
		formationRepository.save(formation1);

		coucheService.affectuerFormationToEmploye(emp1.getId(), formation1.getId());
		coucheService.affectuerFormationToEmploye(emp2.getId(), formation1.getId());
		System.out.println("marouaaa chouraaa") ;
		System.out.println("marouaaa chouraaa") ;
		System.out.println(coucheService.findEmploye(emp1.getId())) ;
		// System.out.println(coucheService.findSiteEmploye(emp1.getId()).getNomSite());

		// coucheService.affectuerSiteToEmploye(emp1.getId(), site1.getId());
		// coucheService.affectuerSiteToEmploye(emp2.getId(), site1.getId());

	}

}