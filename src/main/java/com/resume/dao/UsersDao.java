package com.resume.dao;
import java.sql.*;

import com.resume.entities.Users;
public class UsersDao {

	private Connection con;

	public UsersDao(Connection con) {
		super();
		this.con = con;
	}
	public UsersDao() {}
	
	//method to insert user to database
	boolean f=false;
	public boolean saveUser(Users user) {
		
		try {
			//user-->database
			
			String query="insert into users(name,email,password) values(?,?,?)";
			PreparedStatement pstmt= this.con.prepareStatement(query);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			
			pstmt.executeUpdate();
			
			f=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	 //get user by useremail and userpassword:
    public Users getUserByEmailAndPassword(String email, String password) {
        Users user = null;
        try {

                user = new Users();

            
                
//             set to user object
                user.setName("insiya");
                user.setId(1);
                user.setEmail("insiya@gmail.com");
                user.setPassword("insiya");
                
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
    
    
    public boolean updateUser(Users user) {

        boolean f = false;
        try {

            String query = "update users set name=?, password=? where  id =?";
            PreparedStatement p = con.prepareStatement(query);
            p.setString(1, user.getName());
            p.setString(2, user.getPassword());
            p.setInt(3, user.getId());

            p.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public int getUserCount() {
    	int count= 0;
    	try {
    		String q="select  count(*) from users";
    		PreparedStatement p=this.con.prepareStatement(q);
    		
			ResultSet set=p.executeQuery();
			
			if(set.next()) {
				count=set.getInt("count(*)");
			}
    		
    		
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	return count;
    }
	
	
}