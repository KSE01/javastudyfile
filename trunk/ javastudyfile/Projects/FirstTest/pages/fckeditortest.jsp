<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<%--
 * FCKeditor - The text editor for Internet - http://www.fckeditor.net
 * Copyright (C) 2004-2009 Frederico Caldeira Knabben
 *
 * == BEGIN LICENSE ==
 *
 * Licensed under the terms of any of the following licenses at your
 * choice:
 *
 *  - GNU General Public License Version 2 or later (the "GPL")
 *    http://www.gnu.org/licenses/gpl.html
 *
 *  - GNU Lesser General Public License Version 2.1 or later (the "LGPL")
 *    http://www.gnu.org/licenses/lgpl.html
 *
 *  - Mozilla Public License Version 1.1 or later (the "MPL")
 *    http://www.mozilla.org/MPL/MPL-1.1.html
 *
 * == END LICENSE ==
 * @version: $Id: sample03.jsp 3841 2009-07-08 20:29:57Z mosipov $
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>FCKeditor - JSP Sample</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="robots" content="noindex, nofollow" />
		<link href="../sample.css" rel="stylesheet" type="text/css" />
		<link rel="shortcut icon" href="../fckeditor.gif"
				type="image/x-icon" />
		<script type="text/javascript">
			function FCKeditor_OnComplete(editorInstance) {
				//var oCombo = document.getElementById( 'cmbLanguages' );
				//for (code in editorInstance.Language.AvailableLanguages) {
				//	AddComboOption( oCombo,	editorInstance.Language.AvailableLanguages[code] + '(' + code + ')', code);
				//}

				//oCombo.value = editorInstance.Language.ActiveLanguage.Code;
				//editorInstance.EditorDocument.attachEvent("onkeydown", editor_keydown); 
				editorInstance.Events.AttachEvent('OnSelectionChange',editor_keydown );
				//editorInstance.Events.AttachEvent('OnAfterSetHTML',afterSetHTML);
			}
			function afterSetHTML(editorInstance){
				alert( editorInstance.EditorDocument.body.lastChild.outerHTML ) ;
			}
			function editor_keydown(editorInstance){
				var editorDoc = editorInstance.EditorDocument;
				var lastChild = editorDoc.body.lastChild;
				var oDiv = editorDoc.getElementsByTagName("DIV");

				if(lastChild.tagName == "P" && oDiv.length > 0){					
					editorDoc.body.removeChild(lastChild);
				}
			}
			/*function AddComboOption(combo, optionText, optionValue) {
				var oOption = document.createElement("OPTION");
				combo.options.add(oOption);

				oOption.innerHTML = optionText;
				oOption.value = optionValue;
	
				return oOption;
			}

			function ChangeLanguage(languageCode) {
				if (languageCode != "-1")
					window.location.href = window.location.pathname + "?code=" + languageCode;
			}*/
			function showVal(){
				var   oEditor   =   FCKeditorAPI.GetInstance('EditorDefault') ;
				// Get the editor contents in XHTML.
				alert( oEditor.GetXHTML(true) ) ;    // "true" means you want it formatted.
				//document.all( " tip.c_content " ).value = oEditor.GetXHTML( true );
				/*var oSelect = document.getElementById("selW") 
				var imgs = oEditor.EditorDocument.body.all.tags("img");
			    for(var i=0; i < imgs.length; i++){
			        var oOption = document.createElement("option");
			        oOption.appendChild(document.createTextNode(imgs[i].src));
			        oSelect.appendChild(oOption);
			    }*/
			    
			}
			function setSign(){
				var  editorInstance = FCKeditorAPI.GetInstance('EditorDefault') ;
				var editorDoc = editorInstance.EditorDocument;
				var oDiv = null;
				var oDivs = editorDoc.getElementsByTagName("DIV");
				if(oDivs.length>0){		
					for(var i=1;i<oDivs.length;i++){
						editorDoc.body.removeChild(oDivs[i]);
						i--;
					}
					oDiv = oDivs[0];
					oDiv.innerHTML = "wangwentaosssssss";
				} else {					
					oDiv = editorDoc.createElement("DIV");
					oDiv.innerHTML = "wangwentao";
					editorDoc.body.appendChild(oDiv);
				}
								
			}
			function getSign(){
				var  editorInstance = FCKeditorAPI.GetInstance('EditorDefault') ;
				var editorDoc = editorInstance.EditorDocument;
				var oDivs = editorDoc.getElementsByTagName("DIV");
				var signText = "";
				for(var i=0;i<oDivs.length;i++){
					var tempSignText = oDivs[i].innerHTML;
					signText = signText+tempSignText+"<br>";
				}
				alert(signText);
			}
		</script>
		<style tyle="text/stylesheet">
			.mailAndSign{
				width:900px;
				position:relative;
				border:1px solid red;
				height:400px;
				OVERFLOW:auto;
			}
		</style>
	</head>
	<body>
		<select id="selW" style="width:100px;"></select><br/>
		<input type="text" style="width:200px;" id="ww"/><br/>
		<input type="button" style="width:200px;" onclick="setSign()" value="setSign" id="wsw"/><br/><br/>
		<input type="button" style="width:200px;" onclick="getSign()" value="getSign" id="wssw"/><br/>
		<h1>FCKeditor - JSP - Sample 3</h1>
		This sample shows the editor in all it's available languages.<br />
		The Language dropdown is populated with JavaScript API.
		<hr />
		<table cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td>
					Select a language:&nbsp;
				</td>
				<td>
					<select id="cmbLanguages" onchange="ChangeLanguage(this.value);" >
						<option value="-1">none selected</option>
					</select>
				</td>
			</tr>
		</table>
		<br />
		<form method="post" target="_blank">
				<div id="xToolbar"></div>		
					<FCK:editor instanceName="EditorDefault" width="100%" height="500px;" toolbarSet="Custom">	
					<jsp:attribute name="value">&nbsp;</jsp:attribute>
					</FCK:editor>
			<br />
			<input type="submit" value="Submit" />
			<input type="button" value="showText" onclick="showVal()"/>
		</form>
	</body>
</html>