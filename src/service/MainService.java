package service;

import datastr.MyGraph;

public class MainService {

	public static void main(String[] args) {
		MyGraph<String> map = new MyGraph<String>();
		try {
			map.addVertice("Ventspils");
			map.addVertice("Riga");
			map.addVertice("Kuldiga");
			map.addVertice("Talsi");
			map.addVertice("Tukums");
			
			map.addEdge(189f, "Ventspils", "Riga");
			map.addEdge(56.49f, "Ventspils", "Kuldiga");
			map.addEdge(64f, "Ventspils", "Talsi");
			map.addEdge(58f, "Tukums", "Riga");
			map.addEdge(148.88f, "Riga", "Kuldiga");
			
			map.print();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
