package org.ringel.services.bid2buy.dao;

import java.util.ArrayList;

import org.ringel.services.bid2buy.model.CategoriesModel;
import org.ringel.services.bid2buy.model.ItemModel;

public interface SalesAndServicesDao {

	public ItemModel doSave(ItemModel model);

	public ArrayList<ItemModel> getItemsByCategory(String category);

	CategoriesModel getCategoryByName(String categoryName);
	

}
