package stepdefinations;

import io.cucumber.java.en.And;

import static org.testng.Assert.assertFalse;

public class NegativeUseCaseExample extends MyAbstractsExampleNegativeUseCase{

    @And("I consider the first Guardian news article to be invalid")
    public void iConsiderTheFirstGuardianNewsArticleToBeInvalid() {
        assertFalse(isFirstArticleValid());
    }
    @Override
    public boolean isFirstArticleValid() {
        return false;
    }
}
