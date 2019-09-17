package com.CommpanyTest1.servlet;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import com.CommpanyTest1.model.Company;
import com.CommpanyTest1.model.Gudong;
import com.CommpanyTest1.model.Links;
import com.CommpanyTest1.model.T_CORP_DIST;
import com.CommpanyTest1.dao.CompanyDao;

/**
 * Servlet implementation class Solution
 */
@WebServlet("/Solution")
public class Solution extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Solution() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("action");
		if(method.equals("search")) {
			String cname = request.getParameter("content");
			//System.out.println(cname);
			List<Company>list = new ArrayList<>();
			Company company = CompanyDao.getCompany(cname);
			//if(company==null)System.out.println("呵呵");
			list.add(company);
			request.setAttribute("infolist",list);
			request.getRequestDispatcher("Search.jsp").forward(request,response);
		}else if(method.equals("gud")) {
			String cname = request.getParameter("content");
			//String cname = "je";
			System.out.println(cname);
			List<Gudong>list = CompanyDao.getGudList(cname);
			String m = "疑似实际控制人:";
			String str = "";
			double ma = 0;
			for(Gudong temp:list) {
				if(temp.getGmoney()>ma) {
					ma = temp.getGmoney();
					System.out.println(ma);
					str = temp.getGname()+" "+temp.getGpercent();
				}
			}
			m+=str;
			request.setAttribute("list",list);
			request.setAttribute("m",m);
			request.getRequestDispatcher("Gud.jsp").forward(request,response);
		}else if(method.equals("zupu")) {
			String cname = request.getParameter("content");
			//String cname = "je";
			List<Gudong>list1 = CompanyDao.getGudList(cname);
			List<Company>list2 = CompanyDao.getBGud(cname);
			List<T_CORP_DIST> list3=CompanyDao.getDIST(cname);
			
			JSONObject json = new JSONObject();
			
			List<JSONObject>data = new ArrayList<>();
			List<JSONObject>categories = new ArrayList<>();
			List<JSONObject>links = new ArrayList<>();
			
			
			JSONObject o = new JSONObject();
			o.put("name",cname);
			o.put("draggable",true);
			o.put("symbolSize",new int[] {50,50});
			o.put("itemStyle",new JSONObject().put("color","#000"));
			o.put("category","1投资");
			
			data.add(o);
			
			
			
			JSONObject o3 = new JSONObject();
			o3.put("name","子公司");
			o3.put("draggable",true);
			o3.put("symbolSize",new int[] {50,50});
			o3.put("itemStyle",new JSONObject().put("color","#000"));
			o3.put("category","从属");
			
			data.add(o3);
			
			
			
			JSONObject o1 = new JSONObject();
			o1.put("name","股东");
			o1.put("draggable",true);
			o1.put("symbolSize",new int[] {50,50});
			o1.put("itemStyle",new JSONObject().put("color","#000"));
			o1.put("category","投资");
			
			data.add(o1);
			
			
			
			
			JSONObject jb3 = new JSONObject();
			jb3.put("name","1投资");
			
			categories.add(jb3);
			
			JSONObject jb4 = new JSONObject();
			jb4.put("name","从属");
			
			categories.add(jb4);
			
			
			JSONObject jb5 = new JSONObject();
			jb5.put("name","管理");
			
			categories.add(jb5);
			
			
			
			JSONObject oj2 = new JSONObject();
			oj2.put("target","股东");
			oj2.put("source",cname);
			oj2.put("category","1");
			
			links.add(oj2);
			
			JSONObject oj3 = new JSONObject();
			oj3.put("target","子公司");
			oj3.put("source",cname);
			oj3.put("category","2");
			
			links.add(oj3);
			
			JSONObject oj4 = new JSONObject();
			oj4.put("target","成员");
			oj4.put("source",cname);
			oj4.put("category","2");
			
			links.add(oj4);
			
			for(Gudong temp1:list1) {
				JSONObject oo = new JSONObject();
				oo.put("name",temp1.getGname());
				oo.put("draggable",true);
				oo.put("symbolSize",new int[] {50,50});
				oo.put("itemStyle",new JSONObject().put("color","#000"));
				oo.put("category","touzi");
				data.add(oo);
				JSONObject oo2 = new JSONObject();
				oo2.put("target",temp1.getGname());  //
				oo2.put("source","股东");
				oo2.put("category","");
				links.add(oo2);
				CompanyDao dao=new CompanyDao();
				List<Company> list =dao.getBGud1(cname, temp1.getGname());
				for(Company c:list)
				{
					JSONObject oo3 = new JSONObject();
					oo3.put("name",c.getCORP_NAME());
					oo3.put("draggable",true);
					oo3.put("symbolSize",new int[] {50,50});
					oo3.put("itemStyle",new JSONObject().put("color","#000"));
					oo3.put("category","touzi");
					data.add(oo3);
					JSONObject oo4 = new JSONObject();
					oo4.put("target",c.getCORP_NAME());  //
					oo4.put("source",temp1.getGname());
					oo4.put("category","投资");
					links.add(oo4);
				}
				
			}
			
			for(T_CORP_DIST temp1:list3) {
				JSONObject oo = new JSONObject();
				oo.put("name",temp1.getDIST_NAME());
				oo.put("draggable",true);
				oo.put("symbolSize",new int[] {50,50});
				oo.put("itemStyle",new JSONObject().put("color","#000"));
				oo.put("category","");
				data.add(oo);
				JSONObject oo2 = new JSONObject();
				oo2.put("target",temp1.getDIST_NAME());  //
				oo2.put("source","子公司");
				oo2.put("category","");
				links.add(oo2);
			}
			
			json.put("data",data);
			json.put("links",links);
			json.put("categories", categories);
			
			response.setCharacterEncoding("utf-8");
			//System.out.println(json.toJSONString());
			response.getWriter().write(json.toJSONString());
		}else if(method.equals("qit")) {
			String cname = request.getParameter("content");
			List<Gudong>list1 = CompanyDao.getGudList(cname);
			List<T_CORP_DIST> list2=CompanyDao.getDIST(cname);
			List<Gudong>list3 = CompanyDao.getY(cname);
			List<Company>list4 = CompanyDao.getChild(cname);
			CompanyDao dao=new CompanyDao();
			ArrayList<Links> list5=dao.selectRENyuan(cname);
			JSONObject json = new JSONObject();
			
			List<JSONObject>data = new ArrayList<>();
			List<JSONObject>categories = new ArrayList<>();
			List<JSONObject>links = new ArrayList<>();
			
			
			JSONObject o = new JSONObject();
			o.put("name",cname);
			o.put("draggable",true);
			o.put("symbolSize",new int[] {50,50});
			o.put("itemStyle",new JSONObject().put("color","#000"));
			o.put("category","1投资");
			
			data.add(o);
			
			
			
			JSONObject o3 = new JSONObject();
			o3.put("name","子公司");
			o3.put("draggable",true);
			o3.put("symbolSize",new int[] {50,50});
			o3.put("itemStyle",new JSONObject().put("color","#000"));
			o3.put("category","从属");
			
			data.add(o3);
			
			JSONObject o4 = new JSONObject();
			o4.put("name","成员");
			o4.put("draggable",true);
			o4.put("symbolSize",new int[] {50,50});
			o4.put("itemStyle",new JSONObject().put("color","#000"));
			o4.put("category","管理");
			
			data.add(o4);
			
			JSONObject o1 = new JSONObject();
			o1.put("name","股东");
			o1.put("draggable",true);
			o1.put("symbolSize",new int[] {50,50});
			o1.put("itemStyle",new JSONObject().put("color","#000"));
			o1.put("category","1投资");
			
			data.add(o1);
			
			
			
			JSONObject jb3 = new JSONObject();
			jb3.put("name","1投资");
			
			categories.add(jb3);
			
			JSONObject jb4 = new JSONObject();
			jb4.put("name","从属");
			
			categories.add(jb4);
			
			
			JSONObject jb5 = new JSONObject();
			jb5.put("name","管理");
			
			categories.add(jb5);
			
			JSONObject oj1 = new JSONObject();
			oj1.put("target","子公司");
			oj1.put("source",cname);
			oj1.put("category","1");
			
			links.add(oj1);
			
			JSONObject oj2 = new JSONObject();
			oj2.put("target","股东");
			oj2.put("source",cname);
			oj2.put("category","1");
			
			links.add(oj2);
			
			JSONObject oj3 = new JSONObject();
			oj3.put("target","子公司");
			oj3.put("source",cname);
			oj3.put("category","2");
			
			links.add(oj3);
			
			JSONObject oj4 = new JSONObject();
			oj4.put("target","成员");
			oj4.put("source",cname);
			oj4.put("category","2");
			
			links.add(oj4);
			
			for(Gudong temp1:list1) {
				JSONObject oo = new JSONObject();
				oo.put("name",temp1.getGname());
				oo.put("draggable",true);
				oo.put("symbolSize",new int[] {50,50});
				oo.put("itemStyle",new JSONObject().put("color","#000"));
				oo.put("category","");
				data.add(oo);
				JSONObject oo2 = new JSONObject();
				oo2.put("target",temp1.getGname());
				oo2.put("source","股东");
				oo2.put("category","");
				links.add(oo2);
				CompanyDao cdao=new CompanyDao();
				List<Company> list =cdao.getBGud1(cname, temp1.getGname());
				for(Company c:list)
				{
					JSONObject oo3 = new JSONObject();
					oo3.put("name",c.getCORP_NAME());
					oo3.put("draggable",true);
					oo3.put("symbolSize",new int[] {50,50});
					oo3.put("itemStyle",new JSONObject().put("color","#000"));
					oo3.put("category","touzi");
					data.add(oo3);
					JSONObject oo4 = new JSONObject();
					oo4.put("target",c.getCORP_NAME());  //
					oo4.put("source",temp1.getGname());
					oo4.put("category","投资");
					links.add(oo4);
				}
				
			}
			for(Links temp1:list5) {
				JSONObject oo = new JSONObject();
				oo.put("name",temp1.getSource());
				oo.put("draggable",true);
				oo.put("symbolSize",new int[] {50,50});
				oo.put("itemStyle",new JSONObject().put("color","#000"));
				oo.put("category",temp1.getValue());
				data.add(oo);
				JSONObject oo2 = new JSONObject();
				oo2.put("target",temp1.getSource());//
				oo2.put("source","成员");
				oo2.put("category",temp1.getValue());
				links.add(oo2);
			}
			for(T_CORP_DIST temp1:list2) {
				JSONObject oo = new JSONObject();
				oo.put("name",temp1.getDIST_NAME());
				oo.put("draggable",true);
				oo.put("symbolSize",new int[] {50,50});
				oo.put("itemStyle",new JSONObject().put("color","#000"));
				oo.put("category","");
				data.add(oo);
				JSONObject oo2 = new JSONObject();
				oo2.put("target",temp1.getDIST_NAME());  //
				oo2.put("source","子公司");
				oo2.put("category","");
				links.add(oo2);
			}
			
			
			
			
			
			json.put("data",data);
			json.put("links",links);
			json.put("categories", categories);
			
			response.setCharacterEncoding("utf-8");
			//System.out.println(json.toJSONString());
			response.getWriter().write(json.toJSONString());
		}else if(method.equals("yin")) {
			String cname = request.getParameter("content");
			List<Gudong>list1 = CompanyDao.getGudList(cname);
			//List<Company>list2 = CompanyDao.getBGud(cname);
			//List<Gudong>list3 = CompanyDao.getY(cname);
			//List<Company>list4 = CompanyDao.getChild(cname);
			CompanyDao companydao=new CompanyDao();
			//ArrayList<Links> list0=companydao.selectTouZiOutside(cname);
			//ArrayList<Links> list2=companydao.selectGuDongRenZhiOutside(cname);
			ArrayList<Links> list3=companydao.selectRENyuan(cname);
			JSONObject json = new JSONObject();
			
			List<JSONObject>data = new ArrayList<>();
			List<JSONObject>categories = new ArrayList<>();
			List<JSONObject>links = new ArrayList<>();
			
			
			JSONObject o = new JSONObject();
			o.put("name",cname);
			o.put("draggable",true);
			o.put("symbolSize",new int[] {50,50});
			o.put("itemStyle",new JSONObject().put("color","#000"));
			o.put("category","1投资");
			
			data.add(o);
			
			
			
			JSONObject o3 = new JSONObject();
			o3.put("name","子公司");
			o3.put("draggable",true);
			o3.put("symbolSize",new int[] {50,50});
			o3.put("itemStyle",new JSONObject().put("color","#000"));
			o3.put("category","从属");
			
			data.add(o3);
			
			JSONObject o4 = new JSONObject();
			o4.put("name","成员");
			o4.put("draggable",true);
			o4.put("symbolSize",new int[] {50,50});
			o4.put("itemStyle",new JSONObject().put("color","#FFF"));
			o4.put("category","管理");
			
			data.add(o4);
			JSONObject oj4 = new JSONObject();
			oj4.put("target","成员");
			oj4.put("source",cname);
			oj4.put("category","2");
			
			links.add(oj4);
			
			JSONObject o1 = new JSONObject();
			o1.put("name","股东");
			o1.put("draggable",true);
			o1.put("symbolSize",new int[] {50,50});
			o1.put("itemStyle",new JSONObject().put("color","#000"));
			o1.put("category","投资");
			
			data.add(o1);
			
			
			JSONObject oj2 = new JSONObject();
			oj2.put("target","股东");
			oj2.put("source",cname);
			oj2.put("category","1");
			
			links.add(oj2);
			
			JSONObject oj3 = new JSONObject();
			oj3.put("target","子公司");
			oj3.put("source",cname);
			oj3.put("category","2");
			
			links.add(oj3);
			
			
			
			for(Gudong temp1:list1) {
				JSONObject oo = new JSONObject();
				oo.put("name",temp1.getGname());
				oo.put("draggable",true);
				oo.put("symbolSize",new int[] {50,50});
				oo.put("itemStyle",new JSONObject().put("color","#000"));
				oo.put("category","touzi");
				data.add(oo);
				JSONObject oo2 = new JSONObject();
				oo2.put("target",temp1.getGname());  //
				oo2.put("source","股东");
				oo2.put("category","");
				links.add(oo2);
				CompanyDao dao=new CompanyDao();
				List<Company> list =dao.getBGud1(cname, temp1.getGname());
				for(Company c:list)
				{
					JSONObject oo3 = new JSONObject();
					oo3.put("name",c.getCORP_NAME());
					oo3.put("draggable",true);
					oo3.put("symbolSize",new int[] {50,50});
					oo3.put("itemStyle",new JSONObject().put("color","#000"));
					oo3.put("category","touzi");
					data.add(oo3);
					JSONObject oo4 = new JSONObject();
					oo4.put("target",c.getCORP_NAME());  //
					oo4.put("source",temp1.getGname());
					oo4.put("category","投资");
					links.add(oo4);
				}
			}
			
			
			String [] name=new String[100];
			int i=0;
			for(Links temp1:list3) {
				JSONObject oo = new JSONObject();
				oo.put("name",temp1.getSource());
				oo.put("draggable",true);
				oo.put("symbolSize",new int[] {50,50});
				oo.put("itemStyle",new JSONObject().put("color","#000"));
				oo.put("category","");
				data.add(oo);
				JSONObject oo2 = new JSONObject();
				oo2.put("target",temp1.getSource());  //
				oo2.put("source","成员");
				oo2.put("category",temp1.getValue());
				links.add(oo2);
				CompanyDao dao=new CompanyDao();
				List<Links> list =dao.selectYuangongrenzhi(temp1.getSub_id(), temp1.getSub_org(), temp1.getSub_seq_id(), cname);
				for(Links c:list)
				{
					name[i]=c.getSource();
					boolean b=true;
					System.out.println(c.getSource()+temp1.getSource());
					int j=0;
					int x=0;
					for(j=0;j<i;j++)
					{
						if(c.getSource().equals(name[j]))
						{
							b=false;
							x=j;
						}
					}
					if(b==true)
					{
					JSONObject o44 = new JSONObject();
					o44.put("name",c.getSource());
					o44.put("draggable",true);
					o44.put("symbolSize",new int[] {50,50});
					o44.put("itemStyle",new JSONObject().put("color","#000"));
					o44.put("category",temp1.getValue());
					
					data.add(o44);
					JSONObject oj44 = new JSONObject();
					oj44.put("target",c.getSource());
					oj44.put("source",temp1.getSource());
					oj44.put("category",temp1.getValue());
					
					links.add(oj44);
					}
					else
					{
						System.out.println("lalalal");
						JSONObject oj44 = new JSONObject();
						oj44.put("target",name[x]);
						oj44.put("source",temp1.getSource());
						oj44.put("category",temp1.getValue());
						
						links.add(oj44);
					}
					i++;
				}
			}
			
			
			
			
			json.put("data",data);
			json.put("links",links);
			json.put("categories", categories);
			
			response.setCharacterEncoding("utf-8");
			//System.out.println(json.toJSONString());
			response.getWriter().write(json.toJSONString());
		}
	}

}
