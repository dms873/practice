package example.generics.model.vo;

public class Child<S, D, N> extends Parent<S, D>{
	private N snack;

	public Child() {
		super();
	}

	public Child(N snack) {
		super();
		this.snack = snack;
	}

	public N getSnack() {
		return snack;
	}

	public void setSnack(N snack) {
		this.snack = snack;
	}

	@Override
	public String toString() {
		return super.getStudent() + "-" + super.getDog() + "-" + snack;
	}
	
	
}
