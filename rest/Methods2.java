package rest;

import java.io.File;
import java.util.Date;
import java.util.Random;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Methods2 {

	public static Random random = new Random();

	public static String toJsonString(Object object) throws JsonProcessingException {

		ObjectMapper maper = new ObjectMapper();
		String jsonString = maper.writeValueAsString(object);
		return jsonString;
	}

	public static String getDate() {

		Date d = new Date();
		String date = d.toString();
		String[] datea = date.split(" ");
		String dateFinal = datea[1] + "." + datea[2] + "." + datea[5];
		return dateFinal;
	}

	public static String createFolderPath() {

		String finalPath = "";
		String path = "C:\\Users\\zikaz\\OneDrive\\Desktop\\projects\\PetStoreUser\\MyReports\\reportNo";
		String end = ".html";

		for (int a = 0; a < 200; a++) {
			File file = new File(path + String.valueOf(a) + end);
			if (!file.exists()) {
				finalPath = path + String.valueOf(a) + end;
				break;
			} 
		}
		return finalPath;
	}

	public static String createMail() {

		String a = "json";
		String b = "@gmail.com";
		String c = String.valueOf(random.nextInt(5000));
		String mail = a + c + b;
		return mail;
	}

	public static String createPhone() {

		String a = "0370";
		String b = String.valueOf(random.nextInt(5000));
		String phone = a + b;
		return phone;
	}

	public static String createPassword() {

		String a = "6670";
		String b = String.valueOf(random.nextInt(5000));
		String pwd = a + b;
		return pwd;
	}

	public static String createUsername() {

		String a = "per";
		String b = String.valueOf(random.nextInt(5000));
		String username = a + b;
		return username;

	}

	public static int createID() {

		return random.nextInt(5000);

	}

}
