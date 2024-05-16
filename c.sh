#!/bin/bash -ex
javac -d bin src/rdt/PPInfo.java
javac -d bin -cp bin src/rdt/Gen.java
