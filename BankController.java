package encapsulation;
import java.util.Scanner;

public class BankController {
    public static Scanner sc = new Scanner(System.in);
    public static Bank b = new Bank();
    public static int count = 0;

    // User Registration
    public static void register() {
        System.out.print("Enter Id: ");
        b.setId(sc.next());
        System.out.print("Enter Password: ");
        b.setPwd(sc.next());
        System.out.println("Registration Successful!");
    }

    // Login Validation
    public static boolean isLoginSuccess() {
        System.out.print("Enter Login Id: ");
        String id = sc.next();
        System.out.print("Enter Password: ");
        String pwd = sc.next();
        return id.equals(b.getId()) && pwd.equals(b.getPwd());
    }

    // Open a New Bank Account
    public static void openAccount() {
        System.out.print("Account Holder's Name: ");
        b.setName(sc.next());
        System.out.print("Phone Number: ");
        b.setPh(sc.nextLong());
        System.out.print("Email Id: ");
        b.setEmail(sc.next());
        System.out.print("Account Type (Savings/Current): ");
        b.setAccType(sc.next());
        System.out.print("Set a PIN: ");
        b.setPin(sc.nextInt());

        b.setAccNo(generateAccountNumber());
        b.setBalance(5000);
        b.setIfsc("HDFC0002277");

        System.out.println("Account Opened Successfully!");
    }

    // Generate Unique Account Number
    public static String generateAccountNumber() {
        String accNo = "2277";
        long no = 8765432;
        no *= ++count;
        String acc = no + "";
        for (int i = 0; i < 7; i++) {
            accNo += acc.charAt(i);
        }
        return accNo;
    }

    // View Passbook Details
    public static void passBook() {
        System.out.println("\n*PASSBOOK*");
        System.out.println("=========================");
        System.out.println("Account Holder: " + b.getName());
        System.out.println("Account Number: " + b.getAccNo());
        System.out.println("Balance: ₹" + b.getBalance());
        System.out.println("Phone Number: " + b.getPh());
        System.out.println("IFSC: " + b.getIfsc());
        System.out.println("Account Type: " + b.getAccType());
    }

    // Check Balance with PIN Authentication
    public static void checkBalance() {
        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();
        if (pin == b.getPin())
            System.out.println("Your Balance: ₹" + b.getBalance());
        else
            System.out.println("Invalid PIN!");
    }

    // Deposit Money into Account
    public static void deposit() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();
        System.out.print("Enter Amount: ₹");
        double amt = sc.nextDouble();
        if (accNo.equals(b.getAccNo())) {
            b.setBalance(b.getBalance() + amt);
            System.out.println("Deposit Successful! New Balance: ₹" + b.getBalance());
        } else {
            System.out.println("Invalid Account Number!");
        }
    }

    // Money Transfer Functionality
    public static void moneyTransfer() {
        System.out.print("Enter Transfer Amount: ₹");
        double amt = sc.nextDouble();
        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();
        if (pin == b.getPin()) {
            if (amt <= b.getBalance()) {
                b.setBalance(b.getBalance() - amt);
                System.out.println("Transaction Successful! Remaining Balance: ₹" + b.getBalance());
            } else {
                System.out.println("Insufficient Balance!");
            }
        } else {
            System.out.println("Incorrect PIN!");
        }
    }

    // Change PIN Function
    public static void changePin() {
        System.out.print("Enter Current PIN: ");
        int pin = sc.nextInt();
        if (pin == b.getPin()) {
            System.out.print("Enter New PIN: ");
            b.setPin(sc.nextInt());
            System.out.println("PIN Changed Successfully!");
        } else {
            System.out.println("Incorrect PIN!");
        }
    }
}
