import {
  before,
  Given,
  When,
  And,
  Then,
} from "cypress-cucumber-preprocessor/steps";
var token = "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";
var baseUrl = `https://api.github.com`;
Given("Make a post request with the resource '{word}'", (Resource) => {
  cy.request({
    method: "POST",
    url: baseUrl + Resource,
    headers: {
      Authorization: `Bearer ${token}`,
    },
    header: "application/json",
    body: {
      name: "Team-star-catcherapirepo",
      description: "This is your first repo!",
    },
  }).then((response) => {
    Cypress.env("StatusCode", response.status);
    let body = JSON.parse(JSON.stringify(response.body));
    Cypress.env("MyResponse", JSON.stringify(body));
  });
});
When("Print the response in console", () => {
  cy.log(Cypress.env("MyResponse"));
});
Then("Store Necessary data in the variable", () => {
  Cypress.env("RepoName", JSON.parse(Cypress.env("MyResponse")).name);
});
And("The response status code should be '{word}'", (StatusCode) => {
  const sta = +Cypress.env("StatusCode");
  expect(sta).to.eql(+StatusCode);
});
Then("Check Wether the RepoName is stored in variable '{word}'", (Repo) => {
  expect(Cypress.env("RepoName")).to.eql(Repo);
});

//Make a patch request with resource '/repos/RaviKantBadola/Team-star-catcherapirepo'
Given("Make a patch request with resource '{word}'", (Resource) => {
  cy.request({
    method: "PATCH",
    url: baseUrl + Resource,
    headers: {
      Authorization: `Bearer ${token}`,
    },
    header: "application/json",
    body: {
      name: "Team-Gelexy",
    },
  }).then((response) => {
    Cypress.env("StatusCode", response.status);
    let body = JSON.parse(JSON.stringify(response.body));
    Cypress.env("MyResponse", JSON.stringify(body));
  });
});
When("Print the response in console", () => {
  cy.log(Cypress.env("MyResponse"));
});
Then("Store Necessary data in the variable", () => {
  Cypress.env("RepoName", JSON.parse(Cypress.env("MyResponse")).name);
});
And("The response status code should be '{word}'", (StatusCode) => {
  const sta = +Cypress.env("StatusCode");
  expect(sta).to.eql(+StatusCode);
});
Then("Check the Updated RepoName '{word}'", (Repo) => {
  expect(Cypress.env("RepoName")).to.eql(Repo);
  cy.log(Repo);
});

//Make a get request with resource '/repos/RaviKantBadola/Team-sananana'
Given("Make a GET request with resource '{word}'", (Resource) => {
  cy.request({
    method: "GET",
    url: baseUrl + Resource + Cypress.env("RepoName"),
    headers: {
      Authorization: `Bearer ${token}`,
    },
    header: "application/json",
  }).then((response) => {
    Cypress.env("StatusCode", response.status);
    let body = JSON.parse(JSON.stringify(response.body));
    Cypress.env("MyResponse", JSON.stringify(body));
  });
});
Then("Print the response in console", () => {
  cy.log(Cypress.env("MyResponse"));
});
Then("The response status code should be '{word}'", (StatusCode) => {
  const sta = +Cypress.env("StatusCode");
  expect(sta).to.eql(+StatusCode);
});

// Make a PUT request with the resource '/repos/RaviKantBadola/Team-sananana/contents/README.md'
Given("Make a PUT request with the resource '{word}'", (Resource) => {
  cy.request({
    method: "PUT",
    url: baseUrl + Resource,
    headers: {
      Authorization: `Bearer ${token}`,
    },
    header: "application/json",
    body: {
      message: "File Successfully Created",
      content: "SGVsbG8gV29ybGQ=",
    },
  }).then((response) => {
    Cypress.env("StatusCode", response.status);
    let body = JSON.parse(JSON.stringify(response.body));
    Cypress.env("MyResponse", JSON.stringify(body));
    Cypress.env("ShaValue", JSON.parse(JSON.stringify(body)).content.sha);
  });
});
Then("Print the response in console", () => {
  cy.log(Cypress.env("MyResponse"));
});
Then("Store Necessary data in the variable", () => {
  cy.log(Cypress.env("ShaValue"));
});
Then("The response status code should be '{word}'", (StatusCode) => {
  const sta = +Cypress.env("StatusCode");
  expect(sta).to.eql(+StatusCode);
});
Then("Check Wether the sha value is stored in variable", () => {
  Cypress.env("ShaValue");
});
//Create a fork
Given("Make a POST request with the resource '{word}'", (Resource) => {
  cy.request({
    method: "POST",
    url: baseUrl + Resource,
    headers: {
      Authorization: `Bearer ${token}`,
    },
    header: "application/json",
    body: {
      organization: " Team-Star-Catcher",
      name: "New-Fork",
    },
  }).then((response) => {
    Cypress.env("StatusCode", response.status);
    let body = JSON.parse(JSON.stringify(response.body));
    Cypress.env("MyResponse", JSON.stringify(body));
  });
});
Then("Print the response in console", () => {
  cy.log(Cypress.env("MyResponse"));
});
Then("The response status code should be '{word}'", (StatusCode) => {
  const sta = +Cypress.env("StatusCode");
  expect(sta).to.eql(+StatusCode);
});
//List Forks
Given("Make a GET request For FORKS with the resource '{word}'", (Resource) => {
  cy.request({
    method: "GET",
    url: baseUrl + Resource,
    headers: {
      Authorization: `Bearer ${token}`,
    },
    header: "application/json",
  }).then((response) => {
    Cypress.env("StatusCode", response.status);
    let body = JSON.parse(JSON.stringify(response.body));
    Cypress.env("MyResponse", JSON.stringify(body));
  });
});
Then("Print the response in console", () => {
  cy.log(Cypress.env("MyResponse"));
});
Then("The response status code should be '{word}'", (StatusCode) => {
  const sta = +Cypress.env("StatusCode");
  expect(sta).to.eql(+StatusCode);
});

//list of repository
Given(
  "Make a GET request For LIST OF REPOSITORY with the resource '{word}'",
  (Resource) => {
    cy.request({
      method: "GET",
      url: baseUrl + Resource,
      headers: {
        Authorization: `Bearer ${token}`,
      },
      header: "application/json",
    }).then((response) => {
      Cypress.env("StatusCode", response.status);
      let body = JSON.parse(JSON.stringify(response.body));
      Cypress.env("MyResponse", JSON.stringify(body));
    });
  }
);
Then("Print the response in console", () => {
  cy.log(Cypress.env("MyResponse"));
});
Then("The response status code should be '{word}'", (StatusCode) => {
  const sta = +Cypress.env("StatusCode");
  expect(sta).to.eql(+StatusCode);
});

//list repository languages
Given(
  "Make a GET request for repositories languages with the resource '{word}'",
  (Resource) => {
    cy.request({
      method: "GET",
      url: baseUrl + Resource,
      headers: {
        Authorization: `Bearer ${token}`,
      },
      header: "application/json",
    }).then((response) => {
      Cypress.env("StatusCode", response.status);
      let body = JSON.parse(JSON.stringify(response.body));
      Cypress.env("MyResponse", JSON.stringify(body));
    });
  }
);
Then("Print the response in console", () => {
  cy.log(Cypress.env("MyResponse"));
});
Then("The response status code should be '{word}'", (StatusCode) => {
  const sta = +Cypress.env("StatusCode");
  expect(sta).to.eql(+StatusCode);
});

//list public repositories
Given(
  "Make a GET request for public repositories with the resource '{word}'",
  (Resource) => {
    cy.request({
      method: "GET",
      url: baseUrl + Resource,
      headers: {
        Authorization: `Bearer ${token}`,
      },
      header: "application/json",
    }).then((response) => {
      Cypress.env("StatusCode", response.status);
      let body = JSON.parse(JSON.stringify(response.body));
      Cypress.env("MyResponse", JSON.stringify(body));
    });
  }
);
Then("Print the response in console", () => {
  cy.log(Cypress.env("MyResponse"));
});
Then("The response status code should be '{word}'", (StatusCode) => {
  const sta = +Cypress.env("StatusCode");
  expect(sta).to.eql(+StatusCode);
});
//create a release
Given(
  "Make a POST request to create a release with the resource '{word}'",
  (Resource) => {
    cy.request({
      method: "POST",
      url: baseUrl + Resource,
      headers: {
        Authorization: `Bearer ${token}`,
      },
      header: "application/json",
      body: {
        tag_name: "GitHun1258",
      },
    }).then((response) => {
      Cypress.env("StatusCode", response.status);
      let body = JSON.parse(JSON.stringify(response.body));
      Cypress.env("MyResponse", JSON.stringify(body));
    });
  }
);
Then("Print the response in console", () => {
  cy.log(Cypress.env("MyResponse"));
});
Then("The response status code should be '{word}'", (StatusCode) => {
  const sta = +Cypress.env("StatusCode");
  expect(sta).to.eql(+StatusCode);
});

//list repository tags
Given(
  "Make a GET request for repositories tags with the resource '{word}'",
  (Resource) => {
    cy.request({
      method: "GET",
      url: baseUrl + Resource,
      headers: {
        Authorization: `Bearer ${token}`,
      },
      header: "application/json",
    }).then((response) => {
      Cypress.env("StatusCode", response.status);
      let body = JSON.parse(JSON.stringify(response.body));
      Cypress.env("MyResponse", JSON.stringify(body));
    });
  }
);
Then("Print the response in console", () => {
  cy.log(Cypress.env("MyResponse"));
});
Then("The response status code should be '{word}'", (StatusCode) => {
  const sta = +Cypress.env("StatusCode");
  expect(sta).to.eql(+StatusCode);
});

//create an autolink reference for a repository
Given(
  "Make a POST request For autolink with the resource '{word}'",
  (Resource) => {
    cy.request({
      method: "POST",
      url: baseUrl + Resource,
      headers: {
        Authorization: `Bearer ${token}`,
      },
      header: "application/json",
      body: {
        key_prefix: "Github-Api-Testing",
        url_template: "https://example.com/Api?query=<num>",
      },
    }).then((response) => {
      Cypress.env("StatusCode", response.status);
      let body = response.body;
      Cypress.env("MyResponse", JSON.stringify(body));
      Cypress.env("autolink_id", JSON.parse(JSON.stringify(body)).id);
    });
  }
);
Then("Print the response in console", () => {
  cy.log(Cypress.env("MyResponse"));
});
Then("Store Necessary data in the variable", () => {
  cy.log(Cypress.env("autolink_id"));
});
Then("The response status code should be '{word}'", (StatusCode) => {
  const sta = +Cypress.env("StatusCode");
  expect(sta).to.eql(+StatusCode);
});
//replace all repository topic
Given(
  "Make a PUT request for repositories topics with the resource '{word}'",
  (Resource) => {
    cy.request({
      method: "PUT",
      url: baseUrl + Resource,
      headers: {
        Authorization: `Bearer ${token}`,
      },
      header: "application/json",
      body: {
        names: ["github", "github-api", "github-api-testing"],
      },
    }).then((response) => {
      Cypress.env("StatusCode", response.status);
      let body = JSON.parse(JSON.stringify(response.body));
      Cypress.env("MyResponse", JSON.stringify(body));
    });
  }
);
Then("Print the response in console", () => {
  cy.log(Cypress.env("MyResponse"));
});
Then("The response status code should be '{word}'", (StatusCode) => {
  const sta = +Cypress.env("StatusCode");
  expect(sta).to.eql(+StatusCode);
});

//get all repository topices
Given(
  "Make a GET request for repositories topics with the resource '{word}'",
  (Resource) => {
    cy.request({
      method: "GET",
      url: baseUrl + Resource,
      headers: {
        Authorization: `Bearer ${token}`,
      },
      header: "application/json",
    }).then((response) => {
      Cypress.env("StatusCode", response.status);
      let body = JSON.parse(JSON.stringify(response.body));
      Cypress.env("MyResponse", JSON.stringify(body));
    });
  }
);
Then("Print the response in console", () => {
  cy.log(Cypress.env("MyResponse"));
});
Then("The response status code should be '{word}'", (StatusCode) => {
  const sta = +Cypress.env("StatusCode");
  expect(sta).to.eql(+StatusCode);
});
//get autolink
Given(
  "Make a GET request for repositories autolink with the resource '{word}'",
  (Resource) => {
    cy.request({
      method: "GET",
      url: baseUrl + Resource + Cypress.env("autolink_id"),
      headers: {
        Authorization: `Bearer ${token}`,
      },
      header: "application/json",
    }).then((response) => {
      Cypress.env("StatusCode", response.status);
      let body = JSON.parse(JSON.stringify(response.body));
      Cypress.env("MyResponse", JSON.stringify(body));
    });
  }
);
Then("Print the response in console", () => {
  cy.log(Cypress.env("MyResponse"));
});
Then("The response status code should be '{word}'", (StatusCode) => {
  const sta = +Cypress.env("StatusCode");
  expect(sta).to.eql(+StatusCode);
});

//delete auto link
Given(
  "Make a Delete request to delete autolink with the resource '{word}'",
  (Resource) => {
    cy.request({
      method: "DELETE",
      url: baseUrl + Resource + Cypress.env("autolink_id"),
      headers: {
        Authorization: `Bearer ${token}`,
      },
    }).then((response) => {
      Cypress.env("StatusCode", response.status);
    });
  }
);
Then("The Delete response status code should be '{word}'", (StatusCode) => {
  const sta = Cypress.env("StatusCode");
  expect(sta).to.eql(+StatusCode);
});
// Delete a FORK
Given("Make a Delete request with the resource '{word}'", (Resource) => {
  cy.wait(5000);
  cy.request({
    method: "DELETE",
    url: baseUrl + Resource,
    headers: {
      Authorization: `Bearer ${token}`,
    },
  }).then((response) => {
    Cypress.env("StatusCode", response.status);
  });
});
Then("The Delete response status code should be '{word}'", (StatusCode) => {
  const sta = Cypress.env("StatusCode");
  expect(sta).to.eql(+StatusCode);
});
//  Delete a file
Given("Make a Delete file request with the resource '{word}'", (Resource) => {
  cy.request({
    method: "DELETE",
    url: baseUrl + Resource,
    headers: {
      Authorization: `Bearer ${token}`,
    },
    body: {
      message: "deleted file",
      sha: `${Cypress.env("ShaValue")}`,
    },
  }).then((response) => {
    Cypress.env("StatusCode", response.status);
  });
});
Then("The Delete response status code should be '{word}'", (StatusCode) => {
  const sta = Cypress.env("StatusCode");
  expect(sta).to.eql(+StatusCode);
});

//again get a repository

Given("Make a GET request  with the resource '{word}'", (Resource) => {
  cy.request({
    method: "GET",
    url: baseUrl + Resource,
    headers: {
      Authorization: `Bearer ${token}`,
    },
    header: "application/json",
  }).then((response) => {
    Cypress.env("StatusCode", response.status);
    let body = JSON.parse(JSON.stringify(response.body));
    Cypress.env("MyResponse", JSON.stringify(body));
  });
});
Then("Print the response in console", () => {
  cy.log(Cypress.env("MyResponse"));
});
Then("The response status code should be '{word}'", (StatusCode) => {
  const sta = +Cypress.env("StatusCode");
  expect(sta).to.eql(+StatusCode);
});
// Make a Delete request with the resource '/repos/RavikantBadola/Team-star-catcherapirepo'

Given("Make a Delete request with the resource '{word}'", (Resource) => {
  cy.request({
    method: "DELETE",
    url: baseUrl + Resource,
    headers: {
      Authorization: `Bearer ${token}`,
    },
  }).then((response) => {
    Cypress.env("StatusCode", response.status);
  });
});
Then("The Delete response status code should be '{word}'", (StatusCode) => {
  const sta = Cypress.env("StatusCode");
  expect(sta).to.eql(+StatusCode);
});
