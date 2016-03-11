package uLanguage;

/**
 *
 * @author ruudandriessen
 */
public class Conjunction extends uFormula {
    public uFormula leftFormula, rightFormula;
    
    public Conjunction(uFormula leftFormula, uFormula rightFormula) {
        this.leftFormula = leftFormula;
        this.rightFormula = rightFormula;
        this.operator = uOperator.uOperations.AND;
    }    
    
    @Override
    public String toString() {
        return "(" + leftFormula + " && " + rightFormula + ")";
    }
}