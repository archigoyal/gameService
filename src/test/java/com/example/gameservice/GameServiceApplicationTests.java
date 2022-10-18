package com.example.gameservice;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

import static org.mockito.Mockito.mockStatic;

@Slf4j
@ExtendWith(MockitoExtension.class)
class GameServiceApplicationTests {
	@Test
	void contextLoads() throws IOException {
		try (MockedStatic<SpringApplication> mocked = mockStatic(SpringApplication.class)) {

			mocked.when(() -> { SpringApplication.run(GameServiceApplication.class,
							new String[] { "foo", "bar" }); })
					.thenReturn(Mockito.mock(ConfigurableApplicationContext.class));
			GameServiceApplication.main(new String[] { "foo", "bar" });

			mocked.verify(() -> { SpringApplication.run(GameServiceApplication.class,
					new String[] { "foo", "bar" }); });

		}


	}


}
