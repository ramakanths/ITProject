<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
<sj:head />
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
<b>Add New Course</b>
<br>
<s:form action="CourseAdd" method="post">

	<s:textfield name="course.cName" label="CourseName" size="20" />

	<s:select label="WeekDay of Class" headerKey="-1"
		headerValue="Select WeekDay"
		list="#{'Sunday':'Sunday', 'Monday':'Monday', 'Tuesday':'Tuesday', 'Wednesday':'Wednesday', 'Thursday':'Thursday', 'Friday':'Friday', 'Saturday':'Saturday'}"
		name="course.cWeekName" value="Sunday" />

	<sj:datepicker name="course.cTime" label="Time(HH:mm)"
		timepickerOnly="true" timepicker="true" />

	<s:textfield name="course.cCredits" label="Credits" maxlength="1"
		size="2"
		onkeypress="return event.charCode === 0 || /\d/.test(String.fromCharCode(event.charCode));" />

	<s:submit value="submit" />

</s:form>
