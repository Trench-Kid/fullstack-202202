package com.jdc.assignment.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdc.assignment.domain.OpenClass;
import com.jdc.assignment.model.CourseModel;
import com.jdc.assignment.model.OpenClassModel;

@WebServlet(urlPatterns = { "/classes", "/class-edit" })
public class OpenClassServlet extends AbstractBeanFactoryServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var courseId = req.getParameter("courseId");
		var courseModel = getBean("courseModel", CourseModel.class);
		var course = courseModel.findById(Integer.parseInt(courseId));
		
		req.setAttribute("course", course);
		
		var classModel = getBean("openClassModel", OpenClassModel.class);
		var classes = classModel.findByCourse(Integer.parseInt(courseId));
		req.setAttribute("classes", classes);

		var page = switch (req.getServletPath()) {
		case "/classes" -> {
			
			yield "classes";
		}
		
		default -> "class-edit";
		};
		getServletContext().getRequestDispatcher("/%s.jsp".formatted(page)).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var teacher = req.getParameter("teacher");
		var startDate = req.getParameter("startDate");
		var courseId = req.getParameter("courseId");
		
		var oc = new OpenClass();
		
		var course = getBean("courseModel", CourseModel.class).findById(Integer.parseInt(courseId));
		oc.setCourse(course);
		oc.setStartDate(LocalDate.parse(startDate));
		oc.setTeacher(teacher);
				
		var classModel = getBean("openClassModel", OpenClassModel.class);
		classModel.create(oc);
		
		resp.sendRedirect("/classes?courseId=%s".formatted(courseId));
		
	}

}
