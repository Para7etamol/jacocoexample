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




Links
-----

http://www.eclemma.org/jacoco/


