package example.collection.list.model;

import java.util.Comparator;

import example.collection.list.model.vo.Student;

public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// 오름 차순
		// 비교 주체가 비교 대상보다 크면 양수
		// 비교 주체가 비교 대상보다 작으면 음수
		// 비교 주체가 비교 대상과 같으면 0을 반환
		
		int standard = o1.getScore(); // 주체
		int object = o2.getScore(); // 대상
		
//		if(standard > object) {
//			return -1;
//		} else if(standard == object) {
//			return 0;
//		} else {
//			return 1;
//		} // 내림차순
		
		if(standard > object) {
			return 1;
		} else if(standard == object) {
			return 0;
		} else {
			return -1;
		} // 오름차순
		
	};
	
}
