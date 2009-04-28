package com.tre.trial;

import java.util.*;
import com.googlecode.jsonplugin.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class JsonTest extends ActionSupport {

	private String PersonCode;
	private String name;
	private List<String> personList;
	
	@JSON(serialize=false)
	public String getPersonCode() {
		return PersonCode;
	}
	public void setPersonCode(String personCode) {
		PersonCode = personCode;
	}
	@JSON(name="newName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPersonList() {
		return personList;
	}
	public void setPersonList(List<String> personList) {
		this.personList = personList;
	}
	@Override
	public String execute() throws Exception {
	
		this.name="qin pengyun";
		this.PersonCode = "2200784";
		List<String> cityList = new ArrayList<String>();
		cityList.add("China");
		cityList.add("Liao Ning");
		cityList.add("DA LIAN");
		this.personList = cityList;
		return "success";
	}

}
