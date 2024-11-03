//This program is to print the result of a string str as 15. The sceanrio is when there is arithmetic operator you should perform that operations based on the final result of the variable called Value.


import org.junit.Test;

public class check
{
    @Test
    public void test()
    {
       String str = "45+2*3-";
       int value = 0;
        String[] arr = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = (String.valueOf(str.charAt(i)));

         if(arr[i].equals("+"))
         {
             int a = Integer.parseInt(arr[0]);
                int b = Integer.parseInt(arr[1]);
                value = a + b;
             System.out.println("Addition operation: "+ value);
         }
            if(arr[i].equals("*"))
            {
                int c = Integer.parseInt(arr[3]);
                value = value * c;
                System.out.println("Multiply: "+ value);
            }
            if(arr[i].equals("-"))
            {
                int d = Integer.parseInt(arr[5]);
                value = value - d;
                System.out.println("Subtract: "+ value);
            }
        }
        System.out.println("Final value: "+ value);
    }

}
