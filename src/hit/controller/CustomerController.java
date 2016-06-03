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
public class CustomerController extends AbstractController {

	

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	@RequestMapping(value="/selectCustomerTable.do",method={RequestMethod.POST,RequestMethod.GET})
	public String selectAllTable(@RequestParam(defaultValue="") String table,
			@RequestParam(defaultValue="") String customerNo,@RequestParam(defaultValue="") String customerName,
			@RequestParam(defaultValue="") String telephone,@RequestParam(defaultValue="") String address,
			@RequestParam(defaultValue="") String zip,HttpServletRequest request) throws SQLException{
		
		
	
		 String sql = null;  
	     DBHelper db1 = null;  
	     ResultSet ret = null;  
		 System.out.println("table名称是："+table);
		    if(table!=null){
				sql = "select * from " + table;//SQL语句  
				/*System.out.println(customerNo==null);
				System.out.println(customerNo=="");
				System.out.println(customerName.equals(""));
				System.out.println(customerName);*/
				String prepareSql = null;
				if(customerName.equals("") && customerNo.equals("") && telephone.equals("") && address.equals("") && zip.equals("")){
					 prepareSql = sql;
					System.out.println(sql);
				}else {
					 prepareSql = sql + " where ";
					if (customerNo!="") {
						prepareSql += " customerNo = \"" + customerNo + "\"";
					}else if (customerName!="") {
						prepareSql += " and customerName = \"" + customerName + "\"";
					}else if (telephone!="") {
						prepareSql += " and telephone =\"" + telephone + "\"";
					}else if (address !="") {
						prepareSql += " and address=\"" + address +"\"" ;
					}else if (zip!="") {
						prepareSql += " and zip = \"" + zip + "\"";
					}
					System.out.println("拼接之后的sql语句"+prepareSql);
				}
			
				
			//String newSql = sql.replaceFirst("and", "");
				
	        db1 = new DBHelper(prepareSql);//创建DBHelper对象  
	        
	        ret = db1.pst.executeQuery();//执行语句，得到结果集  
	        List list = new ArrayList();
	        	 while (ret.next()) {  
		            Customer customer = new Customer(ret.getString(1),ret.getString(2),ret.getString(3)
		            		,ret.getString(4),ret.getString(5));
		                list.add(customer);
		            }//显示数据  
	        	 request.getSession().setAttribute("list", list);
	        }
		   
		    return "Page/1";
	
		}
		    
	
	@Test
	public void testCollection(){
		
		 String sql = null;  
	     DBHelper db1 = null;  
	     ResultSet ret = null;  
		    	
			sql = "update product p set p.productname = '32M DRAM' ,p.productclass = '内存12',  p.productprice = 80.70, p.instock = 80 where p.productno = 'P20050001'" ;//SQL语句  
	        db1 = new DBHelper(sql);//创建DBHelper对象  
	  
	        try {  
	            Boolean flag = db1.pst.execute();//执行语句，得到结果集  
	            System.out.println(flag);
	            List list = new ArrayList();
	          /*  while (ret.next()) {  
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
*/	          /*  ret.close();  */
	            db1.close();//关闭连接  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
		}
}
