package com.example.produits.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.produits.entities.Categorie;
import com.example.produits.entities.Produit;
import com.example.produits.service.CategorieService;

@Controller
public class CategorieController {
	@Autowired
	CategorieService categorieService;
	@RequestMapping("/showCreateC")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("categorie", new Categorie());
	modelMap.addAttribute("mode", "newc");
	return "createCategorie";
	}

	@RequestMapping("/saveCategorie")
	public String saveCategorie(@Valid Categorie categorie,
	BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "createCategorie";
	 
	categorieService.saveCategorie(categorie);
	return "createCategorie";
	}
	
	
	@RequestMapping("/ListeCategories")
	public String listeProduits(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	Page<Categorie> cats = categorieService.getAllCategoriesParPage(page, size);
	modelMap.addAttribute("categorie", cats);
	 modelMap.addAttribute("pages", new int[cats.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listecategories";
	}
	@RequestMapping("/supprimerCategorie")
	public String supprimerProduit(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	categorieService.deleteCategorie(id);
	Page<Categorie> cats  = categorieService.getAllCategoriesParPage(page, 
	size);
	modelMap.addAttribute("categorie", cats);
	modelMap.addAttribute("pages", new int[cats.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listecategories";
	}


	@RequestMapping("/modifierCategorie")
	public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Categorie c= categorieService.getCategorie(id);
	modelMap.addAttribute("categorie", c);
	modelMap.addAttribute("mode", "edit");
	return "createCategorie";
	}

	
	

}
