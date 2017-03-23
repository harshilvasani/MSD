package queryengine.app;
import java.util.ArrayList;
import java.util.List;

import queryengine.interfaces.ISearch;
import queryengine.miscellaneous.ResponseMessage;
import resources.personRecord.IPerson;
import resources.personRecord.User;

public class App implements IApp{


	public List<IPerson> search(List<ISearch> searchCriteria) {

		List<IPerson> searchedAuthor = new ArrayList<IPerson>();
		//List<IPerson> searchedEditor = new ArrayList<IPerson>();

		// Article Processing		
		searchedAuthor.addAll(SearchUtils.processArticles(searchCriteria));

		// Incollection Processing	
		searchedAuthor.addAll(SearchUtils.processIncollection(searchCriteria));	

		// Inproceeding Processing
		searchedAuthor.addAll(SearchUtils.processInproceeding(searchCriteria));

		// PhdThesis Processing
		searchedAuthor.addAll(SearchUtils.processPhdThesis(searchCriteria));

		// Then Return authors -- From all refined results
		return searchedAuthor;
	}

	@Override
	public ResponseMessage login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseMessage register(User regInformation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseMessage updateProfile(User regInformation) {
		// TODO Auto-generated method stub
		return null;
	}
}
