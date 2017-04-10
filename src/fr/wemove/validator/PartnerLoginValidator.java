package fr.wemove.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.wemove.model.Utilisateur;

public class PartnerLoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return Utilisateur.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors e) {
		
		Utilisateur utilisateur = (Utilisateur) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "login", "login.empty", "Le login doit être saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "motDePasse", "motDePasse.empty", "Le mot de passe doit être saisi");
		
		
		
	}
	
	
	

}
