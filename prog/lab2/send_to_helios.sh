#!/bin/bash

scp -P 2222 -r send_to_helios.sh bin src lib run.sh compile.sh $1@helios.cs.ifmo.ru:~/prog/lab2/