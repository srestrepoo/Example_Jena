package ejemplosAPI;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.*;


public class EjemploAPI_01 {

	// algunas definiciones
    static String personURI    = "http://algunlugar/jaimeguzman";
    static String fullName     = "Jaime Guzman";
	    
    public static void main (String args[]) {
	       // crea un modelo vacío
	       Model model = ModelFactory.createDefaultModel();

	       // crea el recurso
	       Resource jaimeGuzman = model.createResource(personURI);

	      // adiciona la propiedad
	       jaimeGuzman.addProperty(VCARD.FN, fullName);
	      
	      //escribe el modelo en forma de XML
	      model.write(System.out);
    }
}
