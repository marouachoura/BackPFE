package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "formations")
public class Formation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String nomFormation;
	@NonNull
	private String nomFormateur;
	@NonNull
	private String niveau;
	@NonNull
	private String certification;
	@NonNull
	@Temporal(TemporalType.DATE)
	private Date duree;
	@ManyToMany(mappedBy = "formations", fetch = FetchType.LAZY)
	// @JsonBackReference(value="formations-movement")
	//@JsonBackReference
	//@NotFound(action = NotFoundAction.IGNORE)
	@JsonIgnoreProperties("formations") 
	private Collection<Employe> employes = new ArrayList<>();

	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Formation(@NonNull String nomFormation, @NonNull String nomFormateur, @NonNull String niveau,
			@NonNull String certification, @NonNull Date duree) {
		super();
		this.nomFormation = nomFormation;
		this.nomFormateur = nomFormateur;
		this.niveau = niveau;
		this.certification = certification;
		this.duree = duree;
	}

	public Formation(Long id, @NonNull String nomFormation, @NonNull String nomFormateur, @NonNull String niveau,
			@NonNull String certification, @NonNull Date duree, Collection<Employe> employes) {
		super();
		this.id = id;
		this.nomFormation = nomFormation;
		this.nomFormateur = nomFormateur;
		this.niveau = niveau;
		this.certification = certification;
		this.duree = duree;
		this.employes = employes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomFormation() {
		return nomFormation;
	}

	public void setNomFormation(String nomFormation) {
		this.nomFormation = nomFormation;
	}

	public String getNomFormateur() {
		return nomFormateur;
	}

	public void setNomFormateur(String nomFormateur) {
		this.nomFormateur = nomFormateur;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public Date getDuree() {
		return duree;
	}

	public void setDuree(Date duree) {
		this.duree = duree;
	}

	//@JsonBackReference
	public Collection<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}

}
