package chat;

import java.util.HashMap;
import java.util.Map;

public class Mapping {
	public static Map<String, Integer> Name2IntMapping = new HashMap<String, Integer>();
	public static Map<Integer, String> Int2NameMapping = new HashMap<Integer, String>();
	
	static{
		Int2NameMapping.put(1,	"chat.Chat$Enter");
		Int2NameMapping.put(2,	"chat.Chat$Users");
		Int2NameMapping.put(3,	"chat.Chat$Say");
		Int2NameMapping.put(4,	"chat.Chat$SayBC");
		Int2NameMapping.put(5,	"chat.Chat$Leave");
	}
	
	static {
		for (Map.Entry<Integer, String> entry: Int2NameMapping.entrySet())
		{
			Name2IntMapping.put(entry.getValue(), entry.getKey());
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println(Name2IntMapping);
		System.out.println(Int2NameMapping);
	}
}
