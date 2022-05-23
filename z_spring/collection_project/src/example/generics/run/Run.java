package example.generics.run;

import java.util.ArrayList;
import java.util.Stack;

import example.generics.controller.GenericsController;
import example.generics.model.vo.Child;
import example.generics.model.vo.Parent;

public class Run {

	public static void main(String[] args) {
		
		GenericsController gc = new GenericsController();
		
		Stack s1 = new Stack();
		Stack s2 = new Stack();
		// Stack은 Parent의 자식이 아니기 때문에 에러
		// gc.method1(s1, s2);
		
		Child c1 = new Child();
		Child c2 = new Child();
		gc.method1(c1, c2);
		
		Parent p1 = new Parent();
		Parent p2 = new Parent();
		gc.method1(p1, p2);
		
		ArrayList<Parent> a1 = new ArrayList<>();
		gc.method6(a1);
		
		ArrayList<Child> a2 = new ArrayList<>();
		gc.method6(a2);
		
//		ArrayList<Number> a3 = new ArrayList<Number>();
//		a3.add(new Integer(3));
//		a3.add(new Double(3));
//		a3.add(new Long(3));
	}
	
}
