package rest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BasicAuth implements IAuth {

	@Override
	public RequestSpecification auth(String username, String pwd) {

		RequestSpecification reqSpec = RestAssured.given().auth().basic(username, pwd);
		return reqSpec;

	}

}
