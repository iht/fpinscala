# Functional programming in Scala

This repository hosts my solutions to the exercises of the book
[Functional Programming in Scala, from Manning Publications](http://www.manning.com/bjarnason/).

The list of exercises and the official solutions can be found at https://github.com/fpinscala/fpinscala

Solution to the exercises of Functional Programming in Scala, from Mannig Publications

## Status

Crossed examples are finished and included in the repository.

All the rest of exercises are not done yet.

### Chapter 2

* ~~Example 2.1~~
* Example 2.2 

## How to run the examples

You will need [sbt](http://www.scala-sbt.org/) to run the examples.

To compile the examples, simply run

```
> compile
```

If it's the first time, it will download all the necessary dependencies.

To run the exapmles in sbt, use
```
>  runMain package_name.class_name args
```

For instance
```
> runMain chap2.FibonacciApp 5
```

## Tests

For each one of the examples, I try to provide a test. Tests are
stored in the directory `src/test/scala`, and you can reuse them for
your examples.

To run the tests, simply execute the following in sbt
```
> test
```
