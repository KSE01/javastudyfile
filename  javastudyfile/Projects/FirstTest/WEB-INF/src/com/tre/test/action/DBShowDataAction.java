package com.tre.test.action;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.tre.test.dao.ShowCodeTypeDAO;
import com.tre.test.dto.ShowCodeTypeDTO;

public class DBShowDataAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;
	private ArrayList<ShowCodeTypeDTO> codeTypeList = null;
	

	public ArrayList<ShowCodeTypeDTO> getCodeTypeList() {
		return codeTypeList;
	}


	public void setCodeTypeList(ArrayList<ShowCodeTypeDTO> codeTypeList) {
		this.codeTypeList = codeTypeList;
	}


	@Override
	public String execute() throws Exception {
		codeTypeList = ShowCodeTypeDAO.getCodeTypeInfo();		
		return "success";
	}
}
