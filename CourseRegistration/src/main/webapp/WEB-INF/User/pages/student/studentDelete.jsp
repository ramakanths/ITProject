<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="studentList.size() >0">
	<b>SELECT THE COURSES TO BE REMOVE</b>
	<s:form action="StudentDelete" method="post">
		<s:iterator value="studentList" status="stat">
			<tr>
				<td align="center"><s:checkbox
						name="selectedStudentList[%{#stat.index}]" theme="simple"
						fieldValue="%{sId}" /></td>
				<td align="center"><s:property value="sName" /></td>
			</tr>
		</s:iterator>
		<s:submit></s:submit>
	</s:form>
</s:if>
<s:else>
NO STUDENTS AVAILABLLE
<br>
	<s:url action="StudentAddView.action" var="viewUrl">
	</s:url>
	<s:a href="%{viewUrl}">Add STUDENTS</s:a>
</s:else>