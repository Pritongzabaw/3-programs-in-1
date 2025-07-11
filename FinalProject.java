// CUELLAR, DWAYNE
// NALUZ, ZACH
// CS-102
// FINALS IN 6PROGSDATS [1ST YEAR, 2ND SEM]
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;
class Zodiac 
{
    // Parent class to determine the zodiac sign
    public static String getZodiacSign(int month, int day) {
        if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) {
            return "Your Zodiac sign is Aries";
        } else if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) 
        {
            return "Your Zodiac Sign is Taurus";
        } else if ((month == 5 && day >= 21) || (month == 6 && day <= 21)) 
        {
            return "Your Zodiac Sign is Gemini";
        } else if ((month == 6 && day >= 22) || (month == 7 && day <= 22)) 
        {
            return "Your Zodiac Sign is Cancer";
        } else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) 
        {
            return "Your Zodiac Sign is Leo";
        } else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) 
        {
            return "Your Zodiac Sign is Virgo";
        } else if ((month == 9 && day >= 23) || (month == 10 && day <= 23)) 
        {
            return "Your Zodiac Sign is Libra";
        } else if ((month == 10 && day >= 24) || (month == 11 && day <= 21)) 
        {
            return "Your Zodiac Sign is Scorpio";
        } else if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) 
        {
            return "Your Zodiac Sign is Sagittarius";
        } else if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) 
        {
            return "Your Zodiac Sign is Capricorn";
        } else if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) 
        {
            return "Your Zodiac Sign is Aquarius";
        } else if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) 
        {
            return "Your Zodiac Sign is Pisces";
        } else 
        {
            return null;
        }
    }
}

class ZodiacIdentifier extends Zodiac {
    // Child class to handle input and identify zodiac sign
    public void identifyZodiac() {
        Scanner scanner = new Scanner(System.in);
        LocalDate today = LocalDate.now();

        // User inputs
        System.out.println("Welcome to zodiac identifier");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        int month = -1;//This ensures that the while loop runs at least once.
        while (month < 1 || month > 12) {
            System.out.print("Enter month of birth (1-12): ");
            month = scanner.nextInt();
            if (month < 1 || month > 12) {
                System.out.println("Invalid month. Please enter a number between 1 and 12.");
            }
        }

        int day = -1;
        while (day < 1 || day > 31) {
            System.out.print("Enter day of birth (1-31): ");
            day = scanner.nextInt();
            if (day < 1 || day > 31) {
                System.out.println("Invalid day. Please enter a number between 1 and 31.");
            }
        }

        int year = -1;
        while (year < 1900 || year > today.getYear()) {
            System.out.print("Enter year of birth: ");
            year = scanner.nextInt();
            if (year < 1900 || year > today.getYear()) {
                System.out.println("Invalid year. Please enter a valid year of birth.");
            }
        }

        LocalDate birthDate = LocalDate.of(year, month, day);

        //  age calculation
        int age = Period.between(birthDate, today).getYears();

        String zodiacSignFinal = getZodiacSign(month, day);

        System.out.println("Hi " + name + "! You are " + age + " years old.");
        // Print birthday in the correct month
        printBirthday(month, day, year);

        if (zodiacSignFinal == null) {
            System.out.println("Invalid input for the zodiac sign.");
        } else {
            System.out.println(zodiacSignFinal);
        }

        scanner.close();
    }

    private void printBirthday(int month, int day, int year) //an array months of type String[] containing names of months
    {
        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        if (month >= 1 && month <= 12) //This if statement checks if the month parameter is within the valid range of 1 to 12.
        {
            System.out.println("Your birthday is on " + months[month - 1] + " " + day + ", " + year);
        }
    }
}



class EmployeeCompensation{
    public void employeecompensation() {
        Scanner employeeinput = new Scanner(System.in);
        double taxrate = 0.03;
        

        System.out.println("EMPLOYEE COMPENSATION");
        System.out.println();
        System.out.println("[1] Manager");
        System.out.println("[2] Supervisor");
        System.out.println("[3] Staff");

        int position;
        // Input validation for position
        while (true) 
        {
            System.out.print("Enter your position: ");
            
            // Check if the input is an integer
            if (employeeinput.hasNextInt()) 
            {
                position = employeeinput.nextInt();  // Read the input

                // Check if the input is valid (between 1 and 3)
                if (position >= 1 && position <= 3) {
                    break;  // Exit the loop if the input is valid
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 3.");
                }
            } 
            else 
            {
                // Handle the case when the input is not an integer
                System.out.println("Invalid input. Please enter a valid number.");
                employeeinput.nextLine(); 
            }
        }

        System.out.print("Enter the name of the employee: ");
        String name = employeeinput.next();  // Assuming name input as a single word

        // Input validation for rate per hour
        double rperhour;
        while (true) {
            System.out.print("Enter rate per hour: ");
            if (employeeinput.hasNextDouble()) {
                rperhour = employeeinput.nextDouble();
                break;
            } else 
            {
                System.out.println("Invalid input. Please enter a valid number for rate.");
                employeeinput.next();  // Clear the invalid input
            }
        }

        // Input validation for hours worked
        int hours;
        while (true) {
            System.out.print("Enter hours worked: ");
            
            // Check if the next input is a valid integer
            if (employeeinput.hasNextInt()) {
                hours = employeeinput.nextInt();  // Read the valid integer input
                break;  // Exit the loop if a valid integer is entered
            } else {
                System.out.println("Invalid input. Please enter a valid integer for hours.");
                employeeinput.next();  // Consume the invalid input
            }
        }

        // Calculate salary and tax details
        double salary = rperhour * hours;
        double taxdeductiontotal = salary * taxrate;
        double totalaftertax = salary - taxdeductiontotal;

        // Output the results
        System.out.println("Hello " + name + "!");
        
        if (position == 1) {
            System.out.println("You are a Manager.");
        } else if (position == 2) {
            System.out.println("You are a Supervisor.");
        } else if (position == 3) {
            System.out.println("You are a Staff.");
        }

        System.out.println("Your gross salary for your " + hours + " hours worked is Php " + salary);
        System.out.println("Your 3 percent tax is Php " + taxdeductiontotal);
        System.out.println("Your net salary after tax is Php " + totalaftertax);

        employeeinput.close();  // Close the scanner object
    }
} 


//
class Team {
    private ArrayList<String> members;
    
    public Team() {
        this.members = new ArrayList<>();
    }
    
    public void addMember(String name) {
        if (members.size() < 4) {
            members.add(name);
            System.out.println(name + " has been added to your team! \n");
        } else {
            System.out.println("Team is full! Cannot add " + name + "\n");
        }
    }

    public void removeMember(String name) {
        if (members.contains(name)) {
            members.remove(name);
            System.out.println(name + " has been removed from the team! \n");
        } else if (!members.isEmpty()){
            System.out.println("There is nobody on the team to remove! \n");
        } else {
            System.out.println(name + " is not in the team!\n");
        }
    }

    public void viewTeam() {
        if (!members.isEmpty()) {
            System.out.println("Current Team: " + members + "\n");
        } else {
            System.out.println("The team is empty \n");
        }
    }

    public void viewLeader() 
    {
        if (!members.isEmpty()) {
            System.out.println("Team Leader: " + members.get(0) + "\n");
            viewLeader ("co-leader");// calls out the overloaded version of the viewleader method
        } else {
            System.out.println("No leader! The team is empty.\n");
        }
    }
    
    public void viewLeader(String role)//overloaded version of the viewleader which is for the co-leader
     {
        if (members.size() >= 2) {
            System.out.println("Team Co-Leader: " + members.get(1) + "\n");
        } else {
            System.out.println("No co-leader! The team doesn't have enough members.\n");
        }
    }
}

class TeamManagement extends Team { 
    public void manageTeam(Scanner input) {
        Team myTeam = new Team();
        int option;
        
        do {
            System.out.println("===== Team Management =====");
            System.out.println("1. Add Member");
            System.out.println("2. Remove Member");
            System.out.println("3. View Current Team");
            System.out.println("4. View Team Leader");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Choose an option: ");

            option = input.nextInt();
            input.nextLine();

            switch (option){
                case 1 :
                 System.out.print("Enter name of member: ");
                 String member = input.nextLine();
                 myTeam.addMember(member);
                break;
                case 2 :
                 System.out.print("Enter member's name to remove: ");
                 String removeName = input.nextLine();
                 myTeam.removeMember(removeName);
                 break;
                case 3 :
                 myTeam.viewTeam();
                 break;
                case 4 :
                 myTeam.viewLeader();
                 break;
                case 5 :
                 System.out.println("Exiting Team Management... \n");
                 break;
                default:
                 System.out.println("Invalid Option. Try Again");
            }
        } while (option != 5);
    }
}



public class FinalProject 
{

    public static void main(String[] args) 
    {
        Scanner secondscanner = new Scanner(System.in);

        System.out.println("Program by: ");
        System.out.println("Cuellar, Dwayne Hill C.");
        System.out.println("Naluz, Zach Laurence D.");
        System.out.println();
        System.out.println("Please select a program (1-3)");
        System.out.println("[1] Zodiac Identifier");
        System.out.println("[2] Employee Compensation");
        System.out.println("[3] Team Management");
        System.out.println();

        int userchoice = 0;
        while (userchoice < 1 || userchoice > 3) {
            System.out.print("Enter your choice (1-3): ");
            
            // Check if the input is an integer
            if (secondscanner.hasNextInt()) 
            {
                userchoice = secondscanner.nextInt();

                // Check if input is valid (1-3)
                if (userchoice < 1 || userchoice > 3) 
                {
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                }

            } 
            else 
            {
                // Handle non-integer input
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                secondscanner.next(); // Clear the invalid input
            }
        }



        if (userchoice == 1)
        {
            ZodiacIdentifier zodiacIdentifier = new ZodiacIdentifier();
            zodiacIdentifier.identifyZodiac();

        }

        else if(userchoice == 2)
        {
            EmployeeCompensation employeeCompensation = new EmployeeCompensation();
            employeeCompensation.employeecompensation();

        }

        else if(userchoice == 3)
        {
            TeamManagement teamManagement = new TeamManagement();
            teamManagement.manageTeam(secondscanner);
        }

        
        secondscanner.close();
       
    }
}
