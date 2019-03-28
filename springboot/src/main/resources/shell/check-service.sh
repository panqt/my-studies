#!/bin/sh
# ##和%% http://www.cnblogs.com/pmars/archive/2013/02/17/2914444.html
echo "#!/bin/sh">/usr/java/restart-service.sh
chmod +x /usr/java/restart-service.sh

while read line
do
        if [ "$(ps -ef | grep "${line##*"#"}"| grep -v grep )" == "" ]
                then
                        echo "${line%%"#"*}停了"
                        echo "service ${line%%"#"*} start">>/usr/java/restart-service.sh
        fi
done < /usr/java/installed-service.conf

echo "echo \"\">/usr/java/restart-service.sh">>/usr/java/restart-service.sh
exit 0
