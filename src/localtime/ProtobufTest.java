package localtime;

import com.google.protobuf.InvalidProtocolBufferException;

import localtime.LocalTimeProtocol.*;

public class ProtobufTest {
	
	public static void main(String[] args)
	{
		// 数据必须使用builder来创建
		Location.Builder builder = Location.newBuilder();
		builder.setContinent(Continent.AMERICA);
		builder.setCity("Chicago");		
		Location location = builder.build();
		
		System.out.println(location.toString());
		
		// 序列化
		byte[] bytes = location.toByteArray();
		
		// 反序列化, 注意, 这里已经知道类型了
		try 
		{
			Location location2 = Location.parseFrom(bytes);
			System.out.print(location2.toString());
		}
		catch(InvalidProtocolBufferException e)
		{
			e.printStackTrace();
		}
		
		// 如果我知道该类是"Location", 只是一个字符串, 如何解析呢?
	}
}
