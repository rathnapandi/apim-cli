package com.axway.apim.lib.props;

import com.axway.apim.api.API;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class APICaCertsPropertyHandler implements PropertyHandler {
	
	public JsonNode handleProperty(API desired, API actual, JsonNode response) {
		String[] propertiesToExclude = {"certFile", "useForInbound", "useForOutbound"};
		FilterProvider filters = new SimpleFilterProvider()  
			      .addFilter("IgnoreImportFields",   
			          SimpleBeanPropertyFilter.serializeAllExcept(propertiesToExclude) );
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setFilterProvider(filters);
		if(desired.getCaCerts().size()!=0) {
			((ObjectNode)response).replace("caCerts", objectMapper.valueToTree(desired.getCaCerts()));
		}
		return response;
	}
}
