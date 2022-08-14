import java.util.Scanner;
import java.util.Arrays;
class Main {
  public static void main(String[] args) 
  {
    boolean flag = true;
    Scanner reader = new Scanner(System.in);
    //this is my looping mechanism, its pretty straight forward. You ask the user for inputs(1 through 4) and it will execute each method
    while(flag)
    {
      System.out.print("which method would you like to look at?\n1.max_min_avg\n2.high_values\n3.Bonus\n4.Exit\n>");
      String input = reader.next();
      if(input.equals("1"))
      {
        max_min_avg();
      }
      else if(input.equals("2"))
      {
        high_values();
      }
      else if(input.equals("3"))
      {
        bonusAssignment();
      }
      else if(input.equals("4")){
        System.out.println("Exiting...");
        break;
      }
      else{
        System.out.println("You must input a value from 1 to 4");
      }
    }
  }
  //This method will figure out the maximum and minimum value for a given array of 10 cells as well as add all the values in the array and divide it by 10 in order to find the average
  public static void max_min_avg()
  {
    Scanner reader = new Scanner(System.in);
    //initializes array
    int[] values = new int[10];
    //intializes a counter
    int counter = 0;
    //will loop through asking user for input to store in the array
    while(counter < values.length)
    {
      System.out.print("Enter value " + (counter+1) + ": ");
      int input = reader.nextInt();
      values[counter] = input;
      counter++;
    }
    //sets two variables: maximum and minimum. Sets them both equal to the first number entered into the array
    int maximum = values[0];
    int minimum = values[0];
    int sum = 0;
    //loops through 10 numbers
    for(int i = 0; i < values.length; i++)
    {
      //code for figuring max
      if(values[i] > maximum){
        maximum = values[i];
      }
      //code for figuring min
      if(values[i] < minimum){
        minimum = values[i];
      }
      //figures out sums
      sum += values[i];
    }
    
    double avg = sum/values.length;
    //prints out values for max and min
    System.out.println("");
    System.out.println("The maximum is: " + maximum);
    System.out.println("The minimum is: " + minimum);
    System.out.println("The average is: " + avg + "\n");
    System.out.println("The numbers you entered are: ");
    for(int k = 0; k < 10; k++)
    {
      System.out.print(values[k] + " , ");
    }
    System.out.println("\n");
  }
  //This method will ask the user for the amount of numbers they'd like to enter in. Then it will figure out the 3 highest number from the set of numbers inputed into the array
  public static void high_values()
  {
    Scanner reader = new Scanner(System.in);
    System.out.print("How many numbers would you like to enter? ");
    //variable for storing the amount of numbers
    int total = reader.nextInt();
    //intializes array
    int[] values = new int[total];
    //initializes a counter variable
    int counter = 0;
    //standard loop to go through all numbers and store them into values array
    while(counter < total)
    {
      System.out.print("Enter value " + (counter+1) + ": ");
      int input = reader.nextInt();
      values[counter] = input;
      counter++;
    }
    //finds the smallest value
    int minimum = values[0];
    for(int i = 0; i < total; i++){
      if(values[i] < minimum){
        minimum = values[i];
      }
    }
    //intializes 3 variables: first, second and third and sets them to the lowest value in the array
    int first = minimum;
    int second = minimum;
    int third = minimum;
    for(int i = 0; i < total; i++)
    {
      //figure the first(highest number)
      if(values[i] > first)
      {
        third = second;
        second = first;
        first = values[i];
      }
      //figures out the second
      else if(values[i] < first && values[i] > second)
      {
        third = second;
        second = values[i];
      }
      //figures out the third
      else if(values[i] > third && values[i] < second)
      {
        third = values[i];
      }
    }
    System.out.print("List of values: ");
    for(int i = 0; i < total; i++){
      System.out.print(values[i] + ",");
    }
    System.out.println("\n");
    //searches array and stores the location of each cell
    System.out.println("There were a total of " + total + " numbers entered \n");
    for(int i = 0;  i < total; i++)
    {
      //Figures out position of first value
      if(values[i] == first)
      {
        System.out.println("The highest number was in sequence  # " + (i+1));
      }
    }
    for(int i = 0;  i < total; i++)
    {
      //figures out position of second value
      if(values[i] == second)
      {
        System.out.println("The second highest number was in sequence  # " + (i+1));
      }
    }
    for(int i = 0;  i < total; i++)
    {
      //figures out position of third value
      if(values[i] == third)
      {
        System.out.println("The third highest number was in sequence  # " + (i+1));
      }
    }
    System.out.println("");
  }
  public static void bonusAssignment()
  {
    Scanner reader = new Scanner(System.in); //intialize scanner
    String[] nameList = new String[40]; //Creates an string array called names
    int[] gradeList = new int[40]; //Creates an int array called grade
    boolean flag = true; //creates a variable for while loop
    int counter = 0; //creates a counter variable
    int sum =0;
    System.out.println("The sentinel is stop. Type this at anytime to stop asking for names/grades");
    //looping mechanism will keep going untill user enters in 999 into either the name or the grade.
    //This looping mechanism basically asks the user for names and grades untill the sentinel is pressed
    while(flag)
    {
      int i = counter+1;
      
      System.out.print("Enter name " + i + ": ");
      String name = reader.nextLine();//stores input as name
      if(name.equalsIgnoreCase("stop"))
      {
        break;
        //if name = stop, while loop breaks
      }
      else{
        nameList[counter] = name;
      }
      System.out.print("Enter grade " + i + ": ");
      int grade = reader.nextInt();
      reader.nextLine();
      gradeList[counter] = grade;
      counter++;
      
    }
    //important variable: Postion stores the position that the maximum number is located
    int position = 0;
    //figures out highest num
    int maximum = gradeList[0];
    for(int i = 0; i <= counter; i++)
    {
      if(gradeList[i] > maximum){
        maximum = gradeList[i];
        position = i;
      }
    }
    System.out.println("\n");
    //now it will print all the names in order that they were entered
    for(int i = 0; i<= counter-1; i++){
      //if the gradeList is not equal to the maximum number it will keep printing. if the grade list is equal to the maximum, then it will print it with stars next to its name.
      if(gradeList[i] != maximum){
        System.out.println("Name of person " + nameList[i]);
        System.out.println("Grade recived " + gradeList[i]);
        System.out.println("\n");
      }
      else{
        System.out.println("**Name of person " + nameList[i] + "**");
        System.out.println("**Grade recived " + gradeList[i] + "**");
        System.out.println("\n");
      }
    }
    //figures out the sum of all the numbers in the array
    for(int i = 0; i<= counter-1; i++){
      sum+=gradeList[i];
    }
    double avg = sum/(counter+0.0);//changes counter to double and figures out avg
    double difference = maximum - avg;//subtracts maximum from average
    System.out.println("the difference betwen the mean score and the highest students grade is " + difference);
  }
}
