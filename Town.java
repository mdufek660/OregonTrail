import java.lang.String;
import javax.swing.JOptionPane;

public class Town
{
  
  public Town()
  {
  }
  
  public static Wagon enterTown(Wagon theWagon, int priceMod)
  {
    int flag01=0, flag02=0, flag03=0, choiceOne=1;
    String input, temp;
    while(choiceOne!=0)
    {
      while(flag02==0)
      {
       input=JOptionPane.showInputDialog(null, "Welcome to town! Where would you like to go?"
                                             + "\n[1]Tavern: Hire new people"
                                             + "\n[2]Doctor: Full heal party for $20 per person"
                                             + "\n[3]Blacksmith: Buy/repair guns"
                                             + "\n[4]Gen. Shop: Buy supplies"
                                             +"\n \n[0]Leave town");
      flag02 = StringMod.isStringIntInRange(input, 0, 4);
      if(flag02==0)
      {
        JOptionPane.showMessageDialog(null, "INVALID CHOICE");
        choiceOne = 5;
      }
      else
      {
       choiceOne = Integer.parseInt(input);
      }
    
      switch(choiceOne)
      {
        case 0:
          flag02=1;
          break;
          
        case 1:
          flag02=0;
        
        break;
        
        case 2:
          flag02=0;
      
        break;
        
        case 3:
          flag02=0;
          theWagon=Blacksmith.enterBlacksmith(theWagon, priceMod);
        break;
        
        case 4:
          flag02=0;
          theWagon=Shopping.enterShop(theWagon, priceMod);
        break;
      }
     }
    }
    return(theWagon);
  }
 
}