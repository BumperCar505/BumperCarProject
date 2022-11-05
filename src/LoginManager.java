// 로그인 유저 정보만 포함하기때문에 암호는 없음
public class LoginManager {
	private String seperator;
	private String id;
	
	private LoginManager() {
		seperator = null;
		id = null;
	}
	
	private static class LoginManagerHolder {
		private static final LoginManager member = new LoginManager();
	}
	
	public static LoginManager getInstance() {
		return LoginManagerHolder.member;
	}
	
	public String getSeperator() {
		return seperator;
	}
	
	public String getId() {
		return id;
	}
	
	public boolean login(String seperator, String id) {
		if(this.seperator == null && id == null) {
			this.seperator = seperator;
			this.id = id;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean logout() {
		if(seperator != null && id != null) {
			seperator = null;
			id = null;
			return true;
		} else {
			return false;
		}
	}
}
