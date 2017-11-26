## How java class loading works??

**In java**, Class loading is one of the most important and
powerful mechanisms of Java language specification.

####  Let's start to understand how class are loaded in JVM.

1. First, we write a sample java source file to understand completely.
    
        package com.java.basic.classloading;
        /**
         * Created by : Rakesh Gupta on 11/26/17
         * Package : com.java.basic
         */
        public class ClassLoadingTest {
            public static void main(String[] args) {
                System.out.println("Starting Java Class Loading Test...");
                System.out.println(ClassLoadingTest.class.getDeclaredClasses());
            }
        }

2. Now compile this source using java compiler(**javac**).

    **debian:~ rakeshgupta$** javac ClassLoadingTest.java   

3. Java compiler will compile this source and create a machine 
independent class file known as **bytecode**.

4. Next, run this bytecode using java command as  

    **debian:~ rakeshgupta$** java ClassLoadingTest
5. **java** command will start a new **JVM (Java Virtual Machine)**. 
  Before loading our class **_ClassLoadingTest_** into **JVM**, Following 
  things happened.
    1. **JVM** invokes loadClass method of a java.lang.ClassLoader. ClassLoader is responsible for loading all classes in **JVM** for 
  starting application.
    2. Java class loaders are used to load classes at runtime. ClassLoader in 
      Java works on three principle: delegation, visibility and uniqueness.
        1. **_Delegation principle_** forward request of class loading to parent class loader and only loads the class, if parent is not able to find or load class.
        2. **_Visibility principle_** allows child class loader to see all the classes loaded by parent ClassLoader, but parent class loader can not see classes loaded by child.
        3. **_Uniqueness principle_** allows to load a class exactly once, which is basically achieved by delegation and ensures that child ClassLoader doesn't reload the class already loaded by parent.
 
    3. There are three default class loader used in Java.
        1. Bootstrap class loader  - *JRE/lib/rt.jar*
        2. Extensions class loader - *JRE/lib/ext or any directory denoted by java.ext.dirs*
        3. System class loader     - *CLASSPATH environment variable, -classpath or -cp option.*
    4. Apart from above class loader, there are more class loaders like 
    java.net.URLClassLoader, java.security.SecureClassLoader etc. 
    Those are all extended from java.lang.ClassLoader .
    
     **Bootstrap class loader :-** 
     Bootstrap class loader loads java’s core classes like java.lang, java.util etc.
     These are classes that are part of java runtime environment. Bootstrap class 
     loader is native implementation and so they may differ across different JVMs.
     
     **Extensions class loader :-** JAVA_HOME/jre/lib/ext contains jar packages 
     that are extensions of standard core java classes. Extensions class loader 
     loads classes from this ext folder. Using the system environment propery 
     java.ext.dirs you can add ‘ext’ folders and jar files to be loaded using 
     extensions class loader. 
     
     **System class loader :-**  Java classes that are available in the java 
     classpath are loaded using System class loader. Classes can be added in classpath 
     while running application in command as - 
     **debian:~ rakeshgupta$** java -cp /com/abc ClassLoadingTest
    
  
#### ClassLoader working procedure:


  ![Java Class Loaders](ClassLoaders.jpg?raw=true "Java Class Loader")

#### Let's check ClassLoading practically.
* Run the above class using JVM option as **_-verbose:class_** and 
check outputs.

**debian:~ rakeshgupta$** java ClassLoadingTest -verbose:class
        
        [Opened /usr/lib/jvm/java-8-oracle/jre/lib/rt.jar]
        [Loaded java.lang.Object from /usr/lib/jvm/java-8-oracle/jre/lib/rt.jar]
        
        [Loaded java.io.Serializable from /usr/lib/jvm/java-8-oracle/jre/lib/rt.jar]
        [Loaded java.lang.*]
        [Loaded java.security.*]
        [Loaded java.lang.*]
        [Loaded sun.misc.Cleaner from /usr/lib/jvm/java-8-oracle/jre/lib/rt.jar]
        [Loaded java.util.*]
        [Loaded sun.reflect.*]
        [Loaded java.lang.invoke.*]
        [Loaded java.io.*]
        [Loaded java.security.*]
        [Loaded sun.nio.cs.*]
        [Loaded java.io.*]
        
        Starting Java Class Loading Test...
        [Ljava.lang.Class;@15db9742
        
        [Loaded java.lang.Shutdown from /usr/lib/jvm/java-8-oracle/jre/lib/rt.jar]
        [Loaded java.lang.Shutdown$Lock from /usr/lib/jvm/java-8-oracle/jre/lib/rt.jar]
* Bootstrap class loader is loading internal class as- rt.jar .
* As above we can understand how classes are load by **ClassLoader** and **JVM** executes our 
class data in last after loading all necessary classes.

#### Class Self Reference
*  When a java source file is compiled to a binary class, compiler inserts a 
field into java class file. 
* It is a public static final field named ‘class’ of
    type java.lang.Class So for all java classes you can access it as
 
    **java.lang.Class classObj = ClassName.class;**
    
* Significance of this Class object is it contains a method getClassLoader() 
which returns the class loader for the class. It will return null it it was 
loaded by bootstrap class loader.

#### ClassLoader Namespace

In Java a class is uniquely identified using **_ClassLoader + Class_** as the 
same class may be loaded by two different class loaders.

    Class A loaded by ClassLoader A != Class A loaded by ClassLoader B

* It is helpful for defining different protection and access
 policies for different classloaders.
* Take an example of applet which is loaded using a different 
classloader, you would not want a third party application 
all access to your resources. So for security its important 
to maintain different namespaces.

#### How to load class explicitly in Java?
1. Java provides API to explicitly load a class by *Class.forName(classname)* 
    and *Class.forName(classname, initialized, classloader)*.
2. When we use JDBC then, we load Oracle JDBC driver explicitly as follow.
    ***Class.forName("oracle.jdbc.OracleDriver")***
     

#### User-defined class loaders

The Java class loader is written in Java. It is possible to custom class loader 
without understanding the finer details of the Java Virtual Machine. 
Every Java class loader has a parent class loader which is **_java.lang.ClassLoader_**, 
defined when a new class loader is instantiated or set to the virtual machine's system 
default class loader.

#### References
For more information visit these links.
1. [wiki/Java_Classloader](https://en.wikipedia.org/wiki/Java_Classloader)
2. [onejava/classloading](http://www.onjava.com/pub/a/onjava/2005/01/26/classloading.html?page=1)
3. [jvmjava-virtual-machine-architecture](http://ourjavaguide.blogspot.in/2012/03/jvmjava-virtual-machine-architecture.html)




