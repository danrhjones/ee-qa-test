# Equal Experts QA test


## Choice of tools

For this project, I used the [Serenity](https://serenity-bdd.info/) framework. 

It has built in support for dependency injection, it uses Rest Assured, the reporting works out of the box, and I like the way that it supports the [Screenplay pattern](https://serenity-bdd.github.io/theserenitybook/latest/serenity-screenplay.html), which in, my opinion, makes step defs easy to read

## Run the tests

### To run the tests locally

clone the repo
then run `mvn verify`

To view the report, open `./target/site/serenity/index.html` in a browser 

## CI

I have added a basic CircleCi config, and the runs can be found [here](https://app.circleci.com/pipelines/github/danrhjones/ee-qa-test)

## Manual tests

Serenity allows you to flag cucumber scenarios as manual tests. This allows them to be included in the report and still be considered as part of the 'single source of truth'

These tests are tagged with `@manual`

Some of these are failing tests, as, in the absence of requirements, I made some assumptions about how the site should work

## Possible bugs found

Some possible bugs are listed in [here](Problems.md)
