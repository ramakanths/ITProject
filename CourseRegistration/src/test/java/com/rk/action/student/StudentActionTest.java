package com.rk.action.student;

import org.junit.Assert;
import org.junit.Test;

import com.opensymphony.xwork2.ActionProxy;
import com.rk.action.course.StrutsConventionSpringJUnit4TestCase;

public class StudentActionTest extends StrutsConventionSpringJUnit4TestCase {
	
	@Test
	public void testValidationwithIncorrect() throws Exception {
		request.setParameter("student.sName", "");
		request.setParameter("student.sEmail", "");

		ActionProxy proxy = getActionProxy("/User/StudentAdd");
		StudentAction studentAction = (StudentAction) proxy.getAction();
		proxy.execute();

		Assert.assertTrue("", studentAction.getActionErrors().size() == 2);
	}
	
	@Test
	public void testValidationwithCorrect() throws Exception {
		request.setParameter("student.sName", "xyz");
		request.setParameter("student.sEmail", "s@xyz.com");

		ActionProxy proxy = getActionProxy("/User/StudentAdd");
		StudentAction studentAction = (StudentAction) proxy.getAction();
		String result = proxy.execute();

		Assert.assertTrue("", studentAction.getActionErrors().size() == 0);
		Assert.assertEquals("success", result);
	}
	
}
