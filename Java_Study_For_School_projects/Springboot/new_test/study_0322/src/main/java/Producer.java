public class Producer implements Runnable{
    Product q;
    Producer(Product q)
    {
        this.q = q;
        this.q.name="producer";
    }
    public void run()
    {
        while(true)
        {
            synchronized(q)
            {
                if(q.num<q.size)
                {
                    q.num++;
                    System.out.println("producer已生产第："+q.num+"个产品!");
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    q.notify();
                }
                else
                {
                    try {
                        System.out.println("producer stop!");
                        q.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
