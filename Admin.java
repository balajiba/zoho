import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Admin {

	private int item_id=0;
	private  String item_name;
	private double item_price=0;
	private int item_qty=0;
	private  String name;
	private  String pass;
	private static int item_counter=16;
	private  int x=0;
	private int count=0;
	private  String category_name;
 private int cat_choice=0;
	 private static int counter=0;
	 private double discount=0;
	private static Scanner sc;
	boolean flag=false;
	public static ArrayList<String> list=new ArrayList<>();
	public ArrayList<String> removed_list=new ArrayList<>();
	
	static {
	
		list.add("fruits");
		list.add("foodgrains");
		list.add("snacks");
		list.add("babycare");
	}

	
	public static HashMap<String,String> admin=new HashMap<>();
	static {
	
		admin.put("admin", "admin");
	
	}
	
	public void AdminLogin()
	{
		
		sc = new Scanner(System.in);
		//Scanner sc=new Scanner(System.in);
		System.out.println("enter name");
		name=sc.nextLine();
		System.out.println("enter password");
		pass=sc.nextLine();
		
		if(isValid(name,pass))
		{
			this.AdminMenu();
		}
		else
		{
			System.out.println("incorrect name/password");
		}
	}
	
	
	
public boolean isValid(String name,String pass)
{
	if(admin.containsKey(name))
	{
		if(admin.containsValue(pass))
			return true;
	}
	
	return false;
}



	public void AdminMenu() {
		
		int id=0;
		
	do {
		flag=false;
		id = 0;
		try {
		System.out.println();
		System.out.println("1.View Customer Details");
		System.out.println("2.view prdoducts details");
		System.out.println("3.Add Products");
		System.out.println("4.Remove category");
		System.out.println("5.LogOut");
		
		id = sc.nextInt();

		switch (id) 
		{
			
		case 1:
			this.ViewCustomerDetails();
			this.AdminMenu();
			flag=true;
			break;
		case 2:
			this.ViewProductDetails();;
			this.AdminMenu();
			flag=true;
			break;
		case 3:
			this.Addproducts();
			this.AdminMenu();
			flag=true;
			break;
		case 4:
			this.RemoveCategory();
			this.AdminMenu();
			flag=true;
			break;
		case 5:
			flag=true;
			homepage.main(null);
			break;

		}
		
	
		
		}catch(Exception e)
		{
			System.out.println("choose correct option");
			flag=true;
			sc.nextLine();
		}
		if(!flag)
		{
			System.out.println("choose correct input");
		}
		}while(id>0||id<6);
		
	}
	

	
	
	
//view customer details
	public void ViewCustomerDetails() {
		HashMap<String, CustomerDetails> ex_cus = homepage.ex_cus;
	
		System.out.println("(NAME)" + "  " + "(MAIL)" + "      " + "(ADDRESS)");

		for (Map.Entry<String, CustomerDetails> map : ex_cus.entrySet()) {
			CustomerDetails val = map.getValue();

			System.out.println(val.toString());
		}
		
		

	}
//view productdetails
	
	public void ViewProductDetails()
	{
		
		counter = 0;
		System.out.println("--- AVAILABLE CATEGORY---");
		System.out.println("0.Go back to prevoius menu");

		ArrayList<String> list=Admin.list;
		
		for(String obj:list)  
		{
		
			counter++;
			System.out.println(counter+"."+obj);  
		}
		do {
			cat_choice=1;
		try {
		System.out.println("enter your choice..");
		
		cat_choice = sc.nextInt();
		
			if(cat_choice!=0&&(Admin.list.size()>=cat_choice))
			{
				
				this.display((cat_choice-1));
			}
			else if(cat_choice==0)
			{
				this.AdminMenu();
			}
			else
			{
				System.out.println("select correct option");
			}
		
		}catch(Exception e)
		{
			System.out.println("enter valid input");
			sc.next();
		}
	
		}while(cat_choice!=0);
}



	public void display(int value)
	{
		flag=false;
		
		System.out.println();

		
		System.out.println("Item_id"+"  "+"(ITEM_NAME)" + "  " + "(PRICE)" + " " + "(AVAILABLE quantity)");
		
		for (Map.Entry<Integer, products> m : homepage.product.entrySet()) {
			products val = m.getValue();

			if (val.getcategoryname().equals(Admin.list.get(value))) 

				System.out.println(val.getproductid()+"       "+val.getname() + "        " + val.getprice() + "             " + val.getqty());
		}
		do {	cat_choice=0;
			
		try {
			
				System.out.println();
			System.out.println("(1)Add Item\n(2)Remove item\n(3)AddQuantity\n(4)Price change\n(5)discount change\n(6)previous menu");

			cat_choice = sc.nextInt();
			

			if (cat_choice == 1) {
				flag=true;
				this.AddItem(value);
				this.ViewProductDetails();
				
			}
			else if (cat_choice == 2) {
				flag=true;
				this.RemoveItem(value);
				this.ViewProductDetails();
				
			}
			else if (cat_choice == 3) {
				flag=true;
				this.AddQuantity(value);
				this.ViewProductDetails();
				
			}
			else if(cat_choice==4)
			{
				flag=true;
				this.PriceChange(value);
				this.ViewProductDetails();
				
			}
			else if(cat_choice==5)
			{
				flag=true;
				this.discountChange(value);
				this.ViewProductDetails();
				
			}
			else if (cat_choice == 6) {
				flag=true;
				this.ViewProductDetails();
				
			}
			
				
			}catch(Exception e)
			{
				System.out.println("please enter valid number");
				//e.printStackTrace();
				sc.next();
			}
		if(!flag)
		{
			System.out.println("choose correct input");
		}
		}while(cat_choice!=6);
			
	}
	
	//add item to product
		public void AddItem(int choice)
		{
			
			 x=0;
			 
			 category_name=Admin.list.get(choice);
			
			do {
				try { 
				x=0;
				item_counter++;
				item_id =item_counter;
			  if(!check_itemIndex(item_id,choice))
				 {
					 sc.nextLine();
					 System.out.println("enter item name");
					 item_name=sc.nextLine();
					 System.out.println("enter item price");
					 item_price = sc.nextDouble();
					 System.out.println("enter item quantity");
					 item_qty = sc.nextInt();
					 System.out.println("enter discount");
					 discount=sc.nextDouble();
					 products new_item=new products(category_name,item_id,item_name,item_price,item_qty,discount);
					 homepage.product.put(item_id, new_item);
					 System.out.println("item successfully added");
				 }
				else
				{
					System.out.println(item_id);
					item_counter++;
				
				}
			 
			
			System.out.println("press 1 to continue or otherwise cancel");
			x=sc.nextInt();
			
			}catch(Exception e)
			{
				System.out.println("Enter valid input");
				sc.next();
			}
			}while(x==1);
		}
		
		public void RemoveItem(int index)
		{
			x=1;
			do {
			System.out.println("enter item id you want to remove");
			 try {
				item_id=sc.nextInt();
				if(check_itemIndex(item_id,index))
				{
					homepage.product.remove(item_id);
					System.out.println("item removed successfully");
					
				}

				else
				{
					System.out.println("item not found");
				}
			 }
			 catch(Exception e)
			 {
				 System.out.println("Enter valid input");
				sc.next();
			 }
			 System.out.println("press 1 to continue press 2 to Go back");
				x=sc.nextInt();
				}while(x==1);
			
		}
		
		
		public void AddQuantity(int index)
		{
			x=1;
			do{
				try {
			System.out.println("enter item id");
			item_id=sc.nextInt();
			if(check_itemIndex(item_id,index))
			{
			System.out.println("\n1.add\n2.decrease");
			int n=sc.nextInt();
			if(n==1) {
				System.out.println("how many quantity want to add?");
				count=sc.nextInt();
					
						products val = homepage.product.get(item_id);
						int cnt=val.getqty()+count;
					
						val.setqty(cnt);
						System.out.println("successfully quantity increased");
						
						
			}
			if(n==2)
			{
				System.out.println("how many quantity want to decrease?");
				count=sc.nextInt();
					
				products val = homepage.product.get(item_id);
				int cnt=val.getqty()-count;
				if(cnt>=0) {
				val.setqty(cnt);
				System.out.println("successfully quantity increased");
				}
				else
				{
					System.out.println("check quantity");
				}
			}
			}
			else
			{
				System.out.println("item not found");
			}
			
			}catch(Exception e)
			{
				System.out.println("Enter valid input");
				sc.next();
			}
			System.out.println("press 1 to continue press 2 to Go back");
			x=sc.nextInt();
			}while(x==1);
			
		}
		
		public void PriceChange(int index)
		{
			x=1;
			do {
				 try {
			System.out.println("enter item id");
			item_id=sc.nextInt();
			System.out.println("enter new price");
			item_price=sc.nextDouble();
			if(check_itemIndex(item_id,index))
			{
				products val = homepage.product.get(item_id);
				val.setprice(item_price);
				
				System.out.println("successfully price changed");
			}

			else
			{
				System.out.println("check itemid");
			}
				 }
			catch(Exception e)
			 {
				 System.out.println("Enter valid input");
				sc.next();
			 }
			System.out.println("press 1 to continue press 2 to Go back");
			x=sc.nextInt();
			}while(x==1);
		}
		public void discountChange(int index)
		{
			x=1;
			do {
				try {
			System.out.println("enter item id");
			item_id=sc.nextInt();
			
			if(check_itemIndex(item_id,index))
			{
				System.out.println("enter new discount");
				discount=sc.nextDouble();
				products val = homepage.product.get(item_id);
				val.setprice(discount);
				
				System.out.println("successfully discount changed");
			}

			else
			{
				System.out.println("check itemid");
			}
			}
			catch(Exception e)
			 {
				 System.out.println("Enter valid input");
				sc.next();
			 }
			System.out.println("press 1 to continue press 2 to Go back");
			x=sc.nextInt();
			}while(x==1);
		}
		
		
//public void addnew category
		public void Addproducts()
		
		{
			
			
			
			 x=0;
			 System.out.println("enter category name");
			 sc.nextLine();
			 category_name=sc.nextLine();
			 list.add(category_name);
			 
			do {
				
				x=0;
				item_counter++;
				try {
//			System.out.println("Enter item id");
			 item_id = item_counter;
			
				 if(!homepage.product.containsKey(item_id))
				 {
					 
					 System.out.println("enter item name");
					 item_name=sc.nextLine();
					 System.out.println("enter item price");
					 item_price = sc.nextDouble();
					 System.out.println("enter item quantity");
					 item_qty = sc.nextInt();
					 System.out.println("enter discount");
					 double discount=sc.nextDouble();
					 products new_item=new products(category_name,item_id,item_name,item_price,item_qty,discount);
					 homepage.product.put(item_id, new_item);
					 System.out.println("item successfully added");
			}
				else
				{
				System.out.println("item_id already exist");
				
				}
			}
			catch(Exception e)
			 {
				 System.out.println("Enter valid input");
				sc.next();
			 }
				
				System.out.println("press 1 to continue or otherwise cancel");
				x=sc.nextInt();
				}while(x==1);
				
			
		}
		
		public void RemoveCategory()
				{
				cat_choice=0;
					int x=0;
					counter=0;
					do
					{
						try {
					System.out.println("***Available Categories***");
					System.out.println("0.Go back");
					for(String obj:list)  
					{
						counter++;
					    System.out.println(counter+"."+obj);  
					}
					System.out.println("enter your choice");
					
					cat_choice=sc.nextInt();
					
					if(list.contains(list.get(cat_choice-1))) {
						removed_list.add(list.get(cat_choice-1));
						list.remove((cat_choice-1));
						System.out.println("successfully removed");
					}
					else
					{
						System.out.println("Not found");
					}
					}
					catch(Exception e)
					 {
						 System.out.println("Enter valid input");
						sc.next();
					 }
					
					System.out.println("press 9 to exit or otherwise continued");
					x=sc.nextInt();
					}while(x!=9);
				}
		public boolean check_itemIndex(int id, int index) {

			products val = homepage.product.get(id);
			if (homepage.product.containsKey(id) && ((Admin.list.get(index)).equals(val.getcategoryname()))) {
				return true;
			}

			else {
				return false;
			}

		}
		

}
