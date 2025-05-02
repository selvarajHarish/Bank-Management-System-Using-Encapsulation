##Bank Management System Using Encapsulation##

## Implementation Steps

### Step 1: Create the Project Structure
- Set up a Java project and create a package named `encapsulation`.
- Inside the package, create three classes:
  - **Bank.java** (Model)
  - **BankController.java** (Controller)
  - **BankView.java** (View)

### Step 2: Implement the Model Class (`Bank.java`)
- Define private attributes:
  - `id`, `pwd`, `name`, `accNo`, `balance`, `pin`, `ph`, `email`, `accType`, `ifsc`
- Add getter and setter methods to enforce encapsulation.
- Ensure sensitive fields like `balance` and `pin` can only be updated through controlled methods.

### Step 3: Implement the Controller Class (`BankController.java`)
- Create a `Scanner` object to handle user input.
- Implement key methods:
  - `register()` → User registration
  - `isLoginSuccess()` → Login check
  - `openAccount()` → Create account with unique accNo & ₹5000 minimum balance
  - `passBook()` → Display account details
  - `checkBalance()` → Show balance (PIN required)
  - `deposit()` → Deposit money
  - `moneyTransfer()` → Transfer funds with PIN + balance check
  - `changePin()` → Update PIN after verifying old PIN

### Step 4: Implement the View Class (`BankView.java`)
- Build a menu-based system to:
  - Register
  - Login
  - Perform banking operations
  - Logout and exit
- Use a `while` loop + `switch-case` to handle user actions.
- Call controller methods from user selections.

### Step 5: Test the Application
- Register a new user and check credentials.
- Login with valid and invalid details.
- Perform deposits, balance checks, transfers.
- Verify PIN authentication.
- Test error handling (wrong PIN, insufficient balance, etc.).


## Features

- Encapsulation (private fields + public getters/setters)
- OOP concepts in Java
- Input validation
- Real-world banking operations simulation
