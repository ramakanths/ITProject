<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="courseDetails.size() >0">
CourseView
	<table class="gridtable">
		<tr>
			<th>CourseName</th>
			<th>WeekDay</th>
			<th>Time</th>
			<th>Credits</th>
		</tr>
		<s:iterator value="courseDetails" status="course">
			<tr>
				<td><s:property value="cName" /></td>
				<td><s:property value="cWeekName" /></td>
				<td><s:property value="cTime" /></td>
				<td><s:property value="cCredits" /></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<s:else>
NO COURSE CREATED
</s:else>
