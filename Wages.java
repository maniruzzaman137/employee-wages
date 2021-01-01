/* AssignmentEmployeeWages.java
   Description :Wages class for calculating gross, tax and net wages
   Programmer  :Mohammad Maniruzzaman
   Date        :25/11/2020
*/

import javax.swing.*;

// Defining Wages class
public class Wages
{
    // Declaring array variables for gross, tax and net wages.
    static double [] gross = new double[12];
    static double [] tax = new double[12];
    static double [] nett = new double[12]; 
  
    // Method for calculating gross wages: gross = rate*hours
    public static double  [] calcGross(double [] rate, double [] hours)
    { 
      for (int i = 0; i < 12; i++)
        {
          gross[i] = rate[i] * hours[i];
        }
        return gross;
    }
     
    // Method for calculating tax
    public static double [] calcTax(double [] gross)
    {
      for (int i = 0; i < 12; i++)
        {
          if (gross[i] <= 350) 
          {
            tax[i] = 0;
          } 
          else 
            {  
              if ((gross[i] > 350) & (gross[i] <= 700))
               {
                 tax[i] = (gross[i] - 350)*.1;
               }
              else 
              {
                  if ((gross[i] > 700) & (gross[i] <= 1500))
                  {
                     tax[i] = (gross[i] - 700)*.15 + 35;
                  }
                  else
                  {
                     tax[i] = (gross[i] -1500)*.25 + 35 + 800*.15;
                  }
              }
             }
        }
      return tax;
    }  
    
    // Method for calculating net wages: net = gross - tax 
    public static double [] calcNett(double [] gross, double [] tax)
    {
      for (int i = 0; i < 12; i++) 
       {
         nett[i] = gross[i] - tax[i];
       }
      return nett;
    }   
}