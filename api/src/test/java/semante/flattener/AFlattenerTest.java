package semante.flattener;

import java.util.List;

import lambdacalc.DeBruijn;
import lambdacalc.STL;
import lombok.val;
import semante.ATest;
import semante.Entailment;
import semante.flattener.impl.IFlattenTree;
import semante.flattener.impl.ITreePrinter;
import semante.lexicon.RichLexicon;
import semante.lexicon.impl.IRichLexicon;
import semante.pipeline.Annotation;
import semante.pipeline.BinaryTree;
import semante.pipeline.Either;
import semante.pipeline.Pair;
import semante.pipeline.Result;
import semante.pipeline.SimpleBinaryTree;
import semante.pipeline.impl.IAnnotation;
import semante.pipeline.impl.IBinaryTree;
import semante.pipeline.impl.ILabeller;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public abstract class AFlattenerTest extends ATest {

	private STL stl;
	private RichLexicon lexicon;
	
	protected String textReference;
	protected String hypoReference;
	protected Entailment entailment;
	
	// set up resources

	protected abstract Entailment createEntailment() throws Exception;
	protected abstract void setReferences();
	
	protected final void doSetUp() throws Exception {
		val loader  = Thread.currentThread().getContextClassLoader();
		val lexicon = loader.getResourceAsStream("./semante/flattener/AFlattenerTest.lexicon");
		this.stl        = new STL();
		this.lexicon    = new IRichLexicon(lexicon,stl);
		this.entailment = createEntailment();
		this.setReferences();
	}
	
	// perform the tests
	
	private final void runTest(SimpleBinaryTree<Pair<String,String>> input0, final String reference) {
		val labeller  = new ILabeller();
		val printer   = new ITreePrinter<Integer>();
		val flattener = new IFlattenTree<Integer>(stl, lexicon, printer);
		
		val input1 = labeller.label(input0);
		val input2 = input1.accept(ANNOTATE);
		val input3 = flattener.flatten(input2);
		
		System.err.println("References:");
		System.err.println(" - " + reference);
		System.err.println("Results:");
		
		input3.accept(new Either.Visitor<Result<Integer>,List<DeBruijn>,Void>() {

			@Override
			public final Void left(Result<Integer> result) {
				throw new RuntimeException("Error in flattening "+result);
			}

			@Override
			public final Void right(final List<DeBruijn> results) {
				if (! Iterables.any(results, new Predicate<DeBruijn>() {

					@Override
					public final boolean apply(final DeBruijn result0) {
						val result1 = stl.format(stl.fromDeBruijn(stl.betaReduce(result0)));
						System.err.println(" - " + result1);
						return result1.equals(reference);
					}
					
				})) {
					
					throw new RuntimeException("No result matched reference.");
					
				}
				else {
					
					return null;
					
				}
			}
			
		});
	}
	
	protected void flattenTest() {
		runTest(entailment.getText(),textReference);
		runTest(entailment.getHypothesis(),hypoReference);
	}
	
	// setup the reference files
	
	BinaryTree.Visitor<Integer,Pair<String,String>,BinaryTree<Integer,Annotation>>
		ANNOTATE = IBinaryTree.functor(
			Functions.<Integer> identity(),
				new Function<Pair<String,String>,Annotation>() {
					@Override
					public final Annotation apply(final Pair<String,String> pair) {
						return new IAnnotation(pair.getFirst(),pair.getSecond());
					}
			});
}
