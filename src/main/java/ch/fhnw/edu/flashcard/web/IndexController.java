package ch.fhnw.edu.flashcard.web;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ch.fhnw.edu.flashcard.domain.Questionnaire;

@Controller											// Die Klasse als PageController deklarieren
@RequestMapping("/")								// Reagiert auf eine URL mit .../flashcard (also index)

public class IndexController {
	private Logger log = Logger.getLogger(this.getClass());
	@RequestMapping(method = RequestMethod.GET)		// Bei GET-Requests soll diese Methode ohne Parameter aufgerufen werden

	public String list(Model uiModel) { 			// Methode bekommt leeres Model und füllt dieses mit den Questionnaires (Businesslogik)
													// Dabei ist questionnaires der Key und die Questionnaires der Value im Model
		uiModel.addAttribute("questionnaires", Questionnaire.findAllQuestionnaires());
		log.debug("index called");					// Ausgabe auf der Konsole zur Kontrolle, ob index aufgerufen wurde
		return "index";								// Der Name der view (sehr abstrakt - ohne Technologie) & Model zurück an Framework
	}

}
