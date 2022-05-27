public class Consumer implements Runnable{
    Product q;
    Consumer(Product q)
    {
        this.q = q;
        this.q.name="consumer";
    }
    public void run()
    {
        while(true)
        {
            synchronized(q)
            {
                if(q.num>0)
                {
                    System.out.println("consumer要消费第："+q.num+"个产品!");
                    q.num--;
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    q.notifyAll();
                }
                else
                {
                    try {
                        System.out.println("consumer stop!");
                        q.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
