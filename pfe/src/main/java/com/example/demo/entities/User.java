package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Entity @Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	private String userId ;
	private String name ;
	private String login ;
	private String password ;
	private Date lastLoginDate ;
	private Date lastLoginDateDisplay ;
	private Date joinDate ;
	private String[] roles  ;
	private String[] authorities ;


		
}