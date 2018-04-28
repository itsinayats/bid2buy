package org.ringel.services.bid2buy.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.ringel.services.bid2buy.dao.SalesAndServicesDao;
import org.ringel.services.bid2buy.dao.UserDao;
import org.ringel.services.bid2buy.model.CategoriesModel;
import org.ringel.services.bid2buy.model.ItemModel;
import org.ringel.services.bid2buy.model.UserModel;
public class SalesAndServicesDaoImpl implements SalesAndServicesDao {
	
	@Override
	public ItemModel doSave(ItemModel model) {
	UserDao dao=	new UserDaoImpl();
	UserModel user=dao.getUserDataByUserId(model.getSellar().getId());
	if(user.getSuccess().equals(false)) {
		model.setException("User doesn't Exist");
		model.setSuccess(false);
		return model;
	}
		
		
	System.out.println("Entered in SalesAndServicesDaoImpl:doSave.");
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	Session session = factory.openSession();
	session.beginTransaction();

	try {
		if (model.getId() > 0) {
			System.out.println("Entered in SalesAndServicesDaoImpl:doSave|saveOrUpdate");
			session.saveOrUpdate(model);
		} else {
			System.out.println("Entered in SalesAndServicesDaoImpl:doSave|save");
			Integer generatedId = (Integer) session.save(model);
			model.setId(generatedId);
		}

		session.getTransaction().commit();
		model.setSuccess(true);
	} catch (Exception e) {
		model.setSuccess(false);
		model.setException(e.toString());
		model.setReturnedMsg("Error Saving Data");
	} finally {
		session.close();
		factory.close();
	}
	return model;

	}

	@Override
	public ArrayList<ItemModel> getItemsByCategory(String category) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		List<ItemModel> list=null;
		try {
			session.beginTransaction();

			String hql = "from item_table where category_id = :id";
			System.out.println(hql);
			Query query = session.createQuery(hql);
			query.setParameter("id", category);
			// List result = query.list();
			list = query.list();
			

		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
				System.out.println(e);
				return null;
			}
		} finally {
			session.close();
		}
		return (ArrayList<ItemModel>) list;
	}
	
	
	@Override
	public CategoriesModel getCategoryByName(String categoryName) {
		if(categoryName ==null || categoryName =="") return null;
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		try {
			session.beginTransaction();

			String hql = "from categories_table where cat_name = :categoryName";
			System.out.println(hql);
			Query query = session.createQuery(hql);
			query.setParameter("categoryName", categoryName);
			// List result = query.list();
			List<CategoriesModel> list = query.list();
			return list.get(0);

		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
				System.out.println(e);
				return null;
			}
		} finally {
			session.close();
		}
		return null;
	}
	
}
