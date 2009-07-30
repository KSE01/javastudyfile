package com.tre.test.server;
import javax.servlet.http.HttpServletRequest;

import net.fckeditor.requestcycle.UserPathBuilder;
public class FilePathActionImpl implements UserPathBuilder{
	public String getUserFilesPath(final HttpServletRequest request){
		String filePath = "/wang";
		return filePath;
	}
	public String getUserFilesWebPath(final HttpServletRequest request){
		String filePath = "http://localhost/WebImg/";
		return filePath;
	}
}
