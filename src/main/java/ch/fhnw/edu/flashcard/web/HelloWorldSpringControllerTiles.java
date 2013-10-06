package ch.fhnw.edu.flashcard.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller 										 // Die Klasse als PageController deklarieren
@RequestMapping("/tiles")							 // Reagiert auf eine URL mit /tiles

public class HelloWorldSpringControllerTiles {

	@RequestMapping(value="say/{to}/{from}") 		// Wenn nach /tiles/say kommt, dann diese Methode mit den Parametern "to"/"from"

	/* Der übergebene Parameter to wird in die Variable to gespeichert werden
	 * Der lang Parameter (?lang=de) ist nicht zwingend nötig (required = false) und wird ebenfalls in eine Variable gespeichert*/
	public String sayHello(@PathVariable("to") String to, @PathVariable("from") String from, 
			@RequestParam(value="lang", required=false) String lang, Model uiModel) { 
		
		String message = " ";
		if ("de".equals(lang)) {							// Falls in der RequestParamter lang "de" enthält...
			message = "Hallo an " + to + " von " + from;	// dann ist message in Deutsch, sonst Englisch
		} else {
			message = "Hello to " + to + " from " + from;
		}
		uiModel.addAttribute("message", message);			// Dem Modell den String message mit dem Key message übergeben
		return "hello";										// Das Modell mit dem Namen der richtigen view (?)
	}

}
