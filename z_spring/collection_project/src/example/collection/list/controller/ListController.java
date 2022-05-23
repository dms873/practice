package example.collection.list.controller;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

import example.collection.list.model.StudentComparator;
import example.collection.list.model.vo.Student;

public class ListController {
	public void doList() {
		// Student객체 혹은 Student 자식 객체만 넣을 수 있도록 제한함.
		List<Student> list = new ArrayList<Student>(3); // 크기가 3인 ArrayList 생성(크기 지정)
		
		// add(E e) : 리스트 끝에 데이터 e 추가
		list.add(new Student("테스트", 0));
		list.add(new Student("도대담", 60)); // list에 Student 객체 삽입
		System.out.println("list : " + list); // list : [name : 테스트 / score : 0, name : 도대담 / score : 60]
		
		// 1. 크기의 제약이 없다.
		list.add(new Student("남나나", 90));
		// size() : 리스트에 있는 element 개수 반환
		System.out.println("현재 list에 담긴 element 개수 : " + list.size()); // 현재 list에 담긴 element 개수 : 3
		
		list.add(new Student("하현호", 85));
		list.add(new Student("문미미", 66));
		System.out.println("list : " + list); // list : [name : 테스트 / score : 0, name : 도대담 / score : 60, name : 남나나 / score : 90, name : 하현호 / score : 85, name : 문미미 / score : 66]
		System.out.println("현재 list에 담긴 element 개수 : " + list.size()); // 현재 list에 담긴 element 개수 : 5
		
		System.out.println();
		
		// 2. 추가/삭제.정렬 등의 기능 처리가 간단하다.
		// add(int index, E e) : index번째 인덱스에 E 추가
		list.add(0, new Student("류라라", 100));
		System.out.println("list : " + list); // list : [name : 류라라 / score : 100, name : 테스트 / score : 0, name : 도대담 / score : 60, name : 남나나 / score : 90, name : 하현호 / score : 85, name : 문미미 / score : 66]
		
		// remove(Object o) : 해당 Object 객체 삭제
		list.remove(new Student("테스트", 0));
		System.out.println("list : " + list); // list : [name : 류라라 / score : 100, name : 도대담 / score : 60, name : 남나나 / score : 90, name : 하현호 / score : 85, name : 문미미 / score : 66]
		// remove(int index) : 해당 index번째 객체 삭제
		list.remove(1);
		System.out.println("list : " + list); // list : [name : 류라라 / score : 100, name : 남나나 / score : 90, name : 하현호 / score : 85, name : 문미미 / score : 66]
		
		// 정렬 방법 1. Collections 클래스 이용
//		Collections.sort(list);
//		System.out.println("list 정렬 1 : " + list); // [name : 하현호 / score : 85, name : 문미미 / score : 66, name : 류라라 / score : 100, name : 남나나 / score : 90]
//		Collections.sort(list, new StudentComparator());
//		System.out.println("list 정렬 2 : " + list); // [name : 문미미 / score : 66, name : 하현호 / score : 85, name : 남나나 / score : 90, name : 류라라 / score : 100]
		
		// 정렬 방법 2. List 안에 있는 sort() 메소드 이용
		list.sort(new StudentComparator());
		System.out.println("list 정렬 3 : " + list); // list 정렬 3 : [name : 문미미 / score : 66, name : 하현호 / score : 85, name : 남나나 / score : 90, name : 류라라 / score : 100]
		
		System.out.println();
		
		// 3. 여러 타입의 데이터를 저장 가능하다.
//		list.add("끝"); // 제네릭때문에 타입 제한으로 에러남(String이 아니라 Student객체여야 함)
//		System.out.println("새로운 타입 삽입 : " + list); // 새로운 타입 삽입 : [name : 문미미 / score : 66, name : 하현호 / score : 85, name : 남나나 / score : 90, name : 류라라 / score : 100, 끝]
		
		// set(int index, E e) : index번째 인덱스에 있는 요소를 E 요소로 수정
		list.set(2, new Student("도대담", 31));
		System.out.println("list 수정 : " + list); // list 수정 : [name : 문미미 / score : 66, name : 하현호 / score : 85, name : 도대담 / score : 31, name : 류라라 / score : 100]
		
		System.out.println();
		
		// subList(int index1, int index2)
		// : index1번째 인덱스부터 index2번째 인덱스까지의 리스트 반환
		// index1 <= subList < index2
		List<Student> copyList = list.subList(2, 4);
		System.out.println("list 추출 : " + copyList); // list 추출 : [name : 도대담 / score : 31, name : 류라라 / score : 100]
		
		System.out.println();
		
		// retainAll(Collection c) : c와 겹치는 부분만 빼고 모두 삭제
		list.retainAll(copyList);
		System.out.println("list 중복 부분 삭제 : " + list); // list 중복 부분 삭제 : [name : 도대담 / score : 31, name : 류라라 / score : 100]
		
		System.out.println();
		
		// contains(Object o) : o가 리스트에 존재한다면 true 반환
		// indexOf(Object o) : 리스트에 o객체의 인덱스 번호 반환, o가 없다면 -1 반환
		// get(int index) : index번째 인덱스에 있는 객체 반환
		if(list.contains(new Student("류라라", 100))) {
			int index = list.indexOf(new Student("류라라", 100));
			Student std = (Student)list.get(index);
			System.out.println(std.getName() + "님의 점수는 " + std.getScore() + "점 입니다."); // 류라라님의 점수는 100점 입니다.
		} else {
			System.out.println("존재하지 않습니다.");
		}
		
		System.out.println();
		
		// clear() : 저장된 모든 객체 삭제
		// isEmpty() : 리스트가 비었을 때 true 반환
		list.clear();
		System.out.println("list : " + list); // list : []
		System.out.println("list가 비었나요? " + list.isEmpty()); // list가 비었나요? true
		
	}
}
