package coverage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
 
import org.eclipse.jdt.core.dom.*;
 
public class Main {
 
	//use ASTParse to parse string
	public static void parse(String str, String fileName) {
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(str.toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
 
		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
		
 
		cu.accept(new ASTVisitor() {
			
			Set varNames = new HashSet();
			Set methodNames = new HashSet();
			
//			public boolean visit(MethodInvocation node) {
//				SimpleName name = node.getName();
//				
//				System.out.println("Invocação do método " + name
//						+ "' na linha "+ cu.getLineNumber(name.getStartPosition()));
//				return false;
//			}
			
			@SuppressWarnings("unchecked")
		    public boolean visit(MethodDeclaration node) {
				
				SimpleName name = node.getName();
				this.methodNames.add(name.getIdentifier());
//				System.out.println("Declaração do método '" + name + "' na linha "
//						+ cu.getLineNumber(name.getStartPosition()));
		        AST ast = node.getAST();
		        MethodInvocation methodInvocation = ast.newMethodInvocation();
		       
		        // System.out.println("")
		        QualifiedName qName =
		                   ast.newQualifiedName(
		                            ast.newSimpleName("System"),
		                            ast.newSimpleName("out"));
		        
		        methodInvocation.setExpression(qName);
		        methodInvocation.setName(ast.newSimpleName("println"));
		        
		        StringLiteral literalStart = ast.newStringLiteral();
		        literalStart.setLiteralValue("Iniciado execução do método: " + name);    
		        methodInvocation.arguments().add(0,literalStart);
		        
		       
		        // Append the statement
		        node.getBody().statements().add(0, ast.newExpressionStatement(methodInvocation));
		        	
		        return super.visit(node);
		    }

 
//			public boolean visit(VariableDeclarationFragment node) {
//				
//				SimpleName name = node.getName();
//				this.varNames.add(name.getIdentifier());
//				return false; // do not continue 
//			}
// 
//			public boolean visit(SimpleName node) {
//				
//				if (this.varNames.contains(node.getIdentifier())) {
//					System.out.println("Uso da variável '" + node + "' na linha "
//							+ cu.getLineNumber(node.getStartPosition()));
//				}
//				return true;
//			}	
		});
		
		File dirs = new File(".");
		String dirPath = null;
		try {
			dirPath = dirs.getCanonicalPath() + File.separator+"src/target"+File.separator+fileName+File.separator;
			toFile(cu.toString(),dirPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
 
	//read file content into a string
	public static String readFileToString(String filePath) throws IOException {
		StringBuilder fileData = new StringBuilder(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
 
		char[] buf = new char[10];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}
 
		reader.close();
 
		return  fileData.toString();	
	}
 
	//loop directory to get file list
	public static void ParseFilesInDir() throws IOException{
		File dirs = new File(".");
		String dirPath = dirs.getCanonicalPath() + File.separator+"src/code"+File.separator;
 
		File root = new File(dirPath);
		File[] files = root.listFiles ( );
		String filePath = null;
 
		 for (File f : files ) {
			 filePath = f.getAbsolutePath();
			 if(f.isFile()){
				 parse(readFileToString(filePath),f.getName());
			 }
		 }
	}
 
	public static void toFile(String source, String outputPath)
	{
	   try{
	          // Create file 
	          FileWriter fstream = new FileWriter(outputPath);
	          BufferedWriter out = new BufferedWriter(fstream);
	          out.write(source);
	          //Close the output stream
	          out.close();
	    }catch (Exception e){//Catch exception if any
	          System.err.println("Error: " + e.getMessage());
	    }
	}
	
	public static void main(String[] args) throws IOException {
		ParseFilesInDir();
	}
}	
