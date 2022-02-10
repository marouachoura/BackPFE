package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employe;
import com.example.demo.entities.Formation;
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

	@RequestMapping(value = "/formations", method = RequestMethod.GET)
	public List<Formation> findAllFormations() {
		return iService.findAllFormations();

	}

}
