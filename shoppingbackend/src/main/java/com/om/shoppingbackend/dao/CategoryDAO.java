package com.om.shoppingbackend.dao;
 
import java.util.List;

import com.om.shoppingbackend.dto.Category;

public interface CategoryDAO {

	 public List<Category> list();
	 public Category get(int id);
}
