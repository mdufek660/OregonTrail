import java.util.concurrent.TimeUnit;
import java.lang.String;
import javax.swing.JOptionPane;
import java.util.Random;

public class Shopping
{
  private String [] supplyNames = new String [10];  
  
  private double [] supplyBaseCost = new double [10];
  
  
  public Shopping()
  {
   
  }
  
  public static double[] setPrices(int priceMod, double[] supplyBaseCost, int buyOrSell) // 0 sets it to buy, decreasing cost. 1 sets to sell, increasing cost
   {
    if(buyOrSell == 0)
    {    
     for (int i=1; i<7; i++)
     {
       if(priceMod>75)
         {
           priceMod=75;
         }
       supplyBaseCost[i]*=(1.5-priceMod/Math.pow(10,2));
       supplyBaseCost[i]=StringMod.roundNumbersDouble(supplyBaseCost[i], 2);
     }
    }
    else
    {
      if(buyOrSell==1)
      {
       for (int i=1; i<7; i++)
       {
         if(priceMod>33)
         {
           priceMod=33;
         }
         
        supplyBaseCost[i]*=(1.1+priceMod/Math.pow(10,2));
        supplyBaseCost[i]=StringMod.roundNumbersDouble(supplyBaseCost[i], 2);
       } 
      }
    }
     return(supplyBaseCost);
   }
  
   public static Wagon enterShop(Wagon currentWagon, int priceMod)
   {
     
     int flag=1, flagTwo=0, flagThree=0, choice=0, choiceTwo=10, maxQuantity=0, temp1=1, temp2=1, temp3=1,  derp=1;
     double moneyChange=0, money=0, itemQuantity=0;
     String input;
     String [] supplyNames = new String [10]; 
     double [] supplyBaseCost = new double [10];
     
     
     supplyBaseCost[0]=999999;//note not used. Just there to line up the index in wagon
     supplyBaseCost[1]=25;
     supplyBaseCost[2]=15;
     supplyBaseCost[3]=100;
     supplyBaseCost[4]=10;
     supplyBaseCost[5]=250;
     supplyBaseCost[6]=30;

  
     supplyNames[0]="Money";//note not used. Just there to line up the index in wagon
     supplyNames[1]="Food";
     supplyNames[2]="Water";
     supplyNames[3]="Medicine";
     supplyNames[4]="Bullets";
     supplyNames[5]="Horses";
     supplyNames[6]="Furs";
    
     
     
    while (temp3!=0)
    {
    temp1=1;
    input = JOptionPane.showInputDialog(null, "Welcome to the shop! You have $"+ currentWagon.getMoney()+"\nWant to buy (enter 1), sell (enter 2), or leave (enter 0)?");
    flag = StringMod.isStringIntInRange(input, 0, 2);
    if (flag == 1)
    {
     temp3=Integer.parseInt(input);    
     if(temp3==1)
     {
       choice = 1;
       while(choice!=0)
       {
       supplyBaseCost[0]=999999;//note not used. Just there to line up the index in wagon
       supplyBaseCost[1]=25;
       supplyBaseCost[2]=15;
       supplyBaseCost[3]=100;
       supplyBaseCost[4]=10;
       supplyBaseCost[5]=250;
       supplyBaseCost[6]=30;
     
       supplyBaseCost=setPrices(priceMod, supplyBaseCost, 0);  
         
       flagTwo=0;
       choice=0;
       temp1=1;
       input = JOptionPane.showInputDialog(null, "What would you like to buy? You have $"+ currentWagon.getMoney() 
                                         + "\n[1]" + supplyNames[1] + ": $" + supplyBaseCost[1] +"/unit"
                                         + "\n[2]" + supplyNames[2] + ": $" + supplyBaseCost[2] +"/unit"
                                         + "\n[3]" + supplyNames[3] + ": $" + supplyBaseCost[3] +"/unit"
                                         + "\n[4]" + supplyNames[4] + ": $" + supplyBaseCost[4] +"/unit"
                                         + "\n[5]" + supplyNames[5] + ": $" + supplyBaseCost[5] +"/unit"
                                         + "\n[6]" + supplyNames[6] + ": $" + supplyBaseCost[6] +"/unit"
                                         + "\n[0]Quit buying");
       flagTwo = StringMod.isStringIntInRange(input, 0, 6);    
       if(flagTwo==1)
       {
         choice=Integer.parseInt(input);
         
         if (choice !=0)
         {
          
          money = currentWagon.getMoney();
          maxQuantity = (int) (money/supplyBaseCost[choice]);
          if (!(maxQuantity>0))
          {
           JOptionPane.showMessageDialog(null, "You don't have enough money to buy any " + supplyNames[choice] + "!");
          }
          else
          {
            while(temp1!=0)
            {
            money = currentWagon.getMoney();
            input = JOptionPane.showInputDialog(null, "You have $" + money + " to spend. You are purchasing "+supplyNames[choice]
                                                  +"\nat a cost of $"+supplyBaseCost[choice] + " per unit. How many would you like to buy (integers only)?");
            flagThree = StringMod.isStringIntInRange(input, 0, maxQuantity);
            if (flagThree == 0)
            {
              JOptionPane.showMessageDialog(null, "You entered an invalid value!");
            }
            else
            {
              temp1=Integer.parseInt(input);
              JOptionPane.showMessageDialog(null, "You purchased " +temp1 + " " + supplyNames[choice]);
              switch (choice)
              {
                case 0: break;
                  
                case 1: itemQuantity = currentWagon.getFood();
                        itemQuantity += temp1;
                        currentWagon.setFood(itemQuantity);
                        moneyChange = temp1*supplyBaseCost[1];
                        money -=moneyChange;
                        currentWagon.setMoney(money);
                        break;
                        
                case 2: itemQuantity = currentWagon.getWater();
                        itemQuantity += temp1;
                        currentWagon.setWater(itemQuantity);
                        moneyChange = temp1*supplyBaseCost[2];
                        money -=moneyChange;
                        currentWagon.setMoney(money);
                        break;
                        
                case 3: itemQuantity = currentWagon.getMedicine();
                        itemQuantity += temp1;
                        currentWagon.setMedicine(itemQuantity);
                        moneyChange = temp1*supplyBaseCost[3];
                        money -=moneyChange;
                        currentWagon.setMoney(money);
                        break;
                       
                case 4: itemQuantity = currentWagon.getBullets();
                        itemQuantity += temp1;
                        currentWagon.setBullets(itemQuantity);
                        moneyChange = temp1*supplyBaseCost[4];
                        money -=moneyChange;
                        currentWagon.setMoney(money);
                        break;
                        
                case 5: itemQuantity = currentWagon.getHorses();
                        itemQuantity += temp1;
                        currentWagon.setHorses(itemQuantity);
                        moneyChange = temp1*supplyBaseCost[5];
                        money -=moneyChange;
                        currentWagon.setMoney(money);
                        break;
                        
                case 6: itemQuantity = currentWagon.getFurs();
                        itemQuantity += temp1;
                        currentWagon.setFurs(itemQuantity);
                        moneyChange = temp1*supplyBaseCost[6];
                        money -=moneyChange;
                        currentWagon.setMoney(money);
                        break;
              }
            }
            }
          }
         }
       }
       else
       {
         JOptionPane.showMessageDialog(null, "Your choice is invalid!");
       }
       }
     }
     else
     {
       if(temp3==2)
       {
         choice=1;
         while(choice!=0)
         {
          supplyBaseCost[0]=999999;//note not used. Just there to line up the index in wagon
          supplyBaseCost[1]=25;
          supplyBaseCost[2]=15;
          supplyBaseCost[3]=100;
          supplyBaseCost[4]=10;
          supplyBaseCost[5]=250;
          supplyBaseCost[6]=30;
          
         supplyBaseCost=setPrices(priceMod, supplyBaseCost, 1); 
           
         input = JOptionPane.showInputDialog(null, "What would you like to sell?" 
                                         + "\n[1]" + supplyNames[1] + ": " + StringMod.roundNumbersDouble((supplyBaseCost[1]/2), 2) +"$/unit"
                                         + "\n[2]" + supplyNames[2] + ": " + StringMod.roundNumbersDouble((supplyBaseCost[2]/2), 2) +"$/unit"
                                         + "\n[3]" + supplyNames[3] + ": " + StringMod.roundNumbersDouble((supplyBaseCost[3]/2), 2) +"$/unit"
                                         + "\n[4]" + supplyNames[4] + ": " + StringMod.roundNumbersDouble((supplyBaseCost[4]/2), 2) +"$/unit"
                                         + "\n[5]" + supplyNames[5] + ": " + StringMod.roundNumbersDouble((supplyBaseCost[5]/2), 2) +"$/unit"
                                         + "\n[6]" + supplyNames[6] + ": " + StringMod.roundNumbersDouble((supplyBaseCost[6]/2), 2) +"$/unit"
                                         + "\n[0]Quit selling");
       flagTwo = StringMod.isStringIntInRange(input, 0, 6);    
       if(flagTwo==1)
       {
         choice=Integer.parseInt(input);
         if(choice!=0)
         {
           switch (choice)
              {
                case 0: break;
                  
                case 1: itemQuantity = currentWagon.getFood();
                        int tempQuantity = (int) itemQuantity;
                        if(tempQuantity<=0)
                        {
                          JOptionPane.showMessageDialog(null, "You have none to sell!");
                        }
                        else
                        {
                          
                           
                           input=JOptionPane.showInputDialog(null, "You have " + tempQuantity + " " + supplyNames[1] + " to sell. How much do you want to sell (integers only, 0 to exit)?");
                           flagThree = StringMod.isStringIntInRange(input, 0, tempQuantity);
                           if (flagThree==0)
                           {
                             JOptionPane.showMessageDialog(null, "Invalid quantity!");
                           }
                           else
                           {
                            derp = Integer.parseInt(input);
                            itemQuantity -= derp;
                            currentWagon.setFood(itemQuantity);
                            moneyChange = itemQuantity * (supplyBaseCost[1]/2);
                            money += moneyChange;
                            currentWagon.setMoney(money);
                           }
                          }
                        
                        break;
                        
                case 2: itemQuantity = currentWagon.getWater();
                        tempQuantity = (int) itemQuantity;
                        if(tempQuantity<=0)
                        {
                          JOptionPane.showMessageDialog(null, "You have none to sell!");
                        }
                        else
                        {
                          
                           
                           input=JOptionPane.showInputDialog(null, "You have " + tempQuantity + " " + supplyNames[2] + " to sell. How much do you want to sell (integers only, 0 to exit)?");
                           flagThree = StringMod.isStringIntInRange(input, 0, tempQuantity);
                           if (flagThree==0)
                           {
                             JOptionPane.showMessageDialog(null, "Invalid quantity!");
                           }
                           else
                           {
                            derp = Integer.parseInt(input);
                            itemQuantity -= derp;
                            currentWagon.setWater(itemQuantity);
                            moneyChange = itemQuantity * (supplyBaseCost[2]/2);
                            money += moneyChange;
                            currentWagon.setMoney(money);
                           }
                          }
                        
                        break;
                        
                case 3: itemQuantity = currentWagon.getMedicine();
                        tempQuantity = (int) itemQuantity;
                        if(tempQuantity<=0)
                        {
                          JOptionPane.showMessageDialog(null, "You have none to sell!");
                        }
                        else
                        {
                          
                           
                           input=JOptionPane.showInputDialog(null, "You have " + tempQuantity + " " + supplyNames[3] + " to sell. How much do you want to sell (integers only, 0 to exit)?");
                           flagThree = StringMod.isStringIntInRange(input, 0, tempQuantity);
                           if (flagThree==0)
                           {
                             JOptionPane.showMessageDialog(null, "Invalid quantity!");
                           }
                           else
                           {
                            derp = Integer.parseInt(input);
                            itemQuantity -= derp;
                            currentWagon.setMedicine(itemQuantity);
                            moneyChange = itemQuantity * (supplyBaseCost[3]/2);
                            money += moneyChange;
                            currentWagon.setMoney(money);
                           }
                          }
                        
                        break;
                       
                case 4: itemQuantity = currentWagon.getBullets();
                        tempQuantity = (int) itemQuantity;
                        if(tempQuantity<=0)
                        {
                          JOptionPane.showMessageDialog(null, "You have none to sell!");
                        }
                        else
                        {
                          
                           
                           input=JOptionPane.showInputDialog(null, "You have " + tempQuantity + " " + supplyNames[4] + " to sell. How much do you want to sell (integers only, 0 to exit)?");
                           flagThree = StringMod.isStringIntInRange(input, 0, tempQuantity);
                           if (flagThree==0)
                           {
                             JOptionPane.showMessageDialog(null, "Invalid quantity!");
                           }
                           else
                           {
                            derp = Integer.parseInt(input);
                            itemQuantity -= derp;
                            currentWagon.setBullets(itemQuantity);
                            moneyChange = itemQuantity * (supplyBaseCost[4]/2);
                            money += moneyChange;
                            currentWagon.setMoney(money);
                           }
                          }
                        
                        break;
                        
                case 5: itemQuantity = currentWagon.getHorses();
                        tempQuantity = (int) itemQuantity;
                        if(tempQuantity<=0)
                        {
                          JOptionPane.showMessageDialog(null, "You have none to sell!");
                        }
                        else
                        {
                          
                           input=JOptionPane.showInputDialog(null, "You have " + tempQuantity + " " + supplyNames[5] + " to sell. How much do you want to sell (integers only, 0 to exit)?");
                           flagThree = StringMod.isStringIntInRange(input, 0, tempQuantity);
                           if (flagThree==0)
                           {
                             JOptionPane.showMessageDialog(null, "Invalid quantity!");
                           }
                           else
                           {
                            derp = Integer.parseInt(input);
                            itemQuantity -= derp;
                            currentWagon.setHorses(itemQuantity);
                            moneyChange = itemQuantity * (supplyBaseCost[5]/2);
                            money += moneyChange;
                            currentWagon.setMoney(money);
                           }
                          }
                        
                        break;
                        
                case 6: itemQuantity = currentWagon.getFurs();
                        tempQuantity = (int) itemQuantity;
                        if(tempQuantity<=0)
                        {
                          JOptionPane.showMessageDialog(null, "You have none to sell!");
                        }
                        else
                        {
                          
                           
                           input=JOptionPane.showInputDialog(null, "You have " + tempQuantity + " " + supplyNames[6] + " to sell. How much do you want to sell (integers only, 0 to exit)?");
                           flagThree = StringMod.isStringIntInRange(input, 0, tempQuantity);
                           if (flagThree==0)
                           {
                             JOptionPane.showMessageDialog(null, "Invalid quantity!");
                           }
                           else
                           {
                            derp = Integer.parseInt(input);
                            itemQuantity -= derp;
                            currentWagon.setFurs(itemQuantity);
                            moneyChange = itemQuantity * (supplyBaseCost[6]/2);
                            money += moneyChange;
                            currentWagon.setMoney(money);
                           }
                          }
                        
                        break;
           }
         }
       }
         }
       }
     }
    }
    }
return(currentWagon);
}
}
  