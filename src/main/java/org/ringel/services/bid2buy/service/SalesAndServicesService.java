package org.ringel.services.bid2buy.service;

import java.util.ArrayList;

import org.ringel.services.bid2buy.model.ItemModel;

public interface SalesAndServicesService {

	public ItemModel SaveOrUpdateItem(ItemModel model);
	public ArrayList<ItemModel> getItemsByCategory(String category);

}
