package fr.wemove.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.validator.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.wemove.dao.UtilisateurDAO;
import fr.wemove.model.Utilisateur;



@Component
public class UtilisateurSubscribeValidator implements Validator {
	
	@Autowired
	private UtilisateurDAO utilisateurDAO;

	public void setUtilisateurDAO(UtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}

	@Override
	public boolean supports(Class<?> cls) {
		return Utilisateur.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors e) {
		
		Utilisateur utilisateur = (Utilisateur) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "prenom", "prenom.empty", "Le prénom doit être saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "nom", "nom.empty", "Le nom doit être saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "email", "email.empty", "L'email doit être saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "login", "login.empty", "Le login doit être saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "motDePasse", "motDePasse.empty", "Le motDePasse doit être saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "confirmation", "confirmation.empty", "Le confirmation doit être saisi");
		
		/*
		if ( utilisateur.getCondGV() != true) {
			
			e.rejectValue("condGV", "condGV.empty", "Merci d'accepter les conditions générales de ventes");
		}
		
		*/
		// Verif des emails
		
		EmailValidator validator = EmailValidator.getInstance();

		if (!validator.isValid(utilisateur.getEmail())) {
			e.rejectValue("email", "emailcheck", "Adresse email non valide");
		} 
		
		// Verif des mot de passe
		
		if (utilisateur.getMotDePasse().length()<8) {
			e.rejectValue("motDePasse", "pwdcheck", "Le mot de passe doit faire au moins 8 caractères");	
		}
		
		
		if ( !utilisateur.getMotDePasse().equals(utilisateur.getConfirmation())) {
		e.rejectValue("motDePasse", "pwdcheck", "Les mots de passe ne correspondent pas.");
		
		}
		
		// Vérif des logins
		
		if (utilisateurDAO.checkLogin(utilisateur.getLogin()) != null) {
				e.rejectValue("login", "logincheck", "Login déjà utilisé, changer de pseudo");
		}
		
	}


}
