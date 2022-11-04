// 로그인 유저 정보
public class LoginMember {
	private String seperator;
	private String id;
	private String pw;
	
	private LoginMember() {}
	
	private static class LoginMemberHolder {
		private static final LoginMember member = new LoginMember();
	}
	
	public static LoginMember getInstance() {
		return LoginMemberHolder.member;
	}
	
	public String getSeperator() {
		return seperator;
	}
	
	public String getId() {
		return id;
	}
	
	public String pw() {
		return pw;
	}
	
	public void setSeperator(String seperator) {
		this.seperator = seperator;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
}
