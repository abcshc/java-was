package controller;

import java.util.Map;

import db.DataBase;
import model.User;
import request.GeneralHeaderValue;
import request.RequestHeader;
import util.HttpRequestUtils;

public class UserCreateController implements Controller {

	@Override
	public String run(RequestHeader requestHeader) {
		userSignUp(requestHeader.getRequestBody());
		return "redirect: " + HOMEPATH;
	}

	private void userSignUp(String requestBody) {
		DataBase.addUser(getUser(HttpRequestUtils.parseQueryString(requestBody)));
	}

	private User getUser(Map<String, String> inputValue) {
		User user = new User(inputValue.get("userId"), inputValue.get("password"), inputValue.get("name"),
				inputValue.get("email"));
		return user;
	}

	@Override
	public GeneralHeaderValue getResponseHeaderValue() {
		return null;
	}
}