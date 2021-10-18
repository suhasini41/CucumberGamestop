Feature: Add To Cart
@search
Scenario: search a product
Given the homePage with title "Consoles, Collectibles, Video Games, and More – Buy, Sell or Trade | GameStop"
When I enter the product name "books"
And click search icon
Then I should be in the search results page with title "books | Search Results | GameStop"

Scenario Outline: Add specific products to the cart
Given the search list is displayed
When clicked on <product> 
And the product is added to cart
Then the product page title should contain <product>
Examples:
|product|
|"The Art of the Last of Us Part II by Naughty Dog"|
|"Atelier Sophie: The Alchemist of the Mysterious Book"|
|"Rainbow High Rainbow Fashion Year Book"|

@cart
Scenario: Verify number of items in cart
Given the cart icon is displayed
Then the number of items in the cart must be 3

