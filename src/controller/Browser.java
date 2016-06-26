package controller;

import java.util.ArrayList;

import model.MemberDAO;
import model.MemberDTO;
import view.MemberView;

public class Browser {
	static MemberDAO dao = new MemberDAO();
	static ArrayList<MemberDTO> memList;
	public static void main(String[] args) {
		 memList = dao.selectAllMem();
		 MemberView.print(memList);
//		String name = "simon";
//		String phone = "010-9481-9054";
//		String gender = "M";
//		String code = "C";
//		dao.insertMem(name, phone, gender, code);
	}
}