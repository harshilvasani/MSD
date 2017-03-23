package queryengine;

import java.util.List;

import queryengine.miscellaneous.ResponseMessage;

public interface IQueryEngine {
	
	void validateInputData(List<?> inputData);
	String generateSearchQuery(List<?> queryParams);
	String generateInsertQuery(List<?> queryParams);
	String generateUpdateQuery(List<?> queryParams);
	String generateDeleteQuery(List<?> queryParams);
	ResponseMessage convertResponseToUIFormat(List<?> response);
	ResponseMessage respondToApp();
}
