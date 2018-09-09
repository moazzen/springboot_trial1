package com.bps.sw.model;

import com.bps.sw.model.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebMethod;

/* behtar in ast ke dar yeki az kelasha @SpringBootApplication ra begzarim ke shamele @ComponentScan ham hast.
  * dar marhaleye bad dar an kelas extends SpringBootServletInitializer ra begzarim ta betavanad dar servlet container ha
   * mesle tomcat barname ejra shavad*/

@SpringBootApplication
@RestController
public class ModelSbApplication  extends SpringBootServletInitializer {

	@RequestMapping (value = "/")
	public String Hello () {
		return "First Rest WebService In SpringBoot ... ";
	}

	@RequestMapping (value = "/student" ,method = RequestMethod.POST)
	public String student (@RequestBody Student student) {
		return student.toString();
	}


}
