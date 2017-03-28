package queryengine.app;

import static org.junit.Assert.*;

import org.junit.Test;

import queryengine.app.App;
import queryengine.miscellaneous.ResponseMessage;
import resources.personrecord.User;

public class LoginTest {

	private App aObj = App.getTestAppInstance(20);

	// Test for username and password not present in database
	@Test
	public void testLoginFailure1() {
		ResponseMessage rmObj = new ResponseMessage(false, "Incorrect username and/or password");
		assertEquals(rmObj, aObj.login("username", "password"));
	}

	// Test for correct username in database but incorrect password
	@Test
	public void testLoginFailure2() {
		ResponseMessage rmObj = new ResponseMessage(false, "Incorrect username and/or password");
		assertEquals(rmObj,aObj.login("mike", "password"));
	}

	// Test for incorrect username in database but correct password
	@Test
	public void testLoginFailure3() {
		ResponseMessage rmObj = new ResponseMessage(false, "Incorrect username and/or password");
		assertEquals(rmObj, aObj.login("username", "admin"));
	}

	// Test for username with special characters (not allowed in system) 
	@Test
	public void testLoginFailure4() {
		ResponseMessage rmObj = new ResponseMessage(false, "Incorrect username and/or password");
		assertEquals(rmObj, aObj.login("u$er=name", "admin"));
	}

	//Test for correct username and password in database
	@Test
	public void testLoginSuccess1() {
		ResponseMessage rmObj = new ResponseMessage(true, "Valid username and/or password");
		User user = aObj.getUserByUsername("mike");
		assertEquals(rmObj, aObj.login("mike", user.getPassword()));
	}
}
