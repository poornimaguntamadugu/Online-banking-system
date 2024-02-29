import java.util.Date;

class LoanApplication {
    private String applicantName;
    private double loanAmount;
    private double interestRate;
    private int repaymentPeriodMonths;
    private boolean approved;
    private Date applicationDate;

    // Constructor, getters, and setters
}

class LoanManagementSystem {
    public void applyForLoan(String applicantName, double loanAmount, double interestRate, int repaymentPeriodMonths) {
        // Create a new loan application and store it in the database
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setApplicantName(applicantName);
        loanApplication.setLoanAmount(loanAmount);
        loanApplication.setInterestRate(interestRate);
        loanApplication.setRepaymentPeriodMonths(repaymentPeriodMonths);
        loanApplication.setApplicationDate(new Date());
        loanApplication.setApproved(false);

        // Save loan application to the database
        // (Database integration code here)
    }

    public void makeLoanPayment(LoanApplication loanApplication, double paymentAmount) {
        // Check if the loan application is approved
        if (loanApplication.isApproved()) {
            // Record the payment and update the loan balance in the database
            // (Database integration code here)
        } else {
            System.out.println("Cannot make payment for unapproved loan application.");
        }
    }

    public void checkLoanStatus(LoanApplication loanApplication) {
        // Display the status of the loan application (e.g., approved, pending, rejected)
        if (loanApplication.isApproved()) {
            System.out.println("Loan application approved.");
        } else {
            System.out.println("Loan application pending approval.");
        }
    }
}

public class LoanManagementDemo {
    public static void main(String[] args) {
        LoanManagementSystem loanManagementSystem = new LoanManagementSystem();

        // User applies for a loan
        loanManagementSystem.applyForLoan("John Doe", 5000.0, 5.0, 12);

        // User checks loan status
        LoanApplication loanApplication = new LoanApplication(/* retrieve loan application from database */);
        loanManagementSystem.checkLoanStatus(loanApplication);

        // User makes a loan payment
        loanManagementSystem.makeLoanPayment(loanApplication, 1000.0);
    }
}
