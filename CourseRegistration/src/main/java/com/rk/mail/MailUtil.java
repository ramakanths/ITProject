package com.rk.mail;

import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.rk.dto.Course;
import com.rk.dto.Student;

public class MailUtil {

	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;

	/*
	 * public static void main(String args[]) throws AddressException,
	 * MessagingException { generateAndSendEmail(); System.out.println(
	 * "\n\n ===> Your Java Program has just sent an Email successfully. Check your email.."
	 * ); }
	 */

	public static void generateAndSendEmail(Student studentId, List<Course> studentCourseDetails)
			throws AddressException, MessagingException {
		String stundentName = studentId.getsName();
		String studentEmail = studentId.getsEmail();

		StringBuilder coursesName = new StringBuilder("Course Name :");
		if (studentCourseDetails != null) {

			for (Course course : studentCourseDetails) {
				coursesName.append(course.getcName());
			}
		}

		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		System.out.println("Mail Server Properties have been setup successfully..");

		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(studentEmail));
		generateMailMessage.setSubject("Greetings from CourseRegistration");
		String emailBody = "Welcome to Course Registration : " + stundentName + " <br><br>" + coursesName.toString()
				+ "" + "<br><br> Regards, <br>Admin";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");

		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");

		transport.connect("smtp.gmail.com", "courseregistertest@gmail.com", "abc@test");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
}
