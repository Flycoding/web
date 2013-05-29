package com.flyingh.db.util;

import java.util.LinkedHashMap;
import java.util.Map;

import com.flyingh.vo.Book;

public class DB {
	private static Map<Integer, Book> map = new LinkedHashMap<>();
	static {
		map.put(1, new Book(1, "Java", "zhangsan", 88));
		map.put(2, new Book(2, "C++", "lisi", 85));
		map.put(3, new Book(3, "Java Web", "wangwu", 89));
		map.put(4, new Book(4, "Spring", "zhaoliu", 100));
		map.put(5, new Book(5, "Android", "sunqi", 99.9f));
	}

	public static Map<Integer, Book> getAll() {
		return map;
	}

	public static Book get(int id) {
		return map.get(id);
	}
}
