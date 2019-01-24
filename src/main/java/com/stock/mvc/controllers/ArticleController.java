package com.stock.mvc.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.stock.mvc.entities.Article;
import com.stock.mvc.entities.Category;
import com.stock.mvc.entities.Client;
import com.stock.mvc.services.IArticleService;
import com.stock.mvc.services.ICategorieService;
import com.stock.mvc.services.IClientService;
import com.stock.mvc.services.IFlickrService;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private IArticleService articleService;
	@Autowired
	private ICategorieService categorieService;

	@Autowired
	private IFlickrService flickrService;

	@RequestMapping(value = "/")
	public String client(Model model) {
		List<Article> articles = articleService.selectAll();
		if (articles == null) {
			articles = new ArrayList<Article>();
		}
		model.addAttribute("articles", articles);

		return "article/article";

	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterArticle(Model model) {

		Article article = new Article();
		List<Category> categorys = categorieService.selectAll();
		if (categorys == null) {
			categorys = new ArrayList<Category>();
		}
		model.addAttribute("categorys", categorys);
		model.addAttribute("article", article);

		return "article/ajouterArticle";
	}

	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String enregistrerArticle(Model model, Article article, MultipartFile file) {
		String photoUrl = null;
		if (article != null) {
			if (file != null && !file.isEmpty()) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();
					photoUrl = flickrService.savePhoto(stream, article.getCodeArticle());
					article.setPhoto(photoUrl);

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						stream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			if (article.getIdArticle() != null) {
				articleService.update(article);
			} else {
				articleService.save(article);

			}

		}

		return "redirect:/article/";

	}

	@RequestMapping(value = "/modifier/{idArticle}")
	public String modifierArticle(Model model, @PathVariable Long idArticle) {
		if (idArticle != null) {
			Article article = articleService.getById(idArticle);
			List<Category> categorys = categorieService.selectAll();
			if (categorys == null) {
				categorys = new ArrayList<Category>();
			}
			model.addAttribute("categorys", categorys);
			if (article != null) {
				model.addAttribute("article", article);

			}

		}
		return "article/ajouterArticle";
	}
	
	@RequestMapping(value="/supprimer/{idArticle}")
	public String supprimer(Model model , @PathVariable Long idArticle ) {
		if(idArticle != null) {
			Article article = articleService.getById(idArticle);
		if(article!=null)	{
			articleService.remove(idArticle);
		}
			//model.addAttribute("client", client);

		}
	
		return "redirect:/article/";
		
	
	}
	
}
