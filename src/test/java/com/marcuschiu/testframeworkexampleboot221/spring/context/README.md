# Component

- from Spring

# @ContextConfiguration

- from Spring Test Framework
- used for Spring context
- loads an ApplicationContext for Spring integration test
- it does not enable logging or loads additional properties from application.properties (therefore use
  @SpringApplicationConfiguration or @SpringBootTest)

# @SpringApplicationConfiguration

- deprecated
- from Spring Boot
- includes @ContextConfiguration with the custom SpringApplicationContextLoader as loader
- like @ContextConfiguration but also enables logging, the loading of external properties (application.properties or
  application.yml)

# @SpringBootTest

- from Spring Boot Test
- used for Spring Boot context
- loads an ApplicationContext for Spring Boot integration test

# @SpringBootApplication

- from Spring Boot
- contains @SpringBootConfiguration & @EnableAutoConfiguration

# @Import

- from Spring

# #ComponentScan

- from Spring

# @ComponentScans

- from Spring
- used to specify multiple @ComponentScan configurations

# @Configuration

- from Spring

# @Configuration Variants

### @SpringBootConfiguration

- from Spring Boot

### @TestConfiguration

- from Spring Boot Test