package example.collection.list.model.vo;

public class Student implements Comparable<Student> {
	private String name;
	private int score;
	public Student() {
		super();
	}
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	@Override
	public String toString() {
		return "name : " + name + " / score : " + score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + score;
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
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (score != other.score)
			return false;
		return true;
	}
	@Override
	public int compareTo(Student o) {
		// 이름 오름차순 정렬
		// 매개변수 Object : 비교할 대상
		String otherName = o.getName();
		
		// return name.compareTo(otherName);
		// 비교 주체가 비교 대상과 같으면 0 반환
		// 비교 주체가 비교 대상보다 크면 1 반환
		// 비교 주체가 비교 대상보다 작으면 -1 반환 ==> 오름차순
		return -name.compareTo(otherName); // 내림차순
	}
	
	
	
	
	
}
