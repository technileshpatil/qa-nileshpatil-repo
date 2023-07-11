@news-validation-bing
Scenario Outline: Confirm validity of the first news article from The Guardian
When I read the title of the first news article
And I search for similar information on "<SearchEngine>"
Then I should find at least similar articles on "<SearchEngine>"
And I consider the first Guardian news article to be valid
And I close the browser
Examples:
| SearchEngine |
| Bing         |

@news-validation-yahoo
Scenario Outline: Confirm validity of the first news article from The Guardian
When I read the title of the first news article
And I search for similar information on "<SearchEngine>"
Then I should find at least similar articles on "<SearchEngine>"
And I consider the first Guardian news article to be valid
And I close the browser
Examples:
| SearchEngine |
| Yahoo        |

@news-validation-missing-article
Scenario: Attempt to validate missing news article
When I read the title of the first news article
And I search for similar information on "Google"
Then I should find at least similar articles on "Google"
And I consider the first Guardian news article to be invalid
And I close the browser

@news-validation-invalid-search-engine
Scenario: Attempt to validate using an invalid search engine
When I read the title of the first news article
And I search for similar information on "InvalidSearchEngine"
Then I should receive an error message
And I close the browser

@news-validation-empty-search
Scenario: Attempt to validate with an empty search query
When I read the title of the first news article
And I search for similar information on "Google"
Then I should not find any similar articles
And I close the browser

@news-validation-invalid-search-engine
Scenario: Attempt to validate using an invalid search engine
When I read the title of the first news article
And I search for similar information on an unknown search engine
Then I should receive an error message
And I close the browser