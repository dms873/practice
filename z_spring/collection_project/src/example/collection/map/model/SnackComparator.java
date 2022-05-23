package example.collection.map.model;

import java.util.Comparator;

public class SnackComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		String standard = o1;
		String object = o2;
		
		
		return -standard.compareTo(object);
	}
	
}
