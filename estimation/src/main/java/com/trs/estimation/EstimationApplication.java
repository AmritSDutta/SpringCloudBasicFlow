package com.trs.estimation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EstimationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstimationApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean facesServlet()
	{
		EstimationServlet servlet = new EstimationServlet();
		ServletRegistrationBean servletRegistrationBean = new  ServletRegistrationBean(servlet, "/estimation");
		servletRegistrationBean.setLoadOnStartup(1);
		return servletRegistrationBean;
	}
}
