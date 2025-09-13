# Proyecto de Automatización con Serenity BDD

Este proyecto implementa pruebas automatizadas utilizando Serenity BDD con Gradle como herramienta de construcción.

## 🚀 Tecnologías Utilizadas

- Serenity BDD - Framework de testing BDD
- Gradle - Sistema de construcción
- JUnit - Framework de testing
- Selenium WebDriver - Automatización de navegadores
- Screenplay Pattern - Patrón de diseño para pruebas
- Cucumber - BDD framework )

## 📋 Prerrequisitos

- Java JDK 8+ (Recomendado: JDK 11 o superior)
- Gradle 7+
- Navegadores Web: Chrome, Firefox, o Edge

## 📦 Instalación

1. Clonar el repositorio:
   en bash:
   git clone - https://github.com/henaojua/PruebaAutomatizacionSelenium
   cd PruebaAutomatizacionSelenium

   o realizar un fork en el repositorio: https://github.com/henaojua/PruebaAutomatizacionSelenium

Estructura del proyecto:

src/
├── main/
│   └── java/              
└── test/
    ├── java/                         
    │   ├── runners/TestRunner       
    │   ├── stepdefinitions/Caso1         
    │   ├── tasks/RealizarStep - Seleccionar opción - SeleccionarProducot    
    │   ├── userinterfaces/CheckoutPage - ConfirmacionPage - MainPage 
    │   
    └── resources/
        ├── features/      
        └── serenity.conf  

## 📋 Para el build.gradle se manejan las siguientes dependencias y configuraciones: 

buildscript {
    ext.serenityCoreVersion = '3.3.0'
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("net.serenity-bdd:serenity-gradle-plugin:$serenityCoreVersion")
        classpath "net.serenity-bdd:serenity-single-page-report:$serenityCoreVersion"
    }
}
plugins {
    id "net.serenity-bdd.serenity-gradle-plugin" version "${serenityCoreVersion}"
    id 'java'
    id 'eclipse'
    id 'idea'
}

defaultTasks 'clean','test','aggregate'
apply plugin: 'net.serenity-bdd.serenity-gradle-plugin'

group 'co.com.screenplay.project'
version '1.0-SNAPSHOT'

compileJava.options.encoding = "UTF-8"
compileTestJava.options.encoding = "UTF-8"

sourceCompatibility = 1.8
targetCompatibility = 1.8

repositories {
    mavenCentral()
}

ext {
    slf4jVersion = '1.7.7'
    serenityCoreVersion = '3.3.4'
    serenityCucumberVersion = '3.3.4'
    junitVersion = '5.8.2'
    assertJVersion = '3.22.0'
    logbackVersion = '1.2.10'
    lombokVersion = '1.18.22'
    log4jVersion = '2.17.1'
}

dependencies {
    testImplementation ("net.serenity-bdd:serenity-core:${serenityCoreVersion}"){
        exclude group: 'org.apache.groovy', module: 'groovy'
    }
    implementation "net.serenity-bdd:serenity-ensure:${serenityCoreVersion}"
    implementation "net.serenity-bdd:serenity-junit5:${serenityCoreVersion}"
    implementation "net.serenity-bdd:serenity-cucumber:${serenityCucumberVersion}"
    implementation "net.serenity-bdd:serenity-screenplay:${serenityCoreVersion}"
    implementation "net.serenity-bdd:serenity-screenplay-webdriver:${serenityCoreVersion}"
    implementation "net.serenity-bdd:serenity-screenplay-rest:${serenityCoreVersion}"
    testImplementation 'io.github.bonigarcia:webdrivermanager:5.6.3'

    implementation "org.junit.jupiter:junit-jupiter-api:${junitVersion}"
    implementation "org.junit.jupiter:junit-jupiter-engine:${junitVersion}"
    implementation "org.assertj:assertj-core:${assertJVersion}"
    implementation "ch.qos.logback:logback-classic:${logbackVersion}"

    compileOnly "org.projectlombok:lombok:${lombokVersion}"
    annotationProcessor "org.projectlombok:lombok:${lombokVersion}"
    testCompileOnly "org.projectlombok:lombok:${lombokVersion}"
    testAnnotationProcessor "org.projectlombok:lombok:${lombokVersion}"
    implementation group: 'com.github.javafaker', name: 'javafaker', version: '1.0.2'

}
test {
    useJUnitPlatform()
    testLogging.showStandardStreams = true
    systemProperties System.getProperties()
}

serenity {
    testRoot = "co.com.screenplay.project.runners"
    requirementsBaseDir = "src/test/resources/features"
    reports = ["single-page-html"]
}

gradle.startParameter.continueOnFailure = true
test.finalizedBy(aggregate)


## 📋 Para el Serenity.conf se manejan las siguientes configuraciones: 

webdriver {
    wait {
        for {
          timeouts = 15000
          element = 10000
        }
      }
  driver = chrome
  wait.for.timeout = 20000
  webdriver.chrome.driver = "C:/webdrivers/chromedriver-win64/chromedriver.exe"
  capabilities {
    browserName = "chrome"
    "goog:chromeOptions" {
      args = [
        "start-maximized",
        "--remote-allow-origins=*",
        "--no-sandbox",
        "--disable-dev-shm-usage",
        "--disable-infobars",
        "--disable-notifications",
        "--disable-extensions",
        "--lang=es",
        "incognito"
      ]
      excludeSwitches = ["enable-automation"]  # Oculta la notificación de automatización
    }
  }
}




chrome {
  preferences {
    download.default_directory = "${user.dir}/downloads"
    profile.default_content_settings.popups = 0
    credentials_enable_service = false
  }
}


headless.mode = false
chrome.headless.args = [
  "headless",
  "window-size=1920,1080",
  "--disable-gpu"
]


serenity {
  take.screenshots = FOR_FAILURES
  logging = VERBOSE
  restart.browser.for.each = scenario

}


environments {
  default {

    screen.resolution = "1920x1080"
  }
}


Ejecución del proyecto:

Dirigirse al archivo TestRunner -> Click derecho -> Run 'Test Runner'


