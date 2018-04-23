package org.ringel.services.bid2buy.dao;


import org.ringel.services.bid2buy.model.UserModel;
public  interface UserDao {
	
	public UserModel doSave(UserModel model);
	public UserModel doAuthenticate(UserModel userModel);
	public UserModel getUserDataByUserId(int id);
	public String getPasswod(String username,String secretans);
	
	
}
