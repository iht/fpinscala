// Copyright (c) 2014-2016 Israel Herraiz <isra@herraiz.org>
// 
// Permission is hereby granted, free of charge, to any person
// obtaining a copy of this software and associated documentation
// files (the "Software"), to deal in the Software without
// restriction, including without limitation the rights to use, copy,
// modify, merge, publish, distribute, sublicense, and/or sell copies
// of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be
// included in all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
// EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
// MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
// BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
// ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
// CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.  

name := "Functional Programming in Scala - Solutions to the exercises"

version := "0.1"

licenses += "MIT" -> url("https://github.com/iht/fpinscala/blob/master/LICENSE")

description := "Solutions to the exercises of the book Functional Programming in Scala, from Manning Publications."

homepage := Some(url("https://github.com/iht/fpinscala/"))

startYear := Some(2014)

scalaVersion := "2.13.0"

libraryDependencies += "org.specs2" %% "specs2-core" % "4.7.1" % "test"

scalacOptions in Test ++= Seq("-Yrangepos")


resolvers ++= Seq(Resolver.sonatypeRepo("releases"),
                  Resolver.sonatypeRepo("snaspshots"))
