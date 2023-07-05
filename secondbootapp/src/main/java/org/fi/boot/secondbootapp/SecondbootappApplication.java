package org.fi.boot.secondbootapp;

import java.util.List;
import java.util.Scanner;

import org.fi.boot.secondbootapp.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = { "org.fi.boot.secondbootapp.entity" })
public class SecondbootappApplication implements CommandLineRunner {

	@Autowired
	SessionFactory hibernateFactory;

	public static void main(String[] args) {
		SpringApplication.run(SecondbootappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try (Scanner scanner = new Scanner(System.in); Session hibernateSession = hibernateFactory.openSession()) {
			Query<Category> query = hibernateSession.createQuery("from Category");
			List<Category> list = query.getResultList();

			for (Category objCategory : list) {
				System.out.println(objCategory);
			}

		}

	}

}
