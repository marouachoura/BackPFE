package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@Table(name = "site")
public class Site implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id ;
	 @NonNull
	 private String nomSite ;
	 
	 
	@OneToMany(mappedBy = "site", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JsonManagedReference (value="employes-movement")
	//@JsonManagedReference 
	@JsonIgnore
	private Collection<Employe> employes = new ArrayList<>() ;


	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Site(@NonNull String nomSite) {
		super();
		this.nomSite = nomSite;
	}


	/*public Site(Long id, @NonNull String nomSite, Collection<Employe> employes) {
		super();
		this.id = id;
		this.nomSite = nomSite;
		this.employes = employes;
	}*/


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomSite() {
		return nomSite;
	}


	public void setNomSite(String nomSite) {
		this.nomSite = nomSite;
	}


	
	public Collection<Employe> getEmployes() {
		return employes;
	}


	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}
	
}