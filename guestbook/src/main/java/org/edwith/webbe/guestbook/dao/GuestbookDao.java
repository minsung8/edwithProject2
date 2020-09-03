package org.edwith.webbe.guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
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

		try {
			conn = DBUtil.getConn();
			
			String sql = "select id, name, content, regdate from guestbook";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
					
			while (rs.next()) {
				
				long id = rs.getInt("id");
				String name = rs.getString("name");
				String content = rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regdate");
				Guestbook dto = new Guestbook(id, name, content, regdate);
				list.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
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
		}
    	
    }
}
