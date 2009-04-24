package com.tre.test.action;

import java.util.ArrayList;
import java.util.Hashtable;

import com.opensymphony.xwork2.ActionSupport;

public class ShowDataAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName="";
	private String passWord="";
	private ArrayList<String> arrayList = new ArrayList<String>();
	private ArrayList<String[]> userList = new ArrayList<String[]>();
	public ArrayList<String[]> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<String[]> userList) {
		this.userList = userList;
	}

	public Hashtable<String, String> getUserMap() {
		return userMap;
	}

	public void setUserMap(Hashtable<String, String> userMap) {
		this.userMap = userMap;
	}

	private Hashtable<String,String> userMap = new Hashtable <String,String>();
	
	public ArrayList<String> getArrayList() {
		return arrayList;
	}

	public void setArrayList(ArrayList<String> arrayList) {
		this.arrayList = arrayList;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String execute() throws Exception {
		for(int i=0;i<10;i++){
			arrayList.add("testVal"+i);
		}
		for(int j=0;j<10;j++){
			String singleUser[] = new String[]{"username"+j, "password"+j};
			userList.add(singleUser);
		}
		return "success";
	}

}
