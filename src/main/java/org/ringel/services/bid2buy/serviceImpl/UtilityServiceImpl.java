package org.ringel.services.bid2buy.serviceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.ringel.services.bid2buy.dao.UtilityDao;
import org.ringel.services.bid2buy.daoImpl.UtilityDaoImpl;
import org.ringel.services.bid2buy.model.CategoriesModel;
import org.ringel.services.bid2buy.model.HelpTextModel;
import org.ringel.services.bid2buy.service.UtilityService;

public class UtilityServiceImpl implements UtilityService {

	@Override
	public HelpTextModel getHelpText() {
		UtilityDao dao = new UtilityDaoImpl();
		HelpTextModel helptext = dao.getHelpText();
		return helptext;
	}

	

	@Override
	public String parseDate(Date date) {

		String dateStr = date.toString();
		DateFormat readFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		DateFormat writeFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		try {
			date1 = readFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String formattedDate = "";
		if (date1 != null) {
			formattedDate = writeFormat.format(date1);
		}

		return formattedDate;
	}



	@Override
	public  ArrayList<CategoriesModel> getCategories() {
		UtilityDao dao = new UtilityDaoImpl();
     ArrayList<CategoriesModel>	 categories=dao.fetchCategories();
		return categories;

		
		
	}

}
