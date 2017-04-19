<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="studentCourseDetails.size() >0">
	<b>SELECT THE COURSES TO BE REMOVE</b>
	<s:form action="StudentCoursesRemove" method="post">
		<s:iterator value="studentCourseDetails" status="stat">
			<tr>
				<td align="center"><s:checkbox
						name="selectedRemCourseList[%{#stat.index}]" theme="simple"
						fieldValue="%{cId}" /></td>
				<td align="center"><s:property value="cName" /></td>
			</tr>
		</s:iterator>
		<s:hidden name="sId" value="%{sId}"></s:hidden>
		<s:submit></s:submit>
	</s:form>
</s:if>
<s:else>
NO COURSES REGISTERED
<br>
	<s:url action="StudentView.action" var="viewUrl">
	</s:url>
	<s:a href="%{viewUrl}">Main page</s:a>
</s:else>