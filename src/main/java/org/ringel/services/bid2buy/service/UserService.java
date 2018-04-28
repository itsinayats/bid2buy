package org.ringel.services.bid2buy.service;

import org.ringel.services.bid2buy.model.UserModel;

public interface UserService {

	public UserModel doLogin(UserModel user);

	public UserModel doRegister(UserModel user);

	public String getPassword(String secretans, String secretans2);


}
