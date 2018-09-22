package niitexample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import niitexample.dao.StudentDAO;
import niitexample.entity.Student;


public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = "The details of the Student";
		String docType =
		         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		
		ArrayList<Student> student =null;
		PrintWriter out = response.getWriter();
		try {
		student=StudentDAO.getStudent();
		
		out.println(
				docType +
		         "<html>\n" +
		         "<head><title>" + title + "</title></head>\n" +
		         "<body bgcolor = \"#fff\">\n" +
		         "<h1 align = \"center\">" + title + "</h1>\n" +
		         "<table width = \"100%\" border = \"1\" align = \"center\">\n" +
		         "<tr bgcolor = \"#949494\">\n" +
		            "<th>Student Name</th>"	+
		            "<th>Password</th> \n"+
		           " <th>Email </th> \n" +
		            "<th>Country </th> \n" +
		           " <th>City </th> \n" +
		           " <th>Address </th> \n" +
		           " <th>Gender </th> \n" +
		         "</tr>\n"
		      );
				
				

				
		// Read multiple valued data


       
//             <table width = \"100%\" border = \"1\" align = \"center\">\n" +
            		 
     for(Student s:student) {
    	 	out.println("<tr bgcolor = \"#f0f0f0\">\n");
 		      out.println( "<th>"+s.getName()+"</th>"	+
 		            "<th>"+s.getPassword()+"</th> \n"+
 		           " <th>"+s.getEmail()+" </th> \n" +
 		            "<th>"+s.getCountry()+"</th> \n" +
 		           " <th>"+s.getCity()+" </th> \n" +
 		           " <th>"+s.getAddress()+" </th> \n" +
 		           " <th>"+s.getGender()+"</th> \n" +
 		         "</tr>\n"
 		           );
          }
         
     
						
		}catch(Throwable ex)
		{
			System.out.println(ex);
		}
		
		
//		RequestDispatcher rd = request.getRequestDispatcher("Admin.html");
//		rd.include(request, response);
		out.println("</body>");
		
		out.println("</html>");
		out.println("</head>");
		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
