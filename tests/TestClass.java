package tests;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import pojo.User;
import rest.BasicAuth;
import rest.Context;
import rest.EContentType;
import rest.Methods;
import rest.Methods2;

public class TestClass extends ExtentReportClass {

	User user;
	public String baseUrl = "https://petstore.swagger.io/v2";

	@BeforeTest
	public void estam() throws JsonProcessingException {

		user = new User();
		user.setId(Methods2.createID());
		user.setFirstName("pera");
		user.setUsername(Methods2.createUsername());
		user.setLastName("peric");
		user.setEmail(Methods2.createMail());
		user.setPassword(Methods2.createPassword());
		user.setPhone(Methods2.createPhone());

	}

	@Test(priority = 1)
	public void test00() throws JSONException, JsonProcessingException {

		Context context = new Context();
		context.baseURL = baseUrl;
		context.URI = "/user";
		context.requestContentType = EContentType.JSON;
		context.requestBodyString = Methods2.toJsonString(user);

		Response resp = Methods.POST(context);
		int id = (int) user.id;
		String message = resp.jsonPath().get("message");

		Assert.assertTrue(resp.statusCode() == 200);
		Assert.assertTrue(id == Integer.valueOf(message));

	}

	@Test(priority = 2)
	public void test01() {

		Context context = new Context();
		context.baseURL = baseUrl;
		context.URI = "/user/{username}";
		context.pathParams.put("username", user.getUsername());

		Response resp = Methods.GET(context);
		String userName = resp.jsonPath().get("username");

		Assert.assertTrue(resp.statusCode() == 200);
		Assert.assertTrue(userName.contains("per"));
	}

	@Test(priority = 3)
	public void test02() {

		Context context = new Context();
		context.baseURL = baseUrl;
		context.URI = "/user/login";
		context.auth = new BasicAuth();
		context.username = (String) user.getUsername();
		context.pwd = (String) user.getPassword();

		Response resp = Methods.GET(context);
		String message = resp.jsonPath().get("message");

		Assert.assertTrue(resp.statusCode() == 200);
		Assert.assertTrue(message.contains("logged in user"));
	}

}
