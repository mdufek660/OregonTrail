import java.util.concurrent.TimeUnit;
import java.lang.*;
import javax.swing.JOptionPane;
import java.util.Random;

public class PeopleTest
{
  
  
public static void main(String [] args) 
{
  String input, name;
  int health, bonusType;
  People [] party = new People [3];
  boolean alive = true;
  
  for(int i=0; i<3; i++)
  {
   input = JOptionPane.showInputDialog(null, "Enter health of person");
   health = Integer.parseInt(input);
   input = JOptionPane.showInputDialog(null, "Enter bonus type");
   bonusType = Integer.parseInt(input);
   input = JOptionPane.showInputDialog(null, "Enter name");  
   People temp = new People(health, bonusType, input, alive);
   party[i] = temp;
  }
  for (int i=0; i<3; i++)
  {
  JOptionPane.showMessageDialog(null, "Name: " + party[i].getName() + "\nHealth: " + party[i].getHealth() + "\nType: " + party[i].getBonus());
  }
}
}
  