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
<s:if test="!courseDetails.size>0">
No Courses Available ,please create courses
</s:if>
<s:else>
	<b>SELECT THE COURSES</b>
	<s:form action="StudentCourseRegisterAdd" method="post">
		<s:iterator value="courseDetails" status="stat">
			<tr>
				<td align="center"><s:checkbox
						name="selectedCourseList[%{#stat.index}]" theme="simple"
						fieldValue="%{cId}" /></td>
				<td align="center"><s:property value="cName" /></td>
			</tr>
		</s:iterator>
		<s:hidden name="sId" value="%{sId}"></s:hidden>
		<s:submit value="Register"></s:submit>
	</s:form>
</s:else>