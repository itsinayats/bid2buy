package org.ringel.services.bid2buy.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.ringel.services.bid2buy.model.CategoriesModel;
import org.ringel.services.bid2buy.model.HelpTextModel;
public interface UtilityService {
	public HelpTextModel getHelpText();
	public String parseDate(Date date);
	public ArrayList<CategoriesModel>  getCategories();

}
