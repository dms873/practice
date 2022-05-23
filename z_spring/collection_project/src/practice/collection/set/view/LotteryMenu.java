package practice.collection.set.view;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import practice.collection.set.controller.LotteryController;
import practice.collection.set.model.vo.Lottery;

public class LotteryMenu {
	private Scanner sc = new Scanner(System.in);
	private LotteryController lc = new LotteryController();
	
	public void mainMenu() {
		System.out.println("======== KH 추첨 프로그램 ========");
		
		int menuNum = 0;
		while(menuNum != 9) {
			System.out.println("=====***** 메인 메뉴 *****=====");
			System.out.println("1. 추첨 대상 추가");
			System.out.println("2. 추첨 대상 삭제");
			System.out.println("3. 당첨 대상 확인");
			System.out.println("4. 정렬된 당첨 대상 확인");
			System.out.println("5. 당첨 대상 검색");
			System.out.println("9. 종료");
			
			System.out.println();
			System.out.print("메뉴 번호 입력 : ");
			menuNum = Integer.parseInt(sc.nextLine());
			
			switch (menuNum) {
			case 1:
				insertObject();
				break;
			case 2:
				deleteObject();
				break;
			case 3:
				winObject();
				break;
			case 4:
				sortedWinObject();
				break;
			case 5:
				searchWinner();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;

			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void insertObject() {
		System.out.print("추가할 추첨 대상 수 : ");
		int lotteryObject = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < lotteryObject; i++) {
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("핸드폰 번호('-'빼고) : ");
			String phone = sc.nextLine();
			
			Lottery l = new Lottery(name, phone);
			boolean result = lc.insertObject(l);
			if(!result) {
				i--;
				System.out.println("중복된 대상입니다. 다시 입력하세요.");
			}
			System.out.println();
		}
		System.out.println(lotteryObject + "명 추가 완료되었습니다.");
	}
	
	public void deleteObject() {
		System.out.println("삭제할 대상의 이름과 핸드폰 번호를 입력하세요.");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("핸드폰 번호('-'빼고) : ");
		String phone = sc.nextLine();
		
		Lottery l = new Lottery(name, phone);
		boolean result = lc.deleteObject(l);
		
		if(result)
			System.out.println("삭제 완료되었습니다.");
		else
			System.out.println("존재하지 않는 대상입니다.");
	}
	
	public void winObject() {
		System.out.println(lc.winObject());
	}
	
	public void sortedWinObject() {
		TreeSet set = lc.sortedWinObject();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public void searchWinner() {
		System.out.println("검색할 대상의 이름과 핸드폰 번호를 입력하세요");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("핸드폰 번호('-'빼고) : ");
		String phone = sc.nextLine();
		
		Lottery l = new Lottery(name, phone);
		boolean result = lc.searchWinner(l);
		
		if(result)
			System.out.println("축하합니다. 당첨 목록에 존재합니다.");
		else
			System.out.println("안타깝지만 당첨 목록에 존재하지 않습니다.");
		
		
	}
	
}
