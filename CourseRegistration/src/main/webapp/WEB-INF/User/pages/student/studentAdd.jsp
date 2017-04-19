<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<style type="text/css">
.errorDiv {
	background-color: gray;
	border: 1px solid black;
	width: 400px;
	margin-bottom: 8px;
}
</style>
</head>
<s:if test="hasActionErrors()">
	<div class="errorDiv">
		<s:actionerror />
	</div>
</s:if>
<b>Add Student Details</b>
<s:form action="StudentAdd" method="post">
	<s:textfield name="student.sName" label="Name"></s:textfield>
	<s:textfield name="student.sEmail" label="Email"></s:textfield>
	<s:submit value="submit"></s:submit>
</s:form>
