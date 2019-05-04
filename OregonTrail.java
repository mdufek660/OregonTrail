import java.util.concurrent.TimeUnit;
import java.lang.*;
import javax.swing.JOptionPane;
import java.util.Random;

public class OregonTrail
{
  
  
public static void main(String [] args) 
{
  String input;
  int difficulty=1, flagTwo=0, priceMod=00;
  Wagon myWagon = new Wagon();
  /*
  while(flagTwo==0)
  {
   input = JOptionPane.showInputDialog(null, "What would you like to set your difficulty to? 1 is hardest, 10 is easiest");
   flagTwo = StringMod.isStringIntInRange(input, 1, 10);
   if(flagTwo==1)
   {
     difficulty = Integer.parseInt(input);
     myWagon.setDifficulty(difficulty);
   }
   else
   {
     JOptionPane.showMessageDialog(null, "Invalid choice!");
   }
  }
  */
   
   myWagon=Town.enterTown(myWagon, priceMod);
  
  
  
  
  
}
}