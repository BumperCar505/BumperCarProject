// 로그인 유저 정보만 포함하기때문에 암호는 없음
public class LoginManager {
	private String seperator;
	private String comNum;
	private boolean loginStatus;
	
	private LoginManager() {
		seperator = null;
		comNum = null;
		loginStatus = false;
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
	
	public String getComNum() {
		return comNum;
	}
	
	public boolean getLoginStatus() { 
		return loginStatus;
	}
	
	public boolean login(String seperator, String comNum) {
		if(this.seperator == null && comNum == null) {
			this.seperator = seperator;
			this.comNum = comNum;
			this.loginStatus = true;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean logout() {
		if(seperator != null && comNum != null) {
			seperator = null;
			comNum = null;
			loginStatus = false;
			return true;
		} else {
			return false;
		}
	}
}
