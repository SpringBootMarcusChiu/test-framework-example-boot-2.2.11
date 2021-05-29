## @SpringBootConfiguration

@SpringBootConfiguration indicates that a class provides Spring Boot application @Configuration. Can be used as an
alternative to the Spring's standard @Configuration annotation so that configuration can be found automatically (for
example in tests)

An application should only ever include one @SpringBootConfiguration and most idiomatic Spring Boot applications will
inherit it from @SpringBootApplication