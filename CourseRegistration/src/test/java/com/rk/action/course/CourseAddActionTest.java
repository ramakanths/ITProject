package com.rk.action.course;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.opensymphony.xwork2.ActionProxy;

@RunWith(MockitoJUnitRunner.class)
public class CourseAddActionTest extends StrutsConventionSpringJUnit4TestCase {
	
	@Test
	public void testCourseAddwithIncorrectCredits() throws Exception {
		request.setParameter("course.cName", "xyz");
		request.setParameter("course.cWeekName", "friday");
		request.setParameter("course.cTime", "11:00");
		request.setParameter("course.cCredits", "10");

		ActionProxy proxy = getActionProxy("/User/CourseAdd");
		CourseAddAction courseAddAction = (CourseAddAction) proxy.getAction();
		//proxy.setExecuteResult(false); 
		proxy.execute();
		
		Assert.assertTrue("",courseAddAction.getActionErrors().size() == 1);
	
	}
	
	@Test
	public void testCourseAddwithIncorrectDetails() throws Exception {
		request.setParameter("course.cName", "");
		request.setParameter("course.cTime", "");
		request.setParameter("course.cCredits", "10");

		ActionProxy proxy = getActionProxy("/User/CourseAdd");
		CourseAddAction courseAddAction = (CourseAddAction) proxy.getAction();
		proxy.execute();
		
		Assert.assertTrue("",courseAddAction.getActionErrors().size() == 4);
	
	}
	
	@Test
	public void testCourseAddwithcorrectDetails() throws Exception {
		request.setParameter("course.cName", "xyz");
		request.setParameter("course.cWeekName", "friday");
		request.setParameter("course.cTime", "11:00");
		request.setParameter("course.cCredits", "3");

		ActionProxy proxy = getActionProxy("/User/CourseAdd");
		CourseAddAction courseAddAction = (CourseAddAction) proxy.getAction();
		//proxy.setExecuteResult(false); 
		String result =proxy.execute();
		
		Assert.assertEquals("success", result);
		Assert.assertTrue("",courseAddAction.getActionErrors().size() ==0);
	
	
	}

	
}

/*public class CourseAddActionTest extends StrutsSpringTestCase {

	public void testCourseAddCorrect() throws Exception {
		request.setParameter("course.cName", "xyz");
		request.setParameter("course.cWeekName", "friday");
		request.setParameter("course.cTime", "11:00");
		request.setParameter("course.cCredits", "10");

		ActionProxy proxy = getActionProxy("/User/CourseAdd");
		CourseAddAction courseAddAction = (CourseAddAction) proxy.getAction();
		proxy.setExecuteResult(false); 
		proxy.execute();
		assertTrue("One error present", courseAddAction.getFieldErrors().size() == 1);
		assertTrue("one error", courseAddAction.getFieldErrors().containsKey("course.cCredits"));

	}

	@Override
	public String[] getContextLocations() {
		return new String[] { "classpath*:spring-module.xml" };
	}
}*/
