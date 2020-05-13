package net.codejava;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//component name
public class SpringDependencyInjectionExample {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(); 
		appContext.scan("net.codejava");
		appContext.refresh();
		
		MyClient client = (MyClient) appContext.getBean("client1");
		client.doSomething();
	}

}
