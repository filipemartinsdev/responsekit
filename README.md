<br>

<div align="center">
<img src="images/java.png" alt="Logo" width="160pt">

<h3 align="center">Response Kit</h3> 

<p>

A simple library to create responses for REST APIs <br>
following [JSend](https://github.com/omniti-labs/jsend) standard. <br>
</p>

![Static Badge](https://img.shields.io/badge/version-0.3.4-417393?style=for-the-badge)

<br>

![Static Badge](https://img.shields.io/badge/Java-17-red?logo=openjdk)
![Static Badge](https://img.shields.io/badge/Maven-3.9-orange?logo=apachemaven)
![Static Badge](https://img.shields.io/badge/Spring_Boot-3.5-green?logo=springboot)
![Static Badge](https://img.shields.io/badge/Quarkus-3.15-blue?logo=quarkus)




</div>
️

## About

The goal of this library is to make it easier to create standard responses with an intuitive _Fluent API_. 

## Index

1. [Core library](#core-library)
2. [Spring library](#spring-library)
3. [Quarkus library](#quarkus-library)

---

## [Core library](responsekit-core/README.md)

Base library to use with any Java application. 

### Requirements

- Java 17+
- Apache Maven

### Install

Include in `pom.xml`:


````xml
<dependencies>
    <dependency>
        <groupId>io.github.filipemartinsdev</groupId>
        <artifactId>responsekit-core</artifactId>
        <version>0.3.4</version>
    </dependency>
</dependencies>
````

---

## [Spring library](responsekit-spring/README.md)

An integration library to perform idiomatic operations on Spring Based applications.

### Requirements

- Java 17+
- Spring Boot 3.5+
- Apache Maven

### Install

Include in `pom.xml`:


  ````xml
  <dependencies>
      <dependency>
          <groupId>io.github.filipemartinsdev</groupId>
          <artifactId>responsekit-spring</artifactId>
          <version>0.3.4</version>
      </dependency>
  </dependencies>
  ````

---

## [Quarkus library](responsekit-quarkus/README.md)

An integration library to perform idiomatic operations on Quarkus Based applications.

### Requirements

- Java 17+
- Quarkus 3.15+
- Apache Maven

### Install

Include in `pom.xml`:


  ````xml
  <dependencies>
      <dependency>
          <groupId>io.github.filipemartinsdev</groupId>
          <artifactId>responsekit-quarkus</artifactId>
          <version>0.3.4</version>
      </dependency>
  </dependencies>
  ````
