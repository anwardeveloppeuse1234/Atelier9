package com.example.produits.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Categorie {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idCat;

public Long getIdCat() {
	return idCat;
}

public void setIdCat(Long idCat) {
	this.idCat = idCat;
}

public String getNomCat() {
	return nomCat;
}

@Override
public String toString() {
	return "Categorie [idCat=" + idCat + ", nomCat=" + nomCat + ", descriptionCat=" + descriptionCat + ", produits="
			+ produits + "]";
}

public void setNomCat(String nomCat) {
	this.nomCat = nomCat;
}

public String getDescriptionCat() {
	return descriptionCat;
}

public void setDescriptionCat(String descriptionCat) {
	this.descriptionCat = descriptionCat;
}

public List<Produit> getProduits() {
	return produits;
}

public void setProduits(List<Produit> produits) {
	this.produits = produits;
}

private String nomCat;
private String descriptionCat;

@OneToMany(mappedBy = "categorie")
private List<Produit> produits;
}


