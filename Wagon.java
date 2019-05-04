import javax.swing.JOptionPane;

public class Wagon
{
  private int [] wagonStatus = new int [4];  
  private double [] supplies = new double [10];
  private static Gun [] gunsOwned = new Gun [10];
  private static Gun gunTemp=new Gun(0, 100,100);
  private static Gun gunTemp2=new Gun(0,0,0);
  private People [] peopleInParty = new People [10];
  private int minimumHealth=60; //minimum health to travel at default speed
  private People tester = new People(0, 0, "name", false); //creates a default person with no health, occupation, a default name, and dead.
  private String newName, input;
  private int jobType = 0;
  private int i=0, j=0, h=1; //Set J to 1 to skip the naming, 0 to do the naming of the party
  private int flag=0;
  
  public Wagon()
    
  {
    
   while(i!=2)
   {
     gunsOwned[i]=gunTemp;
     i++;
   }
   
   while(i!=10)
   {
     gunsOwned[i]=gunTemp2;
     i++;
   }
   i=0;
   
   wagonStatus[0] = 4; //wheels
   wagonStatus[1] = 100; //health
   wagonStatus[2] = 1; //axels
   wagonStatus[3] = 3; //base speed
   
   supplies[0]=1000; //sets starting money
   supplies[1]=0; //set food
   supplies[2]=0; //set water
   supplies[3]=0; //set medicine
   supplies[4]=0; //set bullets
   supplies[5]=0; //set horses
   supplies[6]=0; //set furs
   
   
   if(h==0)
   {
   while(i!=10)
   {
     peopleInParty[i]=tester; //create people to fill the array. The people start out dead with no traits
     i++;
   }
   
   while(j==0) //This mess sets the initial 5 people in your party
   {
    i=0;
    while(i!=5) 
    {
      newName=JOptionPane.showInputDialog(null, "What would you like to name person " + (i+1) + "?");
      flag=0;
      while (flag==0)
      {  
       input=JOptionPane.showInputDialog(null, "What is their job type? \n1 for banker, 2 for doctor, 3 for merchant, 4 for hunter, 5 for forager");
       flag=StringMod.isStringIntInRange(input, 1, 5);
      if (flag==0)
      {
        JOptionPane.showMessageDialog(null, "INVALID CHOICE");
      }
      else
      {flag=1;}
      }
      jobType=Integer.parseInt(input);
      tester = new People(100, jobType, newName, true);
      peopleInParty[i]=tester;
      i++;
    }
    flag=0;
    while(flag==0)
    {
     input=JOptionPane.showInputDialog(null, "Your party is: \n" +
                                    peopleInParty[0].getName() +": " + peopleInParty[0].getCareer() + "\n" +
                                    peopleInParty[1].getName() +": " + peopleInParty[1].getCareer() + "\n" +
                                    peopleInParty[2].getName() +": " + peopleInParty[2].getCareer() + "\n" +
                                    peopleInParty[3].getName() +": " + peopleInParty[3].getCareer() + "\n" +
                                    peopleInParty[4].getName() +": " + peopleInParty[4].getCareer() + "\n"
                                    +"Is this acceptable? Enter 1 for yes, 0 for no");
     flag=StringMod.isStringIntInRange(input, 0, 1);
     if (flag==0)
      {
        JOptionPane.showMessageDialog(null, "INVALID CHOICE");
      }
      else
      {flag=1;}
    }
    j=Integer.parseInt(input);
   }
   }
   
  }
  
  public void setDifficulty(int difficulty)
  {
    supplies[0]*=difficulty;
  }

  public int getWheels()
  {
    return(wagonStatus[0]);
  }
  
  public int getHealth()
  {
    return(wagonStatus[1]);
  }
  
  public int getAxels()
  {
    return(wagonStatus[2]);
  }
  
  public int getWagonBaseSpeed()
  {
    return(wagonStatus[3]);
  }
  
  public void setWheels(int tempWheels)
  {
    wagonStatus[0] = tempWheels;
  }
  
  public void setWagonHealth(int tempHealth)
  {
    wagonStatus[1] = tempHealth;
  }
  
  public void setAxels(int axelsTemp)
  {
    wagonStatus[2] = axelsTemp;
  }
  
  /* here begins the methods to
   * retrieve the values of the
   * supplies in the game*/
  public double getMoney()
  {
    return(supplies[0]);
  }
  
  public double getFood()
  {
    return(supplies[1]);
  }
  
  public double getWater()
  {
    return(supplies[2]);
  }
  
  public double getMedicine()
  {
    return(supplies[3]);
  }
  
  public double getBullets()
  {
    return(supplies[4]);
  }
  
  public double getHorses()
  {
    return(supplies[5]);
  }
  
  public double getFurs()
  {
    return(supplies[6]);
  }
  
  public static Gun getGun(int i)
  {
    return(gunsOwned[i]);
  }
  
  /* here begins the methods to
   * set the values of the
   * supplies in the game*/
  
  public void setMoney(double moneyTemp)
  {
    moneyTemp = StringMod.roundNumbersDouble(moneyTemp, 2);
    supplies[0] = moneyTemp;
  }
  
  public void setFood(double foodTemp)
  {
    foodTemp = StringMod.roundNumbersDouble(foodTemp, 2);
    supplies[1] = foodTemp;
  }
  
  public void setWater(double waterTemp)
  {
    waterTemp = StringMod.roundNumbersDouble(waterTemp, 2);
    supplies[2] = waterTemp;
  }
  
  public void setMedicine(double medicineTemp)
  {
    medicineTemp = (int) medicineTemp;
    supplies[3] = medicineTemp;
  }
  
  public void setBullets(double bulletsTemp)
  {
    bulletsTemp = (int) bulletsTemp;
    supplies[4] = bulletsTemp;
  }
  
  public void setHorses(double horsesTemp)
  {
    horsesTemp = (int) horsesTemp;
    supplies[5] = horsesTemp;
  }
  
  public void setFurs(double fursTemp)
  {
    supplies[6] = fursTemp;
  }
  
  
  public void setWagonSpeed()
  {
    if (wagonStatus[0]<4 || wagonStatus[1]==0 || wagonStatus[2]==0 || supplies[5]==0)
    {
      wagonStatus[3]=0; //sets speed to 0 if wagon is too damaged, there are no axels, no horses, or not enough wheels
    }
    else
    {
      if (wagonStatus[1]>=minimumHealth) //checks if wagon health is above or equal to min health
      {
        wagonStatus[3]=3;
      }
      else
      {
        wagonStatus[3]=3*(wagonStatus[1]/100); //modifies wagon speed based on health if health less than min health
      }
    }
    if (supplies[5]==1)
    {
      wagonStatus[3]/=2;
    }
    else
    {
      if(supplies[5]>2)
      {
        wagonStatus[3]*=(1+supplies[5]/10);
      }
    }
  }
  
  
}