package example.generics.controller;

import java.util.ArrayList;
import java.util.Calendar;

import example.collection.list.model.vo.Dog;
import example.collection.map.model.vo.Snack;
import example.generics.model.vo.Parent;

public class GenericsController {
	
	public void doGenerics() {
		
//		Parent<Student, Dog> p = new Parent<>();
//		p.getDog(); // Object(제네릭 안줬을 때)
//		p.getStudent(); // Student
		
		Parent<Integer, String> p = new Parent<>();
		p.getStudent(); // Integer
		p.getDog(); // String
		
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		list2.addAll(list1);
		
		list1.subList(0, 1);
	}
	
	// 구체적인 타입 제한
	// T에는 Parent나 Parent의 자손만 들어갈 수 있다.
	public <T extends Parent<Snack, Dog>> void method1(T t1, T t2) {
		t1.getStudent();
	}
	
	public <T extends Number> void method2(T t) {} // 일반 클래스
	public <T extends Calendar> void method3(T t) {} // 추상 클래스
	public <T extends Readable> void method4(T t) {} // 인터페이스(extends를 사용!)
	public <T extends Number & Readable> void method5(T t) {} // 클래스의 자손이면서 인터페이스 구현(&으로 연결)
	
	// 와일드카드(?) 사용 - ?사용시 모든 객체 받겠다는 의미
	public void method6(ArrayList<? extends Parent> a) {} // ? 타입과 Parent타입의 자손들만 타입 제한
	
	
}
