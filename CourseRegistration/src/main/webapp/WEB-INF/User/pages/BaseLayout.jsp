<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" ignore="true" /></title>
<style>
body {
	padding: 40px 0;
	font-family: helvetica, arial, sans-serif;
}

<style type ="text/css">
table.gridtable {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}

table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}

table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}

.tabe {
	border-collapse: collapse;
}
</style>

</head>
<body>

	<table style="border: 1px solid yellowgreen; width: 80%" align="center">
		<tr>
			<td style="border: 1px solid yellowgreen;" width="15%" align="center"><tiles:insertAttribute
					name="menu" /></td>
			<td style="border: 1px solid yellowgreen;" " bgcolor="#dedede"
				align="center"><tiles:insertAttribute name="header" /></td>
		</tr>
		<tr>
			<td colspan="2" height="350" align="center"><tiles:insertAttribute
					name="body" /></td>
		</tr>
	</table>

</body>
</html>