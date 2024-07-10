package pojo;

public class User <T> {
	
public T id;	
public T username;
public T firstName;
public T lastName;	
public T email;		
public T password;
public T phone;
public int userStatus=0;


public T getId() {
	return id;
}
public void setId(T id) {
	this.id = id;
}
public T getUsername() {
	return username;
}
public void setUsername(T username) {
	this.username = username;
}
public T getFirstName() {
	return firstName;
}
public void setFirstName(T firstName) {
	this.firstName = firstName;
}
public T getLastName() {
	return lastName;
}
public void setLastName(T lastName) {
	this.lastName = lastName;
}
public T getEmail() {
	return email;
}
public void setEmail(T email) {
	this.email = email;
}
public T getPassword() {
	return password;
}
public void setPassword(T password) {
	this.password = password;
}
public T getPhone() {
	return phone;
}
public void setPhone(T phone) {
	this.phone = phone;
}








	

}
