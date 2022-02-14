@regression
Feature: Checkout of board features

  Background:
    Given user has authorization and is located on the Mian Page

  Scenario Outline: checking the new board creating and increasing of the count of page by 1 after clicking Create new Board button for any types
    When click on the point of menu "Доски" get start count of existing boards
    Then click the Create new Board button
    Then fill in the fields: board name=<boardName>, type of board background=<boardViewType>, color of board background=<color>
    And click Create new Board button
    Then open Board page and check the name of board=<boardName>
    And return to Main page and check that the count of pages is changed by 1

    Examples:
      | boardName           | boardViewType | color        |
      | MyBoardWithPictures | pictures      | "0"          |
      | MyBlueBoard         | TestFirstName | "Синий"      |
      | MyOrangeBoard       | color         | "Оранжевый"  |
      | MyGreenBoard        | color         | "Зелёный"    |
      | MyRedBoard          | color         | "Красный"    |
      | MyVioletBoard       | color         | "Фиолетовый" |
      | MyColoredBoard      | color         | "0"          |


  Scenario Outline: checking the board deleting and decreasing of the count of page by 1 after clicking Create new Board button for any types
    When click on the point of menu "Доски" get start count of existing boards
    Then click on the board=<boardName> and move into it
    And click step-by-step Menu, more, close and confirm buttons
    And return to Main page and check that the count of pages is changed by -1

    Examples:
      | boardName           |
      | MyBoardWithPictures |
      | MyBlueBoard         |
      | MyOrangeBoard       |
      | MyGreenBoard        |
      | MyRedBoard          |
      | MyVioletBoard       |
      | MyColoredBoard      |
