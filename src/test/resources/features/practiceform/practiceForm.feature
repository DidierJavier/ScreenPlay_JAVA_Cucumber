
Feature: Automation testing using Screenplay pattern
    As an automation tester
    I need to practice automation testing using Screenplay pattern
    for learn about Serenity BDD framework

    Scenario Outline: Fill a student registration form using mandatory fields
        Given the student is on landing page of Tools QA
        When him browse to registration form
        And him has filled it and submitted
        |firstName|<firstName>|
        |lastName|<lastName>|
        |gender|<gender>|
        |mobile|<mobile>|
        Then the student will see a registration information
        Examples:
            |firstName|lastName|gender|mobile|
            |Ivan     |Arroyave|Male  |1234567890|
            |Isabelle |Ramirez |Female|1234567890|