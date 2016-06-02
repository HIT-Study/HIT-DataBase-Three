package hit.controller;
/**
 * 查询所有
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
public class HITController extends AbstractController {

	

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	@RequestMapping(value="/selectAllTable.do",method={RequestMethod.POST,RequestMethod.GET})
	public String selectAllTable(@RequestParam(defaultValue="") String table,HttpServletRequest request) throws SQLException{
		
		 String sql = null;  
	     DBHelper db1 = null;  
	     ResultSet ret = null;  
		 System.out.println("table名称是："+table);
		    if(table!=null){
		    								//customer
			sql = "select * from " + table;//SQL语句  
	        db1 = new DBHelper(sql);//创建DBHelper对象  
	        
	        ret = db1.pst.executeQuery();//执行语句，得到结果集  
	        List list = new ArrayList();
	        if(ret.getMetaData().getColumnCount()==5&&ret.getMetaData().getColumnName(1)=="customerNo"){
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
	        }else if(ret.getMetaData().getColumnCount()==10){
	        	while (ret.next()) {  
	        		@SuppressWarnings("deprecation")
					Employee employee = new Employee(ret.getString(1), ret.getString(2),
	        				ret.getString(3), new Date(ret.getString(4)), ret.getString(5), ret.getString(6), 
	        				new Date(ret.getString(7)), ret.getString(8), ret.getString(9), Long.parseLong(ret.getString(10)));
	                list.add(employee);
	            }//显示数据  
			}else if (ret.getMetaData().getColumnCount()==4) {
				//orderDetail
				while (ret.next()) {  
	            	OrderDetail od = new OrderDetail(ret.getString(1), ret.getString(2),Integer.parseInt( ret.getString(3)), new BigDecimal(ret.getString(4)));
	                list.add(od);
	            }//显示数据  
			}else if (ret.getMetaData().getColumnCount()==6) {
				//orderMaster
					OrderMaster om = new OrderMaster(ret.getString(1), ret.getString(2),
							ret.getString(3), ret.getString(4), ret.getString(5), ret.getString(6))
	                list.add(customer);
	            }//显示数据  
			}else {
				//product
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
			}
	           
	            request.getSession().setAttribute("list", list);
	            request.getSession().setAttribute("table", table);
	            ret.close();  
	            db1.close();//关闭连接  
	        	return "Page/1";
		
		}else{
			return "error";
		}
		}
	

	@Test
	public void testCollection(){
		
		 String sql = null;  
	     DBHelper db1 = null;  
	     ResultSet ret = null;  
		    	
			sql = "select * from customer" ;//SQL语句  
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
	            ret.close();  
	            db1.close();//关闭连接  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
		}
}
