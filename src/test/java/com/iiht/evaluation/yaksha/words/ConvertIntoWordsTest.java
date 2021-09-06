package com.iiht.evaluation.yaksha.words;

import static com.iiht.evaluation.yaksha.testutils.TestUtils.boundaryTestFile;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.businessTestFile;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.currentTest;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.exceptionTestFile;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.testReport;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.iiht.evaluation.yaksha.words.MyApp;

public class ConvertIntoWordsTest {

	@AfterAll
	public static void afterAll() {
		testReport();
	}
	
	@Test
	public void testGetWords() throws Exception {
		MyApp obj = new MyApp();
		
		String str = obj.getWords(1234);
		yakshaAssert(currentTest(), str.contentEquals("ONE TWO THREE FOUR")? "true":"false", businessTestFile);
	}
	
	@Test
	public void testGetWordsForMinimal() throws Exception {
		MyApp obj = new MyApp();
		String str = obj.getWords(1);
		yakshaAssert(currentTest(), str.contentEquals("ONE")? "true":"false", businessTestFile);
	}
	
	@Test
	public void testGetWordsForNoValue() throws Exception {
		MyApp obj = new MyApp();
		String str = obj.getWords(0);
		yakshaAssert(currentTest(), str.contentEquals("ZERO")? "true":"false", boundaryTestFile);
	}
	
	@Test
	public void testGetWordsForSimilarValues() throws Exception {
		MyApp obj = new MyApp();
		String str = obj.getWords(9999);
		yakshaAssert(currentTest(), str.contentEquals("NINE NINE NINE NINE")? "true":"false", businessTestFile);
	}
	
	@Test
	public void testGetWordsForException() throws Exception {
		MyApp obj = new MyApp();
		String str = obj.getWords(1000);
		yakshaAssert(currentTest(), str.contentEquals("ONE ZERO ZERO ZERO")? "true":"false", exceptionTestFile);
	}
}
