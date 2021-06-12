package guru.sbdi;

import guru.sbdi.controllers.ConstructorInjectedController;
import guru.sbdi.controllers.MyController;
import guru.sbdi.controllers.PropertyInjectedController;
import guru.sbdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SbDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SbDiApplication.class, args);

		MyController myController = (MyController) ctx.getBean("myController");


		String greeting = myController.sayHi();

		System.out.println("-------- primary bean");
		System.out.println(myController.sayHi());


		System.out.println("---------- Property");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");

		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("---------- Setter");

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreeting());

		System.out.println("--------- Constructor");

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");

		System.out.println(constructorInjectedController.getGreeting());
	}

}
