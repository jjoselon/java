package com.interview.springbootinterview;

import com.interview.springbootinterview.springbeanscontainer.beans.AppConfig2;
import com.interview.springbootinterview.springbeanscontainer.beans.scope.SingletonBean;
import com.interview.springbootinterview.springbeanscontainer.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringBootInterviewApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(SpringBootInterviewApplication.class, args);
		SingletonBean singletonBean = context.getBean(SingletonBean.class);
		SingletonBean singletonBean2 = context.getBean(SingletonBean.class);

		if (singletonBean.equals(singletonBean2)) {
			System.out.println("singletonBean == singletonBean2");
		}
//		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig2.class);
//		User user = context.getBean(User.class);
//		System.out.println(user.getName());



	}
}
