package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBUtil;

public class MemberDAO {
	Connection conn;
	PreparedStatement st;
	static final String SELECTALL_ALL_MEM = "select no, member.name, phone, gender, code, class.name from member join class using (code);";
	static final String SELECTALL_ByMno = "select * from member where mno = ?";
	static final String INSERT_MEM = "insert into member(name, phone, gender, code) values(?,?,?,?)";
//	static final String UPDATE_MEM = "update member set mname = ?, phone = ?, email = ?, birthday = ? where mno = ?";
//	static final String DELETE_MEM = "delete from member where mno = ?";
	
	public void insertMem(String name, String phone, String gender, String code){
		try {
			conn = DBUtil.connect();
			st = conn.prepareStatement(INSERT_MEM);
			st.setString(1, name);
			st.setString(2, phone);
			st.setString(3, gender);
			st.setString(4, code);
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private MemberDTO makeMem(ResultSet resultSet) throws SQLException{
		return new MemberDTO(resultSet.getInt("no"), resultSet.getString("member.name"), resultSet.getString("phone"), resultSet.getString("gender"), resultSet.getString("class.name"));
	}
	
	public ArrayList<MemberDTO> selectAllMem() {
		ArrayList<MemberDTO> memList = new ArrayList<>();
		ResultSet rs = null;

		conn = DBUtil.connect();
		try {
			st = conn.prepareStatement(SELECTALL_ALL_MEM);
			rs = st.executeQuery();

			while (rs.next()) {
				MemberDTO mem = makeMem(rs);
				memList.add(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.disconnect(rs, st, conn);
		}

		return memList;
	}
}
