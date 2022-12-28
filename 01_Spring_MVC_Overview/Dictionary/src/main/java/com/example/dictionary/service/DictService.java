package com.example.dictionary.service;

import java.util.HashMap;
import java.util.Map;

public class DictService {
    private static Map<String, String> dict;

    static {
        dict = new HashMap<>();
        dict.put("book", "quyển sách");
        dict.put("pen", "chiếc bút");
        dict.put("apple", "quả táo");
        dict.put("table", "cái bàn");
        dict.put("orange", "quả cam");
        dict.put("watch", "đồng hồ");
    }

    public String find(String input) {
        for (Map.Entry<String,String> entry: dict.entrySet() ) {
            if (input.trim().toLowerCase().equals(entry.getKey())) {
                return entry.getValue().toUpperCase();
            }
        }
        return "not found";
    }
}
