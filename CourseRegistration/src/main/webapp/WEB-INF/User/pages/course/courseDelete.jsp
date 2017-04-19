<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="courseDetails.size() >0">
	<b>SELECT THE COURSES TO BE DELETED</b>
	<s:form action="CourseDelete" method="post">
		<s:iterator value="courseDetails" status="stat">
			<tr>
				<td align="center"><s:checkbox theme="simple"
						name="selectedCourseList[%{#stat.index}]" fieldValue="%{cId}" />
				</td>
				<td align="center"><s:property value="cName" /></td>
			</tr>
		</s:iterator>
		<s:submit></s:submit>
	</s:form>
</s:if>
<s:else>
NO COURSES CREATED
<br>
	<s:url action="CourseAddView.action" var="viewUrl">
	</s:url>
	<s:a href="%{viewUrl}">CourseADD</s:a>
</s:else>