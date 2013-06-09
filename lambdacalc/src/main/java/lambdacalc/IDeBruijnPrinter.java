package lambdacalc;


import static lambdacalc.DeBruijnPredicate.IsVariable;
import static lombok.AccessLevel.PRIVATE;
import lambdacalc.DeBruijn.Visitor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;


@RequiredArgsConstructor
@FieldDefaults(makeFinal=true,level=PRIVATE)
public final class IDeBruijnPrinter implements Visitor<String>, DeBruijnPrinter {
	
	TypePrinter typePrinter;
	SymbolPrinter symbolPrinter;

	@Override
	public String format(DeBruijn expr) {
		return expr.accept(this);
	}
	
	@Override
	public final String application(final DeBruijn f, final DeBruijn a) {
		return between(f) + " " + between(a);
	}

	@Override
	public final String abstraction(final Type type, final DeBruijn expr) {
		return "[" + typePrinter.format(type) + "]" + " " + between(expr);
	}

	@Override
	public final String variable(Integer s) {
		return s.toString();
	}

	@Override
	public final String constant(Symbol symbol) {
		return symbolPrinter.format(symbol);
	}
	
	// print an expression between parentheses.
	private final String between(final DeBruijn expr) {
		return expr.accept(IsVariable) ? format(expr) : "(" + format(expr) + ")";
	}
}
