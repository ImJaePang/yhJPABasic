plugins {
    java
    // 최신 스프링/자바 환경에서 필수적인 플러그인들입니다.
    id("org.springframework.boot") version "3.2.5" apply false
    id("io.spring.dependency-management") version "1.1.4" apply false
}

group = "jpabook"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // JPA 하이버네이트 (강의 내용을 21버전에서 돌리기 위한 최신 버전)
    implementation("org.hibernate.orm:hibernate-core:6.4.4.Final")

    // H2 데이터베이스
    runtimeOnly("com.h2database:h2:2.2.224")

    // 테스트를 위한 설정
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}