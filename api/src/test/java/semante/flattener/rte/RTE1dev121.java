package semante.flattener.rte;

import lombok.val;

import org.junit.Before;
import org.junit.Test;

import semante.Entailment;
import semante.IEntailment;
import semante.flattener.AFlattenerTest;

public final class RTE1dev121 extends AFlattenerTest {
	
	@Before
	public final void setUp() throws Exception {
		super.doSetUp();
	}
	
	@Test
	public final void flattenTest() {
		super.flattenTest();
	}
	
	protected final void setReferences() {
		this.textReference = "EXISTS:(et)t (\\x0:e.((AND:ttt ((AND:ttt ((AND:ttt ((AND:ttt (airman:et x0:e)) (American:et x0:e))) (Syrian:et x0:e))) ((AND:ttt (accused:et x0:e)) (EXISTS:(et)t (\\x1:e.((AND:ttt (espionage:et x1:e)) (((of:e(et)et x0:e) accused:et) x1:e))))))) ((AND:ttt ((AND:ttt (complained:et x0:e)) (((about:e(et)et x0:e) complained:et) (IOTA:(et)e (\\x2:e.((AND:ttt (treatment:et x2:e)) (((at:e(et)et x2:e) treatment:et) (IOTA:(et)e (\\x3:e.((AND:ttt (base:et x3:e)) ((US:(et)et base:et) x3:e))))))))))) ((AND:ttt (((in:e(et)et x0:e) (\\x4:e.((AND:ttt (complained:et x4:e)) (((about:e(et)et x4:e) complained:et) (IOTA:(et)e (\\x5:e.((AND:ttt (treatment:et x5:e)) (((at:e(et)et x5:e) treatment:et) (IOTA:(et)e (\\x6:e.((AND:ttt (base:et x6:e)) ((US:(et)et base:et) x6:e)))))))))))) Guantanamo:e)) ((AND:ttt T:t) (((in:e(et)et Guantanamo:e) (\\x7:e.T:t)) Cuba:e))))))";
		this.hypoReference = "EXISTS:(et)t (\\x0:e.((AND:ttt (American:et x0:e)) ((AND:ttt (accused:et x0:e)) (EXISTS:(et)t (\\x1:e.((AND:ttt (espionage:et x1:e)) (((of:e(et)et x0:e) accused:et) x1:e)))))))";
	}
	
		public final Entailment createEntailment() throws Exception {

			// create the vocabulary for the text;
			val t00_a = word("A","A");
			val t01_syrian = word("MI","Syrian");
			val t02_american = word("MI","American");
			val t03_airman = word("N","airman");
			val t04_app = word("WHO_R","APP");
			val t05_accused = word("V_1","accused");
			val t06_of = word("P_R","of");
			val t07_an = word("A","an");
			val t08_espionage = word("N","espionage");
			val t09_complained = word("V_1","complained");
			val t10_about = word("P_R","about");
			val t11_the = word("THE","the");
			val t12_treatment = word("N","treatment");
			val t13_at = word("P_R","at");
			val t14_the = word("THE","the");
			val t15_us = word("MR","US");
			val t16_base = word("N","base");
			val t17_in = word("P_R","in");
			val t18_guantanamo = word("NP_D","Guantanamo");
			val t19_which = word("WHO_A","which");
			val t20_is = word("IS","is");
			val t21_in = word("P_R","in");
			val t22_cuba = word("NP_D","Cuba");

			// create the vocabulary for the hypothesis;
			val h00_an = word("A","An");
			val h01_american = word("N","American");
			val h02_accused = word("V_1","accused");
			val h03_of = word("P_R","of");
			val h04_an = word("A","an");
			val h05_espionage = word("N","espionage");

			// create the tree structure for the text;
			val tt =
			_(
				_(
					t00_a
					,
					_(
						_(
							t01_syrian
							,
							_(
								t02_american
								,
								t03_airman
							)
						)
						,
						_(
							t04_app
							,
							_(
								t05_accused
								,
								_(
									t06_of
									,
									_(
										t07_an
										,
										t08_espionage
									)
								)
							)
						)
					)
				)
				,
				_(
					_(
						t09_complained
						,
						_(
							t10_about
							,
							_(
								t11_the
								,
								_(
									t12_treatment
									,
									_(
										t13_at
										,
										_(
											t14_the
											,
											_(
												t15_us
												,
												t16_base
											)
										)
									)
								)
							)
						)
					)
					,
					_(
						t17_in
						,
						_(
							t18_guantanamo
							,
							_(
								t19_which
								,
								_(
									t20_is
									,
									_(
										t21_in
										,
										t22_cuba
									)
								)
							)
						)
					)
				)
			)
			;

			// create the tree structure for the hypothesis;
			val th =
			_(
				_(
					h00_an
					,
					h01_american
				)
				,
				_(
					h02_accused
					,
					_(
						h03_of
						,
						_(
							h04_an
							,
							h05_espionage
						)
					)
				)
			)
			;

			// create the subsumption relations;
			val ss =
			new String[] {
				""
			};

			// return the new entailment;
			return new IEntailment(tt, th, ss);
		}

}
