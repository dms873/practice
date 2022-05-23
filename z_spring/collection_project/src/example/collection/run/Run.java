package example.collection.run;

import example.collection.list.controller.ListController;
import example.collection.map.controller.MapController;
import example.collection.set.controller.SetController;

public class Run {

	public static void main(String[] args) {
//		ListController lc = new ListController();
//		lc.doList();
		
//		SetController sc = new SetController();
//		sc.doSet();
		
		MapController mc = new MapController();
		mc.doMap();
//		mc.doProperties();
//		mc.fileSave();
//		mc.fileOpen();
	}
	
}
