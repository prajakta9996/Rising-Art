package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

/**
 * Servlet implementation class SendEmail
 */
@WebServlet("/SendEmail")
public class SendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		/*
		 * Connection con; Statement st; ResultSet rs;
		 */
		try
		{
			
			/*
			 * Class.forName("com.mysql.jdbc.Driver"); con = DriverManager.
			 * getConnection("jdbc:mysql://localhost:3307/online_art_gallery?user=root & password="
			 * ); st = con.createStatement(); rs =
			 * st.executeQuery("SELECT * from where customer_id='"+id+"'");
			 * while(rs.next()){ String email= }
			 */
			
			Email from = new Email("admin@risingart.com");
			String subject = "Welcome Message";
			Email to = new Email("pujaraavadhu@gmail.com");
			Content content = new Content("text/plain", "Welcome to eShop");
			Mail mail = new Mail(from, subject, to, content);
			System.out.println("call");
			SendGrid sg = new SendGrid("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");
			Request request1 = new Request() {
			};
			try {
				request1.setMethod(Method.POST);
				request1.setEndpoint("mail/send");
				request1.setBody(mail.build());
				Response response1 = sg.api(request1);
				System.out.println(response1.getStatusCode());
				System.out.println(response1.getBody());
				System.out.println(response1.getHeaders());
			} catch (IOException ex) {
				throw ex;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
