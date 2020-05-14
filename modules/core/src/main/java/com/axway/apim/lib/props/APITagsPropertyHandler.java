package com.axway.apim.lib.props;

import com.axway.apim.api.API;
import com.axway.apim.lib.errorHandling.AppException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class APITagsPropertyHandler implements PropertyHandler {
	
	ObjectMapper mapper = new ObjectMapper();
	
	public JsonNode handleProperty(API desired, API actual, JsonNode response) throws AppException {
		//((ObjectNode) response).put("tags", desired.getTags());
		((ObjectNode) response).put("tags", mapper.valueToTree(desired.getTags()));
		return response;
	}
}
