package com.oneapi4sms;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;

/**
 * @author IDS
 *
 */
public class OneApi4SmsResult {

	private String CountryAbbreviation; 				/** parameters That are passed in URL */
	private int areacode;
	private String pattern;
	private String region;
	private long msisdn;
	private String clientCorrelator;
	private String criteria;
	private long destinationAddress;
	private short notificationFormat;
	private String notifyURL;
	private String requestId;
	private long senderAddress;

		/**
		 * This  is a class for providing Authentication to the URL.
		 */
	static class MyAuthenticator extends Authenticator {

		/**
		 * This method is called when a password-protected URL is accessed.
		 */
		protected PasswordAuthentication getPasswordAuthentication() {

		/**
		* Get information about the request.
		*/
		String promptString = getRequestingPrompt();
		String hostname = getRequestingHost();
		InetAddress ipaddr = getRequestingSite();
		int port = getRequestingPort();

		/**
		* Get the username from the user... Get the password from the
		* user...
		*/
		String username = "";
		String password = "";

		/**
		 * Return the information.
		*/
		return new PasswordAuthentication(username, password.toCharArray());
		}
	}

		/**
		 * This is the method for find Available Addresses by passing following parameters [Account].
		 */
	public void findAvailableAddress(String CountryAbbreviation, int areacode,String pattern, String region) {

		/**
		 *  Access the page
		 */
		Authenticator.setDefault(new MyAuthenticator());
		try {
		/**
		*Create a URL for find Available Addresses List.
		*/
		URL url = new URL("https://api.oneapi4sms.com/v1/account/availableAddresses/"
							+ CountryAbbreviation + "/?Areacode=" + areacode
							+ "&pattern=" + pattern + "&Region=" + region);

		/**
		*A HttpURLConnection is used to support for HTTP-specific features.
		*/
		HttpURLConnection urlc = (HttpURLConnection) url.openConnection();

		/**
		* Setting the Properties for URL.
		*/
		urlc.setRequestProperty("User-Agent","Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)");
		urlc.setDoInput(true);
		urlc.setFollowRedirects(true);
		urlc.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

		/**
		 * for displaying the URL data.
		*/
		BufferedInputStream buffer = new BufferedInputStream(urlc.getInputStream());
		StringBuilder builder = new StringBuilder();
		int byteRead;
		while ((byteRead = buffer.read()) != -1)
			builder.append((char) byteRead);
			buffer.close();
			System.out.println(builder.toString());
		}

		catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

		/**
		* This is a method for adding Address in [Account]
		*/
	public void addAddress(String CountryAbbreviation, long msisdn) {
		/**
		 *  Access the page
		 */
	Authenticator.setDefault(new MyAuthenticator());
		try {
			/**
			 *Create a URL for the desired page.
			 */
	URL url = new URL("https://api.oneapi4sms.com/v1/account/customerAddresses/"
							+ CountryAbbreviation + "/" + msisdn);

			/**
			 *A HttpURLConnection is used to support for HTTP-specific features.
			 */
			HttpURLConnection urlc = (HttpURLConnection) url.openConnection();

			/**
			 * Setting the Properties for URL.
			 */
			urlc.setRequestProperty("User-Agent","Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)");
			urlc.setDoInput(true);
			urlc.setDoOutput(true);
			urlc.setFollowRedirects(true);

			/**
			 * for displaying the URL data.
			 */
			BufferedInputStream buffer = new BufferedInputStream(
					urlc.getInputStream());
			StringBuilder builder = new StringBuilder();
			int byteRead;
			while ((byteRead = buffer.read()) != -1)
				builder.append((char) byteRead);
			buffer.close();
			System.out.println(builder.toString());
		}

		catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}


		/**
		* This is a method for setSubscribe [inbound SMS]
		*/
		public void setSubscribe(String clientCorrelator, String criteria,
				long destinationAddress, int notificationFormat, String notifyURL) {
		/**
		 * Access the page
		 * */
		Authenticator.setDefault(new MyAuthenticator());

		try {
		/**
		* Create a URL for setSubscribe for messages
		*/
		URL url = new URL("https://api.oneapi4sms.com/v1/smsmessaging/inbound/subscriptions?DestinationAddress="
							+ destinationAddress
							+ "&NotifyURL="
							+ notifyURL
							+ "&NotificationFormat="
							+ notificationFormat
							+ "&criteria=" + criteria);
		/**
		*	A HttpURLConnection is used to support for HTTP-specific features.
		*/
		HttpURLConnection urlc = (HttpURLConnection) url.openConnection();

		/**
		* Setting the Properties for URL.
		*/
		urlc.setRequestProperty("User-Agent","Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)");
		urlc.setDoInput(true);
		urlc.setDoOutput(true);
		urlc.setFollowRedirects(true);

		/**
		 * for displaying the URL data.
		*/
			BufferedInputStream buffer = new BufferedInputStream(urlc.getInputStream());
			StringBuilder builder = new StringBuilder();
			int byteRead;
			while ((byteRead = buffer.read()) != -1)
				builder.append((char) byteRead);
			buffer.close();
			System.out.println(builder.toString());
		}

		catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

		/**
		 *  This is a method for viewSubscribe [inbound SMS]
		*/
		public void viewSubscribe(String destinationAddress) {

			/**
			 *  Access the page
			 */
		Authenticator.setDefault(new MyAuthenticator());
		try {
			/**
			 *  Create a URL for Listing the viewSubscribe status of messages
			 */
			URL url = new URL(
					"https://api.oneapi4sms.com/v1/smsmessaging/inbound?"
							+ destinationAddress);
			/**
			 *A HttpURLConnection is used to support for HTTP-specific features.
			 */
			HttpURLConnection urlc = (HttpURLConnection) url.openConnection();

			/**
			 * Setting the Properties for URL.
			 */
			urlc.setRequestProperty("User-Agent","Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)");
			urlc.setDoInput(true);
			urlc.setDoOutput(true);
			urlc.setFollowRedirects(true);

			/**
			 * for displaying the URL data.
			 */
			BufferedInputStream buffer = new BufferedInputStream(
					urlc.getInputStream());
			StringBuilder builder = new StringBuilder();
			int byteRead;
			while ((byteRead = buffer.read()) != -1)
				builder.append((char) byteRead);
			buffer.close();
			System.out.println(builder.toString());
		}

		catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * This is a method for DeliveryStatus [outbound SMS]
	 */
	public void deliveryStatus(String requestId, long senderAddress) {
		/**
		 *  Access the page
		 */
		Authenticator.setDefault(new MyAuthenticator());

		try {
			/**
			 * Create a URL for the check the deliveryStatus of messages.
			 */
			URL url = new URL(
					"https://api.oneapi4sms.com/v1/smsmessaging/outbound/"
							+ senderAddress + "/requests/" + requestId
							+ "/deliveryInfos");
			/**
			 *A HttpURLConnection is used to support for HTTP-specific features.
			 */
			/**
			 *A HttpURLConnection is used to support for HTTP-specific features.
			 */
			HttpURLConnection urlc = (HttpURLConnection) url.openConnection();

			/**
			 * Setting the Properties for URL.
			 */
			urlc.setRequestProperty("User-Agent","Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)");
			urlc.setDoInput(true);
			urlc.setDoOutput(true);
			urlc.setFollowRedirects(true);

			/**
			 * for displaying the URL data.
			 */
			BufferedInputStream buffer = new BufferedInputStream(
					urlc.getInputStream());
			StringBuilder builder = new StringBuilder();
			int byteRead;
			while ((byteRead = buffer.read()) != -1)
				builder.append((char) byteRead);
			buffer.close();
			System.out.println(builder.toString());
		}

		catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}


		/**
		 * This is a method for sending SMS [outbound SMS]
		 */
		public void sendSms(long address, String clientCorrelator, String message,String notifyURL, long senderAddress) {

		/**
		 * Access the page
		*/
		Authenticator.setDefault(new MyAuthenticator());

			try {
		/**
		* Create a URL for the sending  SMS by using following parameters.
		*/
		URL url = new URL("https://api.oneapi4sms.com/v1/smsmessaging/outbound/"
								+ senderAddress + "/requests?address=" + address
								+ "&clientCorrelator=" + clientCorrelator
								+ "&message=" + message + "&notifyURL=" + notifyURL);
			/**
			 *A HttpURLConnection is used to support for HTTP-specific features.
			 */
		/**
		 *A HttpURLConnection is used to support for HTTP-specific features.
		 */
		HttpURLConnection urlc = (HttpURLConnection) url.openConnection();

		/**
		 * Setting the Properties for URL.
		 */
		urlc.setRequestProperty("User-Agent","Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)");
		urlc.setDoInput(true);
		urlc.setDoOutput(true);
		urlc.setFollowRedirects(true);

		/**
		 * for displaying the URL data.
		 */
		BufferedInputStream buffer = new BufferedInputStream(
				urlc.getInputStream());
		StringBuilder builder = new StringBuilder();
		int byteRead;
		while ((byteRead = buffer.read()) != -1)
			builder.append((char) byteRead);
		buffer.close();
		System.out.println(builder.toString());
	}

	catch (MalformedURLException ex) {
		ex.printStackTrace();
	} catch (IOException ex) {
		ex.printStackTrace();
	}
}


	/**
	 * This is a method for messages [Reporting]
	 */
	public void allMessages(String reportFormat) {
		/**
		 * Access the page
		*/
		Authenticator.setDefault(new MyAuthenticator());
		try {
			/**
			 * Create a URL for the display all messages
			*/
			URL url = new URL(
					"https://api.oneapi4sms.com/v1/smsmessaging/messages?reportFormat="
							+ reportFormat);
			/**
			 *A HttpURLConnection is used to support for HTTP-specific features.
			 */
			/**
			 *A HttpURLConnection is used to support for HTTP-specific features.
			 */
			HttpURLConnection urlc = (HttpURLConnection) url.openConnection();

			/**
			 * Setting the Properties for URL.
			 */
			urlc.setRequestProperty("User-Agent","Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)");
			urlc.setDoInput(true);
			urlc.setDoOutput(true);
			urlc.setFollowRedirects(true);

			/**
			 * for displaying the URL data.
			 */
			BufferedInputStream buffer = new BufferedInputStream(
					urlc.getInputStream());
			StringBuilder builder = new StringBuilder();
			int byteRead;
			while ((byteRead = buffer.read()) != -1)
				builder.append((char) byteRead);
			buffer.close();
			System.out.println(builder.toString());
		}

		catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}


	public static void main(String[] args) {
		new OneApi4SmsResult().findAvailableAddress("USA", 56832390633L, "","Florida");
		new OneApi4SmsResult().addAddress("USA", 12052344070L);
		new OneApi4SmsResult().setSubscribe("", "", 120234414070L, 12, "gfg");
		new OneApi4SmsResult().viewSubscribe("");
		new OneApi4SmsResult().deliveryStatus("071af2342wrwer10d1ae9ae", 17184723439L);
		new OneApi4SmsResult().allMessages("xml"); /**it may be json, csv or xml */
		new OneApi4SmsResult().sendSms(121723421340L, "", "", "", 171823423434L);

	}
}
