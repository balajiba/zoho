import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;
public class homepage {
public static HashMap<String, CustomerDetails> ex_cus = new HashMap<>();
static {

		CustomerDetails cd = new CustomerDetails("bala@zoho.com", "bala", "12345", "chennai",0);
		CustomerDetails cd2 = new CustomerDetails("xyz@zoho.com", "xyz", "12345", "chennai",0);
		ex_cus.put(cd.getemail(), cd);
		ex_cus.put(cd2.getemail(), cd2);

	}

public static HashMap<Integer, products> product = new HashMap<>();
	static {

		product.put(1, new products("fruits", 1, "banana", 130.0, 10,2));
		product.put(2, new products("fruits", 2, "apple", 120.0, 3,5));
		product.put(3, new products("fruits", 3, "orange", 250.0, 5,12));
		product.put(4, new products("fruits", 4, "mangos", 80.0, 5,4));
		product.put(5, new products("foodgrains", 5, "rice", 300.0, 5,1));
		product.put(6, new products("foodgrains", 6, "salt", 30.0, 5,0));
		product.put(7, new products("foodgrains", 7, "dryfruits", 230.0, 5,2));
		product.put(8, new products("foodgrains", 8, "sugar", 280.0, 5,2));
		product.put(9, new products("snacks", 9, "biscuit", 30.0, 5,1));
		product.put(10, new products("snacks", 10, "chocolate", 270.0, 3,2));
		product.put(11, new products("snacks", 11, "icecreams", 410.0, 5,13));
		product.put(12, new products("snacks", 12, "popcorn", 80.0, 5,6));
		product.put(13, new products("babycare", 13, "diapers", 20.0, 5,0));
		product.put(14, new products("babycare", 14, "babyfood", 140.0, 3,3));
		product.put(15, new products("babycare", 15, "babytoys", 210.0, 5,11));
	
	}

	private static Scanner sc;
	private static int id;

	private static int user_input1=0;
	private static String new_name;
	public static String email;
	private static String password;
	private static String confirm_pass;
	private static String address;
	
	

	

	public static void main(String args[]) {
		
		Admin admin = new Admin();
		sc = new Scanner(System.in);

		do {
			try {
				System.out.println("Welcome To Zoho SuperMarket");
				System.out.println("1.Customer");
				System.out.println("2.Admin");
				System.out.println("3.Exit");
				

				id = sc.nextInt();

				switch (id) {
				case 1:
					System.out.println("1.new customer");
					System.out.println("2.Existing customer");
					System.out.println("3.back to home");

					user_input1 = sc.nextInt();
					if (user_input1 == 1) {
						CreateAccount();

					} else if (user_input1 == 2) {
						Ex_cus_login();

					}
					else if(user_input1==3)
					{
						break;
					}

					break;

				case 2:
					admin.AdminLogin();
					break;

				case 3:
					System.exit(0);
				}

			} catch (Exception e) {
				System.out.println("please choose correct option");
				sc.nextLine();
			}
	} while (id != 3);

	}

//create new customer account

	public static void CreateAccount() {

		sc = new Scanner(System.in);
		System.out.println("Enter your name");
		new_name = sc.nextLine();
		System.out.println("Enter your email");
		email = sc.nextLine();
		if (isValid(email)) {
			if (check_mail(email)) {
				System.out.println("Enter your password");
				password = sc.nextLine();
				System.out.println("Enter confirm password");
				confirm_pass = sc.nextLine();
				if (password.equals(confirm_pass)) {
					System.out.println("enter your address");
					address = sc.nextLine();
					CustomerDetails nc1 = new CustomerDetails(email, new_name,password, address,0);
					ex_cus.put(nc1.getemail(), nc1);
					System.out.println("successfully account created");

					System.out.println("please login here..");
					Ex_cus_login();

				} else {
					System.out.println("password enter must same");
				}

			}

			else {
				System.out.println("Mail already exist...please login or try another mail id");
			}
		} else {
			System.out.println("email not valid");
		}
	}

//check email exisit or not

	public static boolean check_mail(String new_email) {

		if (ex_cus.containsKey(new_email)) {

			return false;

		}

		else
			return true;
	}
// Existing customer login

	public static void Ex_cus_login() {
		sc = new Scanner(System.in);
		System.out.println("Enter your mail");
		email = sc.nextLine();
		if (!check_mail(email)) {
			System.out.println("Enter your password");
			password = sc.nextLine();

			boolean b = check_user(email, password);
			if (b) {
				productdetails pi = new productdetails();
				pi.mainmenu();
			}

		}

		else {
			System.out.println("try again.. check mailid");
		}
	}
public static boolean check_user(String email, String password) {
		

		if (ex_cus.containsKey(email)) {

			CustomerDetails val = ex_cus.get(email);
			if (val.getpassword().equals(password)) {

				return true;
			}
			else {
				System.out.println("incorrect password");
				return false;
			}
		}

		else {
			System.out.println("incorrect Mail");
			return false;
		}

	}

public static boolean isValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

}
