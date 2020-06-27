package br.com.mastertech.nfe.helpers;


import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;

public class ValidaIdentidadeHelper {
    private static final CPFValidator cpfValidator = new CPFValidator();
    private static final CNPJValidator cnpjValidator = new CNPJValidator();

    public static boolean isValid(String identidade) {
        return cpfValidator.isEligible(identidade) || cnpjValidator.isEligible(identidade);
    }
}
