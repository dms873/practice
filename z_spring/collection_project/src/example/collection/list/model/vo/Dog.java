package example.collection.list.model.vo;

public class Dog implements Comparable<Dog>{
	
	private String name;
	private double weight;
	public Dog() {
		super();
	}
	public Dog(String name, double weight) {
		super();
		this.name = name;
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int)weight;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		
		Dog other = (Dog) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Dog o) {
		String other = o.getName();
		return name.compareTo(other);
	}
	
	@Override
	public String toString() {
		return name + "(" + weight + "kg)";
	}
	

}
