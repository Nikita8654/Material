package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class calculateFactorial implements Callable<Integer>

{
	private int number;
	public calculateFactorial(int number)
	{
		this.number=number;
	}
	public Integer call() throws Exception
	{
		int result=1;
		if(number==0||number==1)
			result=1;
		else
		{
			for(int i=2;i<=number;i++)
			{
				result*=i;
				TimeUnit.MILLISECONDS.sleep(50);
			}
		}
		System.out.println("result for the no:"+number+"->"+result);
		return result;
	}
}
public class ExecutorFuture {

	public static void main(String[] args) {
		ThreadPoolExecutor executor=(ThreadPoolExecutor)Executors.newFixedThreadPool(2);
		List<Future<Integer>> resultList=new ArrayList<>();
		Random r=new Random();
		for(int i=0;i<4;i++)
		{
			Integer number=r.nextInt(10);
			calculateFactorial calc=new calculateFactorial(number);
			Future<Integer> result=executor.submit(calc);
			resultList.add(result);
		}
		 for(Future<Integer> future : resultList)
         {
               try
               {
                   System.out.println("Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
               } 
               catch (Exception e) 
               {
                   e.printStackTrace();
               }
           }
		 executor.shutdown();
	}
}
