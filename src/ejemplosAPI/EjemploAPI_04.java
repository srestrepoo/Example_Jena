package ejemplosAPI;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.DC;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.SKOS;

public class EjemploAPI_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Model model = ModelFactory.createDefaultModel();
        
        Resource alicia = ResourceFactory.createResource("http://example.org/alicia-barberis");
        
        //Vocabulario FOAF
        Resource bob = ResourceFactory.createResource("http://example.org/bob");
        model.add (alicia, RDF.type, FOAF.Person);
        model.add (alicia, FOAF.name, "Alicia");
        model.add (alicia, FOAF.mbox, ResourceFactory.createResource("mailto:alicia-barberis@example.org"));
        model.add (alicia, FOAF.knows, bob);
        
        //Vocabulario Dublin core
        Resource bookExample = ResourceFactory.createResource("http://example.org/el-infierno-de-los-vivos");
        model.add(bookExample, DC.title, "El infierno de los vivos");
        model.add(bookExample, DC.creator, alicia);
        model.add(bookExample, DC.date, "2005-12-07");
        model.add(bookExample, DC.publisher, bob);
        
      //Vocabulario SKOS core
        Resource book = ResourceFactory.createResource("http://example.org/book");
        model.add(book, RDF.type, SKOS.Concept);
        model.add(book, SKOS.prefLabel, "Libro");
        model.add(book, SKOS.altLabel, "Ejemplar");
        model.add(book, SKOS.definition, "Conjunto de hojas de papel, normalmente encuadernadas");

        model.write(System.out, "TURTLE");
	}
}
