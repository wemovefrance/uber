package fr.wemove.validator;

import org.apache.commons.validator.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.wemove.dao.UtilisateurDAO;
import fr.wemove.model.Conducteur;

@Component
public class ConducteurSubscribeValidator implements Validator {
	
	@Autowired
	private UtilisateurDAO utilisateurDAO;
	
	@Override
	public boolean supports(Class<?> cls) {
		return Conducteur.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors e) {
		
		Conducteur conducteur = (Conducteur) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "prenom", "prenom.empty", "Le prénom doit être saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "nom", "nom.empty", "Le nom doit être saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "email", "email.empty", "Le email doit être saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "login", "login.empty", "Le login doit être saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "adresse.nom", "adresse.nom.empty", "L'adresse doit être saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "motDePasse", "motDePasse.empty", "Le mot de passe doit être saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "confirmation", "confirmation.empty", "Le confirmation doit être saisi");
		
		/*
		if ( conducteur.getCondGV() != true) {
			
			e.rejectValue("condGV", "condGV.empty", "Merci d'accepter les conditions générales de ventes");
		}*/
		
		
		EmailValidator validator = EmailValidator.getInstance();

		if (!validator.isValid(conducteur.getEmail())) {
			e.rejectValue("email", "emailcheck", "Adresse email non valide");
		} 
		
		// Verif des mot de passe
		
		if (conducteur.getMotDePasse().length()<8) {
			e.rejectValue("motDePasse", "pwdcheck", "Le mot de passe doit faire au moins 8 caractères");	
		}
		
		
		if ( !conducteur.getMotDePasse().equals(conducteur.getConfirmation())) {
		e.rejectValue("motDePasse", "pwdcheck", "Les mots de passe ne correspondent pas.");
		
		}
		
		// Vérif des logins
		
		if (utilisateurDAO.checkLogin(conducteur.getLogin()) != null) {
				e.rejectValue("login", "logincheck", "Login déjà utilisé, changer de pseudo");
		}
	
		
	}
	

}
