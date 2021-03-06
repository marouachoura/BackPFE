package com.example.demo.security.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import com.example.demo.entities.Employe;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;
	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	@JsonIgnoreProperties("roles") 
	private Collection<Employe> users = new ArrayList<>();
	public Role() {
	}
	public Role(ERole name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ERole getName() {
		return name;
	}
	public void setName(ERole name) {
		this.name = name;
	}
}
