Feature:  Api Testing for GitHub As a Project

    Scenario: Create a repository for the authenticated user
        Given Make a post request with the resource1 '/user/repos'
        When Print the response in console2
        Then Store Necessary data in the variable3
        And The response status code should be4 201
        Then Check Wether the RepoName is stored in variable5 'Team-star-catcherapirepo'

    Scenario: Update a Repository
        Given Make a patch request with resource6 '/repos/RaviKantBadola/Team-star-catcherapirepo'
        When Print the response in console for update7
        Then Store Necessary data in the variable for update8
        And The response status code should be9 200 
        Then Check the Updated RepoName10 'Team-sananana'

    Scenario: Get a Repository
        Given Make a GET request with resource11 '/repos/RaviKantBadola/'
        When Print the response in console12
        Then The response status code should be13 200

    Scenario: Create file contents
        Given Make a PUT request with the resource14 '/repos/RaviKantBadola/Team-sananana/contents/README.md'
        Then Print the response in console15
        Then Store Necessary data in the variable16
        Then The response status code should be17 201
        And Check Wether the sha value is stored in variable18

    Scenario: CREATE A FORK
        Given Make a POST request with the resource19 '/repos/RaviKantBadola/Team-sananana/forks'
        Then Print the response in console20
        And The response status code should be21 202

    Scenario: LIST FORKS
        Given Make a GET request For FORKS with the resource22 '/repos/RaviKantBadola/Team-sananana/forks'
        Then Print the response in console23
        And The response status code should be24 200

    Scenario:  GET A LIST Of REPOSITORY
        Given Make a GET request For LIST OF REPOSITORY with the resource25 '/users/RaviKantBadola/repos'
        Then Print the response in console26
        And The response status code should be27 200

    Scenario: List repository languages
        Given Make a GET request for repositories languages with the resource28 '/repos/RaviKantBadola/Team-sananana/languages'
        Then Print the response in console29
        And The response status code should be30 200

    Scenario: List public repositories
        Given Make a GET request for public repositories with the resource31 '/repositories'
        Then Print the response in console32
        And The response status code should be33 200


    Scenario: Create a release
        Given Make a POST request to create a release with the resource34 '/repos/RaviKantBadola/Team-sananana/releases'
        Then Print the response in console35
        And The response status code should be36 201

    Scenario: List repository tags
        Given Make a GET request for repositories tags with the resource38 '/repos/RaviKantBadola/Team-sananana/tags'
        Then Print the response in console39
        And The response status code should be40 200

    Scenario: Create an autolink reference for a repository41
        Given Make a POST request For autolink with the resource42 '/repos/RaviKantBadola/Team-sananana/autolinks'
        Then Print the response in console43
        Then Store Necessary data in the variable44
        Then The response status code should be45 201

    Scenario: Replace all repository topics
        Given Make a PUT request for repositories topics with the resource46 '/repos/RaviKantBadola/Team-sananana/topics'
        Then Print the response in console47
        And The response status code should be48 200

    Scenario: Get all repository topics
        Given Make a GET request for repositories topics with the resource49 '/repos/RaviKantBadola/Team-sananana/topics'
        Then Print the response in console50
        And The response status code should be60 200

    Scenario: Get an autolink reference of a repository61
        Given Make a GET request for repositories autolink with the resource62 '/repos/RaviKantBadola/Team-sananana/autolinks/'
        Then Print the response in console63
        And The response status code should be64 200

    Scenario: Delete an autolink reference from a repository65
        Given Make a Delete request to delete autolink with the resource66 '/repos/RaviKantBadola/Team-sananana/autolinks/'
        Then The Delete response status code should be67 204


    Scenario: Delete a FORK
        Given Make a Delete request with the resource68 '/repos/Team-Star-Catcher/New-Fork'
        Then Print the response in console69
        And The response status code should be70 204

    Scenario: Delete a file
        Given Make a Delete file request with the resource71 '/repos/RaviKantBadola/Team-sananana/contents/README.md'
        And The response status code should be72 200

    Scenario: Delete a repository
        Given Make a Delete request with the resource73 '/repos/RaviKantBadola/Team-sananana'
        Then The Delete response status code should be74 204

