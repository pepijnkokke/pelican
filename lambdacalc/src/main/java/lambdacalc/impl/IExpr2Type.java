package lambdacalc.impl;

import static lombok.AccessLevel.PRIVATE;
import lambdacalc.Expr;
import lambdacalc.Expr2Type;
import lambdacalc.Symbol;
import lambdacalc.Type;
import lambdacalc.TypeBuilder;
import lambdacalc.Expr.Visitor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@FieldDefaults(makeFinal=true,level=PRIVATE)
public final class IExpr2Type implements Visitor<Type>, Expr2Type {

	TypeBuilder builder;
	
	@Override
	public final Type typeOf(final Expr expr) {
		return expr.accept(this);
	}

	@Override
	public final Type abstraction(final Symbol s, final Expr body) {
		return builder.function(s.getType(),body.accept(this));
	}

	@Override
	public final Type application(final Expr fun, final Expr arg) {
		return arg.accept(this);
	}

	@Override
	public final Type variable(final Symbol s) {
		return s.getType();
	}

}
