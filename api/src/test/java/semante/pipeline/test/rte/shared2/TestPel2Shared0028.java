package semante.pipeline.test.rte.shared2;

import lombok.val;
import org.junit.Test;
import semante.pipeline.AbsPipelineTest;
import static semante.pipeline.ResultType.*;

public final class TestPel2Shared0028 extends AbsPipelineTest<Integer> {

		@Test
		public final void testPel2Shared0028() throws Exception {

			// create the vocabulary for the text;
			val t01_a = word("A","A",1);
			val t48_news_reporter = word("N","news_reporter",48);
			val t04_said = word("FACT","said",4);
			val t05_that = word("IGNORE","that",5);
			val t06_the = word("THE","the",6);
			val t44_royal_navy_servicemen = word("N","Royal_Navy_servicemen",44);
			val t10_who = word("WHO_A","who",10);
			val t11_are = word("V_AUX","are",11);
			val t12_held = word("V_2","held",12);
			val t13_captive = word("NP_D","captive",13);
			val t14_in = word("P_R","in",14);
			val t15_the = word("THE","the",15);
			val t16_iranian = word("MI","Iranian",16);
			val t17_prison = word("N","prison",17);
			val t18_will = word("IS","will",18);
			val t19_be = word("IS","be",19);
			val t20_freed = word("V_1","freed",20);
			val t21_today = word("MR","today",21);

			// create the vocabulary for the hypothesis;
			val h01_the = word("THE","The",1);
			val h21_royal_navy_servicemen = word("N","Royal_Navy_servicemen",21);
			val h05_are = word("V_AUX","are",5);
			val h06_held = word("V_2","held",6);
			val h07_captive = word("NP_D","captive",7);
			val h08_in = word("P_R","in",8);
			val h09_a = word("A","a",9);
			val h10_prison = word("N","prison",10);

			// create the tree structure for the text;
			val tt =
			_(
				_(
					t01_a
					,
					t48_news_reporter
					,
					49
				)
				,
				_(
					t04_said
					,
					_(
						t05_that
						,
						_(
							_(
								_(
									t06_the
									,
									t44_royal_navy_servicemen
									,
									45
								)
								,
								_(
									t10_who
									,
									_(
										_(
											t11_are
											,
											_(
												t12_held
												,
												t13_captive
												,
												30
											)
											,
											31
										)
										,
										_(
											t14_in
											,
											_(
												t15_the
												,
												_(
													t16_iranian
													,
													t17_prison
													,
													46
												)
												,
												47
											)
											,
											28
										)
										,
										32
									)
									,
									33
								)
								,
								34
							)
							,
							_(
								t18_will
								,
								_(
									t19_be
									,
									_(
										t20_freed
										,
										t21_today
										,
										36
									)
									,
									37
								)
								,
								38
							)
							,
							39
						)
						,
						40
					)
					,
					41
				)
				,
				50
			)
			;

			// create the tree structure for the hypothesis;
			val th =
			_(
				_(
					h01_the
					,
					h21_royal_navy_servicemen
					,
					22
				)
				,
				_(
					_(
						h05_are
						,
						_(
							h06_held
							,
							h07_captive
							,
							17
						)
						,
						18
					)
					,
					_(
						h08_in
						,
						_(
							h09_a
							,
							h10_prison
							,
							14
						)
						,
						15
					)
					,
					23
				)
				,
				25
			)
			;

			// create the subsumption relations;

			// test for a proof;
			assertProof(tt, th);
			// test the testcasecreator;
			testTestCaseCreator(tt, th, Proof);
		}

}
