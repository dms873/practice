package example.collection.map.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import example.collection.map.model.SnackComparator;
import example.collection.map.model.vo.Snack;

public class MapController {
	public void doMap() {
		
		Map<String, Snack> map = new HashMap<>();
		
		// put(K key, V value) : 키와 값 추가, 추가 성공 시 value 반환
		map.put("새우깡", new Snack("짠맛", 1500));
		map.put("다이제", new Snack("단맛", 2500));
		map.put("포테이토칩", new Snack("짠맛", 1500));
		map.put("고소미", new Snack("고소한 맛", 1500));
		System.out.println(map); // {다이제=단맛[2500원], 새우깡=짠맛[1500원], 포테이토칩=짠맛[1500원], 고소미=고소한 맛[1500원]}
		
		map.put("새우깡", new Snack("매운맛", 1500));
		// key가 중복이 되면 값을 덮어 씌운다.
		System.out.println(map); // {다이제=단맛[2500원], 새우깡=매운맛[1500원], 포테이토칩=짠맛[1500원], 고소미=고소한 맛[1500원]}
		
		// containsKey(Object key) : key가 있으면 true 반환
		// containsValue(Object value) : value가 있으면 true 반환
		System.out.println(map.containsKey("새우깡")); // true
		System.out.println(map.containsValue(new Snack("짠맛", 1500))); // true
		
		// get(Object key) : 키의 값 반환
		System.out.println(map.get("새우깡")); // 매운맛[1500원]
		System.out.println(map.get("홈런볼")); // null
		
		// map 엘리먼트 접근하기
		// 1. values() : 모든 value를 Collection에 담아 반환
		System.out.println(map.values()); // [단맛[2500원], 매운맛[1500원], 짠맛[1500원], 고소한 맛[1500원]]
		
		System.out.println();
		
		// 2. keySet() : 모든 key를 Set에 담아 반환
		// 2-1. keySet() + Iterator
		Set<String> set1 = map.keySet();
		Iterator<String> it1 = set1.iterator();
		while(it1.hasNext()) {
			// Object key = it1.next();
			String key = it1.next();
			System.out.printf("키 : %s, 값 : %s%n", key, map.get(key));
			/**
			 * 키 : 다이제, 값 : 단맛[2500원]
			 * 키 : 새우깡, 값 : 매운맛[1500원]
			 * 키 : 포테이토칩, 값 : 짠맛[1500원]
			 * 키 : 고소미, 값 : 고소한 맛[1500원]
			 */
		}
		
		System.out.println();
		
		// 2-2. keySet()
//		int[] arr = {1, 2, 3, 4};
//		for(int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
//		
//		for(int i : arr) {
//			System.out.println(i);
//		}
		
		for(String o : map.keySet()) {
			System.out.printf("키 : %s, 값 : %s%n", o, map.get(o));
			/**
			 * 키 : 다이제, 값 : 단맛[2500원]
			 * 키 : 새우깡, 값 : 매운맛[1500원]
			 * 키 : 포테이토칩, 값 : 짠맛[1500원]
			 * 키 : 고소미, 값 : 고소한 맛[1500원]
			 */
		}
		
		System.out.println();
		
		// 3. entrySet() : 모든 entry(키 + 값의 쌍)를 set에 담아 반환
		// 3-1. entrySet() + Iterator
		Set<Entry<String, Snack>> set2 = map.entrySet();
		Iterator<Entry<String, Snack>> it2 = set2.iterator();
		while(it2.hasNext()) {
			Entry<String, Snack> me = it2.next();
			System.out.printf("키 : %s, 값 : %s%n", me.getKey(), me.getValue());
			/**
			 * 키 : 다이제, 값 : 단맛[2500원]
			 * 키 : 새우깡, 값 : 매운맛[1500원]
			 * 키 : 포테이토칩, 값 : 짠맛[1500원]
			 * 키 : 고소미, 값 : 고소한 맛[1500원]
			 */
		}
		
		System.out.println();
		
		// 3-2. entrySet()
		for(Entry<String, Snack> o : set2) {
			System.out.printf("키 : %s, 값 : %s%n", o.getKey(), o.getValue());
			/**
			 * 키 : 다이제, 값 : 단맛[2500원]
			 * 키 : 새우깡, 값 : 매운맛[1500원]
			 * 키 : 포테이토칩, 값 : 짠맛[1500원]
			 * 키 : 고소미, 값 : 고소한 맛[1500원]
			 */
			
//			 Map.Entry me = (Map.Entry)o;
//			 System.out.printf("키 : %s, 값 : %s%n", me.getKey(), me.getValue());
		}
		
		System.out.println();
		
		Map<String, Snack> map2 = new TreeMap<>();
		// putAll(Map m) : m에 있는 객체 저장
		map2.putAll(map);
		System.out.println(map2); // {고소미=고소한 맛[1500원], 다이제=단맛[2500원], 새우깡=매운맛[1500원], 포테이토칩=짠맛[1500원]}
		
		// 내림차순
		Map<String, Snack> map3 = new TreeMap<>(new SnackComparator());
		map3.putAll(map2);
		System.out.println(map3); // {포테이토칩=짠맛[1500원], 새우깡=매운맛[1500원], 다이제=단맛[2500원], 고소미=고소한 맛[1500원]}
		
		// size() : map에 저장된 entry 수 반환
		// remove(Object key) : 해당 key의 entry 삭제 후 해당 값 반환
		// remove(Object key, Object value) : 해당 키와 값이 맞으면 삭제 후 true 반환
		// clear() : 모든 entry 삭제
		// isEmpty() : map이 비어있으면 true 반환
		
	}
	
	public void doProperties() {
		
		Properties prop = new Properties();
		// prop.put("간식", "사탕");
		// prop.put(1, 10);
		
		// setProperty(String key, String value) : 키와 값을 넣고 Object(null) 반환
		prop.setProperty("채소", "오이");
		prop.setProperty("과일", "사과");
		prop.setProperty("간식", "젤리");
		prop.setProperty("채소", "피망");
		// 순서 유지 되지 않고, 중복 되는 값 덮어쓰기됨.
		System.out.println(prop); // {채소=피망, 과일=사과, 간식=젤리}
		
		// getProperty(String key) : key를 통해서 value 반환
		System.out.println(prop.getProperty("채소")); // 피망
		
		// getProperty(String key, String defaultValue)
		// : key를 통해서 value 반환, key가 존재하지 않는다면 defaultValue 반환
		System.out.println(prop.getProperty("채소", "버섯")); // 피망
		System.out.println(prop.getProperty("과목", "수학")); // 수학
		
		Enumeration<?> e = prop.propertyNames();
		while(e.hasMoreElements()) {
			String key = (String) e.nextElement();
			System.out.println(key + "/" + prop.getProperty(key)); 
			/*
			 * 과일/사과
			 * 채소/피망
			 * 간식/젤리
			 */
		}
		
	}
	
	public void fileSave() {
		try(FileOutputStream fos = new FileOutputStream("test.properties")) {
			Properties prop = new Properties();
			prop.setProperty("title", "Properties Practice");
			prop.setProperty("width", "1920");
			prop.setProperty("height", "1080");
			prop.setProperty("language", "kor");
			
			// store(OutputStream out, String comments)
			// : out에 prop 저장, comments는 주석으로 맨 위에 저장됨
			prop.store(fos, "Properties Test File");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileOpen() {
		try(FileInputStream fis = new FileInputStream("test.properties")) {
			Properties prop = new Properties();
			// load(InputStream inStream) : inStream에 있는 Properties 읽어옴
			prop.load(fis);
			System.out.println(prop); // {width=1920, language=kor, title=Properties Practice, height=1080}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
