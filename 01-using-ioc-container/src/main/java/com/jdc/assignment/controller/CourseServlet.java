package com.jdc.assignment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdc.assignment.domain.Course;
import com.jdc.assignment.model.CourseModel;

@WebServlet(urlPatterns = {"/","/courses","/course-edit"})
public class CourseServlet extends AbstractBeanFactoryServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var model = getBean("courseModel", CourseModel.class);
		getServletContext().setAttribute("courses", model.getAll());
		
		var page = switch (req.getServletPath()) {
		case "/course-edit" -> "/course-edit.jsp";
		default -> {
			
			yield "/index.jsp";
		}
	};
	req.getServletContext().getRequestDispatcher(page).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var name = req.getParameter("name");
		var fees = req.getParameter("fees");
		var duration = req.getParameter("duration");
		var description = req.getParameter("name");
		
		var course = new Course();
		course.setName(name);
		course.setFees(Integer.parseInt(fees));
		course.setDuration(Integer.parseInt(duration));
		course.setDescription(description);
		
		getBean("courseModel",CourseModel.class).save(course);
		
		resp.sendRedirect("/");
		
	}
	
}
