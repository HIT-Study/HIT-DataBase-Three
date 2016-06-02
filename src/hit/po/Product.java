package hit.po;

import java.math.BigDecimal;

public class Product {
    private String productno;

    private String productname;

    private String productclass;

    private BigDecimal productprice;

    private Integer instock;

    public String getProductno() {
        return productno;
    }

    public void setProductno(String productno) {
        this.productno = productno == null ? null : productno.trim();
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public String getProductclass() {
        return productclass;
    }

    public void setProductclass(String productclass) {
        this.productclass = productclass == null ? null : productclass.trim();
    }

    public BigDecimal getProductprice() {
        return productprice;
    }

    public void setProductprice(BigDecimal productprice) {
        this.productprice = productprice;
    }

    public Integer getInstock() {
        return instock;
    }

    public void setInstock(Integer instock) {
        this.instock = instock;
    }

	public Product(String productno, String productname, String productclass,
			BigDecimal productprice, Integer instock) {
		super();
		this.productno = productno;
		this.productname = productname;
		this.productclass = productclass;
		this.productprice = productprice;
		this.instock = instock;
	}
    
    
}