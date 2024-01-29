#!/bin/bash

rm -rf bin/*

javac -d bin src/*/*.java src/*/*/*.java src/*/*/*/*.java -cp lib/*.jar

echo "Manifest-Version: 1.0" >> bin/MANIFEST.mf
echo "Main-Class: application/Main" >> bin/MANIFEST.mf
echo -n "Class-Path: " >> bin/MANIFEST.mf
echo -n "../" >> bin/MANIFEST.mf
ls lib/*.jar >> bin/MANIFEST.mf

jar -cvfm bin/Main.jar bin/MANIFEST.mf -C bin .