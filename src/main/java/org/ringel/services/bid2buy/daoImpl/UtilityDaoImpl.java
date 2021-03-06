package org.ringel.services.bid2buy.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.ringel.services.bid2buy.dao.UtilityDao;
import org.ringel.services.bid2buy.model.CategoriesModel;
import org.ringel.services.bid2buy.model.HelpTextModel;

public class UtilityDaoImpl implements UtilityDao {

	@Override
	public HelpTextModel getHelpText() {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		HelpTextModel model = new HelpTextModel();
		try {
			session.beginTransaction();

			String hql = "from helpText_table";
			System.out.println(hql);
			Query query = session.createQuery(hql);
			// List result = query.list();
			List<HelpTextModel> list = query.list();
		    model=list.get(0);
		    model.setSuccess(true);
		    return model;
		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
				model.setException(e.toString());
				model.setReturnedMsg("Error getting result");
				model.setSuccess(false);
				return model;
			}
		} finally {
			session.close();
		}
		return model;
	
	}

	@Override
	public ArrayList<CategoriesModel> fetchCategories() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			/*session.save(new CategoriesModel());
			session.getTransaction().commit();*/
			String hql = "from categories_table";
			System.out.println(hql);
			Query query = session.createQuery(hql);
			 List result = query.list();
			ArrayList<CategoriesModel> list = (ArrayList<CategoriesModel>) query.list();
		   return list;
		} catch (Exception e) {
			if (session.getTransaction() != null) {
			System.out.println("Error getting result");
			}
		} finally {
			session.close();
		}
		return null;
	
	}

}
