package fr.wemove.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.wemove.model.Conducteur;
import fr.wemove.model.Utilisateur;

public class ConducteurSubscribeValidator implements Validator {
	
	
	@Override
	public boolean supports(Class<?> cls) {
		return Conducteur.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors e) {
		
		Conducteur conducteur = (Conducteur) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "prenom", "prenom.empty", "Le pr�nom doit �tre saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "nom", "nom.empty", "Le nom doit �tre saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "email", "email.empty", "Le email doit �tre saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "login", "login.empty", "Le login doit �tre saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "motDePasse", "motDePasse.empty", "Le motDePasse doit �tre saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "confirmation", "confirmation.empty", "Le confirmation doit �tre saisi");
		
		
		if ( !conducteur.getMotDePasse().equals(conducteur.getConfirmation())) {
		e.rejectValue("motDePasse", "pwdcheck", "Les mots de passe ne correspondent pas.");
		
		}
	
		
	}
	

}
