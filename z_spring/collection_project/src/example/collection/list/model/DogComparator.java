package example.collection.list.model;

import java.util.Comparator;

import example.collection.list.model.vo.Dog;

public class DogComparator implements Comparator<Dog> {
	
	@Override
	public int compare(Dog o1, Dog o2) {
		double standard = o1.getWeight();
		double object = o2.getWeight();
		
		if(standard > object) {
			return 1;
		} else if(standard == object) {
			// return 0;
			// 무게가 같을 때 이름을 가지고 오름차순 하기
			String name1 = o1.getName();
			String name2 = o2.getName();
			return name1.compareTo(name2);
		} else {
			return -1;
		}
		
	};
	
}
