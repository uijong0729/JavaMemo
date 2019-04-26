package file;

import java.util.HashMap;

public class JsonSupporter {
    public static String hashToJson(HashMap<String, String> map) {
        StringBuffer sb = new StringBuffer();
        int size = map.size();
        int count = 0;
        sb.append("{");
        for( String key : map.keySet() ){
            if(size-1 != count) {
                sb.append("\"" + key +"\":");
                sb.append("\"" + map.get(key) + "\",");
            }else {
                sb.append("\"" + key +"\":");
                sb.append("\"" + map.get(key) + "\"");
            }
            count++;
        }
        sb.append("}");
        return sb.toString();
    }

}
