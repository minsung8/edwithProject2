package org.edwith.webbe.guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.edwith.webbe.guestbook.dto.Guestbook;
import org.edwith.webbe.guestbook.util.DBUtil;

public class GuestbookDao {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null; 
	
	public void close() {
		
		try {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
    public List<Guestbook> getGuestbooks(){
        List<Guestbook> list = new ArrayList<>();

        // 코드를 작성하세요.

        return list;
    }

    public void addGuestbook(Guestbook dto){
        
    	try {
			conn = DBUtil.getConn();
			
			String sql = "insert into guestbook(name, content) values (?, ?)";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getContent());

			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
			DBUtil.closeConn();
		}
    	
    }
}
