package ru.myappco.SpringBoot.Task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.myappco.SpringBoot.Task1.config.AppConfig;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class ApplicationTests {

    @Autowired
	private TestRestTemplate restTemplate;

    @Container
	private GenericContainer<?> myAppFirst = new GenericContainer<>("tcapp:1.0")
			.withExposedPorts(8899);

    @Container
	private GenericContainer<?> myAppSecond= new GenericContainer<>("tcapp:2.0")
			.withExposedPorts(8891);

	@BeforeEach
	void setUp() {
		myAppFirst.start();
		myAppSecond.start();
	}

	@Test
	void contextLoads() {
		String value1 = "Hello. I'm version 1 service. I work on port 8899";
		String value2 = "Hello. I'm version 2 service. I work on port 8891";

		Integer first = myAppFirst.getMappedPort(8899);
		Integer second = myAppSecond.getMappedPort(8891);

		ResponseEntity<String> entityFirst = restTemplate.getForEntity("http://localhost:" + first, String.class);
		ResponseEntity<String> entitySecond = restTemplate.getForEntity("http://localhost:" + second, String.class);

		System.out.println(entityFirst.getBody());
		System.out.println(entitySecond.getBody());

		assertEquals(value1, entityFirst.getBody());
		assertEquals(value2, entitySecond.getBody());
	}

}
