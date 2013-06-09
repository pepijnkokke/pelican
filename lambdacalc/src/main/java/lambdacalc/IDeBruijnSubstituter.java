package lambdacalc;

import static lombok.AccessLevel.PRIVATE;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.Value;

@RequiredArgsConstructor
@FieldDefaults(makeFinal=true,level=PRIVATE)
public final class IDeBruijnSubstituter implements DeBruijnSubstituter {

	DeBruijnBuilder builder;
	
	@Override
	public final DeBruijn substituteTop(DeBruijn expr, DeBruijn subject) {
		return subject.accept(new ISubstituteTop(expr,0));
	}
	
	@Value
	private final class ISubstituteTop implements DeBruijnBuilder {

		DeBruijn expr;
		Integer index;
		
		@Override
		public final DeBruijn abstraction(Type type, DeBruijn body) {
			return builder.abstraction(type, body.accept(withIndex(index + 1)));
		}
		
		@Override
		public final DeBruijn application(DeBruijn fun, DeBruijn arg) {
			return builder.application(fun.accept(this), arg.accept(this));
		}
		
		@Override
		public final DeBruijn variable(Integer i) {
			if (i.equals(index)) {
				return expr;
			}
			else {
				return builder.variable(i);
			}
		}
		
		@Override
		public final DeBruijn constant(Symbol symbol) {
			return builder.constant(symbol);
		}	
	}
}
