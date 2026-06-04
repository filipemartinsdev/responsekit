<br>

<div align="center">
<img src="images/java.png" alt="Logo" width="160pt">

<h3 align="center">Response Kit</h3>

<p>

A simple library to create responses for REST APIs <br>
following [JSend](https://github.com/omniti-labs/jsend) standard. <br>
</p>

</div>
️

## About

The goal of this library is to make it easier to create standard responses with an intuitive _Fluent API_. 

## Index

1. [Core library](#core-library)
2. [Spring library](#spring-library)
3. [Quarkus library](#quarkus-library)

---

## Core library

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
        <version>0.3.1</version>
    </dependency>
</dependencies>
````

---

## Spring library

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
          <version>0.3.1</version>
      </dependency>
  </dependencies>
  ````

---

## Quarkus library

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
          <artifactId>responsekit-spring</artifactId>
          <version>0.3.1</version>
      </dependency>
  </dependencies>
  ````
