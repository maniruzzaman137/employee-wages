/* AssignmentEmployeeWages.java
   Description :Assessment 2 for Java programming: EmployeeWagesDetails
   Programmer  :Mohammad Maniruzzaman
   Date        :25/11/2020
*/

import javax.swing.*;

//Definging AssignmentEmployeeWages class
public class AssignmentEmployeeWages
{
    //Declaring variables for empID, name, rate, hour, gross, tax and net
    static String [] empID = {"", "", "", "", "", "", "", "", "", "", "", ""};
    static String [] firstName = {"Barry", "Cheryl", "Samuel", "Natalie", "Colin", "Shane", "Sharon", "William", "Craig", "Susan", "Blake", "Bev"};
    static String [] lastName = {"Dove", "Jacobs", "Devlin", "Taylor", "Masters", "Clarke", "Packer", "Baker", "Lyons", "Parker", "Hamish", "anderson"};
    static double [] rate = new double[12];
    static double [] hours = new double[12];
    static double [] gross = new double[12];
    static double [] tax = new double[12];
    static double [] nett = new double[12]; 
    static String title;
    static int menu;
    
    //main method
    public static void main (String [] args )
    {
     //calling methods getDateTitle() and getMenu() from same class
     getDateAndTitle();
     getMenu();
     while(menu != 0)
     {
        switch(menu)
        {
         case 1:
           enterPayDetails();
           break;
         case 2:
           createEmpID();
           break;           
         case 3:
           //calling calcGross() method from Wages class and assinging its value to the gross variable
           gross = Wages.calcGross(rate, hours);
           break;
         case 4:
           //calling calcTaxs() method from Wages class and assinging its value to the tax variable
           tax = Wages.calcTax(gross);
           break;
         case 5:
           //calling calcNett() method from Wages class and assinging its value to the nett variable
           nett = Wages.calcNett(gross, tax);
           break;
         case 6:
           displayEmployeeDetails();
           break;                       
      }
      getMenu();
    }
    System.exit(0);
  }
     public static void getDateAndTitle()
    {
        title = JOptionPane.showInputDialog(null,"Enter Company name and Date","Message",JOptionPane.QUESTION_MESSAGE);
    }
     
    public static void getMenu()
    {
       String message, temp;

       message = "EMPLOYEE WAGES MENU\n\n";
       message += " (1)   ENTER PAY DETAILS\n";
       message += " (2)   CREATE EMPLOYEE ID\n";   
       message += " (3)   CALCULATE GROSS PAY\n";
       message += " (4)   CALCULATE TAX PAYABLE\n";
       message += " (5)   CALCULATE NETT PAY\n";
       message += " (6)   DISPLAY EMPLOYEE DETAILS\n\n";          
       message += " (0)   QUIT\n\n";
       message += "Enter Choice";
       temp = JOptionPane.showInputDialog(null,message,title,JOptionPane.QUESTION_MESSAGE);
       menu = Integer.parseInt(temp);
    }
   
    public static void enterPayDetails()
    {
        for (int i = 0; i<12; i++)
        {
          rate[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter pay rate for " + firstName[i] + " " + lastName[i], title, JOptionPane.QUESTION_MESSAGE));
          hours[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter hours worked for " + firstName[i] + " " + lastName[i], title, JOptionPane.QUESTION_MESSAGE));
                                       
        }
    }

    public static void createEmpID()
    {
        for (int i = 0; i<12; i++)
        {
          empID[i] = JOptionPane.showInputDialog(null, "Enter employee ID for " + firstName[i] + " " + lastName[i], title, JOptionPane.QUESTION_MESSAGE);
        }
    }
    //defining displayEmployeeDetails() method for showing employee details
    public static void displayEmployeeDetails()
    {
      //initializing display with collumn titles
      String display = "empID  firstName  lastName  rate  hours  gross  tax  net" + "\n";
      for (int i = 0; i < 12; i++)
      {
        display += empID[i] + "  " + firstName[i] + "  " + lastName[i] + "  " + rate[i] + "  " + hours[i] + "  " + String.format("%.2f",gross[i]) + "  " + String.format("%.2f",tax[i]) + "  " + String.format("%.2f",nett[i]) + "\n"; 
      }
      JOptionPane.showMessageDialog(null,"Employee Details" + "\n" + display , title, JOptionPane.INFORMATION_MESSAGE);
    }
}
