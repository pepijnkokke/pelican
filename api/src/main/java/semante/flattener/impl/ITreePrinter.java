package semante.flattener.impl;

import semante.flattener.TreePrinter;
import semante.pipeline.Annotation;
import semante.pipeline.BinaryTree;
import static java.lang.String.format; 

public class ITreePrinter<ID> implements TreePrinter<ID> {

	@Override
	public String leaf(Annotation ann) {
		return format("%s|%s", ann.getText(), ann.getCategory());
	}

	@Override
	public String node(ID _, BinaryTree<ID, Annotation> treeL, BinaryTree<ID, Annotation> treeR) {
		return format("[%s %s]", treeL.accept(this), treeR.accept(this));
	}

}
