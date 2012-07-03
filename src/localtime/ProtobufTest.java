package localtime;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import localtime.LocalTimeProtocol.Continent;
import localtime.LocalTimeProtocol.Location;

public class ProtobufTest {
	
	public static void main(String[] args)
	{
		// 数据必须使用builder来创建
		Location.Builder builder = Location.newBuilder();
		builder.setContinent(Continent.AMERICA);
		builder.setCity("Chicago");		
		Location location = builder.build();
		
	//	System.out.println(location.toString());
		
		// 序列化
		byte[] bytes = location.toByteArray();
		
//		// 反序列化, 注意, 这里已经知道类型了
//		try 
//		{
//			Location location2 = Location.parseFrom(bytes);
//			System.out.print(location2.toString());
//		}
//		catch(InvalidProtocolBufferException e)
//		{
//			e.printStackTrace();
//		}
		
		// 如果我知道该类是"Location", 只是一个字符串, 如何解析呢?
		
		//System.out.println(Location.class.getName());
		try {

			Class<?> cls = Class.forName("localtime.LocalTimeProtocol$Location");
			Method method = cls.getMethod("parseFrom", byte[].class);
			
			// 反序列化得到Location
			Object obj =  method.invoke(null, bytes);
			System.out.println(obj.toString());
			

			Class<?> handler = Class.forName("localtime.business.LocationHandler");
			Method processor = handler.getMethod("process", Object.class);
			processor.invoke(handler.newInstance(), obj);
			System.out.println(processor);
			//处理逻辑
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
