[![Build status](https://travis-ci.org/iht/fpinscala.svg?branch=master)](https://travis-ci.org/iht/fpinscala)
[![Coverage Status](https://coveralls.io/repos/github/iht/fpinscala/badge.svg?branch=master)](https://coveralls.io/github/iht/fpinscala?branch=master)

# Functional Programming in Scala

This repository hosts my solutions to the exercises of the book
[Functional Programming in Scala, from Manning Publications](http://www.manning.com/bjarnason/).

The list of exercises and the official solutions can be found at https://github.com/fpinscala/fpinscala

## Status

* [Completion status of the exercises](https://github.com/iht/fpinscala/blob/master/doc/status.md)

You can find the examples at
[`src/main/scala`](https://github.com/iht/fpinscala/tree/master/src/main/scala/),
with a directory (Scala package) for each book chapter.

## Tests

For each one of the exercises, I provide a test. Tests are
stored in the directory [`src/test/scala`](https://github.com/iht/fpinscala/tree/master/src/test/scala/), and you can reuse them for
your exercises.

You will need [sbt](http://www.scala-sbt.org/) to run the tests and compile the exercises.

To compile the exercises before running the tests, simply run

```
> compile
```

If it's the first time, it will download all the necessary dependencies (basically, the [Scala Specs2 library](http://etorreborre.github.io/specs2/)).

To run all the tests, simply execute the following in sbt
```
> test
```

To run a specific test, execute
```
> testOnly chapXX.ExYYSpec
```
where `XX` is the chapter number, and `YY` is the exercise number. For
instance
```
> testOnly chap03.Ex10Spec
```

## How to run (some of) the exercises

Some of the exercises can also be run as standalone applications.

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


## License

All the code hosted in this repository is distributed under the MIT
license. See [the
license](https://github.com/iht/fpinscala/blob/master/LICENSE) for
more details.
