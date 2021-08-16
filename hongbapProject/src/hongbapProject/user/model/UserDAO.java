/*
 * 회원가입 및 로그인 DAO
UserDAO
DB테이블명은 user
변수 : 
유저 아이디 UserId
유저 비밀번호 UserPw
유저 이름 UserName
유저 이메일 UserEmail
유저 폰번호 UserPnum
 */


package hongbapProject.user.model;
import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO {
	
	private DataSource ds;
	
	// 아이디 삭제 리턴변수
	private static final int ID_DELETE_SUCCESS = 1;
	private static final int ID_DELETE_FAIL = 0;
	
	// 아이디 로그인 리턴변수
	private static final int ID_LOGIN_SUCCESS = 1;
	private static final int ID_LOGIN_FAIL = 0;
	
	// 아이디 수정 리턴변수
	private static final int ID_UPDATE_SUCCESS = 1;
	private static final int ID_UPDATE_FAIL = 0;
	
	// 커넥션 풀
	private UserDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static UserDAO dao = new UserDAO();
	
	public static UserDAO getInstance() {
		return dao;
	}// 여기 까지 커넥션 풀
	
	// 회원 가입
	public int JoinUser(UserVO user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
			con = ds.getConnection();
			String sql = "INSERT INTO user VALUES(?, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPw());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserEmail());
			pstmt.setString(4, user.getUserPnum());
			
			pstmt.executeUpdate();
			
		
		} catch(SQLException e) {
			System.out.println("에러 : "+e);
		} finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}// end JoinUser
	
	// 유저 삭제 
	public int UserDelete(UserDAO user, String UserPw) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			if(user.getUserPw().equals(UserPw)) {
				
			
				con = ds.getConnection();
			String sql = "DELETE FROM user WHERE UserId=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
		
			
			pstmt.executeUpdate();
			
			return ID_DELETE_SUCCESS;
		}else {
			
			return ID_DELETE_FAIL;
		}
		
		} catch(SQLException e) {
			System.out.println("에러 : "+e);
		} finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return ID_DELETE_FAIL;
	}// end UserDelete
	
	// 유저 로그인
	public int UserLogin(UserDAO user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		
		try {
			
			con = ds.getConnection();
			String sql = "SELECT * FROM user WHERE UserId=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
			
			// DB에서 가져오는 아이디, 비번
			String dbId = rs.getString("UserId");
			String dbPw = rs.getString("UserPw");
			
				if(user.getUserId().equals(dbId)&&user.getUserPw().equals(dbPw)) {
					return ID_LOGIN_SUCCESS;
				} else {
					return ID_LOGIN_FAIL;
				}
				
			} else {
				return ID_LOGIN_FAIL;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}  finally{
			try {
			if(con != null && !con.isClosed()){
			con.close();
			}
			if(pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			if(rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
		return ID_LOGIN_FAIL;
	}// end UserLogin 
	
	// 수정을 위한 유저 정보 
	public UserVO GetUserInfo(UserVO user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		UserVO resultData = new UserVO();
		
		
		try {
			
			con = ds.getConnection();
			String sql = "SELECT * FROM user WHERE UserId=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				resultData.setUserId(rs.getString("UserId"));
				resultData.setUserPw(rs.getString("UserPw"));
				resultData.setUserName(rs.getString("UserName"));
				resultData.setUserEmail(rs.getString("UserEmail"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
		}  finally{
			try {
			if(con != null && !con.isClosed()){
			con.close();
			}
			if(pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			if(rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
		return resultData;
		
}// end GetUserInfo
	
	// 유저 수정
	public int UserUpdate(UserVO user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
				
			
			
			con = ds.getConnection();
			String sql = "UPDATE user SET UserPw=?, UserName=?, UserEmail=? WHERE UserId=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserPw());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserEmail());
			pstmt.setString(4, user.getUserId());
		
			
			pstmt.executeUpdate();
			
			return ID_UPDATE_SUCCESS;
		
			
			
		
		
		} catch(SQLException e) {
			System.out.println("에러 : "+e);
		} finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return ID_UPDATE_FAIL;
	}// end userUpdate
	
	// 유저 정보 리스트
	public ArrayList<UserVO> GetAllUser() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<UserVO> userList = new ArrayList<>();
		
		try {
			
			con = ds.getConnection();
			String sql = "SELECT * FROM user";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				UserVO user = new UserVO();
				String UserId = rs.getString("UserId");
				String UserPw = rs.getString("UserPw");
				String UserName = rs.getString("UserName");
				String UserEmail = rs.getString("UserEmail");
				user.setUserId(UserId);
				user.setUserPw(UserPw);
				user.setUserName(UserName);
				user.setUserEmail(UserEmail);
				userList.add(user);
			}
			
			} catch(SQLException e) {
				System.out.println("에러 : "+e);
			} finally {
				try {
					if(con != null && !con.isClosed()) {
						con.close();
					}
					if(pstmt != null && !pstmt.isClosed()) {
						pstmt.close();
					}
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}	
			return userList;
		}// end GetAllUser
	}


