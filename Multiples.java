
public class Multiples {

	
	    static void myMethod()
	    {
	       for (int i=1;i<=100;i++)
	       {
	        if(i%3==0)
	        {
	            if(i%5!=0)
	            {
	                System.out.println("MThree");
	            }
	            else if(i%5==0)
	            {
	                System.out.println("Resolver");
	            }
	        }else if(i%5==0)
	        {
	                System.out.println("MFive");
	        }else
	            System.out.println(i);
	        }
	    }
	    public static void main (String[] args)
	    {
	        myMethod();
	    }
	

}
