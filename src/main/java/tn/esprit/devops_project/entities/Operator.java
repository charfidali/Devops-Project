package tn.esprit.devops_project.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Operator implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idOperateur;
	String fname;
	String lname;
	String password;
	@OneToMany
	@JsonIgnore
	Set<Invoice> invoices;

	public Operator() {
	}

	public Operator(int idOperateur ,String fname,String lname) {
		this.fname = fname;
		this.lname=lname;
		this.idOperateur=idOperateur;
	}
}
