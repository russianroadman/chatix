plugins {
	java
	id("org.springframework.boot") version "3.4.4"
	id("io.spring.dependency-management") version "1.1.7"
    kotlin("jvm") version "2.0.10"
}

springBoot {
	mainClass.set("com.russianroadman.chatix_core.ChatixCoreApplication")
}

group = "com.russianroadman"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<Test> {
	useJUnitPlatform()
}
tasks.withType<Jar> {
	manifest {
		attributes["Main-Class"] = "com.russianroadman.chatix_core.ChatixCoreApplication"
	}
}
