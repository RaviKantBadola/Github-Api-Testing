Feature:  Api Testing for GitHub As a Project

    Scenario: CREATE A REPOSITORY FOR A AUTHENTICATED USER
        Given Make a post request with the resource '/user/repos'
        When Print the response in console
        Then Store Necessary data in the variable
        And The response status code should be '201'
        Then Check Wether the RepoName is stored in variable 'Team-star-catcherapirepo'

    Scenario: UPDATE A REPOSITORY
        Given Make a patch request with resource '/repos/RaviKantBadola/Team-star-catcherapirepo'
        When Print the response in console
        Then Store Necessary data in the variable
        And The response status code should be '200'
        Then Check the Updated RepoName 'Team-Gelexy'

    Scenario: GET A REPOSITORY
        Given Make a GET request with resource '/repos/RaviKantBadola/'
        When Print the response in console
        Then The response status code should be '200'

    Scenario: CREATE FILE CONTENT
        Given Make a PUT request with the resource '/repos/RaviKantBadola/Team-Gelexy/contents/README.md'
        Then Print the response in console
        Then Store Necessary data in the variable
        Then The response status code should be '201'
        And Check Wether the sha value is stored in variable

    Scenario: CREATE A FORK
        Given Make a POST request with the resource '/repos/RaviKantBadola/Team-Gelexy/forks'
        Then Print the response in console
        And The response status code should be '202'

    Scenario: LIST FORKS
        Given Make a GET request For FORKS with the resource '/repos/RaviKantBadola/Team-Gelexy/forks'
        Then Print the response in console
        And The response status code should be '200'

    Scenario:  LIST REPOSITORIES FOR A USER
        Given Make a GET request For LIST OF REPOSITORY with the resource '/users/RaviKantBadola/repos'
        Then Print the response in console
        And The response status code should be '200'

    Scenario: LIST REPOSITORY LANGUAGE
        Given Make a GET request for repositories languages with the resource '/repos/RaviKantBadola/Team-Gelexy/languages'
        Then Print the response in console
        And The response status code should be '200'

    Scenario: LIST PUBLIC REPOSITORIES
        Given Make a GET request for public repositories with the resource '/repositories'
        Then Print the response in console
        And The response status code should be '200'


    Scenario: CREATE A RELEASE
        Given Make a POST request to create a release with the resource '/repos/RaviKantBadola/Team-Gelexy/releases'
        Then Print the response in console
        And The response status code should be '201'

    Scenario: LIST REPOSITORY TAGS
        Given Make a GET request for repositories tags with the resource '/repos/RaviKantBadola/Team-Gelexy/tags'
        Then Print the response in console
        And The response status code should be '200'

    Scenario: CREATE AN AUTOLINK REFERENCE FOR A REPOSITORY
        Given Make a POST request For autolink with the resource '/repos/RaviKantBadola/Team-Gelexy/autolinks'
        Then Print the response in console
        Then Store Necessary data in the variable
        Then The response status code should be '201'

    Scenario: REPLACE ALL REPOSITORY TOPICS
        Given Make a PUT request for repositories topics with the resource '/repos/RaviKantBadola/Team-Gelexy/topics'
        Then Print the response in console
        And The response status code should be '200'

    Scenario: GET ALL REPOSITORY TOPICS
        Given Make a GET request for repositories topics with the resource '/repos/RaviKantBadola/Team-Gelexy/topics'
        Then Print the response in console
        And The response status code should be '200'

    Scenario: GET AN AUTOLINK REFERENCE FOR A REPOSITORY
        Given Make a GET request for repositories autolink with the resource '/repos/RaviKantBadola/Team-Gelexy/autolinks/'
        Then Print the response in console
        And The response status code should be '200'

    Scenario: DELETE FROM AN AUTOLINK REFERENCE FOR A REPOSITORY
        Given Make a Delete request to delete autolink with the resource '/repos/RaviKantBadola/Team-Gelexy/autolinks/'
        Then The Delete response status code should be '204'


    Scenario: DELETE A FORK
        Given Make a Delete request with the resource '/repos/Team-Star-Catcher/New-Fork'
        Then Print the response in console
        And The response status code should be '204'

    Scenario: DELETE A FILE
        Given Make a Delete file request with the resource '/repos/RaviKantBadola/Team-Gelexy/contents/README.md'
        And The response status code should be '200'

    Scenario: GET A REPOSITORY
        Given Make a GET request  with the resource '/repos/RaviKantBadola/Team-Gelexy'
        When Print the response in console
        Then The response status code should be '200'


    Scenario: DELETE A REPOSITORY
        Given Make a Delete request with the resource '/repos/RaviKantBadola/Team-star-catcherapirepo'
        Then The Delete response status code should be '204'

