package practice.collection.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import practice.collection.set.model.SortedLottery;
import practice.collection.set.model.vo.Lottery;

public class LotteryController {
	
	private HashSet lottery = new HashSet();
	private HashSet win = new HashSet();

	public boolean insertObject(Lottery l) {
		boolean result = lottery.add(l);
		
		return result;
	}
	
	public boolean deleteObject(Lottery l) {
		boolean result = lottery.remove(l);
		
		if(win != null && result)
			win.remove(l);
		
		return result;
	}
	
	public HashSet winObject() {
		ArrayList list = new ArrayList(lottery);
		
		while(win.size() != 4) {
			int num = (int)(Math.random() * list.size());
			win.add(list.get(num));
		}
		return win;
	}
	
	public boolean searchWinner(Lottery l) {
		boolean result = win.contains(l);
		return result;
	}

	public TreeSet sortedWinObject() {
		TreeSet sort = new TreeSet(new SortedLottery());
		sort.addAll(win);
		return sort;
	}

}
