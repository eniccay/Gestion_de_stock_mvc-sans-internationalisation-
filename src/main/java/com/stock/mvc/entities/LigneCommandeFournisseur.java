package com.stock.mvc.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class LigneCommandeFournisseur implements Serializable {


@Id
@GeneratedValue
private Long  idLigneCommandeFournisseur;

@ManyToOne
@JoinColumn(name="idArticle")
private Article article;

public CommandeFournisseur getCommandeFournisseur() {
	return commandeFournisseur;
}

public void setCommandeFournisseur(CommandeFournisseur commandeFournisseur) {
	this.commandeFournisseur = commandeFournisseur;
}

@ManyToOne
@JoinColumn(name="idCommandeFournisseur")
private CommandeFournisseur commandeFournisseur;

public Long getIdLigneCommandeFournisseur() {
	return idLigneCommandeFournisseur;
}

public void setIdLigneCommandeFournisseur(Long idLigneCommandeFournisseur) {
	this.idLigneCommandeFournisseur = idLigneCommandeFournisseur;
}

public Article getArticle() {
	return article;
}

public void setArticle(Article article) {
	this.article = article;
}





public Long getIdArticle() {
	return idLigneCommandeFournisseur;
}

public void setIdArticle(Long idLigneCommandeFournisseur) {
	this.idLigneCommandeFournisseur = idLigneCommandeFournisseur;

}
}