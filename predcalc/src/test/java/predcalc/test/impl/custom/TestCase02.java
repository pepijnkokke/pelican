package predcalc.test.impl.custom;

import org.junit.Test;

import predcalc.test.TestData;
import predcalc.test.TestData.ExpectedPredCalc;
import predcalc.test.impl.ATestCase;
import predcalc.test.impl.ITestData;

public class TestCase02 extends ATestCase {

	@Test
	public final void createTestCase() throws Exception {
		runTest("Test02",createTest());
	}
	
	public final TestData createTest() throws Exception {
		String text = "EXISTS:(et)t (\\x0:e.((AND:ttt ((AND:ttt (man:et x0:e)) ((short:(et)et man:et) x0:e))) ((EQ:eet x0:e) jan:e)))";
		String hypothesis = "EXISTS:(et)t (\\x0:e.((AND:ttt (man:et x0:e)) ((EQ:eet x0:e) jan:e)))";
		ExpectedPredCalc epc = new ITestData.IExpectedPredCalc(
				"",
				"exists x0 ((man(x0) & short_man(x0)) & x0=jan).",
				"exists x0 (man(x0) & x0=jan).");
		return new ITestData(text, hypothesis, epc);
	}

}
