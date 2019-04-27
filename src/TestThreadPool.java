import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.security.auth.callback.Callback;

public class TestThreadPool {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);
		
		Call c = new Call("1");
		Call c2 = new Call("2");
		Call c3 = new Call("3");

		Future<String> ff = es.submit(c);
		Future<String> ff2 = es.submit(c2);
		Future<String> ff3 = es.submit(c3);
		
		try {
			String str = ff.get();
			String str2 = ff2.get();
			String str3 = ff3.get();
			
			System.out.println(str);
			System.out.println(str2);
			System.out.println(str3);
			
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	public static class Call implements Callable<String> {
		
		String msg;
		
		public Call(String msg) {
			this.msg = msg;
		}

		@Override
		public String call() throws Exception {
			System.out.println("run : " + msg);					
			return "return : " + msg;
		}
	}

}
