package ejemplosARQ;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.util.FileManager;


public class EjemploARQ_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        FileManager.get().addLocatorClassLoader(EjemploARQ_01.class.getClassLoader());
        Model model = FileManager.get().loadModel("src/owl/data.ttl");
        
        //Hacer un String de consulta
        String queryString = 
                "PREFIX foaf: <http://xmlns.com/foaf/0.1/> " +
        		"SELECT ?name WHERE { " +
        		"    ?person foaf:mbox <mailto:alice@example.org> . " +
        		"    ?person foaf:name ?name . " +
        		"}";
        Query query = QueryFactory.create(queryString); //Crear un objeto para consulta
        QueryExecution qexec = QueryExecutionFactory.create(query, model); // ejecutar la consulta SPARQL
        try {
            ResultSet results = qexec.execSelect();
            while ( results.hasNext() ) {
                QuerySolution soln = results.nextSolution();
                Literal name = soln.getLiteral("name");
                System.out.println(name);
            }
        } finally {
            qexec.close();
        }
    }
}
