#!/usr/bin/env bash
read line < installed-service.conf
echo $line
read line2 < installed-service.conf
echo $line2

if [ $line == $line2 ]
    then echo eq
if [ $line != $line2 ]
    then echo ne
fi
fi
trim()
{
    trimmed=$1
    trimmed=${trimmed%% }
    trimmed=${trimmed## }


    return $trimmed
}

exit 0