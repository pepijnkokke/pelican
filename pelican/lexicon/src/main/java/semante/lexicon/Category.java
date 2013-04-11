package semante.lexicon;

import java.util.List;

import semante.lambdacalc.Expr;
import semante.lambdacalc.TSymbol;

public interface Category<T extends TSymbol> {
	
	/**
	 * Represents the variable name used for the word, as seen below.
	 * <blockquote>
	 * ﻿    Category NP_D λA:et.A:et WORD:e
	 * </blockquote>
	 * Where "WORD" represents the <em>e</em>-type variable that should be inserted.
	 * 
	 * TODO This should probably be read from the lexicon file with a WordName statement.
	 */
	String OldWordName = "WORD";
	
	/**
	 * @return the category's name.
	 */
	String			getName();
	
	/**
	 * @return a list of all the category's possible representations.
	 */
	List<Expr<T>> 	getExpr();
	
	/**
	 * Applies the Category to a word, substituting the word for all occurances
	 * of {@link OldWordName}.
	 * 
	 * @param word the name to use for the word from now on.
	 */
	Word<T> 		apply(String word);
	
}