package lambdacalc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public final class TestBetaReducer extends TestLambdaCalc {
	
	@Test
	public final void identities1() {
		reducesTo("(\\x:e.x:e) john:e",
		          "john:e");
	}
	
	@Test
	public final void identities2() {
		reducesTo("((\\A:et.A:et) walks:et) john:e",
		          "walks:et john:e");
	}
	
	@Test
	public final void identities3() {
		reducesTo("(((\\M:(et)et.M:(et)et) fast:(et)et) walks:et) john:e",
		          "(fast:(et)et walks:et) john:e");
	}
	
	@Test
	public final void irreducibles1() {
		reducesTo("walks:et john:et",
		          "walks:et john:et");
	}
	@Test
	public final void irreducibles2() {
		reducesTo("((fast:(et)et walks:et) john:e)",
		          "((fast:(et)et walks:et) john:e)");
	}
	@Test
	public final void irreducibles3() {
		reducesTo("(((very:((et)et)(et)et fast:(et)et) walks:et) john:e)",
		          "(((very:((et)et)(et)et fast:(et)et) walks:et) john:e)");
	}

	private final void reducesTo(final String exp1, final String exp2) {
		assertEquals(
			stl.format(stl.toDeBruijn(stl.parse(exp2))),
			stl.format(stl.betaReduce(stl.toDeBruijn(stl.parse(exp1)))));
	}
	
}
