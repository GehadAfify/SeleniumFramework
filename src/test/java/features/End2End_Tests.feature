@end2end
Feature: Automated End2End Tests
  The Purpose Of This Feature Is To Test End 2 End Integration Test
  
 Scenario Outline : customer make order and purchasing product from search
	 Given user is in home page
	 When he search for "<productName>"
	 And choose to buy two item
	 And moves to checkout cart and enter personal details on checkout page and place the order
	 Then he can view the order and download the invoice
 
Examples:
|productName|
|Apple MacBook Pro 13-inch|