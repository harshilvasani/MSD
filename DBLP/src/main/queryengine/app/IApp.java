package queryengine.app;


import java.util.List;

import queryengine.interfaces.ICoAuthorSearch;
import queryengine.interfaces.IFilter;
import queryengine.interfaces.ISearch;
import queryengine.miscellaneous.ResponseMessage;
import resources.person.IPerson;
import resources.person.User;

public interface IApp {
	
	ResponseMessage login(String username, String password);
	ResponseMessage register(User regInformation);
	ResponseMessage updateProfile(User regInformation);
	List<IPerson> search(List<ISearch> searchCriteria);
	List<IPerson> searchCoAuthors(ICoAuthorSearch searchCriteria);
	List<IPerson> filter(List<IFilter> searchCriteria, List<IPerson> searchResult);
		
	/*List<IPerson> filter(List<?> criteria, List<?> filterData);
	List<?> displayStatistic();
	List<?> getSimilarPerson();
	List<?> recieveResponseFromQE();
	void sendInputDataToQE(List<?> inputData);*/
}
