

public class CustomerDetails {
	
	private String email;
	private String password;
	private String name;
	private String address;
	private int status;

	CustomerDetails(String email,String name,String  password,String address,int status)
	{
		this.email=email;
		this.password=password;
		this.name=name;
		this.address=address;
		this.status=status;
	}

	public String getemail()
	{
		return email;
	}
	public void setemail(String email)
	{
		this.email=email;
	}
	public String getname()
	{
		return name;
	}
	public void setname(String name)
	{
		this.name=name;
	}
	public String getpassword()
	{
		return password;
	}
	public void setpassword(String password)
	{
		this.password=password;
	}
	public String getaddress()
	{
		return address;
	}
	public void setaddress(String address)
	{
		this.address=address;
	}
	public void setstatus(int status)
	{
		this.status=status;
		
	}
	public int getstatus()
	{
		return status;
	}
	public String toString()
	{
		String str=name+"   "+email+"        "+address;
		return str;
	}


}
