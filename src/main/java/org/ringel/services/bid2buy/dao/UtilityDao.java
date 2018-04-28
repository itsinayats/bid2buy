package org.ringel.services.bid2buy.dao;

import java.util.ArrayList;

import org.ringel.services.bid2buy.model.CategoriesModel;
import org.ringel.services.bid2buy.model.HelpTextModel;

public interface UtilityDao {
	
public HelpTextModel getHelpText();

public ArrayList<CategoriesModel> fetchCategories();
}
