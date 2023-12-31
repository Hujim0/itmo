#!/bin/bash

mkdir lab0
cd lab0

touch delcatty3

touch duskull8
touch gardevoir9

mkdir hoppip4
cd hoppip4
mkdir cherubi
mkdir fraxure
touch staraptor
cd ..

mkdir murkrow9
cd murkrow9
mkdir zubat
touch sunkern
mkdir golduck
touch shinx
mkdir hippowdon
cd ..

mkdir zweilous1
cd zweilous1
mkdir hypno
mkdir carracosta
touch golbat
mkdir wurmple
mkdir armaldo
mkdir vanillite
cd ..

echo "Возможности Overland=8 Surface=6 Jump=3 Power=2" >> delcatty3
echo "Intelligence=4 Tracker=0" >> delcatty3

echo "weight=33.1 height=31.0 atk=4" >> duskull8
echo "def=9" >> duskull8

echo "Способности Mind Mold Synchronize" >> gardevoir9
echo "Trace" >> gardevoir9

cd hoppip4
echo "Живет  Forest Grassland" >> staraptor

cd ../murkrow9
echo "satk=3 sdef=3" >> sunkern
echo "spd=3" >> sunkern

echo "Возможности  Overland=6 Surface=4 Jump=2 Power=1" >> shinx
echo "Intelligence=3" >> shinx

cd ../zweilous1
echo "Способности  Supersonic Astonish Bite Wing" >> golbat
echo "Attack Confuse Ray Swift Air Cutter Acrobatics Mean Look Poison Fang">> golbat
echo "Haze Air Slash" >> golbat
cd ..

#Второй шаг

chmod u=rw,g=,o=r delcatty3
#chmod 604 delcatty3
chmod 060 duskull8
chmod 046 gardevoir9
chmod 573 hoppip4
cd hoppip4
chmod 764 cherubi
chmod 751 fraxure
chmod 440 staraptor
cd ..
chmod 771 murkrow9
cd murkrow9
chmod 512 zubat
chmod 504 sunkern
chmod 333 golduck
chmod u=rw,g=,o=r shinx
chmod 307 hippowdon
cd ..
chmod 764 zweilous1
cd zweilous1
chmod 513 hypno
chmod u=rx,g=wx,o=rwx carracosta
chmod 003 golbat
chmod 512 wurmple
chmod 777 armaldo
chmod 512 vanillite
cd ..
#Третий шаг
chmod -R 777 ../lab0

cp duskull8 murkrow9/zubat/

ln -s duskull8 murkrow9/shinxduskull

cat hoppip4/staraptor murkrow9/sunkern >> delcatty3_22

chmod -R 777 hoppip4
cp -r hoppip4 tmp
cp -r tmp hoppip4/cherubi
rm -rf tmp

ln -s zweilous1 Copy_7

ln delcatty3 hoppip4/staraptordelcatty

cp delcatty3 murkrow9/shinxdelcatty

#Четвертый шаг

wc -l murkrow9/* >&2 | sort -nr

ls -A --sort=none zweilous1/ 2>/dev/null

cat hoppip4/staraptor murkrow9/sunkern | grep -in 'e\>$' 2>/dev/null

ls -ltc hoppip4/ 2>/dev/null

cat murkrow9/* | grep 'g\>$' 2>&1

mkdir tmp
wc -l murkrow9/sunkern murkrow9/shinx >> /tmp/tmp 2>/dev/null

#Пятый шаг

chmod -R 777 ../lab0

rm -f duskull8
rm -f zweilous/golbat

rm -f zweilous1/Copy_7

rm -rf hoppip4/*

rmdir hoppip4