package code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set; 
 
public class Triangle { 
	
	public static List<String> logs= new ArrayList<>();
    private double side1; 
    private double side2; 
    private double side3; 
 
    public Triangle(double side1, double side2, double side3) throws TriangleException { 
        this.side1 = side1; 
        this.side2 = side2; 
        this.side3 = side3; 
        add("Iniciado execu��o do m�todo: Triangle");
        if (allSidesAreZero() || hasImpossibleSides() || violatesTriangleInequality()) { 
            throw new TriangleException(); 
        }  
    } 
 
    public TriangleKind getKind() { 
    	add("Iniciado execu��o do m�todo: getKind");
        int uniqueSides = getNumberOfUniqueSides();
 
        if (uniqueSides == 1) { 
            return TriangleKind.EQUILATERAL; 
        } 
 
        if (uniqueSides == 2) { 
            return TriangleKind.ISOSCELES; 
        } 
 
        return TriangleKind.SCALENE; 
    } 
 
    private boolean allSidesAreZero() { 
    	add("Iniciado execu��o do m�todo: allSidesAreZero");
        return side1 == 0 && side2 == 0 && side3 == 0; 
    } 
 
    private boolean hasImpossibleSides() { 
    	add("Iniciado execu��o do m�todo: hasImpossibleSides");
        return side1 < 0 || side2 < 0 || side3 < 0; 
    } 
 
    private boolean violatesTriangleInequality() { 
    	add("Iniciado execu��o do m�todo: violatesTriangleInequality");
        return side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1; 
    } 
 
 
    public int getNumberOfUniqueSides() { 
        Set<Double> sides = new HashSet<>(); 
        add("Iniciado execu��o do m�todo: getNumberOfUniqueSides");
 
        sides.add(side1); 
        sides.add(side2); 
        sides.add(side3); 
        return sides.size(); 
    } 
    
    private void add(String s) {
    	if (!logs.contains(s))
    		logs.add(s);
    }
}