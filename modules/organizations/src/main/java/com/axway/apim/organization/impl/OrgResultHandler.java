package com.axway.apim.organization.impl;

import java.lang.reflect.Constructor;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.axway.apim.adapter.apis.OrgFilter;
import com.axway.apim.adapter.apis.OrgFilter.Builder;
import com.axway.apim.api.model.Organization;
import com.axway.apim.lib.errorHandling.AppException;
import com.axway.apim.lib.errorHandling.ErrorCode;
import com.axway.apim.organization.lib.OrgExportParams;

public abstract class OrgResultHandler {
	
	protected static Logger LOG = LoggerFactory.getLogger(OrgResultHandler.class);
	
	public enum ResultHandler {
		JSON_EXPORTER(JsonOrgExporter.class),
		CONSOLE_EXPORTER(ConsoleOrgExporter.class),
		ORG_DELETE_HANDLER(DeleteOrgHandler.class);
		
		private final Class<OrgResultHandler> implClass;
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		private ResultHandler(Class clazz) {
			this.implClass = clazz;
		}

		public Class<OrgResultHandler> getClazz() {
			return implClass;
		}
	}
	
	OrgExportParams params;
	
	boolean hasError = false;
	
	public static OrgResultHandler create(ResultHandler exportImpl, OrgExportParams params) throws AppException {
		try {
			Object[] intArgs = new Object[] { params };
			Constructor<OrgResultHandler> constructor =
					exportImpl.getClazz().getConstructor(new Class[]{OrgExportParams.class});
			OrgResultHandler exporter = constructor.newInstance(intArgs);
			return exporter;
		} catch (Exception e) {
			throw new AppException("Error initializing application exporter", ErrorCode.UNXPECTED_ERROR, e);
		}
	}

	public OrgResultHandler(OrgExportParams params) {
		this.params = params;
	}
	
	public abstract void export(List<Organization> apps) throws AppException;
	
	public boolean hasError() {
		return this.hasError;
	}
	
	protected Builder getBaseOrgFilterBuilder() {
		Builder builder = new OrgFilter.Builder()
				.hasApiId(params.getValue("id"))
				.hasName(params.getValue("name"));
		return builder;
	}
	
	public abstract OrgFilter getFilter() throws AppException;
}
