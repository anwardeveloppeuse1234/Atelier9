package com.example.produits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.produits.entities.Categorie;
import com.example.produits.entities.Produit;
import com.example.produits.repos.CategorieReposity;

@Service
public class CategorieServiceImp implements CategorieService {

	@Autowired
	CategorieReposity categorieRepository;

	@Override
	public Categorie saveCategorie(Categorie categorie) {
		return categorieRepository.save(categorie);
	}

	@Override
	public Categorie updateCategorie(Categorie categorie) {
		return categorieRepository.save(categorie);
	
	}


	@Override
	public List<Categorie> getAllCategories() {
return categorieRepository.findAll();
	}

	@Override
	public void deleteCategorie(Long id) {
		categorieRepository.deleteById(id);
		
	}

	@Override
	public Page<Categorie> getAllCategoriesParPage(int page, int size) {
		return categorieRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Categorie getCategorie(Long id) {
		return categorieRepository.findById(id).get();
	}

	

}
