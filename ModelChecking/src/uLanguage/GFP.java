package uLanguage;

import java.util.List;
import uLanguage.uOperator.uOperations;

/**
 *
 * @author ruudandriessen
 */
public class GFP extends uFormula {
    public Variable variable;
    public uFormula formula;
    
    public GFP(Variable variable, uFormula formula) {
        this.variable = variable;
        this.formula = formula;
        this.operator = uOperator.uOperations.GFP;
        
        this.addChild(variable);
        this.addChild(formula);
    }
    
    @Override
    public String toString() {
        return "nu " + variable + "." + formula;
    }
    
    @Override
    public int getNestingDepth() {
        return formula.getNestingDepth() + 1;
    }

    @Override
    public int getAlternationDepth() {
        int max = -1;
        for (uFormula f : this.getChildrenFormulas(uOperations.LFP)) {
            int ad = f.getAlternationDepth();
            if (ad > max) {
                max = ad;
            }
        }
        return 1 + max;
    }

    @Override
    public int getDependentAlternationDepth() {
        int subFormMax = -1;
        for (uFormula f : this.getChildrenFormulas(uOperations.LFP)) {
            List<uFormula> variables = f.getChildrenFormulas(uOperations.VARIABLE);
            
            if (variables.contains(this.variable)) {
                subFormMax = Math.max(subFormMax, f.getDependentAlternationDepth());
            }
        }
        return Math.max(formula.getDependentAlternationDepth(), 1 + subFormMax);
    }
}
