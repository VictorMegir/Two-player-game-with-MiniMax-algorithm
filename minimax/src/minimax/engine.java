package minimax;
import java.util.Scanner;
import java.util.Random;
public class engine
{   
	public static void main(String[] args)
    {
		System.out.println("Put a number of red,green and yellow cubes:");
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int green = M;
        int yellow = M;
        int red = M;
        int count=3*M;
        Random rand = new Random();
        int k1 = rand.nextInt(M) + 1;        
        int k2 = rand.nextInt(M) + 1;
        int k3 = rand.nextInt(M) + 1;
               
        System.out.println("1.Choose "+k1+" of red\n"
        		+ "2.Choose "+k2+" of green\n"
        		+ "3.Choose "+k3+" of yellow\n"
        		+ "4.Choose one of red\n"
        		+ "5.Choose one of green\n"
        		+ "6.Choose one of yellow\n");
    	System.out.println("Total balls:"+count);
        int playermove;
        int bestmove;
        int localdepth=0;
        while(count>0)
        {
        	playermove=sc.nextInt();
        	if(playermove==1 && red>=k1)
        	{
        		red=red-k1;
        		count=count-k1;
        	}
        	else if(playermove==2 && green>=k2)
        	{
    			green=green-k2;
       			count=count-k2;
        	}
        	else if(playermove==3 && yellow>=k3)
        	{
	        	yellow=yellow-k3;
	        	count=count-k3;
        	}
        	else if(playermove==4 && red>=1)
        	{
        		red=red-1;
        		count=count-1;
        	}
        	else if(playermove==5 && green>=1)
        	{
        		green=green-1;
        		count=count-1;
        	}
        	else if(playermove==6 && yellow>=1)
        	{
        		yellow=yellow-1;
        		count=count-1;
        	}
        	localdepth++;
        	System.out.println("Total balls:"+count);
        	System.out.println("There are "+red+" red "+green+" green "+yellow+" yellow balls.");
        	if(count==0)
        	{
        		System.out.println("Human wins!");
        		break;
        	}
        	Node move=new Node(0,localdepth,count,red,green,yellow);
        	move.init(k1,k2,k3);
        	bestmove=move.minimax(localdepth,true);
        	System.out.println(bestmove);
        	for(int i=0;i<move.getchildren().size();i++)
        	{
        		/*System.out.println("------------");
        		System.out.println(move.getchildren().get(i).getdata());
        		System.out.println("Total balls:"+move.getchildren().get(i).getcount());
	        	System.out.println("There are "+move.getchildren().get(i).getred()+" red "+move.getchildren().get(i).getgreen()+" green "+move.getchildren().get(i).getyellow()+" yellow balls.")´*/
        		int bestmove1=move.getchildren().get(i).minimax(localdepth+1, false);
        		System.out.println(bestmove1);
        		if(bestmove==bestmove1)
        		{
        			red=move.getchildren().get(i).getred();
        			green=move.getchildren().get(i).getgreen();
        			yellow=move.getchildren().get(i).getyellow();
        			count=move.getchildren().get(i).getcount();
        			System.out.println("Total balls:"+count);
    	        	System.out.println("There are "+red+" red "+green+" green "+yellow+" yellow balls.");
        			if(count==0)
        			{
        				System.out.println("Computer wins");
        				System.out.println("Total balls:"+count);
        	        	System.out.println("There are "+red+" red "+green+" green "+yellow+" yellow balls.");
        				break;
        			}
        			break;
        		}
        	}
        }
        sc.close();
        System.out.println("Game Over");
    }
}