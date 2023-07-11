Feature: News Validation from The Guardian

  Background:
    Given I am on The Guardian news website

  @news-validation-google
  Scenario Outline: Confirm validity of the first news article from The Guardian
    When I read the title of the first news article
    And I search for similar information on "<SearchEngine>"
    Then I should find at least similar articles on "<SearchEngine>"
    And I consider the first Guardian news article to be valid
    And I close the browser
    Examples:
      | SearchEngine |
      | Google       |