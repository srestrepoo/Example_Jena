package ejemplosAPI;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import virtuoso.jena.driver.*;

public class VirtuosoSPARQLExample1 {

	/**
	 * Executes a SPARQL query against a virtuoso url and prints results.
	 */
	public static void main(String[] args) {
		VirtGraph set = new VirtGraph ("zonas-wifi","jdbc:virtuoso://18.188.78.66:1111", "dba", "dba");
/*		Select all data in virtuoso	*/
		Query sparql = QueryFactory.create("PREFIX ds:<https://www.datos.gov.co/resource/f4kx-n3nn/>"
				+ " SELECT ?zona ?municipio ?departamento "
				+ "WHERE{ ?x ds:municipio ?municipio. "
				+ "?x ds:departamento ?departamento. "
				+ "?x ds:nombre_zona_wifi ?zona "
				+ "FILTER regex(?municipio,"+"'Medellín'"+")}");

		VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (sparql, set);
		ResultSet results = vqe.execSelect();

		while (results.hasNext()) {
            QuerySolution soln = results.nextSolution();
            Literal zona = soln.getLiteral("zona");
            Literal ciudad = soln.getLiteral("municipio");
            System.out.println(zona + " " + ciudad);
		}
//		try {
//			ResultSet results = vqe.execSelect();
//        	ResultSetFormatter.out(System.out, results, sparql);
//        }
//        finally {
//           vqe.close();
//        }
	}
}
