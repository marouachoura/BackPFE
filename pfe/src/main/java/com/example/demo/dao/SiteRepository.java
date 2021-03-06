package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Formation;
import com.example.demo.entities.Site;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long>{
	Formation findByNomSiteContaining(String nomSite  );
	
}	

