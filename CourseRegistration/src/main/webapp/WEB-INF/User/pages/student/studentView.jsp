<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="studentList.size() >0">
Student View
	<table class="gridtable">
		<tr>
			<th>StudentName</th>
			<th>Email</th>
			<th></th>
		</tr>
		<s:iterator value="studentList" status="student">
			<s:url action="StudentEdit.action" var="editUrl">
				<s:param name="sId">
					<s:property value="sId" />
				</s:param>
			</s:url>
			<tr>
				<td><s:property value="sName" /></td>
				<td><s:property value="sEmail" /></td>
				<td><s:a href="%{editUrl}">Edit</s:a></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<s:else>
NO STUDENTS ADDED
</s:else>
