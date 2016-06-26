package model;

public class MemberDTO {
	private int no;
	private String name;
	private String phone;
	private String gender;
	private String className;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Override
	public String toString() {
		return "MemberDTO [no=" + no + ", name=" + name + ", phone=" + phone + ", gender=" + gender + ", className="
				+ className + "]";
	}
	public MemberDTO(int no, String name, String phone, String gender, String className) {
		super();
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.gender = gender;
		this.className = className;
	}
	
}
