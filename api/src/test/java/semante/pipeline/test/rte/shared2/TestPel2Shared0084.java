package semante.pipeline.test.rte.shared2;

import lombok.val;
import org.junit.Test;
import semante.pipeline.AbsPipelineTest;
import static semante.pipeline.ResultType.*;

public final class TestPel2Shared0084 extends AbsPipelineTest<Integer> {

		@Test
		public final void testPel2Shared0084() throws Exception {

			// create the vocabulary for the text;
			val t01_the = word("THE","The",1);
			val t76_state_of_california_department_of_occupational_safety_and_health = word("N","State_of_California_Department_of_Occupational_Safety_and_Health",76);
			val t77_app = word("WHO_A","APP",77);
			val t11_ = word("IGNORE","",11);
			val t12_osha = word("NP_D","OSHA",12);
			val t13_ = word("IGNORE","",13);
			val t14_released = word("V_2","released",14);
			val t15_the = word("THE","the",15);
			val t16_report = word("N","report",16);
			val t17_on = word("P_R","on",17);
			val t18_the = word("THE","the",18);
			val t19_fatal = word("MR","fatal",19);
			val t20_accident = word("N","accident",20);
			val t21_on = word("P_R","on",21);
			val t22_the = word("THE","the",22);
			val t61_big_thunder_mountain_railroad = word("NP_D","Big_Thunder_Mountain_Railroad",61);
			val t84_app = word("WHO_A","APP",84);
			val t28_an = word("A","an",28);
			val t29_attraction = word("N","attraction",29);
			val t30_in = word("P_R","in",30);
			val t31_disneyland = word("NP_D","Disneyland",31);

			// create the vocabulary for the hypothesis;
			val h01_osha = word("NP_D","OSHA",1);
			val h02_released = word("V_2","released",2);
			val h03_a = word("A","a",3);
			val h04_report = word("N","report",4);
			val h05_on = word("P_R","on",5);
			val h06_the = word("THE","the",6);
			val h07_accident = word("N","accident",7);
			val h08_on = word("P_R","on",8);
			val h09_the = word("THE","the",9);
			val h10_attraction = word("N","attraction",10);
			val h11_in = word("P_R","in",11);
			val h12_disneyland = word("NP_D","Disneyland",12);

			// create the tree structure for the text;
			val tt =
			_(
				_(
					_(
						t01_the
						,
						t76_state_of_california_department_of_occupational_safety_and_health
						,
						71
					)
					,
					_(
						t77_app
						,
						_(
							_(
								t11_
								,
								t12_osha
								,
								68
							)
							,
							t13_
							,
							69
						)
						,
						78
					)
					,
					42
				)
				,
				_(
					t14_released
					,
					_(
						t15_the
						,
						_(
							t16_report
							,
							_(
								t17_on
								,
								_(
									t18_the
									,
									_(
										t19_fatal
										,
										_(
											t20_accident
											,
											_(
												t21_on
												,
												_(
													_(
														t22_the
														,
														t61_big_thunder_mountain_railroad
														,
														62
													)
													,
													_(
														t84_app
														,
														_(
															t28_an
															,
															_(
																t29_attraction
																,
																_(
																	t30_in
																	,
																	t31_disneyland
																	,
																	49
																)
																,
																47
															)
															,
															86
														)
														,
														85
													)
													,
													52
												)
												,
												82
											)
											,
											56
										)
										,
										87
									)
									,
									88
								)
								,
								45
							)
							,
							43
						)
						,
						79
					)
					,
					55
				)
				,
				70
			)
			;

			// create the tree structure for the hypothesis;
			val th =
			_(
				h01_osha
				,
				_(
					h02_released
					,
					_(
						h03_a
						,
						_(
							h04_report
							,
							_(
								h05_on
								,
								_(
									h06_the
									,
									_(
										h07_accident
										,
										_(
											h08_on
											,
											_(
												h09_the
												,
												_(
													h10_attraction
													,
													_(
														h11_in
														,
														h12_disneyland
														,
														20
													)
													,
													18
												)
												,
												31
											)
											,
											22
										)
										,
										16
									)
									,
									30
								)
								,
								17
							)
							,
							15
						)
						,
						29
					)
					,
					25
				)
				,
				28
			)
			;

			// create the subsumption relations;

			// test for a proof;
			assertProof(tt, th);
			// test the testcasecreator;
			testTestCaseCreator(tt, th, Proof);
		}

}
