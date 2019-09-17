package com.CommpanyTest1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.CommpanyTest1.model.Company;
import com.CommpanyTest1.model.Gudong;
import com.CommpanyTest1.util.DBUtil;


import com.CommpanyTest1.model.Links;
import com.CommpanyTest1.model.T_CORP_DIST;
import com.CommpanyTest1.model.ChildrenBean;






public class CompanyDao {
	public List<Company> load(String name) {
		Connection connection = DBUtil.getConnection();
		String sql = "SELECT * FROM d7 WHERE CORP_NAME like ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Company> goods = new ArrayList<Company>();
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				Company c = new Company();
				//c.setORG(rs.getString("ORG"));
				c.setID(rs.getString("ID"));
				c.setSEQ_ID(rs.getString("SEQ_ID"));
				c.setREG_NO(rs.getString("REG_NO"));
				c.setCORP_NAME(rs.getString("CORP_NAME"));
				c.setADDR(rs.getString("ADDR"));
				c.setBELONG_ORG(rs.getString("BELONG_ORG"));
				c.setBELONG_DIST_ORG(rs.getString("BELONG_DIST_ORG"));
				c.setBELONG_TRADE(rs.getString("BELONG_TRADE"));
				c.setECON_KIND(rs.getString("ECON_KIND"));
				c.setADMIT_MAIN(rs.getString("ADMIT_MAIN"));
				c.setSTART_DATE(rs.getString("START_DATE"));
				c.setCHECK_DATE(rs.getString("CHECK_DATE"));
				c.setOPER_MAN_IDENT_NO(rs.getString("OPER_MAN_IDENT_NO"));
				c.setOPER_MAN_NAME(rs.getString("OPER_MAN_NAME"));
				c.setCORP_STATUS(rs.getString("CORP_STATUS"));
				c.setREG_CAPI(rs.getString("REG_CAPI"));
				c.setFARE_TERM_START(rs.getString("FARE_TERM_START"));
				c.setFARE_TERM_END(rs.getString("fARE_TERM_END"));
				c.setFARE_SCOPE(rs.getString("fARE_SCOPE"));
				c.setUNI_SCID(rs.getString("UNI_SCID"));
				c.setTEL(rs.getString("TEL"));
				c.setWEB_URL(rs.getString("wEB_URL"));
				c.setEMAIL(rs.getString("EMAIL"));
				c.setPRAC_PERSON_NUM(rs.getString("PRAC_PERSON_NUM"));
				c.setORG_INST_CODE(rs.getString("ORG_INST_CODE"));
				c.setTAXPAY_NUM(rs.getString("TAXPAY_NUM"));
				c.setSTAFF_SIZE(rs.getString("STAFF_SIZE"));
				c.setENGLISH_NAME(rs.getString("ENGLISH_NAME"));
				c.setFORMER_NAME(rs.getString("FORMER_NAME"));
				c.setCREATE_DATE(rs.getString("CREATE_DATE"));
				c.setCREATE_ORG(rs.getString("CREATE_ORG"));
				
				goods.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(connection);
		}
		return goods;
	}
	public List<Company> loadAll() {
		Connection connection = DBUtil.getConnection();
		String sql = "SELECT * FROM d7";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Company> goods = new ArrayList<Company>();
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Company c = new Company();
				//c.setORG(rs.getString("ORG"));
				c.setID(rs.getString("ID"));
				c.setSEQ_ID(rs.getString("SEQ_ID"));
				c.setREG_NO(rs.getString("REG_NO"));
				c.setCORP_NAME(rs.getString("CORP_NAME"));
				c.setADDR(rs.getString("ADDR"));
				c.setBELONG_ORG(rs.getString("BELONG_ORG"));
				c.setBELONG_DIST_ORG(rs.getString("BELONG_DIST_ORG"));
				c.setBELONG_TRADE(rs.getString("BELONG_TRADE"));
				c.setECON_KIND(rs.getString("ECON_KIND"));
				c.setADMIT_MAIN(rs.getString("ADMIT_MAIN"));
				c.setSTART_DATE(rs.getString("START_DATE"));
				c.setCHECK_DATE(rs.getString("CHECK_DATE"));
				c.setOPER_MAN_IDENT_NO(rs.getString("OPER_MAN_IDENT_NO"));
				c.setOPER_MAN_NAME(rs.getString("OPER_MAN_NAME"));
				c.setCORP_STATUS(rs.getString("CORP_STATUS"));
				c.setREG_CAPI(rs.getString("REG_CAPI"));
				c.setFARE_TERM_START(rs.getString("FARE_TERM_START"));
				c.setFARE_TERM_END(rs.getString("fARE_TERM_END"));
				c.setFARE_SCOPE(rs.getString("fARE_SCOPE"));
				c.setUNI_SCID(rs.getString("UNI_SCID"));
				c.setTEL(rs.getString("TEL"));
				c.setWEB_URL(rs.getString("wEB_URL"));
				c.setEMAIL(rs.getString("EMAIL"));
				c.setPRAC_PERSON_NUM(rs.getString("PRAC_PERSON_NUM"));
				c.setORG_INST_CODE(rs.getString("ORG_INST_CODE"));
				c.setTAXPAY_NUM(rs.getString("TAXPAY_NUM"));
				c.setSTAFF_SIZE(rs.getString("STAFF_SIZE"));
				c.setENGLISH_NAME(rs.getString("ENGLISH_NAME"));
				c.setFORMER_NAME(rs.getString("FORMER_NAME"));
				c.setCREATE_DATE(rs.getString("CREATE_DATE"));
				c.setCREATE_ORG(rs.getString("CREATE_ORG"));
				
				goods.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(connection);
		}
		return goods;
	}
	//查出股东
	public static  List<Gudong> getGudList1(String cname){
		System.out.println("呵呵");
		List<Gudong>list = new ArrayList<>();
		try {
			Connection connection = DBUtil.getConnection();
			ResultSet rs = null;
			
			
			String sql2 ="select stock_name,stock_percent,STOCK_CAPI from d7 a,d72 b,d73 c where a.org=c.ORG and a.id=c.ID and a.seq_id=c.SEQ_ID and c.SUB_ID=b.SUB_ID and c.sub_org=b.sub_org and c.SUB_SEQ_ID=b.SUB_SEQ_ID and b.CERTIFICATE_TYPE !='null' and a.CORP_NAME=? order by STOCK_CAPI desc";
			//String sql2 = "select SUB_ID from d73 where d73.ID = ?";
			PreparedStatement pre = connection.prepareStatement(sql2);
			pre.setString(1,cname);
			rs = pre.executeQuery();
			while(rs.next()) {
				
				
				Gudong gud = new Gudong();
				System.out.println("呵呵");
				gud.setGname(rs.getString("STOCK_NAME"));
				gud.setGmoney(rs.getDouble("STOCK_CAPI"));
				gud.setGpercent(rs.getString("STOCK_PERCENT"));
				if(gud.getGpercent()==null)gud.setGpercent("100%");
				list.add(gud);
			}
			DBUtil.close(rs);
			DBUtil.close(pre);
			DBUtil.close(connection);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			
			
		}
		
		//System.out.println(list.size());
		return list;
	}
	public static List<Gudong> getGudList(String cname){
		List<Gudong>list = new ArrayList<>();
		try {
			Connection con = DBUtil.getConnection();
			String sql = "select ID from d7 where CORP_NAME = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1,cname);
			ResultSet rs = pre.executeQuery();
			String ID = null;
			while(rs.next())ID = rs.getString("ID");
			System.out.println(ID);
			String sql2 = "select STOCK_NAME,STOCK_PERCENT,STOCK_CAPI from d7 a,d72 b,d73 c " + 
					" where a.org=c.ORG and a.id=c.ID and a.seq_id=c.SEQ_ID and c.SUB_ID=b.SUB_ID and c.sub_org=b.sub_org " + 
					" and c.SUB_SEQ_ID=b.SUB_SEQ_ID and a.CORP_NAME=?";
			//String sql2 = "select SUB_ID from d73 where d73.ID = ?";
			pre = con.prepareStatement(sql2);
			pre.setString(1,cname);
			rs = pre.executeQuery();
			while(rs.next()) {
				
				
				Gudong gud = new Gudong();
				System.out.println("呵呵");
				gud.setGname(rs.getString("STOCK_NAME"));
				gud.setGmoney(rs.getDouble("STOCK_CAPI"));
				gud.setGpercent(rs.getString("STOCK_PERCENT"));
				if(gud.getGpercent()==null)gud.setGpercent("100%");
				list.add(gud);
			}
			DBUtil.close(rs);
			DBUtil.close(pre);
			DBUtil.close(con);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			
			
		}
		
		//System.out.println(list.size());
		return list;
	}
	public static List<Company> getBGud(String cname){
		List<Company>list = new ArrayList<>();
		try {
			Connection con = DBUtil.getConnection();
			String sql = "select ID from d7 where CORP_NAME = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1,cname);
			ResultSet rs = pre.executeQuery();
			String ID = null;
			while(rs.next())ID = rs.getString("ID");
			System.out.println(ID);
			String sql2 = "SELECT CORP_NAME from d7 x, (SELECT ORG,ID,SEQ_ID from d73 b, (select SUB_ORG ,SUB_ID ,SUB_SEQ_ID from d7 a,d73 c where a.org=c.ORG and a.id=c.ID and a.seq_id=c.SEQ_ID and a.CORP_NAME=? ) d\r\n" + 
					"WHERE b.SUB_ORG=d.SUB_ORG and b.SUB_ID=d.SUB_ID and b.SUB_SEQ_ID=d.SUB_SEQ_ID) y WHERE x.ORG=y.ORG and x.SEQ_ID=y.SEQ_ID and x.ID=y.ID and x.CORP_NAME!=?";
			//String sql2 = "select ID from d73 where SUB_ID = '78497'";
			pre = con.prepareStatement(sql2);
			pre.setString(1,cname);
			pre.setString(2,cname);
			rs = pre.executeQuery();
			while(rs.next()) {
				
				Company gud = new Company();
				//System.out.println("呵呵");
				gud.setCORP_NAME(rs.getString("CORP_NAME"));
				list.add(gud);
			}
			DBUtil.close(rs);
			DBUtil.close(pre);
			DBUtil.close(con);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			
			
		}
		
		//System.out.println(list.size());
		return list;
	}
	//查询子公司
	public static List<T_CORP_DIST> getDIST(String cname){
		List<T_CORP_DIST>list = new ArrayList<>();
		try {
			Connection con = DBUtil.getConnection();
			String sql = "select ID from d7 where CORP_NAME = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1,cname);
			ResultSet rs = pre.executeQuery();
			String ID = null;
			while(rs.next())ID = rs.getString("ID");
			System.out.println(ID);
			String sql2 = "SELECT DIST_NAME from  d74 b,(\r\n" + 
					"SELECT SUB_ID,SUB_ORG,SUB_SEQ_ID from d75 a ,d7 b WHERE a.`﻿ID`=b.ID AND a.ORG=b.ORG and \r\n" + 
					"a.SEQ_ID=b.SEQ_ID and b.CORP_NAME=?) c WHERE c.SUB_ID=b.SUB_ID and c.SUB_ORG=b.SUB_ORG AND\r\n" + 
					"c.SUB_SEQ_ID=b.SUB_SEQ_ID";
			//String sql2 = "select ID from d73 where SUB_ID = '78497'";
			pre = con.prepareStatement(sql2);
			pre.setString(1,cname);
			rs = pre.executeQuery();
			while(rs.next()) {
				
				T_CORP_DIST gud = new T_CORP_DIST();
				//System.out.println("呵呵");
				gud.setDIST_NAME(rs.getString("DIST_NAME"));
				list.add(gud);
			}
			DBUtil.close(rs);
			DBUtil.close(pre);
			DBUtil.close(con);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			
			
		}
		
		//System.out.println(list.size());
		return list;
	}
	public List<Company> getBGud1(String cname,String name){
		List<Company>list = new ArrayList<>();
		try {
			Connection con = DBUtil.getConnection();
			String sql = "select ID from d7 where CORP_NAME = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1,cname);
			ResultSet rs = pre.executeQuery();
			String ID = null;
			while(rs.next())ID = rs.getString("ID");
			System.out.println(ID);
			String sql2 = "SELECT CORP_NAME from d7 x, (SELECT ORG,ID,SEQ_ID from d73 b, (select SUB_ORG ,SUB_ID ,SUB_SEQ_ID from d72 where STOCK_NAME=? ) d\r\n" + 
					"WHERE b.SUB_ORG=d.SUB_ORG and b.SUB_ID=d.SUB_ID and b.SUB_SEQ_ID=d.SUB_SEQ_ID) y WHERE x.ORG=y.ORG and x.SEQ_ID=y.SEQ_ID and x.ID=y.ID and x.CORP_NAME!=?\r\n" + 
					"";
			//String sql2 = "select ID from d73 where SUB_ID = '78497'";
			pre = con.prepareStatement(sql2);
			pre.setString(1,name);
			pre.setString(2,cname);
			rs = pre.executeQuery();
			while(rs.next()) {
				
				Company gud = new Company();
				//System.out.println("呵呵");
				gud.setCORP_NAME(rs.getString("CORP_NAME"));
				list.add(gud);
			}
			DBUtil.close(rs);
			DBUtil.close(pre);
			DBUtil.close(con);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			
			
		}
		
		//System.out.println(list.size());
		return list;
	}
	public static List<Gudong>getY(String cname){
		List<Gudong>list = new ArrayList<>();
		try {
			Connection con = DBUtil.getConnection();
			String sql = "select ID from d7 where CORP_NAME = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1,cname);
			ResultSet rs = pre.executeQuery();
			String ID = null;
			while(rs.next())ID = rs.getString("ID");
			System.out.println(ID);
			String sql2 = "select PERSON_NAME from d76 where ID in (select SUB_ID from d77 where ID = ?)";
			//String sql2 = "select SUB_ID from d73 where d73.ID = ?";
			pre = con.prepareStatement(sql2);
			pre.setString(1,ID);
			rs = pre.executeQuery();
			while(rs.next()) {
				
				
				Gudong gud = new Gudong();
				//System.out.println("呵呵");
				gud.setGname(rs.getString("PERSON_NAME"));
				//gud.setGmoney(rs.getDouble("STOCK_CAPI"));
				//gud.setGpercent(rs.getString("STOCK_PERCENT"));
				//if(gud.getGpercent()==null)gud.setGpercent("100%");
				list.add(gud);
			}
			DBUtil.close(rs);
			DBUtil.close(pre);
			DBUtil.close(con);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			
			
		}
		
		//System.out.println(list.size());
		return list;
	}
	
	public static List<Company>getChild(String cname){
		List<Company>list = new ArrayList<>();
		try {
			Connection con = DBUtil.getConnection();
			String sql = "select ID from d7 where CORP_NAME = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1,cname);
			ResultSet rs = pre.executeQuery();
			String ID = null;
			while(rs.next())ID = rs.getString("ID");
			System.out.println(ID);
			String sql2 = "select";
			//String sql2 = "select ID from d73 where SUB_ID = '78497'";
			pre = con.prepareStatement(sql2);
			pre.setString(1,ID);
			rs = pre.executeQuery();
			while(rs.next()) {
				
				Company gud = new Company();
				//System.out.println("呵呵");
				gud.setCORP_NAME(rs.getString("CORP_NAME"));
				list.add(gud);
			}
			DBUtil.close(rs);
			DBUtil.close(pre);
			DBUtil.close(con);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			
			
		}
		
		//System.out.println(list.size());
		return list;
	}
	public static Company getCompany(String cname) {
		// TODO Auto-generated method stub
		Connection connection = DBUtil.getConnection();
		String sql = "SELECT * FROM d7 WHERE CORP_NAME = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Company c = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, cname);
			rs = ps.executeQuery();
			while(rs.next()) {
				c = new Company();
				//c.setORG(rs.getString("ORG"));
				c.setID(rs.getString("ID"));
				c.setSEQ_ID(rs.getString("SEQ_ID"));
				c.setREG_NO(rs.getString("REG_NO"));
				c.setCORP_NAME(rs.getString("CORP_NAME"));
				c.setADDR(rs.getString("ADDR"));
				c.setBELONG_ORG(rs.getString("BELONG_ORG"));
				c.setBELONG_DIST_ORG(rs.getString("BELONG_DIST_ORG"));
				c.setBELONG_TRADE(rs.getString("BELONG_TRADE"));
				c.setECON_KIND(rs.getString("ECON_KIND"));
				c.setADMIT_MAIN(rs.getString("ADMIT_MAIN"));
				c.setSTART_DATE(rs.getString("START_DATE"));
				c.setCHECK_DATE(rs.getString("CHECK_DATE"));
				c.setOPER_MAN_IDENT_NO(rs.getString("OPER_MAN_IDENT_NO"));
				c.setOPER_MAN_NAME(rs.getString("OPER_MAN_NAME"));
				c.setCORP_STATUS(rs.getString("CORP_STATUS"));
				c.setREG_CAPI(rs.getString("REG_CAPI"));
				c.setFARE_TERM_START(rs.getString("FARE_TERM_START"));
				c.setFARE_TERM_END(rs.getString("fARE_TERM_END"));
				c.setFARE_SCOPE(rs.getString("fARE_SCOPE"));
				c.setUNI_SCID(rs.getString("UNI_SCID"));
				c.setTEL(rs.getString("TEL"));
				c.setWEB_URL(rs.getString("wEB_URL"));
				c.setEMAIL(rs.getString("EMAIL"));
				c.setPRAC_PERSON_NUM(rs.getString("PRAC_PERSON_NUM"));
				c.setORG_INST_CODE(rs.getString("ORG_INST_CODE"));
				c.setTAXPAY_NUM(rs.getString("TAXPAY_NUM"));
				c.setSTAFF_SIZE(rs.getString("STAFF_SIZE"));
				c.setENGLISH_NAME(rs.getString("ENGLISH_NAME"));
				c.setFORMER_NAME(rs.getString("FORMER_NAME"));
				c.setCREATE_DATE(rs.getString("CREATE_DATE"));
				c.setCREATE_ORG(rs.getString("CREATE_ORG"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(connection);
		}
		return c;
	}
	
	
	/*
	 * 通过公司名，查找向该公司投资的股东
	 */
	public static ArrayList<ChildrenBean> selectGuDongByCompanyName(String type,String name){
		ArrayList<ChildrenBean> GuDongRen=new ArrayList<>();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String selectType=type;
		Connection conn=DBUtil.getConnection();
		String sql="select STOCK_NAME,STOCK_PERCENT from d7 a,d72 b,d73 c " + 
				" where a.org=c.ORG and a.id=c.ID and a.seq_id=c.SEQ_ID and c.SUB_ID=b.SUB_ID and c.sub_org=b.sub_org " + 
				" and c.SUB_SEQ_ID=b.SUB_SEQ_ID and a.CORP_NAME=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, name);
			rs=pst.executeQuery();
			while(rs.next()) {
				String STOCK_NAME=rs.getString("STOCK_NAME");
				String STOCK_PERCENT=rs.getString("STOCK_PERCENT");
				ChildrenBean children=new ChildrenBean(STOCK_NAME,selectType,STOCK_PERCENT);
				GuDongRen.add(children);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.close(conn);
		}
		return GuDongRen;
	}
	/*
	 * 通过公司名，查找向该公司的对外投资
	 */
	public static ArrayList<ChildrenBean> selectTouZiByCompanyName(String type,String name){
		ArrayList<ChildrenBean> GuDongCom=new ArrayList<>();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String selectType=type;
		Connection conn=DBUtil.getConnection();
		String sql="select CORP_name,stock_percent from d7 c,( " + 
				" select ORG,ID,SEQ_ID,stock_percent from d73 a,( " + 
				" select distinct SUB_ORG,SUB_ID,SUB_SEQ_ID,stock_percent from d72 " + 
				" where CERTIFICATE_TYPE = 'null' and stock_name=? " + 
				" ) b where a.SUB_ORG=b.SUB_ORG and a.SUB_ID=b.SUB_ID and a.SUB_SEQ_ID=b.SUB_SEQ_ID " + 
				"  ) d where c.ORG=d.ORG and c.ID=d.ID and c.SEQ_ID=c.SEQ_ID";
		System.out.println("selectGuDongCom   "+sql);
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, name);
			rs=pst.executeQuery();
			while(rs.next()) {
				String CORP_NAME=rs.getString("CORP_NAME");
				String STOCK_PERCENT=rs.getString("STOCK_PERCENT");
				ChildrenBean childrenData=new ChildrenBean(CORP_NAME,selectType,STOCK_PERCENT);
				GuDongCom.add(childrenData);
			}
			System.out.println("查出来的对外投资   "+GuDongCom);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return GuDongCom;
	}
	
	
	//查询疑似关系中股东对外投资情况
		public ArrayList<Links> selectTouZiOutside(String corpName) {
			ArrayList<Links> GuDongTouZi=new ArrayList<>();
			PreparedStatement pst=null;
			ResultSet rs=null;
			String sql="select CORP_name,stock_name from d7 c,( " + 
					"  select ORG,ID,SEQ_ID,stock_name from d73 a,( " + 
					" select distinct SUB_ORG,SUB_ID,SUB_SEQ_ID, stock_name from d72 " + 
					" where  stock_name in( " + 
					"  select stock_name from d7 a,d72 b,d73 c " + 
					"  where a.org=c.ORG and a.id=c.ID and a.seq_id=c.SEQ_ID and c.SUB_ID=b.SUB_ID and c.sub_org=b.sub_org " + 
					"  and c.SUB_SEQ_ID=b.SUB_SEQ_ID and b.CERTIFICATE_TYPE != 'null' and a.CORP_NAME=?) " + 
					"  ) b where a.SUB_ORG=b.SUB_ORG and a.SUB_ID=b.SUB_ID and a.SUB_SEQ_ID=b.SUB_SEQ_ID " + 
					"  ) d where c.ORG=d.ORG and c.ID=d.ID and c.SEQ_ID=c.SEQ_ID";
			Connection conn=DBUtil.getConnection();
			try {
				pst=conn.prepareStatement(sql);
				pst.setString(1, corpName);
				rs=pst.executeQuery();
				while(rs.next()) {
					String CORP_NAME=rs.getString("CORP_NAME");
					String STOCK_NAME=rs.getString("STOCK_NAME");
					Links links=new Links(STOCK_NAME, CORP_NAME, "股东");
					GuDongTouZi.add(links);
				}
				System.out.println("selectTouZiOutside  "+GuDongTouZi);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}finally {
				DBUtil.close(conn);
			}
			return GuDongTouZi;
		}
		
		//根据人员查询员工
		public ArrayList<Links> selectRENyuan(String corpName) {
			ArrayList<Links> GuDongTouZi=new ArrayList<>();
			PreparedStatement pst=null;
			ResultSet rs=null;
			String sql="SELECT * from d76 c,\r\n" + 
					"(SELECT SUB_ID,SUB_ORG,SUB_SEQ_ID from d77 a,d7 b WHERE a.ID=b.ID and a.ORG=b.ORG and a.SEQ_ID=b.SEQ_ID and b.CORP_NAME=? ) d\r\n" + 
					"WHERE c.SUB_ID=d.SUB_ID and c.SUB_ORG=d.SUB_ORG and c.SUB_SEQ_ID=d.SUB_SEQ_ID;\r\n" + 
					"";
			Connection conn=DBUtil.getConnection();
			try {
				pst=conn.prepareStatement(sql);
				pst.setString(1, corpName);
				rs=pst.executeQuery();
				while(rs.next()) {
					Links link=new Links();
				    link.setSub_id(rs.getInt("SUB_ID"));
				    link.setSub_org(rs.getInt("SUB_ORG"));
				    link.setSub_seq_id(rs.getInt("SUB_SEQ_ID"));
				    link.setSource(rs.getString("PERSON_NAME"));
				    link.setValue(rs.getString("PERSON_TYPE"));
					GuDongTouZi.add(link);
				}
				System.out.println("selectTouZiOutside  "+GuDongTouZi);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}finally {
				DBUtil.close(conn);
			}
			return GuDongTouZi;
		}
		public ArrayList<Links> selectRenZhiOutside(String corpName, String sql) {
			ArrayList<Links> RenZhi=new ArrayList<>();
			PreparedStatement pst=null;
			ResultSet rs=null;
			Connection conn=DBUtil.getConnection();
			try {
				pst=conn.prepareStatement(sql);
				pst.setString(1, corpName);
				rs=pst.executeQuery();
				while(rs.next()) {
					String CORP_NAME=rs.getString("CORP_NAME");
					String PERSON_NAME=rs.getString("PERSON_NAME");
					String PERSON_TYPE=rs.getString("PERSON_TYPE");
					Links links=new Links(PERSON_NAME, CORP_NAME, PERSON_TYPE);
					RenZhi.add(links);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}finally {
				DBUtil.close(conn);
			}
			return RenZhi;
		}
       
		//查询员工在其他公司任职信息
		public ArrayList<Links> selectYuangongrenzhi(int sub_id,int sub_org,int sub_seq_id,String cname) {
			ArrayList<Links> GuDongTouZi=new ArrayList<>();
			PreparedStatement pst=null;
			ResultSet rs=null;
			String sql="SELECT CORP_NAME FROM d7 c, d77 a WHERE\r\n" + 
					" a.SUB_ID=? and a.SUB_ORG=? and a.SUB_SEQ_ID=? and c.CORP_NAME!=? and c.ID=a.ID and c.ORG=a.ORG and c.SEQ_ID=a.SEQ_ID;";
			Connection conn=DBUtil.getConnection();
			try {
				pst=conn.prepareStatement(sql);
				pst.setInt(1, sub_id);
				pst.setInt(2, sub_org);
				pst.setInt(3, sub_seq_id);
				pst.setString(4, cname);
				rs=pst.executeQuery();
				while(rs.next()) {
					Links links=new Links();
					links.setSource(rs.getString("CORP_NAME"));
					links.setTarget("lalalal");
					links.setValue("lallala");
					GuDongTouZi.add(links);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}finally {
				DBUtil.close(conn);
			}
			return GuDongTouZi;
		}
		
		public List<Links> selectYuangongrenzhi1(int sub_id,int sub_org,int sub_seq_id,String cname) {
			ArrayList<Links> GuDongTouZi=new ArrayList<>();
			try {
				Connection con = DBUtil.getConnection();
				String sql = "select ID from d7 where CORP_NAME = ?";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1,cname);
				ResultSet rs = pst.executeQuery();
				String ID = null;
				while(rs.next())ID = rs.getString("ID");
				System.out.println(ID);
				String sql2 = "SELECT CORP_NAME FROM d7 c, d77 a WHERE\r\n" + 
						" a.SUB_ID=? and a.SUB_ORG=? and a.SUB_SEQ_ID=? and c.CORP_NAME!=? and c.ID=a.ID and c.ORG=a.ORG and c.SEQ_ID=a.SEQ_ID;";
				pst = con.prepareStatement(sql2);
				pst.setInt(1, sub_id);
				pst.setInt(2, sub_org);
				pst.setInt(3, sub_seq_id);
				pst.setString(4, cname);
				rs=pst.executeQuery();
				while(rs.next()) {
					Links links=new Links();
					links.setSource(rs.getString("CORP_NAME"));
					links.setTarget("lalalal");
					links.setValue("lallala");
					GuDongTouZi.add(links);
				}
				DBUtil.close(rs);
				DBUtil.close(pst);
				DBUtil.close(con);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally {
				
				
			}
			
			//System.out.println(list.size());
			return GuDongTouZi;
		}
		public ArrayList<Links> selectGuDongRenZhiOutside(String corpName) {
			ArrayList<Links> GuDongRenZhi=new ArrayList<>();
			String sql="select CORP_name,person_name ,person_type from d7 c,( " + 
					"select ORG,ID,SEQ_ID ,person_name ,person_type from d77 a,( " + 
					" select SUB_ORG,SUB_ID,SUB_SEQ_ID, person_name ,person_type from d76 where person_name in( " + 
					" select stock_name from d7 a,d72 b,d73 c " + 
					"  where a.org=c.ORG and a.id=c.ID and a.seq_id=c.SEQ_ID and c.SUB_ID=b.SUB_ID and c.sub_org=b.sub_org " + 
					"  and c.SUB_SEQ_ID=b.SUB_SEQ_ID and b.CERTIFICATE_TYPE != 'null' and a.CORP_NAME=?) " + 
					") b where a.SUB_ORG=b.SUB_ORG and a.SUB_ID=b.SUB_ID and a.SUB_SEQ_ID=b.SUB_SEQ_ID " + 
					") d where c.ORG=d.ORG and c.ID=d.ID and c.SEQ_ID=c.SEQ_ID";
			GuDongRenZhi=selectRenZhiOutside(corpName,sql);
			return GuDongRenZhi;
		}

		public ArrayList<Links> selectGaoGuanRenZhiOutside(String corpName) {
			ArrayList<Links> GaoGuanRenZhi=new ArrayList<>();
			String sql="select CORP_name,person_name ,person_type from d7 c,( " + 
					"select ORG,ID,SEQ_ID ,person_name ,person_type from d77 a,( " + 
					" select SUB_ORG,SUB_ID,SUB_SEQ_ID, person_name ,person_type from d76 where person_name in( " + 
					"select person_name from d7 a,d76 b,d77 c where a.org=c.ORG and a.id=c.ID and a.seq_id=c.SEQ_ID and c.SUB_ID=b.SUB_ID and c.sub_org=b.sub_org " + 
					" and c.SUB_SEQ_ID=b.SUB_SEQ_ID and a.CORP_NAME=?) " + 
					") b where a.SUB_ORG=b.SUB_ORG and a.SUB_ID=b.SUB_ID and a.SUB_SEQ_ID=b.SUB_SEQ_ID " + 
					") d where c.ORG=d.ORG and c.ID=d.ID and c.SEQ_ID=c.SEQ_ID";
			GaoGuanRenZhi=selectRenZhiOutside(corpName,sql);
			return GaoGuanRenZhi;
		}
		/*
		 * 查询公司的主要成员
		 */
		public ArrayList<ChildrenBean> selectMemberByCompany(String type, String corpName, int org, int seq_id) {
			System.out.println("数据库查询公司的主要成员");
			// TODO Auto-generated method stub
			//集合存储所有查询出来的股东数据
			ArrayList<ChildrenBean> corpMember=new ArrayList<>();
			PreparedStatement pst=null;
			ResultSet rs=null;
			String selectType=type;
			Connection conn=DBUtil.getConnection();
			String sql="select corp_name,PERSON_NAME from d7 a,d76 b,d77 c" + 
					" where a.org=c.ORG and a.id=c.ID and a.seq_id=c.SEQ_ID " + 
					" and c.SUB_ID=b.SUB_ID and c.sub_org=b.sub_org and c.SUB_SEQ_ID=b.SUB_SEQ_ID and a.ORG=? and a.seq_id=?";
			try {
				pst=conn.prepareStatement(sql);
				pst.setInt(1, org);
				pst.setInt(2, seq_id);
				rs=pst.executeQuery();
				while(rs.next()) {
					String PERSON_NAME=rs.getString("PERSON_NAME");
					ChildrenBean childrenData=new ChildrenBean(PERSON_NAME,selectType,"");
					corpMember.add(childrenData);
				}
				System.out.println("查出来的公司成员   "+corpMember);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return corpMember;
		}
}
