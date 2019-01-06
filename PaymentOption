import java.util.HashMap;
import java.util.Scanner;

public class PaymentOption {
	private int choice=0;
	private Scanner sc;
	private String Address=null;
	private String card_number=null;
	private String card_name=null;
	private String cvv_number=null;
	private String date=null;
	private String mobile_number=null;
	productdetails pd;
	int max = 100000; 
	int min = 100; 
	int range = max - min + 1;
	HashMap<String,CustomerDetails> ad=homepage.ex_cus;
	public void checkAddress()
	{
		int x=0;
		sc=new Scanner(System.in);
		System.out.println("Shippment Address ");
		
		
		
		CustomerDetails detail=ad.get(homepage.email);
		System.out.println(detail.getaddress());
		System.out.println("Do you Want to Change this Address?");
		do {
		try {
		System.out.println("1-yes  2-No");

		choice=sc.nextInt();
		if(choice==1)
		{
			System.out.println("enter new addrss");
			sc.nextLine();
			Address=sc.nextLine();
			detail.setaddress(Address);
			this.checkAddress();
		}
		if(choice==2)
		{
		this.Payment();
		}
		x=1;
		}catch(Exception e)
		{
			System.out.println("Enter correct option");
			sc.next();
		}
		}while(x==0);
	}
	
	
	public void Payment()
	{
		pd=new productdetails();
		sc=new Scanner(System.in);
		System.out.println("choose payment option");
		System.out.println("1.Paytm Wallet");
		System.out.println("2.credit card");
		System.out.println("3.Debit card");
		System.out.println("4.Net Banking");
		System.out.println("5.Free Charge");
		System.out.println("6.Cash On Delivery");
		System.out.println("7.cancel");
		System.out.println("enter your choice");
		choice=sc.nextInt();
		
		switch(choice)
		{
			case 1:
				this.PaytmWallet();
				pd.mainmenu();
				break;
			case 2:
				this.CreditCart();
				pd.mainmenu();
				break;
			case 3:
				this.DebitCart();
				pd.mainmenu();
				break;
			case 4:
				this.NetBanking();
				pd.mainmenu();
				break;
			case 5:
				this.COD();
				pd.mainmenu();
				break;
			case 6:
				this.COD();
				pd.mainmenu();
				break;
			case 7:
				pd.mainmenu();
				break;
				
				
				
		}
		
	}



	private void COD() {
		CustomerDetails detail=ad.get(homepage.email);
		System.out.println("order Successfull ");
		detail.setstatus(1);
		System.out.println("your order reference number:"+randvalue());
	}


	private void NetBanking() {
		CustomerDetails detail=ad.get(homepage.email);
		choice=0;
		System.out.println("1.HDFC");
		System.out.println("2.SBI");
		System.out.println("ICICI");
		choice=sc.nextInt();
		System.out.println("order Successfull ");
		detail.setstatus(1);
		System.out.println("your order reference number:"+randvalue());
	}


	private void DebitCart() {
		CustomerDetails detail=ad.get(homepage.email);
		System.out.println("card number");
		card_number=sc.nextLine();
		System.out.println("name on card");
		sc.nextLine();
		card_name=sc.nextLine();
		System.out.println("enter CVV number");
		cvv_number=sc.nextLine();
		System.out.println("expiry date");
		date=sc.nextLine();
		System.out.println("enter mobile number");
		mobile_number=sc.nextLine();
		System.out.println("order Successfull ");
		detail.setstatus(1);
		//PaymentClass pc=new PaymentClass(homepage.email,card_number,cvv_number,date,card_name,mobile_number);
		System.out.println("your order reference number:"+randvalue());
	}


	private void CreditCart() {
		CustomerDetails detail=ad.get(homepage.email);
		System.out.println("card number");
		sc.nextLine();
		card_number=sc.nextLine();
		System.out.println("name on card");
		
		card_name=sc.nextLine();
		System.out.println("order Successfull ");
		detail.setstatus(1);
		System.out.println("your order reference number:"+randvalue());
	}


	private void PaytmWallet() {
		CustomerDetails detail=ad.get(homepage.email);
		System.out.println("order Successfull ");
		detail.setstatus(1);
		System.out.println("your order reference number:"+randvalue());
	}
	
	public int randvalue()
	{
		int rand = (int)(Math.random() * range) + min;
		return rand;
	}
	
}
