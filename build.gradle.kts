val kotlinVersion = "1.2.30"
val seleniumVersion = "3.11.0"

plugins {
    kotlin("jvm").version("1.2.30")
    id("com.atlassian.performance.tools.gradle-release").version("0.4.0")
}

dependencies {
    compile("com.atlassian.performance.tools:jira-actions:0.0.1")
    compile("com.github.stephenc.jcip:jcip-annotations:1.0-1")
    compile("org.jetbrains.kotlin:kotlin-stdlib-jre8:$kotlinVersion")
    compile("org.glassfish:javax.json:1.1")
    compile("org.apache.commons:commons-math3:3.6.1")
    compile("org.seleniumhq.selenium:selenium-support:$seleniumVersion")
    compile("org.seleniumhq.selenium:selenium-chrome-driver:$seleniumVersion")
    log4j(
        "api",
        "core",
        "slf4j-impl"
    ).forEach { compile(it) }
    testCompile("junit:junit:4.12")
}

fun log4j(
    vararg modules: String
): List<String> = modules.map { module ->
    "org.apache.logging.log4j:log4j-$module:2.10.0"
}

val wrapper = tasks["wrapper"] as Wrapper
wrapper.gradleVersion = "4.9"
wrapper.distributionType = Wrapper.DistributionType.ALL