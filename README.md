# Liferay 7 Training Course Elis

![](https://travis-ci.org/amusarra/liferay-7-training-course-elis.svg?branch=master)

Questo repository contiene un workspace Liferay 7 utilizzato come materiale a supporto del corso Java Design Pattern in [ELIS](http://www.elis.org).

I requisiti minimi per eseguire la build del workspace sono:

* Oracle JDK 1.8
* Gradle 3.0

è possibile fare a meno d'installare Gradle sulla propria workstation perchè all'interno del workspace è disponibile il [Gradle Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html).

Per importare il workspace su Liferay IDE è necessario avere la versione [3.1.0 Milestone-2](https://web.liferay.com/it/downloads/liferay-projects/liferay-ide).

L'ambiente di runtime richiesto è Liferay 7 Community Edition GA3 (qualunque bundle: tomcat, wildfly, JBoss, etc.).

## 1. Cosa contiene il workspace
Il workspace contiene i seguenti moduli:

* __application-configuration__: Esempio di uno Scheduler e Listener con configurazione OSGi
* __bundle-activator__: Esempio di un Activator OSGi
* __framework-events__: Esempio di utilizzo degli eventi Liferay
* __service-builder__: Esempio completo dell'utilizzo del framework [Service Builder](https://dev.liferay.com/develop/tutorials/-/knowledge_base/7-0/what-is-service-builder)
* __service-registry__: Esempio di definizione API, implementazione, registrazione del servizio e utilizzo via Gogo Shell
* __webservices-client__: Esempio completo di un client Web Service SOAP utilizzando come framework [Apache CXF 3.x](http://cxf.apache.org)

Per utilizzare correttamente il modulo __webservices-client__ è necessario installare sulla propria istanza di Liferay il framework di Apache CXF. L'articolo [Liferay 7: Come realizzare un client SOAP con Apache CXF in OSGi Style](https://www.dontesta.it/2016/07/19/liferay-7-come-realizzare-un-client-soap-apache-cxf-osgi-style/) spiega step-by-step come installare il framework.

A seguire il dettaglio della struttura di directory del folder modules:

```
- modules
   ├── application-configuration
   │   └── scheduler-app
   ├── bundle-activator
   │   └── osgi-bundle-activator
   ├── framework-events
   │   └── lifecycle-action
   ├── service-builder
   │   └── horse
   │       ├── horse-api
   │       ├── horse-client
   │       ├── horse-service
   │       └── horse-web
   ├── service-registry
   │   ├── horse-api
   │   ├── horse-client
   │   └── horse-service
   └── webservices-client
       ├── crmservices-api
       ├── crmservices-commands
       └── crmservices-service
```

## 2. Build & deploy
Per eseguire build e deploy del workspace dalla vostra shell è necessario avere anche Git, oltre al compilatore Java 8 e Gradle (opzionale).

Il task deploy di Gradle esegue l'installazione dei bundle OSGi (jar) all'interno della directory d'installazione di Liferay definita in `gradle.properties` attraverso la proprietà `liferay.workspace.home.dir` il cui valore predefinito è `bundles`.

Opzionalmente è possibile scaricare il bundle di Liferay 7 CE GA3 eseguendo dopo il clone del repository il task gradle `initBundle`

```
$ git clone https://github.com/amusarra/liferay-7-training-course-elis.git
$ cd liferay-7-training-course-elis
$ ./gradlew deploy
```

## 3. Importazione workspace in Liferay IDE
Sicuramente per sviluppare moduli per Liferay è più conveniente che utilizziate l'ambiente integrato che Liferay mette a disposizione come plugin di Eclipse. Per importare il workspace del progetto (dopo aver fatto il clone dal repository) all'interno del Liferay IDE basta seguire la guida [Creating a liferay workspace with Liferay IDE]( https://dev.liferay.com/develop/tutorials/-/knowledge_base/7-0/creating-a-liferay-workspace-with-liferay-ide)

## 4. Riferimenti
* Esempio pratico di Abstract Factory e Java SPI [Oracle DB support for Liferay CE 7.0](https://github.com/amusarra/liferay-portal-oracledb-support)
* Esempi pratici di [Design patterns implemented in Java](https://github.com/amusarra/java-design-patterns)
* Presentazione al Liferay User Group 2016 di Bologna di [OSGi e Liferay 7](https://www.slideshare.net/amusarra/osgi-e-liferay-7)
* Presentazione su come implementare servizi [JAX-WS e JAX-RS su Liferay 7](https://www.slideshare.net/amusarra/jaxws-e-jaxrs)
* [Introduzione base dei Design Pattern in Java](https://www.slideshare.net/amusarra/corso-introduttivo-di-design-pattern-in-java-per-elis-1)
