package com.jdc.assignment.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.support.GenericXmlApplicationContext;

@WebListener
public class SpringContainerManager implements ServletContextListener {

	private GenericXmlApplicationContext springContext;
	public static final String SPRING_CONTEXT = "spring.context";

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		springContext = new GenericXmlApplicationContext("classpath:application.xml");
		sce.getServletContext().setAttribute(SPRING_CONTEXT, springContext);

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

		if (springContext != null) {
			springContext.close();
		}
	}

}
