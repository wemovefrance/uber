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
			ValidationUtils.rejectIfEmptyOrWhitespace(e, "commentaire", "commentaire.empty", "Donnez des pr�cisions sur votre course");
			ValidationUtils.rejectIfEmptyOrWhitespace(e, "poids", "poids.empty", "Estimer le poids des objets � transporter");
			ValidationUtils.rejectIfEmptyOrWhitespace(e, "distance", "distance.empty", "Estimer le poids des objets � transporter");
			ValidationUtils.rejectIfEmptyOrWhitespace(e, "depart.nom", "depart.nom.empty", "Saisir le point de d�part du trajet");
			ValidationUtils.rejectIfEmptyOrWhitespace(e, "prix", "prix.empty", "Veuillez simuler un prix");

			
		}
		

	}
