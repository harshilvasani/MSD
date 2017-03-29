package queryengine.app;

import static org.junit.Assert.*;
import org.junit.Test;
import queryengine.app.App;
import queryengine.miscellaneous.ResponseMessage;
import resources.personrecord.User;

public class UpdateProfileTest {

	private App app = App.getAppInstance();	

	// Successful profile update - password, name, number and email
	@Test
	public void UpdateProfileAllFieldsSuccess(){
		User u = app.getUserByUsername("mike");
		u = new User(u.getId(), "mike", "admin", "Mike Weintraub", "6177847587", "m.weintraub@northeastern.edu");
		ResponseMessage rmObj = new ResponseMessage(true, "Success");
		assertEquals(app.updateProfile(u), rmObj);
	}

	// Successful profile update - password
	@Test
	public void UpdateProfilePasswordSuccess(){
		User u = app.getUserByUsername("mike");
		u = new User(u.getId(), "mike", "adm!n#250", "Mike Weintraub", "6179857589", "m.weintraub@northeastern.edu");
		ResponseMessage rmObj = new ResponseMessage(true, "Success");
		assertEquals(app.updateProfile(u), rmObj);
	}

	// Successful profile update - name
	@Test
	public void UpdateProfileNameSuccess(){
		User u = app.getUserByUsername("mike");
		u = new User(u.getId(), "mike", "admin", "Michael Weintraub", "6177847587", "m.weintraub@northeastern.edu");
		ResponseMessage rmObj = new ResponseMessage(true, "Success");
		assertEquals(app.updateProfile(u), rmObj);
	}
}
