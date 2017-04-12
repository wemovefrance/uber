package fr.wemove.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.wemove.model.Trajet;


	public class TrajetValidator implements Validator {
		
		
		@Override
		public boolean supports(Class<?> cls) {
			return Trajet.class.equals(cls);
		}

		@Override
		public void validate(Object obj, Errors e) {
			
			Trajet trajet = (Trajet) obj;
			
			ValidationUtils.rejectIfEmptyOrWhitespace(e, "dateDuTrajet", "dateDuTrajet.empty", "Saisir la date du trajet");
			ValidationUtils.rejectIfEmptyOrWhitespace(e, "commentaire", "commentaire.empty", "Donnez des précisions sur votre course");

		}
		

	}
