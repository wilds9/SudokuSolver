#!/bin/bash

rm -rf bin test.jar &&\
    mkdir bin &&\
    javac -cp ./bin/ -d ./bin/ src/myPackage/Copy1To2.java &&\
    javac -cp ./bin/ -d ./bin/ src/myPackage/Sudoku.java &&\
    javac -cp ./bin/ -d ./bin/ src/myPackage/Algorithm_1.java &&\
    javac -cp ./bin/ -d ./bin/ src/myPackage/Algorithm_2.java &&\
    javac -cp ./bin/ -d ./bin/ src/myPackage/Solver.java &&\
    javac -cp ./bin/ -d ./bin/ src/myPackage/myClass.java &&\
    echo "Main-Class: myPackage.myClass" > bin/manifest.mf &&\
    cd bin &&\
    jar -cvfm test.jar manifest.mf myPackage/ &&\
    cd ../ &&\
    ln -s bin/test.jar &&\
    java -jar test.jar


