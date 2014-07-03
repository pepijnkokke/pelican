package semante.pipeline.test.subs;

import lombok.val;
import org.junit.Test;
import semante.pipeline.AbsPipelineTest;
import static semante.pipeline.ResultType.*;

import java.util.List;
import com.google.common.collect.Lists;
import semante.pipeline.Pair;
import semante.pipeline.impl.IPair;

public final class TestPNs extends AbsPipelineTest {

		@Test
		public final void TestCase01() throws Exception {

			// create the vocabulary for the text;
			val t01_john = word("NP_D","John",1);
			val t02_kissed = word("V_2","kissed",2);
			val t03_virginia = word("$NPC_1$","Virginia",3);
			val t04_wolf = word("NP_D","Wolf",4);

			// create the vocabulary for the hypothesis;
			val h01_john = word("NP_D","John",1);
			val h02_kissed = word("V_2","kissed",2);
			val h03_wolf = word("NP_D","Wolf",3);

			// create the tree structure for the text;
			val tt =
			_(
				t01_john
				,
				_(
					t02_kissed
					,
					_(
						t03_virginia
						,
						t04_wolf
						,
						6
					)
					,
					7
				)
				,
				8
			)
			;

			// create the tree structure for the hypothesis;
			val th =
			_(
				h01_john
				,
				_(
					h02_kissed
					,
					h03_wolf
					,
					6
				)
				,
				7
			)
			;

			// create the subsumption relations;
		List<Pair<Integer,Integer>> subs = Lists.newArrayList();
		subs.add(new IPair<Integer,Integer>(6,3));

			// test for a proof;
			assertProof(tt, th, subs);
			// test the testcasecreator;
			testTestCaseCreator(tt, th, Proof, subs);
		}

		@Test
		public final void TestCas02() throws Exception {

			// create the vocabulary for the text;
			val t01_norma = word("$NPC_1$","Norma",1);
			val t02_jean = word("NP_D","Jean",2);
			val t03_kissed = word("V_2","kissed",3);
			val t04_john = word("NP_D","John",4);

			// create the vocabulary for the hypothesis;
			val h01_norma = word("NP_D","Norma",1);
			val h02_kissed = word("V_2","kissed",2);
			val h03_john = word("NP_D","John",3);

			// create the tree structure for the text;
			val tt =
			_(
				_(
					t01_norma
					,
					t02_jean
					,
					5
				)
				,
				_(
					t03_kissed
					,
					t04_john
					,
					7
				)
				,
				8
			)
			;

			// create the tree structure for the hypothesis;
			val th =
			_(
				h01_norma
				,
				_(
					h02_kissed
					,
					h03_john
					,
					6
				)
				,
				7
			)
			;

			// create the subsumption relations;
		List<Pair<Integer,Integer>> subs = Lists.newArrayList();
		subs.add(new IPair<Integer,Integer>(5,1));

			// test for a proof;
			assertProof(tt, th, subs);
			// test the testcasecreator;
			testTestCaseCreator(tt, th, Proof, subs);
		}

		@Test
		public final void TestCas03() throws Exception {

			// create the vocabulary for the text;
			val t01_john = word("$NPC_1$","John",1);
			val t02_lennon = word("NP_D","Lennon",2);
			val t20_app = word("WHO_A","APP",20);
			val t04_the = word("THE","the",4);
			val t05_singer = word("N","singer",5);
			val t06_of = word("P_R","of",6);
			val t07_imagine = word("NP_D","Imagine",7);
			val t09_smiled = word("V_1","smiled",9);

			// create the vocabulary for the hypothesis;
			val h01_lennon = word("NP_D","Lennon",1);
			val h19_app = word("WHO_A","APP",19);
			val h03_the = word("THE","the",3);
			val h04_singer = word("N","singer",4);
			val h05_of = word("P_R","of",5);
			val h06_imagine = word("NP_D","Imagine",6);
			val h08_smiled = word("V_1","smiled",8);

			// create the tree structure for the text;
			val tt =
			_(
				_(
					_(
						t01_john
						,
						t02_lennon
						,
						10
					)
					,
					_(
						t20_app
						,
						_(
							t04_the
							,
							_(
								t05_singer
								,
								_(
									t06_of
									,
									t07_imagine
									,
									13
								)
								,
								14
							)
							,
							18
						)
						,
						21
					)
					,
					19
				)
				,
				t09_smiled
				,
				17
			)
			;

			// create the tree structure for the hypothesis;
			val th =
			_(
				_(
					h01_lennon
					,
					_(
						h19_app
						,
						_(
							h03_the
							,
							_(
								h04_singer
								,
								_(
									h05_of
									,
									h06_imagine
									,
									12
								)
								,
								13
							)
							,
							17
						)
						,
						20
					)
					,
					18
				)
				,
				h08_smiled
				,
				16
			)
			;

			// create the subsumption relations;
		List<Pair<Integer,Integer>> subs = Lists.newArrayList();
		subs.add(new IPair<Integer,Integer>(10,1));

			// test for a proof;
			assertProof(tt, th, subs);
			// test the testcasecreator;
			testTestCaseCreator(tt, th, Proof, subs);
		}
		
		
		@Test
		public final void TestCas04() throws Exception {

			// create the vocabulary for the text;
			val t01_john = word("$NPC_1$","John",1);
			val t02_lennon = word("NP_D","Lennon",2);
			val t04_who = word("WHO_A","who",4);
			val t05_sang = word("V_2","sang",5);
			val t06_imagine = word("NP_D","Imagine",6);
			val t08_smiled = word("V_1","smiled",8);

			// create the vocabulary for the hypothesis;
			val h01_lennon = word("NP_D","Lennon",1);
			val h03_who = word("WHO_A","who",3);
			val h04_sang = word("V_2","sang",4);
			val h05_imagine = word("NP_D","Imagine",5);
			val h07_smiled = word("V_1","smiled",7);

			// create the tree structure for the text;
			val tt =
			_(
				_(
					_(
						t01_john
						,
						t02_lennon
						,
						9
					)
					,
					_(
						t04_who
						,
						_(
							t05_sang
							,
							t06_imagine
							,
							12
						)
						,
						14
					)
					,
					18
				)
				,
				t08_smiled
				,
				17
			)
			;

			// create the tree structure for the hypothesis;
			val th =
			_(
				_(
					h01_lennon
					,
					_(
						h03_who
						,
						_(
							h04_sang
							,
							h05_imagine
							,
							11
						)
						,
						13
					)
					,
					17
				)
				,
				h07_smiled
				,
				16
			)
			;

			// create the subsumption relations;
		List<Pair<Integer,Integer>> subs = Lists.newArrayList();
		subs.add(new IPair<Integer,Integer>(9,1));

			// test for a proof;
			assertProof(tt, th, subs);
			// test the testcasecreator;
			testTestCaseCreator(tt, th, Proof, subs);
		}
	
		@Test
		public final void TestCas05() throws Exception {

			// create the vocabulary for the text;
			val t01_the = word("THE","The",1);
			val t02_singer = word("N","singer",2);
			val t03_of = word("P_R","of",3);
			val t04_imagine = word("NP_D","Imagine",4);
			val t20_app = word("WHO_A","APP",20);
			val t06_john = word("$NPC_1$","John",6);
			val t07_lennon = word("NP_D","Lennon",7);
			val t09_smiled = word("V_1","smiled",9);

			// create the vocabulary for the hypothesis;
			val h01_the = word("THE","The",1);
			val h02_singer = word("N","singer",2);
			val h03_of = word("P_R","of",3);
			val h04_imagine = word("NP_D","Imagine",4);
			val h19_app = word("WHO_A","APP",19);
			val h06_lennon = word("NP_D","Lennon",6);
			val h08_smiled = word("V_1","smiled",8);

			// create the tree structure for the text;
			val tt =
			_(
				_(
					_(
						t01_the
						,
						_(
							t02_singer
							,
							_(
								t03_of
								,
								t04_imagine
								,
								12
							)
							,
							13
						)
						,
						18
					)
					,
					_(
						t20_app
						,
						_(
							t06_john
							,
							t07_lennon
							,
							14
						)
						,
						21
					)
					,
					19
				)
				,
				t09_smiled
				,
				17
			)
			;

			// create the tree structure for the hypothesis;
			val th =
			_(
				_(
					_(
						h01_the
						,
						_(
							h02_singer
							,
							_(
								h03_of
								,
								h04_imagine
								,
								11
							)
							,
							12
						)
						,
						17
					)
					,
					_(
						h19_app
						,
						h06_lennon
						,
						20
					)
					,
					18
				)
				,
				h08_smiled
				,
				16
			)
			;

			// create the subsumption relations;
		List<Pair<Integer,Integer>> subs = Lists.newArrayList();
		subs.add(new IPair<Integer,Integer>(14,6));

			// test for a proof;
			assertProof(tt, th, subs);
			// test the testcasecreator;
			testTestCaseCreator(tt, th, Proof, subs);
		}


		@Test
		public final void TestCas06() throws Exception {

			// create the vocabulary for the text;
			val t01_john = word("NP_D","John",1);
			val t02_met = word("V_2","met",2);
			val t03_mary = word("NP_D","Mary",3);
			val t04_in = word("P_R","in",4);
			val t05_los = word("$NPC_1$","Los",5);
			val t06_angeles = word("NP_D","Angeles",6);

			// create the vocabulary for the hypothesis;
			val h01_john = word("NP_D","John",1);
			val h02_met = word("V_2","met",2);
			val h03_mary = word("NP_D","Mary",3);
			val h04_in = word("P_R","in",4);
			val h05_la = word("NP_D","LA",5);

			// create the tree structure for the text;
			val tt =
			_(
				t01_john
				,
				_(
					_(
						t02_met
						,
						t03_mary
						,
						12
					)
					,
					_(
						t04_in
						,
						_(
							t05_los
							,
							t06_angeles
							,
							9
						)
						,
						10
					)
					,
					13
				)
				,
				14
			)
			;

			// create the tree structure for the hypothesis;
			val th =
			_(
				h01_john
				,
				_(
					_(
						h02_met
						,
						h03_mary
						,
						11
					)
					,
					_(
						h04_in
						,
						h05_la
						,
						9
					)
					,
					12
				)
				,
				13
			)
			;

			// create the subsumption relations;
		List<Pair<Integer,Integer>> subs = Lists.newArrayList();
		subs.add(new IPair<Integer,Integer>(9,5));

			// test for a proof;
			assertProof(tt, th, subs);
			// test the testcasecreator;
			testTestCaseCreator(tt, th, Proof, subs);
		}
		
		@Test
		public final void TestCas07() throws Exception {

			// create the vocabulary for the text;
			val t01_the = word("THE","The",1);
			val t02_los = word("$NPC_1$","Los",2);
			val t03_angeles = word("$NPC_1$","Angeles",3);
			val t04_lakers = word("NP_D","Lakers",4);
			val t05_won = word("V_2","won",5);
			val t06_the = word("THE","the",6);
			val t07_game = word("N","game",7);

			// create the vocabulary for the hypothesis;
			val h01_the = word("THE","The",1);
			val h02_la = word("$NPC_1$","LA",2);
			val h03_lakers = word("NP_D","Lakers",3);
			val h04_won = word("V_2","won",4);
			val h05_the = word("THE","the",5);
			val h06_game = word("N","game",6);

			// create the tree structure for the text;
			val tt =
			_(
				_(
					t01_the
					,
					_(
						t02_los
						,
						_(
							t03_angeles
							,
							t04_lakers
							,
							12
						)
						,
						13
					)
					,
					14
				)
				,
				_(
					t05_won
					,
					_(
						t06_the
						,
						t07_game
						,
						9
					)
					,
					10
				)
				,
				11
			)
			;

			// create the tree structure for the hypothesis;
			val th =
			_(
				_(
					h01_the
					,
					_(
						h02_la
						,
						h03_lakers
						,
						11
					)
					,
					12
				)
				,
				_(
					h04_won
					,
					_(
						h05_the
						,
						h06_game
						,
						8
					)
					,
					9
				)
				,
				10
			)
			;

			// create the subsumption relations;
		List<Pair<Integer,Integer>> subs = Lists.newArrayList();
		subs.add(new IPair<Integer,Integer>(13,11));

			// test for a proof;
			assertProof(tt, th, subs);
			// test the testcasecreator;
			testTestCaseCreator(tt, th, Proof, subs);
		}

}
