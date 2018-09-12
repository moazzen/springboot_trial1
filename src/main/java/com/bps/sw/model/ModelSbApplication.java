package com.bps.sw.model;

import com.bps.sw.model.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
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
public class ModelSbApplication  extends SpringBootServletInitializer implements ApplicationRunner {


	/*ba in kar yek meghdar ra az properties mikhanim va be in moteghayer midahim.
	server.name moteghayerist ke dar properties haye env va release tarif shode ast. meghdari ke be in
	moteghayer assign mishavad az profile e active mikhanad. masalan agar profile e active dar maven , release bashad
	angah meghdare server.name az application-release.properties khande mishavad.*/
	/*baraye set kardane default value va jelogiri az exception mitavan yek meghdare default ra ingune set kard :
	@Value("${server.name:default_value}")*/

	@Value("${server.port}")
	private String mavenProfile;



	@RequestMapping (value = "/")
	public String Hello () {
		return "First Rest WebService In SpringBoot ... ";
	}

	@RequestMapping (value = "/maven_profile")
	public String testMavenProfiles () {
		return mavenProfile ;
	}


	/*dar in tabe methode post baraye farakhanie web service entekhab shode ast va
	* hamchenin ba @RequestBody mitavanim beguiim ke vorudie tabe ra az body e request daryaft kon.
	* hamchenin agar json daryafti daraye kelidhaye hamnam ba objecte vorudi bashad in maghadir be surate automatic
	* ruye object set mishavand. */
	@RequestMapping (value = "/student" ,method = RequestMethod.POST)
	public String student (@RequestBody Student student) {
		return student.toString();
	}



	/*implement kardane ApplicationRunner in emkan ra midahad ke belafasele bad az run shodane barname tavasote
	* @SpringBootApplication betavan tabe'e run ra ejra kard. in kar faghat yek bar dar ebtedaye barname anjam migirad.*/

	// dar surate nabudane main agar ApplicationRunner ra implement karde bashim baz ham run ejra mishavad
	// dar mavaredi ke mikhahim tabe'e run dar mavagheii ke app ra dar console run mikonim ejra shavad be jaye
	// implement kardane ApplicationRunner bayad CommandLineRunner ra implement konim.
	public static void main(String[] args) {
		SpringApplication.run(ModelSbApplication.class, args);
	}
	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		System.out.println("this is printed from application runner ... ");
	}
}
