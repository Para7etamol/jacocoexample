Jacoco-Maven-JEE-Weblogic-Showcase
==================================

Jacoco
------
Version: 0.8.0


Weblogic-Configuration
----------------------

Weblogic-Version: 12.1.3

### Configure 

If not existent, create setUserOverrides.sh in \<your-domain\>/bin.

Add to setUserOverrides.sh:

~~~
export EXTRA_JAVA_PROPERTIES="-javaagent:lib/org.jacoco.agent-0.8.0-runtime.jar=output=tcpserver,address=*,port=6301,includes=com.example.jacoco.*"
~~~

Add org.jacoco.agent-0.8.0-runtime.jar to \<your-domain\>/lib.

You can get the agent from

http://search.maven.org/#search|ga|1|g%3Aorg.jacoco


### Checking configuration

Firstly after starting the weblogic domain the console output of weblogic must contain something about jacoco like this:

Starting WLS with line:
/usr/lib/jvm/default-java/bin/java -server -Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=8453,server=y,suspend=n -Djava.compiler=NONE  -Xms6000m -Xmx8000m -XX:MaxPermSize=1024m -Dweblogic.Name=AdminServer -Djava.security.policy=/opt/Oracle_Weblogic/wls12130/wlserver/server/lib/weblogic.policy  -Xverify:none -Djava.endorsed.dirs=/usr/lib/jvm/jdk1.8.0_144/jre/lib/endorsed:/opt/Oracle_Weblogic/wls12130/oracle_common/modules/endorsed  -ea -da:com.bea... -da:javelin... -da:weblogic... -ea:com.bea.wli... -ea:com.bea.broker... -ea:com.bea.sbconsole... -Dwls.home=/opt/Oracle_Weblogic/wls12130/wlserver/server -Dweblogic.home=/opt/Oracle_Weblogic/wls12130/wlserver/server  -Djava.security.egd=file:/dev/./urandom -Xloggc:logs/GCLogs.log -XX:+PrintGCDetails -XX:+PrintGCTimeStamps __-javaagent:lib/org.jacoco.agent-0.8.0-runtime.jar=destfile=/tmp/jacoco.exec,output=tcpserver,address=*,port=6301,includes=com.stucho.*,de.creditreform.*,jmx=true__ -Dlog4j.configuration=file:/home/os/work/Projekte/crefoteam/cti-testumgebung/systeme/weblogic-ct/weblogictool/domains/ctDomain/properties/log4j.properties   -Dweblogic.utils.cmm.lowertier.ServiceDisabled=true -Dlaunch.main.class=weblogic.Server -Dlaunch.class.path=\<REMOVED\> -Dlaunch.complete=weblogic.store.internal.LockManagerImpl -cp /opt/Oracle_Weblogic/wls12130/wlserver/server/lib/pcl2.jar  com.oracle.classloader.launch.Launcher 


Another way to check, if jacocoagent is running is to telnet to the port (e.g. localhost:6301).

You can event get the coverage data using an cli-jar:

~~~
java -jar jacococli.jar dump --address localhost --port 6301 --destfile jacoco.exec
~~~

Again you can get the cli-jar from

http://search.maven.org/#search|ga|1|g%3Aorg.jacoco


Links
-----

http://www.eclemma.org/jacoco/


