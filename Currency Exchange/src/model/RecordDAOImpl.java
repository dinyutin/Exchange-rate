package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RecordDAOImpl implements RecordDAO {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/calculate_record?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "123";
	
	
	private static final String INSERT_STMT = 
			"INSERT INTO calculate_record.calculate_record (rate, currency, price, discount, result, record_time) VALUES (?, ?, ?, ?, ?,NOW())";
	
	@Override
	public void insert(RecordVO recordVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setDouble(1, recordVO.getRate());
			pstmt.setString(2, recordVO.getCurrency());
			pstmt.setDouble(3, recordVO.getPrice());
			pstmt.setDouble(4, recordVO.getDiscount());
			pstmt.setDouble(5, recordVO.getResult());	

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}
	public static void main(String[] args) {
		RecordDAOImpl dao =new RecordDAOImpl();
		RecordVO recordVO = new RecordVO();
		recordVO.setRate(1.0);
		recordVO.setCurrency("TWD");
		recordVO.setPrice(1.0);
		recordVO.setDiscount(1.0);
		recordVO.setResult(1.0);
		dao.insert(recordVO);	
		
	}		
	
}
