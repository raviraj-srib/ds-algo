package practice.string;

import java.util.ArrayList;

public class ValidIpAddresses {

	public static void main(String[] args) {
		ValidIpAddresses validIpAddresses = new ValidIpAddresses();
		validIpAddresses.restoreIpAddresses("0100100");
	}

	public ArrayList<String> restoreIpAddresses(String A) {
		if (A.length() < 3 && A.length() > 12) {
			return new ArrayList<String>();
		}
		return getAllPossibleIps(A);
	}

	private ArrayList<String> getAllPossibleIps(String ipString) {
		ArrayList<String> ipList = new ArrayList<String>();
		int ipLength = ipString.length();
		for (int i = 1; i < ipLength - 2; i++) {
			for (int j = i + 1; j < ipLength - 1; j++) {
				for (int k = j + 1; k < ipLength; k++) {
					StringBuilder sb = new StringBuilder(ipString);
					sb.insert(k, '.');
					sb.insert(j, '.');
					sb.insert(i, '.');
					String ip = sb.toString();
					if (isValidIp(ip)) {
						ipList.add(ip);
					}
					// System.out.println("i:" + i + ", j:" + j + ", k:" + k +"\t"+ sb.toString());
				}
			}

		}
		// System.out.println(ipList);
		return ipList;
	}

	private boolean isValidIp(String ip) {
		String[] ipParts = ip.split("\\.");
		for (String ipPart : ipParts) {
			if (ipPart.length() > 3) {
				return false;
			}
			if (ipPart.length() != 1 && ipPart.charAt(0) == '0') {
				return false;
			}

			int val = Integer.parseInt(ipPart);
			if (val < 0 || val > 255) {
				return false;
			}
		}
		return true;
	}
}
