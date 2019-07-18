package rxjava;

import java.util.WeakHashMap;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

public class HelloRxJava {
	public static void main(String[] args) {
        Flowable.just("Hello rxjava").subscribe(System.out::println);
        Flowable.just("Hello rxjava").subscribe(new Consumer<String>(){
			@Override
			public void accept(String t) throws Exception {
				// TODO Auto-generated method stub
				System.out.println(t);
				
			}}
        );
        WeakHashMap whm = new WeakHashMap<String, String>();
      
        
    }
}
