package com.tre.test.server;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.struts2.ServletActionContext;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
public class XmlRead {

	/**
	 * @param args
	 */
	private String sysPath = "";
	private String xmlFilePath = "";

	public XmlRead(){
	
	}
	/**
	 * 类实例化
	 * @param <code>String<code> XML文件相对于工程目录的路径
	 */
	public XmlRead(String filePath) {
		sysPath = ServletActionContext.getServletContext().getRealPath("/");
		xmlFilePath = 	sysPath+filePath;
		
	}

	/**
	 * 
	 * @param filePath XML文件路径
	 * @param virtualFlg true：XML文件路径是相对于工程目录的路径
	 * false：XML文件路径为绝对路径
	 * @throws Exception
	 */
	public void setXmlFilePath(String filePath,boolean virtualFlg) throws Exception{
		if(virtualFlg){
			if(filePath.substring(0, 1).indexOf('\\')>0){
				xmlFilePath = 	sysPath+filePath;
			} else {
				xmlFilePath = 	sysPath+"\\"+filePath;
			}
		} else {
			xmlFilePath = filePath;
		}
		
	}
	
	/**
	 * 获取XML文档
	 * @return <code>InputSource</code>
	 * @throws Exception
	 */
	
	public InputSource getInputSource() throws Exception{
		if("".equals(xmlFilePath)){
			throw new Exception("文件路径没有设置");
		}
		
		InputSource inputSource = null;
		try {
			inputSource = new InputSource(xmlFilePath);		
		}catch (Exception e) {
			throw e;
		}
		return inputSource;	
	}
	
	
	/***
	 * 获取指定路径节点的Text值
	 * @param <pre><code>String<code> xPath 节点路径
	 * 例： "root/firstnode/childenode1"
	 * 如果路径上节点不唯一则取第一个符号条件的节点</pre>
	 * @return <code>String<code> 节点的Text值
	 * @throws Exception
	 */
	public String getNodeVal(String xPath) throws Exception{
		if(null == xPath || "".equals(xPath)){
			throw new Exception("节点路径不能为空");
		}
		String selNodeVal = "";
		try{
		XPath xpath = XPathFactory.newInstance().newXPath();
		
		InputSource inputSource = getInputSource();
		Node node = (Node) xpath.evaluate(xPath, inputSource, XPathConstants.NODE);
		selNodeVal = node.getTextContent();
		
		} catch (Exception e){
			throw e;
		}	
		return selNodeVal;
	}
	/***
	 * 获取指定路径的节点
	 * @param <pre><code>String<code> xPath 节点路径
	 * 例： "root/firstnode/childenode1"</pre>
	 * @return <code>NodeList<code> 节点
	 * @throws Exception
	 */
	public NodeList getNodes(String xPath) throws Exception{
		NodeList selNodes = null;
		if(null == xPath || "".equals(xPath)){
			throw new Exception("节点路径不能为空");
		}
		try{
			XPath xpath = XPathFactory.newInstance().newXPath();
			InputSource inputSource = getInputSource();
			selNodes = (NodeList) xpath.evaluate(xPath, inputSource, XPathConstants.NODESET);
		
		} catch (Exception e){
			throw e;
		}
		return selNodes;
	}

}
