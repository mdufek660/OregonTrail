import java.util.concurrent.TimeUnit;
import java.lang.*;
import javax.swing.JOptionPane;
import java.util.Random;

public class GunTest
{
public static void main(String [] args) 
{
  Gun tester = new Gun();
  int temp = 1, flagTwo, flagOne, temp2=0;
  String input, input2="0";
  
  while(temp!=4)
  {
    input = JOptionPane.showInputDialog(null, "What type of gun would you like to make?" +
                                        "\n[0] Musket" +
                                        "\n[1] Marksman Rifle" +
                                        "\n[2] Winchester" +
                                        "\n[3] Shotgun" +
                                        "\n[4] exit tester");  
                                          
                                          
    flagTwo = StringMod.isStringIntInRange(input, 0, 4);
    if(flagTwo==0)
    {
      JOptionPane.showMessageDialog(null, "INVALID CHOICE");
      temp = 1;
    }
    else
    {
     temp = Integer.parseInt(input);
     if (temp != 4)
     {
     tester = tester.makeGun(temp, 100, 100, tester);
     JOptionPane.showMessageDialog(null, "Here are your gun's stats:" +
                                   "\n Name: " + tester.getName() +
                                   "\n Health: " + tester.getHealth() +
                                   "\n Damage per hit: " + tester.getDamage() +
                                   "\n damage per minute: " +tester.calculateDamage(tester) + 
                                   "\n Ammo Cap: " + tester.getAmmoCapacity() +
                                   "\n Quality: " + tester.getQuality() + 
                                   "\n Accuracy: " + tester.getAccuracy() + 
                                   "\n Power: " + tester.getPower() + 
                                   "\n Reload time: " + tester.getReload());
     
    }
    }
  }
    
}
}