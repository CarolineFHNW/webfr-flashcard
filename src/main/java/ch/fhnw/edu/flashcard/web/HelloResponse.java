package ch.fhnw.edu.flashcard.web;

public class HelloResponse {
	private String to;
	private String from;
	private String language;
	
	public HelloResponse(String to, String from, String language) {
		this.to = to;
		this.from = from;
		this.language = language;
	}
	
	public String getTo() {
		return to;
	}
	public String getFrom() {
		return from;
	}
	public String getLanguage() {
		return language;
	}
	
	

}
