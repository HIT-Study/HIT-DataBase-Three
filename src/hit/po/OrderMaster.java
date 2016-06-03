package hit.po;

import java.math.BigDecimal;
import java.util.Date;

public class OrderMaster {
    private String orderno;

    private String customerno;

    private String employeeno;

    private String orderdate;

    private BigDecimal ordersum;

    private String invoiceno;
    
    

    public OrderMaster(String orderno, String customerno, String employeeno,
			String orderdate, BigDecimal ordersum, String invoiceno) {
		super();
		this.orderno = orderno;
		this.customerno = customerno;
		this.employeeno = employeeno;
		this.orderdate = orderdate;
		this.ordersum = ordersum;
		this.invoiceno = invoiceno;
	}

	public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public String getCustomerno() {
        return customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno == null ? null : customerno.trim();
    }

    public String getEmployeeno() {
        return employeeno;
    }

    public void setEmployeeno(String employeeno) {
        this.employeeno = employeeno == null ? null : employeeno.trim();
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public BigDecimal getOrdersum() {
        return ordersum;
    }

    public void setOrdersum(BigDecimal ordersum) {
        this.ordersum = ordersum;
    }

    public String getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno = invoiceno == null ? null : invoiceno.trim();
    }
}