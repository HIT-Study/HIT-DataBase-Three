package hit.controller;
/**
 * 查询所有
 */

import hit.po.Customer;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.sql.SQLException;  


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
public class HITController extends AbstractController {

	

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	static String sql = null;  
    static DBHelper db1 = null;  
    static ResultSet ret = null;  
	
	@RequestMapping(value="/selectAllTable.do",method={RequestMethod.POST,RequestMethod.GET})
	public String selectAllTable(@RequestParam(defaultValue="") String table,HttpServletRequest request){
		    if(table!=null){
			sql = "select * from" + table;//SQL语句  
	        db1 = new DBHelper(sql);//创建DBHelper对象  
	  
	        try {  
	            ret = db1.pst.executeQuery();//执行语句，得到结果集  
	            List list = new ArrayList();
	            while (ret.next()) {  
	            	Customer customer = new Customer();
	                String customerNo = ret.getString(1);  
	                String customerName = ret.getString(2);  
	                String telephone = ret.getString(3);  
	                String address = ret.getString(4);  
	                String zip = ret.getString(5);  
	                customer.setCustomerno(customerNo);
	                customer.setCustomername(customerName);
	                customer.setZip(zip);
	                customer.setTelephone(telephone);
	                customer.setAddress(address);
	                System.out.println(customerNo + "\t" + customerName + "\t" + telephone + "\t" + address
	                		+ "\t" + zip );  
	                list.add(customer);
	            }//显示数据  
	            request.getSession().setAttribute("list", list);
	            ret.close();  
	            db1.close();//关闭连接  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
		
		return "Page/1";
		
		}else{
			return "error";
		}
		}
}
