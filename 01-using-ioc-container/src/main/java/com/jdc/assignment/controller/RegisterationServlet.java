package com.jdc.assignment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdc.assignment.domain.Registeration;
import com.jdc.assignment.model.CourseModel;
import com.jdc.assignment.model.OpenClassModel;
import com.jdc.assignment.model.RegisterationModel;

@WebServlet(value = {"/registeration","/registeration-create"})
public class RegisterationServlet extends AbstractBeanFactoryServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
		var courseId = req.getParameter("courseId");
		var openClassId = req.getParameter("openClassId");
		
		var courseModel = getBean("courseModel", CourseModel.class);
		var course = courseModel.findById(Integer.parseInt(courseId));
		
		req.setAttribute("course", course);

		var ocModel = getBean("openClassModel", OpenClassModel.class);
		var oc = ocModel.findByCourse(Integer.parseInt(courseId));
		
		req.setAttribute("classes", oc);
		
		
	
		var page = switch (req.getServletPath()) {
		case "/registeration" -> {
			var regisModel = getBean("registerModel", RegisterationModel.class);
			List regis = regisModel.findByClass(Integer.parseInt(openClassId));
			req.setAttribute("registeration", regis);
			yield("registeration");
		}
		
		default -> "registeration-create";
		};
		
		getServletContext().getRequestDispatcher("/%s.jsp".formatted(page)).forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		var courseId = req.getParameter("courseId");
		var student = req.getParameter("student");
		var phone = req.getParameter("phone");
		var email = req.getParameter("email");
		
		var oc = getBean("openClassModel", OpenClassModel.class).findByCourse(Integer.parseInt(courseId));
		int openClassId = oc.get(0).getId();
		var regis = new Registeration();
		regis.setOpenClass(oc.get(0));
		regis.setStudent(student);
		regis.setPhone(phone);
		regis.setEmail(email);
		
		getBean("registerModel", RegisterationModel.class).create(regis);
		
		resp.sendRedirect("/registeration?courseId=%s&openClassId=%d".formatted(courseId,openClassId));
	}

}
