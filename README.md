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

## Snyk

### Snyk Maven Analysis

```bash
 Testing /github/workspace...

Organization:      lyes-sefiane
Package manager:   maven
Target file:       pom.xml
Project name:      com.lyes.sefiane:api-gateway
Open source:       no
Project path:      /github/workspace
Licenses:          enabled

✔ Tested 127 dependencies for known issues, no vulnerable paths found.
```

### Snyk Docker Analysis

```bash
Testing docker.io/***:main...

Organization:      lyes-sefiane
Package manager:   apk
Project name:      docker-image|docker.io/***
Docker image:      docker.io/***:main
Platform:          linux/amd64
Licenses:          enabled

✔ Tested 16 dependencies for known issues, no vulnerable paths found.

-------------------------------------------------------

Testing docker.io/***:main...

Organization:      lyes-sefiane
Package manager:   maven
Target file:       /api-gateway
Project name:      docker.io/***:main:/api-gateway
Docker image:      docker.io/***:main
Licenses:          enabled

✔ Tested 119 dependencies for known issues, no vulnerable paths found.


Tested 2 projects, no vulnerable paths were found.
```

<img title="Snyk" alt="Snyk" src="https://raw.githubusercontent.com/wiki/lyes-sefiane/api-gateway/images/lyes-sefiane-snyk.PNG">

<img title="Snyk" alt="Snyk" src="https://raw.githubusercontent.com/wiki/lyes-sefiane/api-gateway/images/lyes-sefiane-snyk-analysis.PNG">

## DockerHub

<img title="DockerHub" alt="DockerHub" src="https://raw.githubusercontent.com/wiki/lyes-sefiane/api-gateway/images/lyes-sefiane-dockerhub.PNG">


# OWASP Local Dependency-Check

```bash
[INFO] Check for updates complete (1355063 ms)
Warning:  Explicitly loaded driver org.h2.Driver from classpath; if JDBCv4 service loading is supported by the driver you should remove the dbDriver configuration
[INFO] 

Dependency-Check is an open source tool performing a best effort analysis of 3rd party dependencies; false positives and false negatives may exist in the analysis performed by the tool. Use of the tool and the reporting provided constitutes acceptance for use in an AS IS condition, and there are NO warranties, implied or otherwise, with regard to the analysis or its use. Any use of the tool and the reporting provided is at the user's risk. In no event shall the copyright holder or OWASP be held liable for any damages whatsoever arising out of or in connection with the use of this tool, the analysis performed, or the resulting report.


   About ODC: https://jeremylong.github.io/DependencyCheck/general/internals.html
   False Positives: https://jeremylong.github.io/DependencyCheck/general/suppression.html

💖 Sponsor: https://github.com/sponsors/jeremylong


[INFO] Analysis Started
[INFO] Finished Archive Analyzer (0 seconds)
[INFO] Finished File Name Analyzer (0 seconds)
[INFO] Finished Jar Analyzer (1 seconds)
[INFO] Finished Dependency Merging Analyzer (0 seconds)
[INFO] Finished Hint Analyzer (0 seconds)
[INFO] Finished Version Filter Analyzer (0 seconds)
[INFO] Created CPE Index (1 seconds)
[INFO] Finished CPE Analyzer (4 seconds)
[INFO] Finished False Positive Analyzer (0 seconds)
[INFO] Finished NVD CVE Analyzer (0 seconds)
[INFO] Finished Sonatype OSS Index Analyzer (0 seconds)
[INFO] Finished Vulnerability Suppression Analyzer (0 seconds)
[INFO] Finished Known Exploited Vulnerability Analyzer (0 seconds)
[INFO] Finished Dependency Bundling Analyzer (0 seconds)
[INFO] Finished Unused Suppression Rule Analyzer (0 seconds)
[INFO] Analysis Complete (8 seconds)
[INFO] Writing HTML report to: /home/runner/work/api-gateway/api-gateway/target/dependency-check-report.html
Warning:  

One or more dependencies were identified with known vulnerabilities in api-gateway:

spring-web-6.1.14.jar (pkg:maven/org.springframework/spring-web@6.1.14, cpe:2.3:a:pivotal_software:spring_framework:6.1.14:*:*:*:*:*:*:*, cpe:2.3:a:springsource:spring_framework:6.1.14:*:*:*:*:*:*:*, cpe:2.3:a:vmware:spring_framework:6.1.14:*:*:*:*:*:*:*, cpe:2.3:a:web_project:web:6.1.14:*:*:*:*:*:*:*) : CVE-2024-38828


See the dependency-check report for more details.


[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  23:10 min
[INFO] Finished at: 2024-11-17T02:02:32Z
[INFO] ------------------------------------------------------------------------
Error:  Failed to execute goal org.owasp:dependency-check-maven:11.1.0:check (default) on project api-gateway: 
Error:  
Error:  One or more dependencies were identified with vulnerabilities that have a CVSS score greater than or equal to '0.0': 
Error:  
Error:  spring-web-6.1.14.jar: CVE-2024-38828(8.699999809265137)
Error:  
Error:  See the dependency-check report for more details.
Error:  
Error:  
Error:  -> [Help 1]
Error:  
Error:  To see the full stack trace of the errors, re-run Maven with the -e switch.
Error:  Re-run Maven using the -X switch to enable full debug logging.
Error:  
Error:  For more information about the errors and possible solutions, please read the following articles:
Error:  [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
Error: Process completed with exit code 1.
```
<img title="DockerHub" alt="DockerHub" src="https://raw.githubusercontent.com/wiki/lyes-sefiane/api-gateway/images/owasp-dependency-check.PNG">


# Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.