package com.tre.test.server;

import javax.servlet.http.HttpServletRequest;

import net.fckeditor.requestcycle.UserAction;

public class FileUserActionImpl implements UserAction{
	/* (non-Javadoc)
	 * @see net.fckeditor.requestcycle.UserAction#isEnabledForFileBrowsing(javax.servlet.http.HttpServletRequest)
	 */
	public boolean isEnabledForFileBrowsing(final HttpServletRequest request) {
		return true;
	}

	/* (non-Javadoc)
	 * @see net.fckeditor.requestcycle.UserAction#isEnabledForFileUpload(javax.servlet.http.HttpServletRequest)
	 */
	public boolean isEnabledForFileUpload(final HttpServletRequest request) {
		return true;
	}
}
