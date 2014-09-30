# Functional Programming in Scala

This repository hosts my solutions to the exercises of the book
[Functional Programming in Scala, from Manning Publications](http://www.manning.com/bjarnason/).

The list of exercises and the official solutions can be found at https://github.com/fpinscala/fpinscala

## Status

Crossed examples are finished and included in the repository.

All the rest of exercises are not done yet.

You can find the examples at
[`src/main/scala`](https://github.com/iht/fpinscala/tree/master/src/main/scala/),
with a directory (Scala package) for each book chapter.

### Chapter 2

* ~~Exercise 2.1~~
* ~~Exercise 2.2~~
* ~~Exercise 2.3~~
* ~~Exercise 2.4~~
* ~~Exercise 2.5~~

### Chapter 3

* Exercise 3.2
* Exercise 3.3
* Exercise 3.4
* Exercise 3.5
* Exercise 3.6
* Exercise 3.9
* Exercise 3.10
* Exercise 3.11
* Exercise 3.12
* Exercise 3.13
* Exercise 3.14
* Exercise 3.15



## How to run the exercises

You will need [sbt](http://www.scala-sbt.org/) to run the exercises.

To compile the exercises, simply run

```
> compile
```

If it's the first time, it will download all the necessary dependencies.

To run the exercises in sbt, use
```
>  runMain package_name.object_name args
```

For instance
```
> runMain chap2.Ex02 5
```

Not all exercises can be run as applications. To check the output for
some input values of all the exercises, you can add cases to the tests.

## Tests

For each one of the exercises, I try to provide a test. Tests are
stored in the directory [`src/test/scala`](https://github.com/iht/fpinscala/tree/master/src/test/scala/), and you can reuse them for
your exercises.

To run the tests, simply execute the following in sbt
```
> test
```

## License

All the code hosted in this repository is distributed under the MIT
license. See [the
license](https://github.com/iht/fpinscala/blob/master/LICENSE) for
more details.
