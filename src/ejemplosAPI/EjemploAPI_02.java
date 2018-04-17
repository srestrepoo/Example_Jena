package ejemplosAPI;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.vocabulary.*;

public class EjemploAPI_02 {

	// algunas definiciones
    static String personURI    = "http://algunLugar/JaimeGuzman";
    static String givenName    = "Jaime";
    static String familyName   = "Guzman";
    static String fullName     = givenName + " " + familyName;
	
	public static void main(String[] args) {
		// crea un modelo vacío
		Model model = ModelFactory.createDefaultModel();
	    
		//Adiciona al modelo las propiedades en estilo cascada
		model.createResource(personURI)
	                        .addProperty(VCARD.FN, fullName)
	                        .addProperty(VCARD.N,
	                        model.createResource()
	                                            .addProperty(VCARD.Given,givenName)
	                                            .addProperty(VCARD.Family,familyName));
		
		//escribe el modelo en forma de XML
	      model.write(System.out);
	}
}
