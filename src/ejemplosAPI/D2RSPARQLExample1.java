package ejemplosAPI;

import org.apache.jena.query.Query;

import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import virtuoso.jena.driver.*;
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
		VirtGraph set = new VirtGraph ("zonas-wifi","jdbc:virtuoso://18.188.78.66:1111", "dba", "dba");
		Query sparql = QueryFactory.create(
				"PREFIX ds:<https://www.datos.gov.co/resource/f4kx-n3nn/>"
				+"	SELECT ?proyecto ?nombre ?municipio ?cod_mun ?cat_mun ?localidad ?departamento ?cod_dep ?cat_dep ?longitud ?latitud ?zona_inaugurada"
				+"	WHERE{"
				+"	?x ds:municipio ?municipio;"
				+"	   ds:departamento ?departamento;"
				+"	   ds:nombre_zona_wifi ?nombre;"
				+"	   ds:proyecto ?proyecto;"
				+"	   ds:c_digo_dane_del_departamento ?cod_dep;"
				+"	   ds:categoria_de_departamento ?cat_dep;"
				+"	   ds:categoria_de_municipio ?cat_mun;"
				+"	   ds:c_digo_dane_del_municipio ?cod_mun;"
				+"	   ds:localidad ?localidad;"
				+"	   ds:longitud ?longitud;"
				+"	   ds:latitud ?latitud;"
				+"	   ds:zona_inagurada ?zona_inaugurada."
				+"	FILTER regex(?municipio,'Medellín')}");
		VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (sparql, set);
		ResultSet results = vqe.execSelect();
		while (results.hasNext()) {
			//Datos zonas-wifi
            QuerySolution soln = results.nextSolution();
            Literal proyectoZona = soln.getLiteral("proyecto");
            Literal nombreZona = soln.getLiteral("nombre");
            Literal municipio = soln.getLiteral("municipio");
            Literal cod_munZona = soln.getLiteral("cod_mun");
            Literal cat_munZona = soln.getLiteral("cat_mun");
            Literal departamentoZona = soln.getLiteral("departamento");
            Literal cod_depZona = soln.getLiteral("cod_dep");
            Literal cat_depZona = soln.getLiteral("cat_dep");
            Literal localidadZona = soln.getLiteral("localidad");
            Literal longitudZona = soln.getLiteral("longitud");
            Literal latitudZona = soln.getLiteral("latitud");
            Literal zona_inauguradaZona = soln.getLiteral("zona_inaugurada");
            System.out.println(nombreZona);
		}
		
		
		
		String sparqlQueryString1 = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
									+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
									+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
									+ "PREFIX vocab: <http://localhost:2020/resource/vocab/>"
									+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
									+ "PREFIX map: <http://localhost:2020/resource/#>"
									+ "PREFIX db: <http://localhost:2020/resource/>"
									+ "SELECT  ?nombre ?municipio ?departamento ?naturaleza ?direccion ?georeferencia"
									+ "WHERE {"
									+ "?x vocab:Biblioteca_municipio ?municipio; "
									+ "   vocab:Biblioteca_nombre_de_la_biblioteca ?nombre;"
									+ "   vocab:Biblioteca_naturaleza_de_la_biblioteca ?naturaleza;"
									+ "   vocab:Biblioteca_departamento ?departamento;"
									+ "   vocab:Biblioteca_direccion_de_la_biblioteca ?direccion;"
									+ "   vocab:Biblioteca_georeferencia ?georeferencia."
									+ "FILTER regex(?municipio,'MEDELLIN')}";
		
        // Crear el objeto consulta
        Query query = QueryFactory.create(sparqlQueryString1);
        QueryExecution qexec = QueryExecutionFactory.sparqlService("http://18.188.78.66:2020/sparql", query);

        ResultSet resultsd2r = qexec.execSelect();
		while (resultsd2r.hasNext()) {
			//DATOS BIBLIOTECAS D2R
            QuerySolution soln = resultsd2r.nextSolution();
            Literal nombreBiblioteca = soln.getLiteral("nombre");
            Literal ciudadBiblioteca = soln.getLiteral("municipio");
            Literal departamentoBiblioteca = soln.getLiteral("departamento");
            Literal naturalezaBiblioteca = soln.getLiteral("naturaleza");
            Literal direccionBiblioteca = soln.getLiteral("direccion");
            Literal georeferenciaBiblioteca = soln.getLiteral("georeferencia");
            System.out.println(nombreBiblioteca + " " + ciudadBiblioteca);
		}
	
	}

}
