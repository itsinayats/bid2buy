package org.ringel.services.bid2buy.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ringel.services.bid2buy.model.BidderModel;
import org.ringel.services.bid2buy.model.UserModel;

public class GenerateTable {
	// registration
		public static BidderModel doSave(BidderModel model) {
			System.out.println("Entered in userDaoImpl:doSave.");
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(model);
            session.getTransaction().commit();
			return model;

		}
		
		public static void main(String[] args) {
			BidderModel model=new BidderModel();
			doSave(model);
		}

}
