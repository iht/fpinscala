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

| **Chapter/Exercise** | **Solution** | **Test** |
| ---------------- | ---- | ---- |
| *Ch. 2*          |      |      |
| ~~Ex. 2.1~~| [Code](https://github.com/iht/fpinscala/blob/master/src/main/scala/chap02/ex01.scala) | [Test](https://github.com/iht/fpinscala/blob/master/src/test/scala/chap02/ex01.scala)|
| ~~Ex. 2.2~~|[Code](https://github.com/iht/fpinscala/blob/master/src/main/scala/chap02/ex02.scala) | [Test](https://github.com/iht/fpinscala/blob/master/src/test/scala/chap02/ex02.scala)|
| ~~Ex. 2.3~~|[Code](https://github.com/iht/fpinscala/blob/master/src/main/scala/chap02/ex03.scala) | [Test](https://github.com/iht/fpinscala/blob/master/src/test/scala/chap02/ex03.scala)|
| ~~Ex. 2.4~~|[Code](https://github.com/iht/fpinscala/blob/master/src/main/scala/chap02/ex04.scala) | [Test](https://github.com/iht/fpinscala/blob/master/src/test/scala/chap02/ex04.scala)|
| ~~Ex. 2.5~~|[Code](https://github.com/iht/fpinscala/blob/master/src/main/scala/chap02/ex04.scala) | [Test](https://github.com/iht/fpinscala/blob/master/src/test/scala/chap02/ex04.scala)|
| *Ch. 3*            |      |      |
| Ex. 3.2 |   |   |
| Ex. 3.3 |   |   |
| Ex. 3.4 |   |   |
| Ex. 3.5 |   |   |
| Ex. 3.6 |   |   |
| Ex. 3.9 |   |   |
| Ex. 3.10|   |   |
| Ex. 3.11|   |   |
| Ex. 3.12|   |   |
| Ex. 3.13|   |   |
| Ex. 3.14|   |   |
| Ex. 3.15|   |   |




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
