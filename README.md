# API Gateway with Spring Cloud Gateway

### © 2024 | Lyes Sefiane <img src="https://raw.githubusercontent.com/wiki/lyes-sefiane/grocery-items-management-application/images/algeria-flag-icon.png" width="2%"> <img src="https://raw.githubusercontent.com/wiki/lyes-sefiane/grocery-items-management-application/images/canada-flag-icon.png" width="2%"> All Rights Reserved | [CC BY-NC-ND 4.0](https://creativecommons.org/licenses/by-nc-nd/4.0/)

[![CC BY-NC-ND 4.0][cc-by-nc-nd-image]][cc-by-nc-nd]

[cc-by-nc-nd]: http://creativecommons.org/licenses/by-nc-nd/4.0/
[cc-by-nc-nd-image]: https://licensebuttons.net/l/by-nc-nd/4.0/88x31.png
[cc-by-nc-nd-shield]: https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg

# GitHub Badges

![License](https://img.shields.io/static/v1?label=License&message=CC-BY-NC-ND-4.0&color=green)
[![Contributor Covenant](https://img.shields.io/badge/Contributor%20Covenant-2.1-4baaaa.svg)](code_of_conduct.md)
[![CodeQL](https://github.com/lyes-sefiane/api-gateway/actions/workflows/github-code-scanning/codeql/badge.svg)](https://github.com/lyes-sefiane/api-gateway/actions/workflows/github-code-scanning/codeql)
[![Automatic Dependency Submission](https://github.com/lyes-sefiane/api-gateway/actions/workflows/dependency-graph/auto-submission/badge.svg)](https://github.com/lyes-sefiane/api-gateway/actions/workflows/dependency-graph/auto-submission)
[![Java CI with Maven](https://github.com/lyes-sefiane/api-gateway/actions/workflows/maven.yml/badge.svg)](https://github.com/lyes-sefiane/api-gateway/actions/workflows/maven.yml)
[![Docker Publish](https://github.com/lyes-sefiane/api-gateway/actions/workflows/docker-publish.yml/badge.svg)](https://github.com/lyes-sefiane/api-gateway/actions/workflows/docker-publish.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=lyes-sefiane_api-gateway&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=lyes-sefiane_api-gateway)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=lyes-sefiane_api-gateway&metric=bugs)](https://sonarcloud.io/summary/new_code?id=lyes-sefiane_api-gateway)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=lyes-sefiane_api-gateway&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=lyes-sefiane_api-gateway)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=lyes-sefiane_api-gateway&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=lyes-sefiane_api-gateway)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=lyes-sefiane_api-gateway&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=lyes-sefiane_api-gateway)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=lyes-sefiane_api-gateway&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=lyes-sefiane_api-gateway)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=lyes-sefiane_api-gateway&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=lyes-sefiane_api-gateway)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=lyes-sefiane_api-gateway&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=lyes-sefiane_api-gateway)
![Docker Pulls](https://img.shields.io/docker/pulls/lsefiane/api-gateway)
![GitHub top language](https://img.shields.io/github/languages/top/lyes-sefiane/api-gateway)
![GitHub Release](https://img.shields.io/github/v/release/lyes-sefiane/api-gateway)
![GitHub Release Date](https://img.shields.io/github/release-date/lyes-sefiane/api-gateway)
![GitHub contributors](https://img.shields.io/github/contributors/lyes-sefiane/api-gateway)
![GitHub Repo stars](https://img.shields.io/github/stars/lyes-sefiane/api-gateway?style=social)

# Properties

### Redis

| Property                               | Value             |
|----------------------------------------|-------------------|
| spring.profiles.active                 | prod, test        |
| spring.application.name                | api-gateway       |
| spring.data.redis.repositories.enabled | false             |
| spring.cache.type                      | redis             |
| spring.data.redis.database             | ${REDIS_DATABASE} |
| spring.data.redis.host                 | ${REDIS_HOST}     |
| spring.data.redis.port                 | ${REDIS_PORT}     |
| spring.data.redis.password             | ${REDIS_PASSWORD} |
| spring.data.redis.timeout              | 60000             |


### Routes

| Property                                                                           | Value                       |
|------------------------------------------------------------------------------------|-----------------------------|
| spring.cloud.gateway.routes[0].id                                                  | ${ROUTE_0_ID}               |
| spring.cloud.gateway.routes[0].uri                                                 | ${ROUTE_0_URI}              |
| spring.cloud.gateway.routes[0].predicates[0]                                       | Path=${PATH}                |
| spring.cloud.gateway.routes[0].predicates[1]                                       | Method=GET,POST,PUT,DELETE  |


### Rate Limiting

| Property                                                                           | Value                  |
|------------------------------------------------------------------------------------|------------------------|
| spring.cloud.gateway.routes[0].filters[0].name                                     | RequestRateLimiter     |
| spring.cloud.gateway.routes[0].filters[0].args[redis-rate-limiter.replenishRate]   | 10                     |
| spring.cloud.gateway.routes[0].filters[0].args[redis-rate-limiter.burstCapacity]   | 20                     |
| spring.cloud.gateway.routes[0].filters[0].args[redis-rate-limiter.requestedTokens] | 1                      |
| spring.cloud.gateway.routes[0].filters[0].args[key-resolver]                       | #{@customKeyResolver}  |



### Retry

| Property                                                                     | Value               |
|------------------------------------------------------------------------------|---------------------|
| spring.cloud.gateway.routes[0].filters[1].name                               | Retry               |
| spring.cloud.gateway.routes[0].filters[1].args[retries]                      | 2                   |
| spring.cloud.gateway.routes[0].filters[1].args[statuses]                     | SERVICE_UNAVAILABLE |
| spring.cloud.gateway.routes[0].filters[1].args[methods]                      | GET,POST,PUT,DELETE |
| spring.cloud.gateway.routes[0].filters[1].args[backoff.firstBackoff]         | 10ms                |
| spring.cloud.gateway.routes[0].filters[1].args[backoff.maxBackoff]           | 50ms                |
| spring.cloud.gateway.routes[0].filters[1].args[backoff.factor]               | 3                   |
| spring.cloud.gateway.routes[0].filters[1].args[backoff.basedOnPreviousValue] | false               |


### Circuit Breaker

| Property                                                     | Value                         |
|--------------------------------------------------------------|-------------------------------|
| spring.cloud.gateway.routes[0].filters[2].name               | CircuitBreaker                |  
| spring.cloud.gateway.routes[0].filters[2].args[name]         | myCircuitBreaker              |
| spring.cloud.gateway.routes[0].filters[2].args[fallbackUri]  | forward:/service-unavailable  |


### HashiCorp Consul

| Property                                        | Value                       |
|-------------------------------------------------|-----------------------------|
| spring.cloud.consul.enabled                     | true/false                  | 
| spring.cloud.consul.host                        | ${SPRING_CLOUD_CONSUL_HOST} | 
| spring.cloud.consul.port                        | ${SPRING_CLOUD_CONSUL_PORT} | 
| spring.cloud.consul.discovery_register          | true/false                  | 
| spring.cloud.gateway.discovery.locator.enabled  | ture/false                  | 


### Zipkin

| Property                                 | Value                                 |
|------------------------------------------|---------------------------------------|
| management.tracing.enabled               | true/false                            | 
| management.zipkin.tracing.endpoint       | ${MANAGEMENT_ZIPKIN_TRACING_ENDPOINT} | 
| management.tracing.sampling.probability  | 1.0                                   | 

# CI/CD with GitHub Actions

![GitHub Release](https://img.shields.io/github/v/release/lyes-sefiane/api-gateway)
![GitHub Release Date](https://img.shields.io/github/release-date/lyes-sefiane/api-gateway)

## GitHub Actions Pipeline

<img title="GitHub Actions Pipeline" alt="GitHub Actions Pipeline" src="https://raw.githubusercontent.com/wiki/lyes-sefiane/api-gateway/images/lyes-sefiane-github-actions.PNG">


## SonarQube Cloud

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=lyes-sefiane_api-gateway&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=lyes-sefiane_api-gateway)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=lyes-sefiane_api-gateway&metric=bugs)](https://sonarcloud.io/summary/new_code?id=lyes-sefiane_api-gateway)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=lyes-sefiane_api-gateway&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=lyes-sefiane_api-gateway)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=lyes-sefiane_api-gateway&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=lyes-sefiane_api-gateway)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=lyes-sefiane_api-gateway&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=lyes-sefiane_api-gateway)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=lyes-sefiane_api-gateway&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=lyes-sefiane_api-gateway)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=lyes-sefiane_api-gateway&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=lyes-sefiane_api-gateway)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=lyes-sefiane_api-gateway&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=lyes-sefiane_api-gateway)

<img title="SonarQube Cloud" alt="SonarQube Cloud" src="https://raw.githubusercontent.com/wiki/lyes-sefiane/api-gateway/images/lyes-sefiane-sonarcloud.PNG">


## Snyk Maven Analysis

```bash

Run snyk/actions/maven-3-jdk-17@master
  with:
    command: monitor
    args: --severity-threshold=low
    json: false
  env:
    SNYK_TOKEN: ***
/usr/bin/docker run --name snyksnykmaven3jdk17_8bea9f --label 2de416 --workdir /github/workspace --rm -e "SNYK_TOKEN" -e "INPUT_COMMAND" -e "INPUT_ARGS" -e "INPUT_JSON" -e "FORCE_COLOR" -e "SNYK_INTEGRATION_NAME" -e "SNYK_INTEGRATION_VERSION" -e "HOME" -e "GITHUB_JOB" -e "GITHUB_REF" -e "GITHUB_SHA" -e "GITHUB_REPOSITORY" -e "GITHUB_REPOSITORY_OWNER" -e "GITHUB_REPOSITORY_OWNER_ID" -e "GITHUB_RUN_ID" -e "GITHUB_RUN_NUMBER" -e "GITHUB_RETENTION_DAYS" -e "GITHUB_RUN_ATTEMPT" -e "GITHUB_REPOSITORY_ID" -e "GITHUB_ACTOR_ID" -e "GITHUB_ACTOR" -e "GITHUB_TRIGGERING_ACTOR" -e "GITHUB_WORKFLOW" -e "GITHUB_HEAD_REF" -e "GITHUB_BASE_REF" -e "GITHUB_EVENT_NAME" -e "GITHUB_SERVER_URL" -e "GITHUB_API_URL" -e "GITHUB_GRAPHQL_URL" -e "GITHUB_REF_NAME" -e "GITHUB_REF_PROTECTED" -e "GITHUB_REF_TYPE" -e "GITHUB_WORKFLOW_REF" -e "GITHUB_WORKFLOW_SHA" -e "GITHUB_WORKSPACE" -e "GITHUB_ACTION" -e "GITHUB_EVENT_PATH" -e "GITHUB_ACTION_REPOSITORY" -e "GITHUB_ACTION_REF" -e "GITHUB_PATH" -e "GITHUB_ENV" -e "GITHUB_STEP_SUMMARY" -e "GITHUB_STATE" -e "GITHUB_OUTPUT" -e "RUNNER_OS" -e "RUNNER_ARCH" -e "RUNNER_NAME" -e "RUNNER_ENVIRONMENT" -e "RUNNER_TOOL_CACHE" -e "RUNNER_TEMP" -e "RUNNER_WORKSPACE" -e "ACTIONS_RUNTIME_URL" -e "ACTIONS_RUNTIME_TOKEN" -e "ACTIONS_CACHE_URL" -e "ACTIONS_RESULTS_URL" -e GITHUB_ACTIONS=true -e CI=true -v "/var/run/docker.sock":"/var/run/docker.sock" -v "/home/runner/work/_temp/_github_home":"/github/home" -v "/home/runner/work/_temp/_github_workflow":"/github/workflow" -v "/home/runner/work/_temp/_runner_file_commands":"/github/file_commands" -v "/home/runner/work/api-gateway/api-gateway":"/github/workspace" snyk/snyk:maven-3-jdk-17  "snyk" "monitor" "--severity-threshold=low"

Monitoring /github/workspace (io.github.lyes-sefiane:api-gateway)...

Explore this snapshot at https://app.snyk.io/org/lyes-sefiane/project/8bb8216c-fa31-4e01-be2d-990dc42d1e2a/history/7ecdd7e5-51dd-4481-b97e-f0a73d476b67

Notifications about newly disclosed issues related to these dependencies will be emailed to you.
```

<img title="Snyk" alt="Snyk" src="https://raw.githubusercontent.com/wiki/lyes-sefiane/api-gateway/images/lyes-sefiane-snyk-analysis.PNG">

## DockerHub

### Docker Scout

```bash

Run docker/scout-action@v1
quickview
cves
            ✓ SBOM of image already cached, 138 packages indexed
  
  
  ## Overview
  
                      │         Analyzed Image          
  ────────────────────┼─────────────────────────────────
    Target            │  ***:v1.7.13   
      digest          │  28a0e5e97111                   
      platform        │ linux/amd64                     
      vulnerabilities │    0C     0H     0M     0L      
      size            │ 211 MB                          
      packages        │ 138                             
  
  
  ## Packages and Vulnerabilities
  
    No vulnerable packages detected
  
  
recommendations


```
<img title="Docker Scout" alt="Docker Scout" src="https://raw.githubusercontent.com/wiki/lyes-sefiane/api-gateway/images/lyes-sefiane-docker-scout.PNG">

<img title="DockerHub" alt="DockerHub" src="https://raw.githubusercontent.com/wiki/lyes-sefiane/api-gateway/images/lyes-sefiane-dockerhub.PNG">


# Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.