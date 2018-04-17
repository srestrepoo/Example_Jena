package ejemplosARQ;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.util.FileManager;

public class EjemploARQ_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Carga la ontología de data.ttl y la imprime
        FileManager.get().addLocatorClassLoader(EjemploARQ_01.class.getClassLoader());
        Model model = FileManager.get().loadModel("src/owl/data.ttl");
        System.out.println("Input data:");
        model.write(System.out, "TURTLE");
        
        //Lee la lista de archivos de consulta que 
        //inicien con "construct-" y finalicen con ".sparql"
        File path = new File("src/owl/queries");
        File[] files = path.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.startsWith("construct-") && name.endsWith(".sparql");
			}
		});
        Arrays.sort(files);

        //Se ejecuta cada uno de los archivos de consulta previamente identificados
        for (File file : files) {
        	System.out.println("Executing " + file.getName() + " ...");
        	Query query = QueryFactory.read(file.getAbsolutePath());
            QueryExecution qexec = QueryExecutionFactory.create(query, model);
            try {
                Model result = qexec.execConstruct();
                model.add(result);
            } finally {
                qexec.close();
            }
		}
        
        //Se imprime el resultado
        System.out.println("Output data:");
        model.write(System.out, "TURTLE");
	}

}
