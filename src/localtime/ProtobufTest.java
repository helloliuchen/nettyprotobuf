package localtime;

import com.google.protobuf.InvalidProtocolBufferException;

import localtime.LocalTimeProtocol.*;

public class ProtobufTest {
	
	public static void main(String[] args)
	{
		// ���ݱ���ʹ��builder������
		Location.Builder builder = Location.newBuilder();
		builder.setContinent(Continent.AMERICA);
		builder.setCity("Chicago");		
		Location location = builder.build();
		
		System.out.println(location.toString());
		
		// ���л�
		byte[] bytes = location.toByteArray();
		
		// �����л�, ע��, �����Ѿ�֪��������
		try 
		{
			Location location2 = Location.parseFrom(bytes);
			System.out.print(location2.toString());
		}
		catch(InvalidProtocolBufferException e)
		{
			e.printStackTrace();
		}
		
		// �����֪��������"Location", ֻ��һ���ַ���, ��ν�����?
	}
}
