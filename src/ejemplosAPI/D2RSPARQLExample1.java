package ejemplosAPI;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.query.ResultSet;

public class D2RSPARQLExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /* String sparqlQueryString1 = "PREFIX dbont: <http://dbpedia.org/ontology/> " +
                "PREFIX dbp: <http://dbpedia.org/property/>" +
                "PREFIX geo: <http://www.w3.org/2003/01/geo/wgs84_pos#>" +
                "   SELECT ?musician  ?place" +
                "   WHERE { " +
                "       ?musician dbont:birthPlace ?place ." +
                "   }"; */

		String sparqlQueryString1 = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
									+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
									+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
									+ "PREFIX vocab: <http://localhost:2020/resource/vocab/>"
									+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
									+ "PREFIX map: <http://localhost:2020/resource/#>"
									+ "PREFIX db: <http://localhost:2020/resource/>"
									+ "SELECT DISTINCT ?municipio ?nombre WHERE {?x vocab:Biblioteca_municipio ?municipio. ?x vocab:Biblioteca_nombre_de_la_biblioteca ?nombre FILTER regex(?municipio,'MED')}";
        // Crear el objeto consulta
        Query query = QueryFactory.create(sparqlQueryString1);
        QueryExecution qexec = QueryExecutionFactory.sparqlService("http://18.188.78.66:2020/sparql", query);

        //Luego procesar la ejecución de la consulta y su resultado

        try {
        	ResultSet results = qexec.execSelect();
        	ResultSetFormatter.out(System.out, results, query);
        }
        finally {
           qexec.close();
        }

	}

}
