Feature:
  I want to be able to integration test Spring endpoints

  Scenario Outline:
    Given I have a Rest Spring <Endpoint>
    When I call the <roomEndpoint> by name for rooms
    Then <roomName> is the result from the server

    Examples:
    |Endpoint|roomEndpoint|roomName|
    |"http://localhost:8080"|"/room?name=Cliffhanger"|"Cliffhanger"|


  Scenario Outline:
    Given I have a Rest Spring Endpoint <Endpoint>
    When I call the <cheapEndpoint> for the cheapest room
    Then <cheapRoom> is the cheapest from the server
    When I call the <expEndpoint> for the most expensive room
    Then <expRoom> is the most expensive from the server


    Examples:
      |Endpoint               |cheapEndpoint  |cheapRoom    |expEndpoint         |expRoom      |
      |"http://localhost:8080"|"/cheapestRoom"|"Cliffhanger"|"/mostExpensiveRoom"|"Deluxe"|


  Scenario Outline:
    Given I have this Rest Spring Endpoint <Endpoint>
    When I call the <createEndpoint> with  <roomName> and <rate> a new room is created
    Then I call the <testCreateEndpoint> to test the recently added room

    Examples:
      | Endpoint | createEndpoint | roomName | rate | testCreateEndpoint |
      |"http://localhost:8080"|"/createRoom"|"Casa"|550.0|"/newestRoom"|
