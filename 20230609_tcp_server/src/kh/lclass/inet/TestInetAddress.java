package kh.lclass.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class TestInetAddress {
	public void testInetAddressEx() {
		// the constructor InetAddress() is not visible
		// 원인 생성자 없음.
		// 조치내용 : 1. singleton 확인 (주로 getInstance(), create() 메소드 지원 확인)
		// 2. static method 즉 클래스메소드 지원 확인.
		String host1 = "www.naver.com";
		String host2 = "www.google.com";
		String host3 = "www.oracle.com";
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
		try {
			InetAddress loopbackAddr = InetAddress.getLoopbackAddress();
			System.out.println(loopbackAddr);
			
			InetAddress localIp = InetAddress.getLocalHost();
			System.out.println(localIp);	// DESKTOP-10FBTCJ/192.168.10.9
			boolean isLoopback = localIp.isLoopbackAddress();
			System.out.println(isLoopback);

			System.out.println("=== localhost ===");
			InetAddress lb = InetAddress.getByName("localhost");
			System.out.println(Arrays.toString(lb.getAddress()));
			boolean lbisLoopback = lb.isLoopbackAddress();
			System.out.println(lbisLoopback);

			byte[] localIpArr = localIp.getAddress();
			System.out.println("ip: ");
			for(int i=0;i<localIpArr.length;i++) {
				if(localIpArr[i]<0) {
					System.out.print(i+256);
				}
				else {
					System.out.print(i);
				}
				if(i != localIpArr.length-1) {
				System.out.print(".");
				}
			}
			
			
			
			System.out.println("");
			byte[] byteArr = new byte[] {(byte)192,(byte)168,(byte)10,(byte)9};
			System.out.println(Arrays.toString(byteArr)); // -64.-88.10.9
			
			System.out.println("");
			InetAddress byte2Arr = InetAddress.getByAddress(byteArr);
			System.out.println(byte2Arr);// /192.168.10.9
			
			System.out.println("");
			String byte2Arr2HostName = byte2Arr.getHostName();
			System.out.println(byte2Arr2HostName); // 192.168.10.9
			
			System.out.println(byte2Arr.getHostAddress());
			
			InetAddress[] ipAll = InetAddress.getAllByName(host1);
			System.out.println(Arrays.toString(ipAll)); // www.naver.com/223.130.200.107
			for(InetAddress ip : ipAll) {
				System.out.println(ip);
				System.out.println("====");
				System.out.println(ip.getHostName());
				byte[] ipAddr = ip.getAddress();
				for(int i=0;i<ipAddr.length;i++) {
					if(ipAddr[i]<0) {
						System.out.print(i+256);
					}
					else {
						System.out.print(i);
					}
					if(i != ipAddr.length-1) {
					System.out.print(".");
					}
				}
				System.out.println();
				
				
				System.out.println("ip: ");
				int cnt=0;
				for(int item : ipAddr) {
					if(item<0) {
						System.out.print(item+256);
					}
					else {
						System.out.print(item);
					}
					if(cnt != ipAddr.length-1) {
						System.out.print(".");
					}
					cnt++;
				}
				System.out.println();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
