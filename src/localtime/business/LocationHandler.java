package localtime.business;

import localtime.LocalTimeProtocol.Location;

public class LocationHandler implements IHandler {

	@Override
	public boolean process(Object obj) {
		Location p = (Location)obj;
		System.out.println("recv data:");
		System.out.println(p.toString());
		return false;
	}
}
