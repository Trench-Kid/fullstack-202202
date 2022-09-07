package com.trench_kid.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RelationshipTest {

	private static EntityManagerFactory emf;

	@BeforeAll
	static void start() {
		emf = Persistence.createEntityManagerFactory("one-to-one");

	}

	@AfterAll
	static void shutDown() {
		emf.close();

	}
	@Test
	void test() {
		
	}

}
