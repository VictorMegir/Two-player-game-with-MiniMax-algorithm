package minimax;
import java.util.ArrayList;
public class Node
{
   private int data;
   private int depth;
   private int count;
   private int red,green,yellow;
   private ArrayList<Node> children;
   private static boolean turn=true;
  
   public Node(int data, int depth,int count,int red,int green,int yellow)
   {
       this.data = data;
       this.depth = depth;
       this.count = count;
       this.red = red;
       this.green = green;
       this.yellow = yellow;
       children = new ArrayList<Node>();
   }
   public ArrayList<Node> getchildren()
   {
	   return children;
   }
   public int getred()
   {
	   return red;
   }
   public int getgreen()
   {
	   return green;
   }
   public int getyellow()
   {
	   return yellow;
   }
   public int getdata()
   {
	   return data;
   }
   public void setdata(int newdata)
   {
	   data=newdata;
   }
   public int getcount()
   {
	   return count;
   }	
   public int minimax(int depth,boolean turn)
	{
	   	if(count==0)
	   		return data;
	    int bestvalue,v;
		if(turn)//max
		{
			bestvalue=-100;
			for(int i=0;i<children.size();i++)
			{
				v=children.get(i).minimax(depth+1,false);
				if(v>bestvalue)bestvalue=v;
			}
			return bestvalue;
		}
		else//min
		{
			bestvalue=100;
			for(int i=0;i<children.size();i++)
			{
				v=children.get(i).minimax(depth+1,true);
				if(v<bestvalue)bestvalue=v;
			}
			return bestvalue;
		}
	}
   public void init(int k1,int k2,int k3)
   {
	   	if(count==0)
	   	{
	   		if(turn) {
	   			data=1;
	   		}else {
	   			data=-1;
	   		} 			
	   	}
	   	if(red>=1)
		{
		   	int newred=red-1;
		   	int newcount=count-1;
		   	int newdepth=depth+1;
		   	Node r1;
		   	if(count!=0)
			{
		   		r1=new Node(0,newdepth,newcount,newred,green,yellow);
				children.add(r1);
				turn=!turn;
				r1.init(k1,k2,k3);
			}
		}
	   	if(red>=k1)
		{
			int newred=red-k1;
		   	int newcount=count-k1;
		   	int newdepth=depth+1;
		   	Node r2;
		   	if(count!=0)
			{
		   		r2=new Node(0,newdepth,newcount,newred,green,yellow);
				children.add(r2);
				turn=!turn;
				r2.init(k1,k2,k3);
			}
		}
		if(green>=1)
		{
			int newgreen=green-1;
		   	int newcount=count-1;
		   	int newdepth=depth+1;
		   	Node g1;
		   	if(count!=0)
			{
		   		g1=new Node(0,newdepth,newcount,red,newgreen,yellow);
				children.add(g1);
				turn=!turn;
				g1.init(k1,k2,k3);
			}
		}
		if(green>=k2)
		{
			int newgreen=green-k2;
		   	int newcount=count-k2;
		   	int newdepth=depth+1;
		   	Node g2;
		   	if(count!=0)
			{
		   		g2=new Node(0,newdepth,newcount,red,newgreen,yellow);
				children.add(g2);
				turn=!turn;
				g2.init(k1,k2,k3);
			}
		}
		if(yellow>=1)
		{
			int newyellow=yellow-1;
		   	int newcount=count-1;
		   	int newdepth=depth+1;
		   	Node y1;
		   	if(count!=0)
			{
				y1=new Node(0,newdepth,newcount,red,green,newyellow);
				children.add(y1);
				turn=!turn;
				y1.init(k1,k2,k3);
			}
		}
		if(yellow>=k3)
		{
			int newyellow=yellow-k3;
		   	int newcount=count-k3;
		   	int newdepth=depth+1;
		   	Node y2;
			if(count!=0)
			{
				y2=new Node(0,newdepth,newcount,red,green,newyellow);
				children.add(y2);
				turn=!turn;
				y2.init(k1,k2,k3);
			}
		}
   }
}