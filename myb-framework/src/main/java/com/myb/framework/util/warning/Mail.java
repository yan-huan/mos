package com.myb.framework.util.warning;

import com.myb.framework.util.mail.MailSenderInfo;
import com.myb.framework.util.mail.SimpleMailSender;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Mail implements IWarning {

	private Log logger = LogFactory.getLog(this.getClass());

    private String userName;

	private String password;

	private String serverHost;

	private String port;

	private String fromAddress;

	private String toAddress;


	public void send(String subject, String body) {

		try {
			MailSenderInfo mailInfo = new MailSenderInfo();
			mailInfo.setMailServerHost(serverHost);
			mailInfo.setMailServerPort(port);
			mailInfo.setValidate(true);
			mailInfo.setUserName(userName);
			mailInfo.setPassword(password);
			mailInfo.setFromAddress(fromAddress);

			mailInfo.setSubject(subject);
			mailInfo.setContent(body);
			String[] reces = toAddress.split(",");
			for (int i = 0; i < reces.length; i++) {
				mailInfo.setToAddress(reces[i]);
				SimpleMailSender sms = new SimpleMailSender();
				sms.sendHtmlMail(mailInfo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e);
		}

	}

	public Log getLogger() {
		return logger;
	}

	public void setLogger(Log logger) {	this.logger = logger;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getServerHost() {
		return serverHost;
	}

	public void setServerHost(String serverHost) {
		this.serverHost = serverHost;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

}
