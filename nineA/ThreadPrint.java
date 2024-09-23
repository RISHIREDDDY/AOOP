package nineA;
public class ThreadPrint {
    public static void printTwo()
    {
        for(int i=0;i<15;i++)
        {
            if(i%2==0&&i%3!=0&&i%4!=0&&i%5!=0)
            {
                System.out.println("print div by 2"+"->"+i);
            }
        }
    }
    public static void printThree()
    {
        for(int i=0;i<15;i++)
        {
            if(i%3==0&&i%4!=0&&i%5!=0)
            {
                System.out.println("print div by 3"+"-> "+i);
            }
        }
    }
    public static void printFour()
    {
        for(int i=0;i<15;i++)
        {
            if(i%4==0&&i%5!=0)
            {
                System.out.println("print div by 4"+" ->"+i);
            }
        }
    }
    public static void printFive()
    {
        for(int i=0;i<15;i++)
        {
            if(i%5==0)
            {
                System.out.println("print div by 5"+" ->"+i);
            }
        }
    }
    public static void printNumber()
    {
        for(int i=0;i<15;i++)
        {
            if(i%2!=0&&i%3!=0&&i%4!=0&&i%5!=0)
            {
                System.out.println("print it is not divisible"+"->"+i);
            }
        }
    }
    public static void main(String[] args)
    {

        Thread t2 = new Thread(()->printTwo());
        Thread t3 = new Thread(()->printThree());
        Thread t4 = new Thread(()->printFour());
        Thread t5 = new Thread(()->printFive());
        Thread  t6 = new Thread(()->printNumber());
        //start in ready queue
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        //in between process
        try{
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
        }
        //interrupted will be in waiting again it will  backtrace to ready queue
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
