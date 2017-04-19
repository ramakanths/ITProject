package com.rk.action.course;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.opensymphony.xwork2.ActionProxy;

public class CourseActionTest extends StrutsConventionSpringJUnit4TestCase {

	@Test
	public void testCourseAction() throws Exception{
		ActionProxy proxy = getActionProxy("/User/CourseView");
		Map<String, Object> sessionMap = new HashMap<String, Object>();
		proxy.getInvocation().getInvocationContext().setSession(sessionMap);
		String 	result = proxy.execute();
		assertEquals("success", result);
		// String result = executeAction("/login");
		System.out.println("************************"+response.getContentAsString());
		
	}
}

/*
public class CourseActionTest extends StrutsSpringJUnit4TestCase<CourseAction> {

	@Test
	public void testCourseAction() throws Exception{
		ActionProxy proxy = getActionProxy("/User/CourseView");
		Map<String, Object> sessionMap = new HashMap<String, Object>();
		proxy.getInvocation().getInvocationContext().setSession(sessionMap);
		String 	result = proxy.execute();
			assertEquals("success", result);
		// String result = executeAction("/login");
			System.out.println(response.getContentAsString());
		
	}

	@Override
	public String getConfigPath() {
		return "classpath*:spring-module.xml";
	}

}*/
