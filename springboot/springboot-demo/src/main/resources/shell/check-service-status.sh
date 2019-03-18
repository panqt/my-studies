#!/bin/bash

#while read line
#do
#echo $line
#done  < installed-service.properties

read line < installed-service.properties
echo $line
read line2 < installed-service.properties
echo $line2
if [ $line == $line2 ]
    then echo eq
    
fi

trim()
{
    trimmed=$1
    trimmed=${trimmed%% }
    trimmed=${trimmed## }


    return $trimmed
}

