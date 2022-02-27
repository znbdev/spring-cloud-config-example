[![Build Status](https://travis-ci.org/ericdahl/spring-cloud-config-example.svg)](https://travis-ci.org/ericdahl/spring-cloud-config-example)

# spring-cloud-config-example
basic example of using spring-cloud-config to retrieve configs from a git-backed server

## Quick Start

### Build code

```bash
git clone git@github.com:znbdev/spring-cloud-config-example.git
cd spring-cloud-config-example
mvn clean package
```

### Start Config Server

```bash
java -jar server/target/spring-cloud-config-example-server-1.0-SNAPSHOT.jar
```
### example-cloud-config-client.yml
Dev   
访问方式1:[http://localhost:8888/example-cloud-config-client/dev/master](http://localhost:8888/example-cloud-config-client/dev/master).   
访问方式2:[http://localhost:8888/example-cloud-config-client-dev.yml](http://localhost:8888/example-cloud-config-client-dev.yml).   
访问方式3:[http://localhost:8888/master/example-cloud-config-client-dev.yml](http://localhost:8888/master/example-cloud-config-client-dev.yml).

Test   
访问方式1:[http://localhost:8888/example-cloud-config-client/test/master](http://localhost:8888/example-cloud-config-client/test/master).   
访问方式2:[http://localhost:8888/example-cloud-config-client-test.yml](http://localhost:8888/example-cloud-config-client-test.yml).   
访问方式3:[http://localhost:8888/master/example-cloud-config-client-test.yml](http://localhost:8888/master/example-cloud-config-client-test.yml).

### application.yml
Dev   
访问方式1:[http://localhost:8888/application/dev/master](http://localhost:8888/application/dev/master).   
访问方式2:[http://localhost:8888/application-dev.yml](http://localhost:8888/application-dev.yml).   
访问方式3:[http://localhost:8888/master/application-dev.yml](http://localhost:8888/master/application-dev.yml).

Test   
访问方式1:[http://localhost:8888/application/test/master](http://localhost:8888/application/test/master).   
访问方式2:[http://localhost:8888/application-test.yml](http://localhost:8888/application-test.yml).   
访问方式3:[http://localhost:8888/master/application-test.yml](http://localhost:8888/master/application-test.yml).



Note: keep the server running in backround. The client app in the next step needs to connect to it.

### Start Client App
```bash
java -jar client/target/*jar
```

Load [http://localhost:8088](http://localhost:8088) to see the property from the server. 
Alternatively, you can inspect the properties and their sources from the spring-boot-actuator
endpoint at [http://localhost:8088/env](http://localhost:8088/env)

### Reload configuration from server (at runtime)

Spring Cloud Config has a `@RefreshScope` mechanism to allow beans to be reinitialized
on demand to fetch updated configuration values. The AppController on the client
has this annotation, so it will display the new config value once the refresh
endpoint is called.

```bash
curl -X POST 'http://localhost:8088/actuator/refresh'
```
