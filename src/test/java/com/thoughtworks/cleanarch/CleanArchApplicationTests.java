package com.thoughtworks.cleanarch;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CleanArchApplicationTests {

	@Test
	public void should_return_inputStr_when_given_input() {
		String inputArgs = "-l true -p 8080 -d /usr/logs";

		Args args = new Args(inputArgs);

		assertEquals("[Arg{flag='l', value=true}, Arg{flag='p', value=8080}" +
				", Arg{flag='d', value=/usr/logs}]",args.getArgList().toString());
	}

}
