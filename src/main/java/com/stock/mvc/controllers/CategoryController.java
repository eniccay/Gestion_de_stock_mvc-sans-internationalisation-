package com.stock.mvc.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stock.mvc.entities.Category;

import com.stock.mvc.services.ICategorieService;


@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private ICategorieService categoryService;
	

	@RequestMapping(value = "/")
	public String category(Model model) {
		List<Category> categorys = categoryService.selectAll();
		if (categorys == null) {
			categorys = new ArrayList<Category>();
		}
		model.addAttribute("categorys",categorys);

		return "category/category";

	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterCategory(Model model) {

		Category category = new Category();
		model.addAttribute("category", category);
		return "category/ajouterCategory";
	}

	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String enregistrerCategory(Model model, Category category) {
		
		if (category != null) {
			if (category.getIdCategory() != null) {
				categoryService.update(category);
			} else {
				categoryService.save(category);

			}

		}

		return "redirect:/category/";

	}

	@RequestMapping(value = "/modifier/{idCategory}")
	public String modifierCategory(Model model, @PathVariable Long idCategory) {
		if (idCategory != null) {
			Category category = categoryService.getById(idCategory);
			if (category != null) {
				model.addAttribute("category", category);

			}

		}
		return "category/ajouterCategory";
	}
	
	@RequestMapping(value="/supprimer/{idCategory}")
	public String supprimer(Model model , @PathVariable Long idCategory ) {
		if(idCategory != null) {
			Category category = categoryService.getById(idCategory);
		if(category!=null)	{
			categoryService.remove(idCategory);
		}
			//model.addAttribute("client", client);

		}
	
		return "redirect:/category/";
		
	
	}
	
}
