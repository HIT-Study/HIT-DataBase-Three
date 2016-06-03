package hit.controller;
/**
 * 修改控制器
 */

import hit.po.Customer;
import hit.po.Employee;
import hit.po.OrderDetail;
import hit.po.OrderMaster;
import hit.po.Product;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.sql.SQLException;  


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
public class ProductController extends AbstractController {

	

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	@RequestMapping(value="/updateProductTable.do",method={RequestMethod.POST,RequestMethod.GET})
	public String selectAllTable(@RequestParam(defaultValue="") String table,HttpServletRequest request) throws SQLException{
		
		
		 String sql = null;  
	     DBHelper db1 = null;  
	     ResultSet ret = null;  
		System.out.println("table名称是：" + table);
		if (table != null) {
			sql = "select * from " + table;// SQL语句
			
			db1 = new DBHelper(sql);// 创建DBHelper对象

			ret = db1.pst.executeQuery();// 执行语句，得到结果集
			List list = new ArrayList();
			while (ret.next()) {
				Product product = new Product(ret.getString(1),
						ret.getString(2), ret.getString(3),new BigDecimal(ret.getString(4)),
						Integer.parseInt(ret.getString(5)));
				list.add(product);
			}// 显示数据
			request.getSession().setAttribute("list", list);
		}
		   
		    return "Page/2";
	
		}
		    
	
	@RequestMapping(value="/updateProductTableByone.do",method={RequestMethod.POST,RequestMethod.GET})
	public String updateProductTableByone(@RequestParam(defaultValue="") String productno,
			@RequestParam(defaultValue="") String productname,@RequestParam(defaultValue="") String productclass,
			@RequestParam(defaultValue="") String productprice,@RequestParam(defaultValue="") int instock,HttpServletRequest request) throws SQLException{
		
		
		 String sql = null;  
	     DBHelper db1 = null;  
	     ResultSet ret = null;  
		//System.out.println("table名称是：" + table);
	      sql = "update product p set p.productname = \'" + productname + "\',p.productclass = \'" + productclass  +"\',  p.productprice = " + new BigDecimal(productprice)
	    		 + ", p.instock = " +instock + " where p.productno = \'" + productno + "\'";
	      System.out.println(sql);
	      db1 = new DBHelper(sql);//创建DBHelper对象  
	        
	      Boolean bool = db1.pst.execute();//执行语句，得到结果集  
	       System.out.println(bool);
	      DBHelper db2 = new DBHelper("select * from product");
	       ret = db2.pst.executeQuery();
	       List list = new ArrayList();
		   	while (ret.next()) {
				Product product = new Product(ret.getString(1),
						ret.getString(2), ret.getString(3),new BigDecimal(ret.getString(4)),
						Integer.parseInt(ret.getString(5)));
				list.add(product);
			}// 显示数据
	       request.getSession().setAttribute("list", list);
		return "Page/2";
		
		    
		}
	
	@Test
	public void testCollection(){
		
		 String sql = null;  
	     DBHelper db1 = null;  
	     ResultSet ret = null;  
		    	
			sql = "delete from orderdetail where orderNo ='200801090001'" ;//SQL语句  
	        db1 = new DBHelper(sql);//创建DBHelper对象  
	  
	        try {  
	         db1.pst.executeQuery();//执行语句，得到结果集  
	         /*   List list = new ArrayList();
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
	            }//显示数据  */
	            ret.close();  
	            db1.close();//关闭连接  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
		}
	
	
	
	
}
