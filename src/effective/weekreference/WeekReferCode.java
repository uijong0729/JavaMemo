package effective.weekreference;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class WeekReferCode {
	//WeakReference
	Object strongRef = new Object();
	WeakReference<Object> wrf = new WeakReference<Object>(strongRef);
	
	//WeakHashMap
	WeakHashMap<String, Object> whm = new WeakHashMap<String, Object>();
	
}
