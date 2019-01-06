
public class products {
	private String name;
	private Double price;
	private int qty;
	private int product_id;
	private String category;
	private Double discount;
	
	public products(String category,int product_id,String name,Double price,int qty,double discount)
	{
		this.category=category;
		this.product_id=product_id;
		this.name=name;
		this.price=price;
		this.qty=qty;
		this.discount=discount;
		
	}
	public int getproductid()
	{
		return product_id;
	}
	public void setproductid(int product_id)
	{
		this.product_id=product_id;
	}
	public String getcategoryname()
	{
		return category;
	}
	public void setcategoryname(String category)
	{
		this.category=category;
	}
	public String getname()
	{
		return name;
	}
	public void setname(String name)
	{
		this.name=name;
	}
	public Double getprice()
	{
		return price;
	}
	public void setprice(Double price)
	{
		this.price=price;
	}
	public int getqty()
	{
		return qty;
	}
	public void setqty(int qty)
	{
		this.qty=qty;
	}
	public double getdiscount()
	{
		return discount;
	}
	public void setdiscount(double discount)
	{
		this.discount=discount;
	}
	public void setqty(double discount)
	{
		this.discount=discount;
	}
	public double getdiscountprice()
	{
		double amount=100-discount;
		 
		amount= (amount*price)/100;
		return amount;
	}
	public String toString()
	{
		String str=name+" "+price+" "+qty;
		return str;
	}

}

 
