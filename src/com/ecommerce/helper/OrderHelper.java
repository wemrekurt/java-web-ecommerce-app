package com.ecommerce.helper;

import java.util.ArrayList;
import java.util.List;
import com.ecommerce.helper.Pair;

public class OrderHelper {
	private List<Pair> list = new ArrayList<Pair>();
	
	public OrderHelper() {
		list.add(new Pair(1, "Onay Bekliyor"));
		list.add(new Pair(2, "Onaylandı"));
		list.add(new Pair(3, "Paketleniyor"));
		list.add(new Pair(4, "Kargoya Verildi"));
		list.add(new Pair(5, "Teslim Edildi"));
		list.add(new Pair(6, "İptal Edildi"));
	}
	
	public List<Pair> states() {
		return list;
	}
	
	public String getState(int key) {
		String str = "";
		for(Pair item : list){
			if(item.getKey() == key) {
				str = item.getValue();
				break;
			}
		}
		return str;
	}
}
