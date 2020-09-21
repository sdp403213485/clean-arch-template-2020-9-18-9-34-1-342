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


	@Test
	public void should_throw_repeatError_when_error_input_value() throws Exception {
		String inputArgs = "-p true -p false";

		try {
			Args args = new Args(inputArgs);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			assertThat(exception.getMessage(), is("参数输入重复"));
		}
	}

	@Test
	public void should_return_rightArgs_when_inputArgs() throws Exception {
		String inputArgs = "-l true -p 8080 -d /usr/logs";

		Args args = new Args(inputArgs);

		assertEquals("[Arg{flag='l', value=true, type='boolean'}, " +
						"Arg{flag='p', value=8080, type='int'}, " +
						"Arg{flag='d', value=/usr/logs, type='String'}]"
				,args.getArgList().toString());
	}

}
