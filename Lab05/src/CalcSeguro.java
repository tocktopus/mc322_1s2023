/*
 * CalcSeguro.java
 * Ultima modificacao: 08/05/2023
 * Material usado na disciplina MC322
 */

public enum CalcSeguro {
    VALOR_BASE(100.0),
    FATOR_18_30(1.2),
    FATOR_30_60(1.0),
    FATOR_60_90(1.5);

    public final double fator;

    CalcSeguro(double fator){
        this.fator = fator;
    }

    public double getFator() {
        return fator;
    }
}
