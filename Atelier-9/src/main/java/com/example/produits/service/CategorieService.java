package com.example.produits.service;



import java.util.List;

import org.springframework.data.domain.Page;

import com.example.produits.entities.Categorie;
import com.example.produits.entities.Produit;

public interface CategorieService {
	Categorie saveCategorie(Categorie categorie);
	Categorie updateCategorie(Categorie categorie);
	void deleteCategorie(Long id);
	List<Categorie> getAllCategories();
	Page<Categorie> getAllCategoriesParPage(int page, int size);
	Categorie getCategorie(Long id);
}
