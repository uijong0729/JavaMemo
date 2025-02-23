package rxjava;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HelloRxJava {
	public static void main(String[] args) {
		Observable<ArrayList<String>> flow = Observable.fromCallable(new Callable<ArrayList<String>>() {
			@Override
			public ArrayList<String> call() throws Exception {
				// TODO Auto-generated method stub
				return createList();
			}
		}).subscribeOn(Schedulers.io())
		.observeOn(Schedulers.single());
		
		Disposable disposable = flow.subscribe(list -> {
		    for(String str : list) {
		    	System.out.println(str);
		    }
		  }, err -> {
			  System.out.println("err");
		  });
		
		//disposable.dispose();
    }
	
	public static ArrayList<String> createList(){
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0 ; i < 20 ; i++) {
			list.add("number : " + i);
		}
		return list;
	}
}
