package hit.controller;
/**
 * 查询所有
 */

import hit.po.OrderMaster;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
@Controller
public class OrderController extends AbstractController {

	

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:删除订单和级联删除，采用事务处理
	TODO
	 *创建时间:2016年6月3日下午12:34:35
	 * @return
	 */
	@RequestMapping(value="/deleteOrder.do")
	public String deleteOrder(@RequestParam(defaultValue="") String orderno,HttpServletRequest request) {
		/*System.out.println(orderno);
		  boolean flag = false;  
	      DBHelper db = null;   
		
	       String sql = "delete from ordermaster where orderNo = " + orderno;
	       String sql_Second = "delete from orderdetail where orderNo" + orderno;
		
	      try {
			db.conn.setAutoCommit(false);
			db.pst.execute(sql);
			db.pst.addBatch();
			db.pst.execute(sql_Second);
			db.pst.addBatch();
			db.pst.executeBatch();
			db.conn.commit();
		} catch (Exception e) {
			try {  
                db.conn.rollback(); //进行事务回滚  
            } catch (SQLException ex) {   
            }   
			// TODO: handle exception
		}finally {  
            db.close();  
        }   */
		  String sql = "delete from ordermaster where orderNo = \'"+ orderno +"\'";
	       String sql_Second = "delete from orderdetail where orderNo = \'"+ orderno +"\'";
	      try {
	    	  DBHelper db1 = new DBHelper(sql_Second);
	    	  DBHelper db2 = new DBHelper(sql);
	    	  db1.pst.execute();
	    	  db2.pst.execute();
	    	  selectAllTable("ordermaster", request);
		} catch (Exception e) {
			
		}finally {  
         /*  db.close();*/
       }
		return "Page/3";   
	}
		
		
		
	
	
	
	
	@RequestMapping(value="/selectOrderTable.do",method={RequestMethod.POST,RequestMethod.GET})
	public String selectAllTable(@RequestParam(defaultValue="") String table,HttpServletRequest request) throws SQLException{
		
		
	
		 String sql = null;  
	     DBHelper db1 = null;  
	     ResultSet ret = null;  
		 System.out.println("table名称是："+table);
		    if(table!=null){
				sql = "select * from " + table;//SQL语句  
		
				System.out.println(sql);
	        db1 = new DBHelper(sql);//创建DBHelper对象  
	        
	        ret = db1.pst.executeQuery();//执行语句，得到结果集  
	        List list = new ArrayList();
	        	 while (ret.next()) {  
		            @SuppressWarnings("deprecation")
		            
					OrderMaster om = new OrderMaster(ret.getString(1),ret.getString(2),ret.getString(3)
							,ret.getString(4), new BigDecimal(ret.getString(5)),ret.getString(6));
		                list.add(om);
		            }//显示数据  
	        	 request.getSession().setAttribute("list", list);
	        }
		   
		    return "Page/3";
	
		}
		    
	
	@Test
	public void testCollection(){
	  /*     DBHelper db = null;   */
	       String sql = "delete from ordermaster where orderNo = '200801090002'";
	       String sql_Second = "delete from orderdetail where orderNo ='200801090002'";
	      try {
	    	  DBHelper db1 = new DBHelper(sql_Second);
	    	  DBHelper db2 = new DBHelper(sql);
	    	  db1.pst.execute();
	    	  db2.pst.execute();
		} catch (Exception e) {
		}finally {  
          /*  db.close();*/
        }   
	}
}
