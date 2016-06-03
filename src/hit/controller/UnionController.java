package hit.controller;
/**
 * 多表联合查询
 */

import hit.po.Customer;
import hit.po.Employee;
import hit.po.OrderDetail;
import hit.po.OrderMaster;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.sql.SQLException;  


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ho.yaml.Yaml;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
@Controller
public class UnionController extends AbstractController {

	

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	@RequestMapping(value="/selectUnionTable.do",method={RequestMethod.POST,RequestMethod.GET})
	public String selectAllTable(@RequestParam(defaultValue="") String employeeName,HttpServletRequest request) throws SQLException, UnsupportedEncodingException{
		
		request.setCharacterEncoding("utf-8");
	
		 String sql = null;  
	     DBHelper db1 = null;  
	     ResultSet ret = null;  
		 System.out.println("Employee名称是："+employeeName);
		sql = "select * from ordermaster o , employee e where e.employeeNo=o.employeeNo and  e.employeeName = \"" + employeeName + "\"" ;//SQL语句  
				System.out.println(sql);
	        db1 = new DBHelper(sql);//创建DBHelper对象  
	        
	        ret = db1.pst.executeQuery();//执行语句，得到结果集  
	        int count = ret.getMetaData().getColumnCount();
	        System.out.println(count);
	        
	        List list = new ArrayList();
	       List<List> bigList = new ArrayList<List>() ;
	       
	       
	        	 while (ret.next()) {
	        		 for (int i = 1; i <count ; i++) {
						System.out.println(ret.getString(i));
						list.add(ret.getString(i));
					}
		       bigList.add(list);
	        }
		   request.getSession().setAttribute("bigList", bigList);
		   
		   return "Page/4";
	}


}
		    
	
