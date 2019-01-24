package com.stock.mvc.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Utilisateur implements Serializable {


@Id
@GeneratedValue
private Long  idUtilisateur;

private String nom;
 
private String prenom;

private String mail;

private String moteDePasse;

private String photo;

public Long getIdUtilisateur() {
	return idUtilisateur;
}

public void setIdUtilisateur(Long idUtilisateur) {
	this.idUtilisateur = idUtilisateur;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getMail() {
	return mail;
}

public void setMail(String mail) {
	this.mail = mail;
}

public String getMoteDePasse() {
	return moteDePasse;
}

public void setMoteDePasse(String moteDePasse) {
	this.moteDePasse = moteDePasse;
}

public String getPhoto() {
	return photo;
}

public void setPhoto(String photo) {
	this.photo = photo;
}



}