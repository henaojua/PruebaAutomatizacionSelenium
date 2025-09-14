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


## 📋 Para el settings.gradle se manejan las siguientes dependencias y configuraciones: 

pluginManagement {
    repositories {
        maven { url "https://plugins.gradle.org/m2" }  // Portal de plugins
        mavenCentral()
    }
}

rootProject.name = 'PruebaAutomatizacion'

## 📋 Para el build.gradle se manejan las siguientes dependencias y configuraciones: 

plugins {
    id "net.serenity-bdd.serenity-gradle-plugin" version "4.2.34"
    id "java"
}

repositories { mavenCentral() }

ext {
    serenityVersion = "4.2.34"
}

dependencies {
    // JUnit 4 (ojo: NO serenity-junit5)
    testImplementation "junit:junit:4.13.2"
    testImplementation "net.serenity-bdd:serenity-junit:${serenityVersion}"

    testImplementation "net.serenity-bdd:serenity-screenplay:${serenityVersion}"
    testImplementation "net.serenity-bdd:serenity-screenplay-webdriver:${serenityVersion}"
    testImplementation "net.serenity-bdd:serenity-cucumber:${serenityVersion}"
}

// Quita useJUnitPlatform(); usa el runner JUnit4
test { useJUnit() }


## 📋 Para el Serenity.conf se manejan las siguientes configuraciones: 

webdriver {
  driver = chrome
  wait.for.timeout = 20000
  capabilities {
    "goog:chromeOptions" {
      args = ["start-maximized", "--no-sandbox", "--disable-dev-shm-usage", "--lang=es"]
    }
  }
}

serenity {
  take.screenshots = FOR_FAILURES
  logging = VERBOSE
  restart.browser.for.each = scenario
}


Ejecución del proyecto:

Dirigirse al archivo TestRunner -> Click derecho -> Run 'Test Runner'

Visualizacion del reporte:

Dirigirse a la carpeta target -> cucumber-reports -> cucumber.html -> Elegir el navegador para ver el reporte

IMPORTANTE:

Si en la primera ejecucion el navegador se cierra muy rapido, por favor ejecutarlo nuevamente.




