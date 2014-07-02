package semante.pipeline.test.rte.shared1;

import lombok.val;
import org.junit.Test;
import semante.pipeline.AbsPipelineTest;
import static semante.pipeline.ResultType.*;

public final class TestPel1Shared0008 extends AbsPipelineTest {

		@Test
		public final void testPel1Shared0008() throws Exception {

			// create the vocabulary for the text;
			val t01_the = word("THE","The",1);
			val t02_international = word("MI","international",2);
			val t03_humanitarian = word("MI","humanitarian",3);
			val t04_aid = word("$NC_1$","aid",4);
			val t05_organization = word("N","organization",5);
			val t84_app = word("WHO_A","APP",84);
			val t07_doctors = word("$NPC_1$","Doctors",7);
			val t08_without = word("$NPC_1$","Without",8);
			val t09_borders = word("NP_D","Borders",9);
			val t81_app = word("WHO_A","APP",81);
			val t11_medecins = word("$NPC_1$","Medecins",11);
			val t12_sans = word("$NPC_1$","Sans",12);
			val t13_frontieres = word("NP_D","Frontieres",13);
			val t79_app = word("WHO_A","APP",79);
			val t14_ = word("IGNORE","",14);
			val t15_msf = word("NP_D","MSF",15);
			val t16_ = word("IGNORE","",16);
			val t18_treats = word("V_2","treats",18);
			val t74_det = word("A","DET",74);
			val t19_victims = word("N","victims",19);
			val t20_of = word("P_R","of",20);
			val t76_det = word("A","DET",76);
			val t21_violence = word("N","violence",21);
			val t22_in = word("P_R","in",22);
			val t23_all = word("EVERY","all",23);
			val t24_locations = word("N","locations",24);
			val t25_that = word("WHO_R","that",25);
			val t26_exhibit = word("V_2","exhibit",26);
			val t72_det = word("A","DET",72);
			val t27_violence = word("N","violence",27);
			val t28_in = word("P_R","in",28);
			val t29_darfur = word("NP_D","Darfur",29);

			// create the vocabulary for the hypothesis;
			val h01_doctors = word("$NPC_1$","Doctors",1);
			val h02_without = word("$NPC_1$","Without",2);
			val h03_borders = word("NP_D","Borders",3);
			val h04_is = word("IS","is",4);
			val h05_an = word("A","an",5);
			val h06_international = word("MI","international",6);
			val h07_aid = word("$NC_1$","aid",7);
			val h08_organization = word("N","organization",8);

			// create the tree structure for the text;
			val tt =
			_(
				_(
					_(
						t01_the
						,
						_(
							t02_international
							,
							_(
								t03_humanitarian
								,
								_(
									t04_aid
									,
									t05_organization
									,
									66
								)
								,
								67
							)
							,
							68
						)
						,
						69
					)
					,
					_(
						t84_app
						,
						_(
							_(
								t07_doctors
								,
								_(
									t08_without
									,
									t09_borders
									,
									39
								)
								,
								40
							)
							,
							_(
								t81_app
								,
								_(
									_(
										t11_medecins
										,
										_(
											t12_sans
											,
											t13_frontieres
											,
											60
										)
										,
										61
									)
									,
									_(
										t79_app
										,
										_(
											_(
												t14_
												,
												t15_msf
												,
												62
											)
											,
											t16_
											,
											63
										)
										,
										80
									)
									,
									37
								)
								,
								82
							)
							,
							78
						)
						,
						85
					)
					,
					70
				)
				,
				_(
					_(
						t18_treats
						,
						_(
							t74_det
							,
							_(
								t19_victims
								,
								_(
									t20_of
									,
									_(
										t76_det
										,
										t21_violence
										,
										77
									)
									,
									46
								)
								,
								58
							)
							,
							75
						)
						,
						56
					)
					,
					_(
						t22_in
						,
						_(
							t23_all
							,
							_(
								t24_locations
								,
								_(
									t25_that
									,
									_(
										t26_exhibit
										,
										_(
											t72_det
											,
											_(
												t27_violence
												,
												_(
													t28_in
													,
													t29_darfur
													,
													50
												)
												,
												51
											)
											,
											73
										)
										,
										52
									)
									,
									54
								)
								,
								43
							)
							,
							71
						)
						,
						44
					)
					,
					65
				)
				,
				86
			)
			;

			// create the tree structure for the hypothesis;
			val th =
			_(
				_(
					h01_doctors
					,
					_(
						h02_without
						,
						h03_borders
						,
						12
					)
					,
					19
				)
				,
				_(
					h04_is
					,
					_(
						h05_an
						,
						_(
							h06_international
							,
							_(
								h07_aid
								,
								h08_organization
								,
								16
							)
							,
							17
						)
						,
						18
					)
					,
					14
				)
				,
				21
			)
			;

			// create the subsumption relations;

			// test for a proof;
			assertProof(tt, th);
			// test the testcasecreator;
			testTestCaseCreator(tt, th, Proof);
		}

}

