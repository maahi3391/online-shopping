package com.om.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.om.shoppingbackend.dao.CategoryDAO;
import com.om.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	
	private static List<Category> categories = new ArrayList<>();
	
	static{
		Category  category=new Category();
		category.setId(101);
		category.setName("Telivision");
		category.setDescription("some desc of tv........");
		category.setImageURL("Cat.png");
		
		categories.add(category);
		 
		category=new Category();
		category.setId(102);
		category.setName("Mobile");
		category.setDescription("some desc of Mobile........");
		category.setImageURL("Cat1.png");
		
		categories.add(category);
		 
		category=new Category();
		category.setId(103);
		category.setName("Laptop");
		category.setDescription("some desc of Laptop........");
		category.setImageURL("Cat2.png");
		
		categories.add(category);
	}
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}


	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		for(Category category : categories ) {
			if(category.getId() == id) return category;
		}
		return null;
	}

}
