package ejemplosAPI;

import java.io.InputStream;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

public class EjemploIO_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model model = ModelFactory.createDefaultModel(); // creates an in-memory Jena Model
		
		// abrir el archivo con la ontología
		InputStream in = FileManager.get().open( "src/owl/generations-Turtle.owl" );
		model.read(in, null, "TURTLE"); // parses an InputStream assuming RDF in Turtle format
		
		// Escribir el "Jena Model" en formato Turtle, RDF/XML y N-Triples 
		//System.out.println("\n---- Turtle ----");
		//model.write(System.out, "TURTLE");
        //System.out.println("\n---- RDF/XML ----");
        //model.write(System.out, "RDF/XML");
        //System.out.println("\n---- RDF/XML Abbreviated ----");
        //model.write(System.out, "RDF/XML-ABBREV");
        //System.out.println("\n---- N-Triples ----");
        //model.write(System.out, "N-TRIPLES");
        System.out.println("\n---- RDF/JSON ----");
        model.write(System.out, "RDF/JSON");
	}
}