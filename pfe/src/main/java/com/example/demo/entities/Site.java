package com.example.demo.entities;

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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "site")
public class Site {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id ;
	 @NonNull
	 private String nomSite ;
	 
	 @OneToMany(mappedBy = "site", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 private Set<Employe> Employes;
}
