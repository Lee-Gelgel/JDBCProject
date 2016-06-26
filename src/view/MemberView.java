package view;

import java.util.ArrayList;

import model.MemberDTO;

public class MemberView {
	
		public static void print(ArrayList<MemberDTO> memList) {
			for (MemberDTO mem : memList) {
				System.out.println(mem);
			}
		}
		
		public static void print(String msg) {
			System.out.println(msg);
		}
}
