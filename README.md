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
![Docker Pulls](https://img.shields.io/docker/pulls/lsefiane/api-gateway)
![GitHub top language](https://img.shields.io/github/languages/top/lyes-sefiane/api-gateway)
![GitHub Release](https://img.shields.io/github/v/release/lyes-sefiane/api-gateway)
![GitHub Release Date](https://img.shields.io/github/release-date/lyes-sefiane/api-gateway)
![GitHub contributors](https://img.shields.io/github/contributors/lyes-sefiane/api-gateway)
![GitHub Repo stars](https://img.shields.io/github/stars/lyes-sefiane/api-gateway?style=social)

# Properties

## Redis

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


## Routes

| Property                                                                           | Value                       |
|------------------------------------------------------------------------------------|-----------------------------|
| spring.cloud.gateway.routes[0].id                                                  | ${ROUTE_0_ID}               |
| spring.cloud.gateway.routes[0].uri                                                 | ${ROUTE_0_URI}              |
| spring.cloud.gateway.routes[0].predicates[0]                                       | Path=${PATH}                |
| spring.cloud.gateway.routes[0].predicates[1]                                       | Method=GET,POST,PUT,DELETE  |


## Rate Limiting

| Property                                                                           | Value                  |
|------------------------------------------------------------------------------------|------------------------|
| spring.cloud.gateway.routes[0].filters[0].name                                     | RequestRateLimiter     |
| spring.cloud.gateway.routes[0].filters[0].args[redis-rate-limiter.replenishRate]   | 10                     |
| spring.cloud.gateway.routes[0].filters[0].args[redis-rate-limiter.burstCapacity]   | 20                     |
| spring.cloud.gateway.routes[0].filters[0].args[redis-rate-limiter.requestedTokens] | 1                      |
| spring.cloud.gateway.routes[0].filters[0].args[key-resolver]                       | #{@customKeyResolver}  |



## Retry

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


## Circuit Breaker

| Property                                                     | Value                         |
|--------------------------------------------------------------|-------------------------------|
| spring.cloud.gateway.routes[0].filters[2].name               | CircuitBreaker                |  
| spring.cloud.gateway.routes[0].filters[2].args[name]         | myCircuitBreaker              |
| spring.cloud.gateway.routes[0].filters[2].args[fallbackUri]  | forward:/service-unavailable  |


## HashiCorp Consul

| Property                                        | Value                       |
|-------------------------------------------------|-----------------------------|
| spring.cloud.consul.enabled                     | true/false                  | 
| spring.cloud.consul.host                        | ${SPRING_CLOUD_CONSUL_HOST} | 
| spring.cloud.consul.port                        | ${SPRING_CLOUD_CONSUL_PORT} | 
| spring.cloud.consul.discovery_register          | true/false                  | 
| spring.cloud.gateway.discovery.locator.enabled  | ture/false                  | 


## Zipkin

| Property                                 | Value                                 |
|------------------------------------------|---------------------------------------|
| management.tracing.enabled               | true/false                            | 
| management.zipkin.tracing.endpoint       | ${MANAGEMENT_ZIPKIN_TRACING_ENDPOINT} | 
| management.tracing.sampling.probability  | 1.0                                   | 


# Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.