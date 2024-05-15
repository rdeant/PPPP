#!/bin/bash -ex
javac -d bin src/Gen.java
java -cp bin Gen
