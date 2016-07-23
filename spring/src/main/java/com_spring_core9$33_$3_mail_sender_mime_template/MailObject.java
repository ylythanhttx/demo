package com_spring_core9$33_$3_mail_sender_mime_template;

import java.io.Serializable;
import java.util.Date;

public class MailObject implements Serializable{

	private static final long serialVersionUID = 4402646054806964229L;
	private String to;
	private String from;
	private String[] cc;
	private String subject;
	private Date sentDate;
	private String replyTo;
	private String text;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String[] getCc() {
		return cc;
	}

	public void setCc(String[] cc) {
		this.cc = cc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public String getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
