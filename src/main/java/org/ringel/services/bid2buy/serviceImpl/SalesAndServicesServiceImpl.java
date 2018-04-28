package org.ringel.services.bid2buy.serviceImpl;

import java.util.ArrayList;
import java.util.Date;

import org.ringel.services.bid2buy.dao.SalesAndServicesDao;
import org.ringel.services.bid2buy.daoImpl.SalesAndServicesDaoImpl;
import org.ringel.services.bid2buy.model.CategoriesModel;
import org.ringel.services.bid2buy.model.ItemModel;
import org.ringel.services.bid2buy.service.SalesAndServicesService;

public class SalesAndServicesServiceImpl implements SalesAndServicesService {

	@Override
	public ItemModel SaveOrUpdateItem(ItemModel model) {
		SalesAndServicesDao dao=new SalesAndServicesDaoImpl();
		model=dao.doSave(model);
		return model;
	}

	@Override
	public ArrayList<ItemModel> getItemsByCategory(String category) {
		if(category ==null ||category =="") return null;
		System.out.println(category);
		ArrayList<ItemModel> items=null;
		try {
		SalesAndServicesDao dao=new SalesAndServicesDaoImpl();
		CategoriesModel cat=dao.getCategoryByName(category);
		int cat_id=cat.getCat_id();
		String id=Integer.toString(cat_id);
		items=		dao.getItemsByCategory(id);
		}
		catch (Exception e) {
			System.err.println(e);
			return null;
		}
		return items;

	}
	
	

}
