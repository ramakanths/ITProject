<%@ taglib prefix="s" uri="/struts-tags"%>
STUDENT&nbsp&nbsp&nbsp
<s:url var="view" action="StudentView.action" />
<a href="<s:property value="%{view}" />">View</a>
&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="<s:url action="StudentAddView.action"/>">Add</a>
&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="<s:url action="StudentDeleteView.action"/>">Delete</a>

