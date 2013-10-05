package ch.fhnw.edu.flashcard.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller 								 // Die Klasse als PageController deklarieren
@RequestMapping("/hello")					 // Reagiert auf eine URL mit /hello

public class HelloWorldSpringController {

	@ResponseBody 							 // Die Methode sayHello soll einen String retour geben (keinen view-Namen)
	@RequestMapping(value="say/{to}/{from}") // Wenn nach /hello/say kommt, dann diese Methode mit den Parametern "to"/"from"

	/* Der übergebene Parameter to wird in die Variable to gespeichert werden
	 * Der lang Parameter (?lang=de) ist nicht zwingend nötig (required = false) und wird ebenfalls in eine Variable gespeichert*/
	public String sayHello(@PathVariable("to") String to, @PathVariable("from") String from, 
			@RequestParam(value="lang", required=false) String lang) { 

		if ((lang != null) && (lang.equals("de"))) { // Falls lang nicht null ist und de, dann Hallo... ausgeben, sonst...
			return "Hallo an " +to+ " von " +from;
		}
		return "Hello to " +to+ " from " +from;
	}

}
