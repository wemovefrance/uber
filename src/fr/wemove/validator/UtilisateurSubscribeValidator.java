package fr.wemove.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.wemove.model.Utilisateur;

public class UtilisateurSubscribeValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return Utilisateur.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors e) {
		
		Utilisateur utilisateur = (Utilisateur) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "prenom", "prenom.empty", "Le prénom doit être saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "nom", "nom.empty", "Le nom doit être saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "email", "email.empty", "Le email doit être saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "login", "login.empty", "Le login doit être saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "user_input_autocomplete_address", "adress.empty", "L'adresse doit être saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "motDePasse", "motDePasse.empty", "Le motDePasse doit être saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "confirmation", "confirmation.empty", "Le confirmation doit être saisi");
		
		if ( utilisateur.getCondGV() != true) {
			
			e.rejectValue("condGV", "condGV.empty", "Merci d'accepter les conditions générales de ventes");
		}
		
		
		if ( !utilisateur.getMotDePasse().equals(utilisateur.getConfirmation())) {
		e.rejectValue("motDePasse", "pwdcheck", "Les mots de passe ne correspondent pas.");
		
		}
	
		
	}
	
	

}
