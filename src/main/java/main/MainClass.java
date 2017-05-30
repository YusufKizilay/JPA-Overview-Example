package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Book;

public class MainClass {

	public static void main(String[] args) {

		Float price = new Float(12.5);

		Book book = new Book("H2G2", price, "The .....", "1-84023-742-2", 354, Boolean.FALSE);

		// Obtains an entity manager and a transaction
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("oraclePU");
		EntityManager manager = factory.createEntityManager();

		// Persist the book to database
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(book);
		transaction.commit();

		// Close the entity manager and factory
		manager.close();
		factory.close();
	}

}
