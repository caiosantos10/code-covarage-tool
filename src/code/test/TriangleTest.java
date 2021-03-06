package code.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import code.Triangle;
import code.TriangleException;
import code.TriangleKind;

public class TriangleTest { 
	public List<String> logs= Arrays.asList(
			"Iniciado execu��o do m�todo: Triangle",
			"Iniciado execu��o do m�todo: getKind",
			"Iniciado execu��o do m�todo: allSidesAreZero",
			"Iniciado execu��o do m�todo: hasImpossibleSides",
			"Iniciado execu��o do m�todo: violatesTriangleInequality",
			"Iniciado execu��o do m�todo: getNumberOfUniqueSides"); 
	
		
		 
    @Test 
    public void equilateralTriangleHaveEqualSides() throws Exception { 
        Triangle triangle = new Triangle(2, 2, 2); 
        assertEquals(TriangleKind.EQUILATERAL, triangle.getKind());
        
    } 
 
    @Test 
    public void largerEquilateralTrianglesAlsoHaveEqualSides() throws Exception { 
        Triangle triangle = new Triangle(10, 10, 10); 
 
        assertEquals(TriangleKind.EQUILATERAL, triangle.getKind()); 
    } 
 
    @Test 
    public void isoscelesTrianglesHaveLastTwoSidesEqual() throws Exception { 
        Triangle triangle = new Triangle(3, 4, 4); 
 
        assertEquals(TriangleKind.ISOSCELES, triangle.getKind()); 
    } 
 
    @Test 
    public void isoscelesTrianglesHaveFirstAndLastSidesEqual() throws Exception { 
        Triangle triangle = new Triangle(4, 3, 4); 
 
        assertEquals(TriangleKind.ISOSCELES, triangle.getKind()); 
    } 
 
    @Test 
    public void isoscelesTrianglesHaveTwoFirstSidesEqual() throws Exception { 
        Triangle triangle = new Triangle(4, 4, 3); 
 
        assertEquals(TriangleKind.ISOSCELES, triangle.getKind()); 
    } 
 
    @Test 
    public void isoscelesTrianglesHaveInFactExactlyTwoSidesEqual() throws Exception { 
        Triangle triangle = new Triangle(10, 10, 2); 
 
        assertEquals(TriangleKind.ISOSCELES, triangle.getKind()); 
    } 
 
    @Test 
    public void scaleneTrianglesHaveNoEqualSides() throws Exception { 
        Triangle triangle = new Triangle(3, 4, 5); 
 
        assertEquals(TriangleKind.SCALENE, triangle.getKind()); 
    } 
 
    @Test 
    public void scaleneTrianglesHaveNoEqualSidesAtLargerScaleEither() throws Exception { 
        Triangle triangle = new Triangle(10, 11, 12); 
 
        assertEquals(TriangleKind.SCALENE, triangle.getKind()); 
    } 
 
    @Test 
    public void scaleneTrianglesHaveNoEqualSidesInDescendingOrderEither() throws Exception { 
        Triangle triangle = new Triangle(5, 4, 2); 
 
        assertEquals(TriangleKind.SCALENE, triangle.getKind()); 
    } 
 
    @Test 
    public void verySmallTrianglesAreLegal() throws Exception { 
        Triangle triangle = new Triangle(0.4, 0.6, 0.3); 
 
        assertEquals(TriangleKind.SCALENE, triangle.getKind()); 
    } 
    
    @Test 
    public void trianglesWithNoSizeAreIllegal() { 
    	 Assertions.assertThrows(TriangleException.class, () -> new Triangle(0, 0, 0)); 
    } 
 
    @Test 
    public void trianglesWithNegativeSidesAreIllegal() throws Exception { 
    	Assertions.assertThrows(TriangleException.class, () -> new Triangle(3, 4, -5));
    } 
 
    @Test 
    public void trianglesViolatingTriangleInequalityAreIllegal() throws Exception {
    	Assertions.assertThrows(TriangleException.class, () -> new Triangle(1, 1, 3));
    } 
 
    @Test 
    public void trianglesViolatingTriangleInequalityAreIllegal2() { 
    	Assertions.assertThrows(TriangleException.class, () -> new Triangle(2, 4, 2));
    } 
 
    @Test 
    public void trianglesViolatingTriangleInequalityAreIllegal3() { 
    	Assertions.assertThrows(TriangleException.class, () -> new Triangle(7, 3, 2));
    	
    	
    	double realidade = Triangle.logs.size();
        double espectativa = this.logs.size();
        double cobertura = (realidade*100)/espectativa;
        System.out.println("------------------------------------------------------");
        System.out.println("|                                                    |");
        System.out.println("---------COBERTURA DE CODIGO = "+cobertura+"%---------");
        System.out.println("|                                                    |");
        System.out.println("------------------------------------------------------");
        
    	
    } 
    
    
 
    
    
}