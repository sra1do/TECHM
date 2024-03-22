package Repositaries;

import java.util.*;

import Entities.Subject;

import java.sql.*;
class SubjectDAOImpl implements SubjectDAO {
	private static SubjectDAOImpl ob=null;
	private Connection contodb=null;
	private SubjectDAOImpl() {}
	public static SubjectDAOImpl returnInstance() {
		if(ob==null)
			ob=new SubjectDAOImpl();
		return ob;
	}
	public boolean createConnection()throws Exception {
		contodb=DriverManager.getConnection(
	       "jdbc:mysql://localhost:3306/8cse","root","sravan");
		Class.forName("com.mysql.cj.jdbc.Driver");
		if(contodb!=null)
			return true;
		else
			return false; 
	}
	public int insertSubject(Subject s) {
		int response=0;
		try {
		PreparedStatement ps=contodb.prepareStatement(
				"insert into subject values(?,?,?)");
		ps.setString(1, s.getSubjectCode());
		ps.setString(2, s.getSubjectName());
		ps.setInt(3, s.getCredit());
		response=ps.executeUpdate();
		}catch(Exception e) {}
		return response;
	}
	public int updateSubject(String sid,Subject s) {
		int response=0;
		try {
		PreparedStatement ps=contodb.prepareStatement(
				"update subject set subName=?,credit=? where subcode=? ");
		ps.setString(1, s.getSubjectName());
		ps.setInt(2, s.getCredit());
		ps.setString(3, sid);
		response=ps.executeUpdate();
		}catch(Exception e) {}
		return response;
	}
	public int deleteSubject(String scode) {
		int response=0;
		try {
		PreparedStatement ps=contodb.prepareStatement(
				"delete from subject where where subcode=? ");
		ps.setString(1, scode);
		response=ps.executeUpdate();
		}catch(Exception e) {}
			return response;
	}
	public List<Subject> fetchAllSubject(){
		List<Subject> subjectsFetched=new ArrayList<Subject>();
		try {
			PreparedStatement ps=contodb.prepareStatement(
					"select * from subject ");
			ResultSet rs=ps.executeQuery();
			Subject s=new Subject();
			while(rs.next()) {
			s.setSubjectCode(rs.getString(1));
			s.setSubjectName(rs.getString(2));
			s.setCredit(rs.getInt(3));
			subjectsFetched.add(s);
			}
			}catch(Exception e) {}
		return subjectsFetched;
	}
	public Subject fetchASubject(String scode) {
		Subject subjectFetched=new Subject();
		try {
			PreparedStatement ps=contodb.prepareStatement(
					"select * from subject where subcode=? ");
			ps.setString(1, scode);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				subjectFetched.setSubjectCode(rs.getString(1));
				subjectFetched.setSubjectName(rs.getString(2));
				subjectFetched.setCredit(rs.getInt(3));
			}
			}catch(Exception e) {}
		return subjectFetched;
	}
}

