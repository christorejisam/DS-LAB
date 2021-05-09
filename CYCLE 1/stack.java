// CYCLE 1 PRM 2

import java.io.*;
class stack
{
int s[]=new int[20];
int sp,n;
stack(int nn)//constructor
{
    for(int i=0;i<20;i++)
    s[i]=0;
    sp=-1;
    n=nn;

}
void push(int item)
 {
 sp++;
 s[sp]=item;
 }
void pop()
 {
 int v;
 v=s[sp];
 System.out.println("Popped out element is "+v);
 sp--;
 }
void peek()
 {
 System.out.println("Peeked out element is "+s[sp]);
 }
boolean underflow()
 {
 if(sp==-1)
 {
 System.out.println("Stack Underflow");
 return true;
 }
 else
 return false;
 }
boolean overflow()
 {
 if(sp==(n-1))
 {
 System.out.println("Stack overflow");
 return true;
 }
 else
 return false;
 }
public static void main(String[] args) throws IOException
     {
        int l,c,x,i;
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        System.out.println("Enter the size of stack");
        l= Integer.parseInt(in.readLine());
        stack st = new stack(l);
        System.out.println("Choose The Stack Operations \n ");
        do{
            System.out.println("1.PUSH \n 2.POP \n 3.PEEK \n");
            c=Integer.parseInt(in.readLine());
            switch (c)
            {
                case 1:
                    if(st.overflow()==false)
                    {
                        System.out.println("Enter the element to be added");
                        x = Integer.parseInt(in.readLine());
                        st.push(x);
                    }
                    break;
                case 2:
                    if(st.underflow()==false)
                    {
                        st.pop();
                    }
                    break;
                case 3:
                    if(st.underflow()==false)
                    {
                        st.peek();
                    }
                    break;
                default:System.out.println("Invalid Input..");
                    break;
            }
            System.out.println("press 1 to continue");
            i=Integer.parseInt(in.readLine());
        }while(i==1);

}
}
