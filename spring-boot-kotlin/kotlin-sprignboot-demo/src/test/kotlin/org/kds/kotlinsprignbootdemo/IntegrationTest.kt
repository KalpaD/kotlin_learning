package org.kds.kotlinsprignbootdemo

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.CoreMatchers.*
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IntegrationTest(@Autowired val restTemplate: TestRestTemplate) {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @BeforeAll
    fun setUp() {
        log.info(">> setting up")
    }

    @Test
    fun `assert response content`() {
        val entitiy = restTemplate.getForEntity<List<Message>>("/")
        assertThat(entitiy.statusCode, `is`(HttpStatus.OK))
    }

    @AfterAll
    fun tearDown() {
        log.info(">> Tear down")
    }

}