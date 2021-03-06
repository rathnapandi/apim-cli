package com.axway.apim.api.model;

import org.apache.commons.lang3.StringUtils;

public class Policy {
	
	String name;
	
	String id;

	public Policy() {
		
	}
	
	public Policy(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if (this == obj) return true;
		if(obj instanceof Policy == false) return false;
		Policy other = (Policy)obj;
		return (
				StringUtils.equals(other.getId(), this.getId()) && 
				StringUtils.equals(other.getName(), this.getName())
				);
	}

	@Override
	public int hashCode() {
		return this.getId().hashCode() + this.getName().hashCode();
	}

	@Override
	public String toString() {
		return "Policy [name=" + name + "]";
	}
}
