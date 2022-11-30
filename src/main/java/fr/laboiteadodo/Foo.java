package fr.laboiteadodo;

import java.time.Instant;

import javax.ejb.Asynchronous;
import javax.ws.rs.*;

@Path("foo")
public class Foo {
	@GET
	public String get() {
		System.out.printf("%s: Request started \n", Instant.now());
		this.doSomething();
		System.out.printf("%s: Request ended\n", Instant.now());
		return "Hello world!";
	}

	@Asynchronous
	private void doSomething() {
		try {
			System.out.printf("%s: Long task started\n", Instant.now());
			Thread.sleep(2000);
			System.out.printf("%s: Long task ended\n", Instant.now());
		} catch (InterruptedException e) {
			System.out.printf("%s: Long task failed\n", Instant.now());
		}
	}
}
