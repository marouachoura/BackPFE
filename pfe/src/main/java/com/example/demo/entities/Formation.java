package com.example.demo.entities;

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
@Table(name = "formations")
public class Formation {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id ;
	 @NonNull
	 private String nomFormation ;
	 @NonNull
	 private String nomFormateur ;
	 @NonNull
	 private String niveau ;
	 @NonNull
	 private String certification ;
	 @NonNull
	 private Date duree ;
	 @ManyToMany(mappedBy = "formations", fetch = FetchType.LAZY)
	 private Collection<Employe> employes  = new ArrayList<>(); 


}
