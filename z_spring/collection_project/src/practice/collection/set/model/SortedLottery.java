package practice.collection.set.model;

import java.util.Comparator;

import practice.collection.set.model.vo.Lottery;

public class SortedLottery implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		String standared = ((Lottery)o1).getName();
		String object = ((Lottery)o2).getName();
		
		if(standared.equals(object)) {
			String standardPhone = ((Lottery)o1).getPhone();
			String objectPhone = ((Lottery)o2).getPhone();
			
			return standardPhone.compareTo(objectPhone);
		}
		return standared.compareTo(object);
	}

}
