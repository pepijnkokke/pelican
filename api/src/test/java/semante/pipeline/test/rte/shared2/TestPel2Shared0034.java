package semante.pipeline.test.rte.shared2;

import lombok.val;
import org.junit.Test;
import semante.pipeline.AbsPipelineTest;
import static semante.pipeline.ResultType.*;

public final class TestPel2Shared0034 extends AbsPipelineTest {

		@Test
		public final void testPel2Shared0034() throws Exception {

			// create the vocabulary for the text;
			val t01_the = word("THE","The",1);
			val t02_series = word("N","series",2);
			val t03_of = word("P_R","of",3);
			val t04_tremors = word("NP_D","tremors",4);
			val t05_which = word("WHO_A","which",5);
			val t06_rocked = word("V_2","rocked",6);
			val t07_mount = word("$NPC_1$","Mount",7);
			val t08_st = word("$NPC_1$","St",8);
			val t09_helens = word("NP_D","Helens",9);
			val t10_for = word("P_R","for",10);
			val t11_num90 = word("NUMBER","num90",11);
			val t12_minutes = word("N","minutes",12);
			val t13_overnight = word("MI","overnight",13);
			val t14_foretell = word("V_2","foretell",14);
			val t15_a = word("A","a",15);
			val t16_volcanic = word("MR","volcanic",16);
			val t17_eruption = word("N","eruption",17);
			val t18_within = word("P_R","within",18);
			val t19_the = word("THE","the",19);
			val t20_next = word("MR","next",20);
			val t21_few = word("MR","few",21);
			val t22_minutes = word("$NC_1$","minutes",22);
			val t23_or = word("$NC_1$","or",23);
			val t24_months = word("N","months",24);
			val t26_frightening = word("GER_2","frightening",26);
			val t27_the = word("THE","the",27);
			val t28_local = word("MR","local",28);
			val t29_population = word("N","population",29);

			// create the vocabulary for the hypothesis;
			val h01_a = word("A","A",1);
			val h02_series = word("N","series",2);
			val h03_of = word("P_R","of",3);
			val h04_tremors = word("NP_D","tremors",4);
			val h05_rocked = word("V_2","rocked",5);
			val h06_mount = word("$NPC_1$","Mount",6);
			val h07_st = word("$NPC_1$","St",7);
			val h08_helens = word("NP_D","Helens",8);
			val h09_overnight = word("MI","overnight",9);

			// create the tree structure for the text;
			val tt =
			_(
				_(
					_(
						t01_the
						,
						_(
							t02_series
							,
							_(
								t03_of
								,
								t04_tremors
								,
								52
							)
							,
							31
						)
						,
						69
					)
					,
					_(
						t05_which
						,
						_(
							_(
								_(
									t06_rocked
									,
									_(
										t07_mount
										,
										_(
											t08_st
											,
											t09_helens
											,
											48
										)
										,
										73
									)
									,
									72
								)
								,
								_(
									t10_for
									,
									_(
										t11_num90
										,
										t12_minutes
										,
										46
									)
									,
									76
								)
								,
								74
							)
							,
							t13_overnight
							,
							49
						)
						,
						50
					)
					,
					68
				)
				,
				_(
					_(
						t14_foretell
						,
						_(
							t15_a
							,
							_(
								t16_volcanic
								,
								_(
									t17_eruption
									,
									_(
										t18_within
										,
										_(
											t19_the
											,
											_(
												t20_next
												,
												_(
													t21_few
													,
													_(
														t22_minutes
														,
														_(
															t23_or
															,
															t24_months
															,
															58
														)
														,
														79
													)
													,
													78
												)
												,
												59
											)
											,
											60
										)
										,
										40
									)
									,
									56
								)
								,
								82
							)
							,
							57
						)
						,
						61
					)
					,
					_(
						t26_frightening
						,
						_(
							t27_the
							,
							_(
								t28_local
								,
								t29_population
								,
								63
							)
							,
							64
						)
						,
						65
					)
					,
					70
				)
				,
				83
			)
			;

			// create the tree structure for the hypothesis;
			val th =
			_(
				_(
					h01_a
					,
					_(
						h02_series
						,
						_(
							h03_of
							,
							h04_tremors
							,
							13
						)
						,
						11
					)
					,
					22
				)
				,
				_(
					_(
						h05_rocked
						,
						_(
							h06_mount
							,
							_(
								h07_st
								,
								h08_helens
								,
								19
							)
							,
							20
						)
						,
						17
					)
					,
					h09_overnight
					,
					21
				)
				,
				23
			)
			;

			// create the subsumption relations;

			// test for a proof;
			assertProof(tt, th);
			// test the testcasecreator;
			testTestCaseCreator(tt, th, Proof);
		}

}

