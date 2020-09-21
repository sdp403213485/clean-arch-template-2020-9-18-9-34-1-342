package com.thoughtworks.cleanarch;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CleanArchApplicationTests {

	@Test
	public void should_return_inputStr_when_given_input() throws Exception {
		String inputArgs = "-l  -p  -d ";

		Args args = new Args(inputArgs);

		assertEquals("[Arg{flag='l  ', value=false, type='boolean'}, " +
						"Arg{flag='p  ', value=0, type='int'}, " +
						"Arg{flag='d ', value=, type='String'}]"
				,args.getArgList().toString());
	}

	@Test
	public void should_throw_error_when_error_input_value() throws Exception {
		String inputArgs = "-l -true";

		try {
			Args args = new Args(inputArgs);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			assertThat(exception.getMessage(), is("格式错误"));
		}
	}

}
