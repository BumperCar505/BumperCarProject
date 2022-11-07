import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookMain {

	private final DBManager dbManager = new DBManager();  // DB연결 
//	public UserInfo = new UserInfo();  // 유저 정보 저장 
	
//	화면 닫을 때 발생하는 메서드 
	public void frameClose() {
		dbManager.closeDB();
		System.exit(0);
	}
	
	public Connection getConn() { return dbManager.getConn(); }
	
	public void closeDB(PreparedStatement pstmt, ResultSet rs) { dbManager.closeDB(pstmt, rs); }
	
	public void closeDB(PreparedStatement pstmt) { dbManager.closeDB(pstmt); }
	
	public static void main(String[] args) {
		BookMain bMain = new BookMain();
	}
}
