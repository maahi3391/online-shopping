package com.om.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.om.shoppingbackend.dao.CategoryDAO;
import com.om.shoppingbackend.dto.Category;

@Controller
public class pageController {

	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	/*
	 * Method to load all category product
	 */
	@RequestMapping(value = "show/all/products")
	public ModelAndView showAllProducts() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = "show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {

		ModelAndView mv = new ModelAndView("page");
        
		 // Category DAO to featch the category
		Category category = null;
		category = categoryDAO.get(id);

		mv.addObject("title", category.getName());

		//to featch the list of category
		mv.addObject("categories", categoryDAO.list());
		
		//to featch the single of category
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
}
