package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "employes")
public class Employe {
 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id ;
 @NonNull
 private String nomPrenom ;
 @NonNull
 private int cin ;
 @NonNull
 private Date dateNais ;
 @NonNull
 private String login ;
 @NonNull
 private String password ;
 @ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
 @JoinTable(name = "EmployeFormation", joinColumns = {
         @JoinColumn(name = "employe_id", referencedColumnName = "id",
                 nullable = false, updatable = false)},
 inverseJoinColumns = {
         @JoinColumn(name = "formation_id", referencedColumnName = "id",
                 nullable = false, updatable = false)})
 private Collection<Formation> formations  = new ArrayList<>() ;
 
 @ManyToOne(fetch = FetchType.LAZY, optional = false)
 @JoinColumn(name = "site_id", nullable = false)
 private Site site;

}
