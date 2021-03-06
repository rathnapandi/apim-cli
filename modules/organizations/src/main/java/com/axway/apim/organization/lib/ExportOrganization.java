package com.axway.apim.organization.lib;

import com.axway.apim.api.model.Image;
import com.axway.apim.api.model.Organization;

public class ExportOrganization {
	
	Organization org;

	public ExportOrganization(Organization org) {
		this.org = org;
	}
	
	public String getName() {
		return this.org.getName();
	}
	
	public String getDescription() {
		return this.org.getDescription();
	}
	
	public boolean isRestricted() {
		return this.org.isRestricted();
	}
	
	public boolean isEnabled() {
		return this.org.isEnabled();
	}
	
	public boolean isDevelopment() {
		return this.org.isDevelopment();
	}
	
	public Long getCreatedOn() {
		return this.org.getCreatedOn();
	}	
	
	public String getEmail() {
		return this.org.getEmail();
	}
	
	public Image getImage() {
		return this.org.getImage();
	}
}
