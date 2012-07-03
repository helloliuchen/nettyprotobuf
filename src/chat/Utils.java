package chat;

import com.google.protobuf.MessageLite;

import chat.Chat.*;
public class Utils {
    public static void main(String[] args)
    {
        Enter.Builder builder = Enter.newBuilder();
        builder.setName("test");
        Enter enter = builder.build();
        System.out.println(getName(enter));
//        Class<?> cls = null;
//        try
//        {
//        	cls = Class.forName("chat.Chat$Enter");
//        }
//        catch(Exception e)
//        {
//        	e.printStackTrace();
//        }
//        try {
//			MessageLite m = (MessageLite)cls.newInstance();
//			
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
        
    }
    
    public static String getName(Object obj)
    {
    	//return obj.getClass().getName();
    	return obj.getClass().getPackage().getName() + "." + obj.getClass().getSimpleName();
    }
}
