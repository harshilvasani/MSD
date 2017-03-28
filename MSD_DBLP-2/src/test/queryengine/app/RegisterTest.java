package queryengine.app;

import static org.junit.Assert.*;
import org.junit.Test;
import queryengine.app.App;
import queryengine.miscellaneous.ResponseMessage;
import resources.personrecord.User;

public class RegisterTest {

	private App aObj = App.getTestAppInstance(20);

	// Success in registration - Username already exists
	@Test
	public void RegisterSuccess1(){
		User u = new User(-1, "mike", "admin", "Mike Weintraub", "6177847587", "m.weintraub@northeastern.edu");
		ResponseMessage rmObj = new ResponseMessage(false, "Username/Email-Id already exists");
		assertEquals(aObj.register(u), rmObj);
	}

	// Failure in registration - Username already exists
	@Test
	public void RegisterFailureExistingUsername(){
		User u = new User(-1, "m.weintraub", "pa$$word", "Mike Weintraub", "6177847587", "m.weintraub@neu.edu");
		ResponseMessage rmObj = new ResponseMessage(false, "Username/Email-Id already exists");
		assertEquals(aObj.register(u), rmObj);
	}


}
