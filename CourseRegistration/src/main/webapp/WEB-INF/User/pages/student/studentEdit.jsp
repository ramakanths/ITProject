<%@ taglib prefix="s" uri="/struts-tags"%>
<h3>
	<s:property value="student.sName" />
</h3>

	<table class="gridtable">
		<tr>
			<th>Registered Courses</th>
		</tr>
		<s:iterator value="student.courses">
			<tr>
				<td align="center"><s:property value="cName" /></td>
			</tr>
		</s:iterator>
	</table>


<%-- <s:if test="studentCourseDetails.size() >0">
	<table class="gridtable">
		<tr>
			<th>Registered Courses</th>
		</tr>
		<s:iterator value="studentCourseDetails">
			<tr>
				<td align="center"><s:property value="cName" /></td>
			</tr>
		</s:iterator>
	</table>
</s:if> --%>
<br>
<s:if test="totalCredits!=0">
	<h3>
		Total Credits :
		<s:property value="totalCredits" />
	</h3>
</s:if>
<br>

<s:url var="remUrl" action="StudentCoursesRemoveView.action">
	<s:param name="sId">
		<s:property value="sId" />
	</s:param>
</s:url>
<s:a href="%{remUrl}">Remove Courses</s:a>
<s:form method="post" action="StudentCourseRegisterView">
	<s:hidden name="sId" value="%{sId}"></s:hidden>
	<s:submit value="Register Courses"></s:submit>
</s:form>
<s:url action="StudentView.action" var="viewUrl">
</s:url>
<s:a href="%{viewUrl}">Main page</s:a>
