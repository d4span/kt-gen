plugins {
    kotlin("jvm") version "1.4.0"
}

group = "org.d4span.kt-gen"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    val main = sourceSets["main"].apply { 
        kotlin.srcDir("src/main/kotlin")
    }
    
    sourceSets["test"].apply { 
        kotlin.srcDir("src/test/kotlin")
        
        dependsOn(main)
        
        dependencies {
            implementation(kotlin("test-junit"))
        }
     }
}