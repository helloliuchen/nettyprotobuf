package localtime;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.google.protobuf.DescriptorProtos.FileDescriptorSet;
import com.google.protobuf.InvalidProtocolBufferException;

import localtime.LocalTimeProtocol.Continent;
import localtime.LocalTimeProtocol.Location;

public class ProtobufTest {
	
	public static void main(String[] args)
	{
		// ���ݱ���ʹ��builder������
		Location.Builder builder = Location.newBuilder();
		builder.setContinent(Continent.AMERICA);
		builder.setCity("Chicago");		
		Location location = builder.build();
		System.out.println("origin:"+location.toString());
		// ���л�
		byte[] bytes = location.toByteArray();
		
//		// ----------------------------------------------------------
//		// �����л���ʽһ, ע��, �����Ѿ�֪��������
//		// ----------------------------------------------------------
//		try 
//		{
//			Location location2 = Location.parseFrom(bytes);
//			System.out.print(location2.toString());
//		}
//		catch(InvalidProtocolBufferException e)
//		{
//			e.printStackTrace();
//		}
//		
//		// ----------------------------------------------------------
//		// �����л���ʽ��, ʹ��java��reflection
//		// �����֪��������"Location", ֻ��һ���ַ���, ��ν�����?
//		// ----------------------------------------------------------
//		
//		//System.out.println(Location.class.getName());
//		try {
//
//			Class<?> cls = Class.forName("localtime.LocalTimeProtocol$Location");
//			Method method = cls.getMethod("parseFrom", byte[].class);
//			
//			// �����л��õ�Location
//			Object obj =  method.invoke(null, bytes);
//			System.out.println(obj.toString());
//			
//
//			Class<?> handler = Class.forName("localtime.business.LocationHandler");
//			Method processor = handler.getMethod("process", Object.class);
//			processor.invoke(handler.newInstance(), obj);
//			System.out.println(processor);
//			//�����߼�
//			
//			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		

		// ----------------------------------------------------------
		// �����л���ʽ��, ʹ��protobuf.DynamicMessage
		// �����֪��������"Location", ֻ��һ���ַ���, ��ν�����?
		// ----------------------------------------------------------
		
		try {			
			FileDescriptorSet fileDescriptorSet;
			fileDescriptorSet = FileDescriptorSet.parseFrom(bytes);
			System.out.println(fileDescriptorSet);
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
