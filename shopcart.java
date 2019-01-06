import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Shopcart {

	productdetails pd;
	PaymentOption po;
	
	
	public static HashMap<String, HashMap<Integer,Integer>> customer=new HashMap<>();
	Scanner sc = new Scanner(System.in);
	private int itemid =0;
	private int cnt_degress=0;
	private double total=0;
	private double subtotal=0;
	private int count = 0;
	private int choice=0;
//add item function

	public void finadd(int itemid,int count)
	{
		try {
		products val = homepage.product.get(itemid);
		cnt_degress = val.getqty() - count;
		val.setqty(cnt_degress);

		HashMap<Integer,Integer> pr=new HashMap<>();
	
		pr.put(itemid, count);
		
			if(customer.containsKey(homepage.email))
			{
				HashMap<Integer,Integer> hm=customer.get(homepage.email);
				Integer ct=hm.get(itemid)!=null?hm.get(itemid)+count:count;
				hm.put(itemid,ct);
				pr=hm;
			}
				customer.put(homepage.email, pr);
		
				System.out.println("Item successfully added your bucket");
		}catch(Exception e)
		{
			System.out.println("failed");
			e.printStackTrace();
		}

		
	}
	

	public boolean check_count(int item_id, int count) {
		 itemid = item_id;
		 if (homepage.product.containsKey(itemid)) {
			products val = homepage.product.get(itemid);
				if ((count > val.getqty())) {
					return false;

				}
				else
				{
					return true;
				}
		 	}
		 return false;
}
	
	public void show()
	{

		 total = 0;
		 subtotal=0;
		 choice=0;
		 HashMap<String,CustomerDetails> ad=homepage.ex_cus;
		
		 try {
		HashMap<Integer, Integer> pr=customer.get(homepage.email);
		CustomerDetails detail=ad.get(homepage.email);
		if(detail.getstatus()==1) {
		System.out.println("order status : process to shipping" );
		}
		
		System.out.println(pr.size() + " items your bucket. ");
		
		System.out.println("Item_id"+"  "+"(ITEM_NAME)" + "  " + "(M.R.P)" + "  "+"(discount)" + "( quantity)"+"\t(total)");
		for(Map.Entry<Integer,Integer> li:pr.entrySet())
		{
			products pi=homepage.product.get(li.getKey());
			total=pi.getdiscountprice()*li.getValue();
			subtotal+=total;
			System.out.println(li.getKey()+"   \t"+pi.getname()+" \t "+pi.getprice()+"\t\t "+  pi.getdiscount() + "\t\t"+li.getValue()+"\t\t"+total);
			
		}
		
		System.out.println("              \t \t    sub total = "+subtotal);
		
		do {
		System.out.println();
		System.out.println("1.Continue to shopping");
		System.out.println("2.Confirm to checkout");
		System.out.println("3.Add/Decrease  Quantity");
		System.out.println("4.remove item from your bucket");
		System.out.println("5.Go back Mainmenu");
		try {
		choice=sc.nextInt();
		    
		switch(choice)
		{
			case 1:
				pd=new productdetails();
				pd.listmenu();
				break;
			case 2:
				if(pr.size()>0) {
					if(detail.getstatus()==1) {
						System.out.println("you want to again buy this item?");
						System.out.println("1.yes\n2.no");
						int c=sc.nextInt();
						if(c==1)
						{
							po=new PaymentOption();
							po.checkAddress();
						}
						else
						{
							this.show();
						}
					}
					po=new PaymentOption();
					po.checkAddress();
				
				}
				
				break;
			case 3:
				this.AddAdditionalQuantity();;
				this.show();
				break;
			case 4:
				this.RemoveItem();
				this.show();
				break;
			case 5:
				pd=new productdetails();
				pd.mainmenu();
				break;
				
			
		}
		}
		catch(Exception e)
		{
			System.out.println("enter correct value");
			sc.next();
		}
		}while(choice!=5);
		 }catch(Exception e)
		{
			System.out.println("0 items your bucket");
			
		}
	}
	public void AddAdditionalQuantity() 
	{
		count=0;
		try {
		HashMap<Integer, Integer> pr=customer.get(homepage.email);
		System.out.println("\n1.Add\n2.Decrease");
		int m=sc.nextInt();
		
		System.out.println("enter item id");
		
		itemid=sc.nextInt();
		
	
		if((m==1)&&pr.containsKey(itemid))
		{
			System.out.println("how many extra Quantity you want to add");
			count=sc.nextInt();
			if(check_count(itemid,count))
			{
				
				products val = homepage.product.get(itemid);
				cnt_degress = val.getqty() - count;
				val.setqty(cnt_degress);
				
				
						HashMap<Integer,Integer> hm=customer.get(homepage.email);
						Integer ct=hm.get(itemid)!=null?hm.get(itemid)+count:count;
						
						hm.put(itemid,(ct));
						pr=hm;
						customer.put(homepage.email, pr);
				
						System.out.println("Item successfully added your bucket");
						
				
			}
			else
			{
				System.out.println("sorry insufficient item");
			}
			
		}
		else if((m==2)&&pr.containsKey(itemid))
		{
			System.out.println("how many Quantity you want to decrease?");
			count=sc.nextInt();
			
				products val = homepage.product.get(itemid);
				cnt_degress = val.getqty()+count;
				val.setqty(cnt_degress);
				
				
						HashMap<Integer,Integer> hm=customer.get(homepage.email);
						Integer ct=hm.get(itemid)!=null?hm.get(itemid)-count:count;
						if(ct<=0) {
							itemid=0;
						hm.put(itemid,(ct));
						pr=hm;}
						else
						{
							hm.put(itemid,(ct));
							pr=hm;}
						customer.put(homepage.email, pr);
				
						System.out.println("Item successfully decreased your bucket");
						
					
		}
		else
		{
			System.out.println("Item id not found your basket");
		}
		}catch(Exception e)
		{
			//e.printStackTrace();
			System.out.println("enter correct option");
			sc.next();
		}
	
	}
		
	
	private void RemoveItem() {
		
		if(customer.containsKey(homepage.email)) {
		
		HashMap<Integer, Integer> pr=customer.get(homepage.email);
		
		
		System.out.println("enter ItemId to remove");
		itemid=sc.nextInt();
		
		if(pr.containsKey(itemid))
		{
			int c=pr.get(itemid);
			
			products val = homepage.product.get(itemid);
			val.setqty(val.getqty()+ c );
			pr.remove(itemid);
			System.out.println("successfully removed");
		}
	
		else
		{
			System.out.println("**itemid not found your basket");
		}
		
	}

	}
	
	
	
	
		
}
