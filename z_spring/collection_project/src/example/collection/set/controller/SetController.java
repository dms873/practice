package example.collection.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

import example.collection.list.model.DogComparator;
import example.collection.list.model.vo.Dog;

public class SetController {
	
	public void doSet() {
		Set<Dog> set = new HashSet<>();
		// add(Object e) : set 안에 e 추가
		set.add(new Dog("뽀삐", 2.2));
		set.add(new Dog("모모", 2.4));
		set.add(new Dog("마음", 3.3));
		// 순서대로 add가 되지 않은 것을 알 수 있다.
		System.out.println(set); // [모모(2.4kg), 마음(3.3kg), 뽀삐(2.2kg)]
		
		// 중복 값은 저장되지 않는다.
		set.add(new Dog("모모", 2.4));
		System.out.println(set); // [모모(2.4kg), 마음(3.3kg), 뽀삐(2.2kg)]
		
//		set.add(new String("예시1"));
//		set.add(new String("예시2"));
//		set.add(new String("예시1"));
//		System.out.println(set);
		
		Set<Dog> set2 = new LinkedHashSet<Dog>();
		set2.add(new Dog("초코", 2.1));
		set2.add(new Dog("콩이", 8.3));
		set2.add(new Dog("두부", 5.0));
		set2.add(new Dog("초코", 2.1));
		System.out.println(set2); // [초코(2.1kg), 콩이(8.3kg), 두부(5.0kg)]
		
		set2.add(new Dog("로이", 6.1));
		set2.add(new Dog("공주", 5.2));
		set2.add(new Dog("왕자", 9.5));
		set2.add(new Dog("조이", 12.5));
		// LinkedHashSet 이라서 추가할 때 순서를 유지하는 것을 확인할 수 있다.
		System.out.println(set2); // [초코(2.1kg), 콩이(8.3kg), 두부(5.0kg), 로이(6.1kg), 공주(5.2kg), 왕자(9.5kg), 조이(12.5kg)]
		
		Set<Dog> set3 = new TreeSet<Dog>();
		set3.addAll(set2);
		// 이름 오름차순으로 정렬
		System.out.println(set3); // [공주(5.2kg), 두부(5.0kg), 로이(6.1kg), 왕자(9.5kg), 조이(12.5kg), 초코(2.1kg), 콩이(8.3kg)]
		
		Set<Dog> set4 = new TreeSet<Dog>(new DogComparator());
		set4.addAll(set2);
		set4.add(new Dog("초코", 6.1));
		// 무게 오름차순 정렬
		System.out.println(set4); // [초코(2.1kg), 두부(5.0kg), 공주(5.2kg), 로이(6.1kg), 초코(6.1kg), 콩이(8.3kg), 왕자(9.5kg), 조이(12.5kg)]
		
		// Set 요소에 접근하기 1 : addAll() 메소드를 통해 List화
		List<Dog> list = new ArrayList<Dog>();
		// index가 생김
		list.addAll(set4);
		System.out.println(list.get(3)); // 로이(6.1kg)
		
		System.out.println();
		// Set 요소에 접근하기 2 : Iterator
		// 1. iterator는 Collection 인터페이스에 정의(list와 set밖에 못씀)
		// 2. iterator 단방향이어서 재활용 불가능
		
		Iterator<Dog> it = set4.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " "); // 초코(2.1kg) 두부(5.0kg) 공주(5.2kg) 로이(6.1kg) 초코(6.1kg) 콩이(8.3kg) 왕자(9.5kg) 조이(12.5kg) 
		}
		
		while(it.hasNext()) {
			System.out.print("re : " + it.next() + " "); // 나오지 않음(단방향이어서 재활용 불가능)
		}
		
//		ListIterator lit = (ListIterator)set4.iterator();
//		while(lit.hasNext()) {
//			System.out.println(lit.next());
//		}
		
		// ListIterator는 양방향이어서 이전 값을 읽을 수 있다.
		ListIterator<Dog> lit = list.listIterator();
		while(lit.hasNext()) {
			System.out.print(lit.next() + " "); // 초코(2.1kg) 두부(5.0kg) 공주(5.2kg) 로이(6.1kg) 초코(6.1kg) 콩이(8.3kg) 왕자(9.5kg) 조이(12.5kg)
		}
		System.out.println();
		while(lit.hasPrevious()) {
			System.out.print(lit.previous() + " "); // 조이(12.5kg) 왕자(9.5kg) 콩이(8.3kg) 초코(6.1kg) 로이(6.1kg) 공주(5.2kg) 두부(5.0kg) 초코(2.1kg) 
		}
		
	}
}
