package semante.flattener;

import semante.pipeline.Annotation;
import semante.pipeline.BinaryTree;

public interface AnnotationTreePrinter<ID> extends BinaryTree.Visitor<ID, Annotation, String> {

}
