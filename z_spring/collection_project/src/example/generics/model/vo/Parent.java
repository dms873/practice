package example.generics.model.vo;

public class Parent<S, D> {

	private S student;
	private D dog;
	public Parent() {
		super();
	}
	public Parent(S student, D dog) {
		super();
		this.student = student;
		this.dog = dog;
	}
	public S getStudent() {
		return student;
	}
	public void setStudent(S student) {
		this.student = student;
	}
	public D getDog() {
		return dog;
	}
	public void setDog(D dog) {
		this.dog = dog;
	}
	@Override
	public String toString() {
		return student + "-" + dog;
	}
	
	

}
