package com.jetbrains.demo.exception

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@ControllerAdvice
class ApplicationExceptionsHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [
        IllegalArgumentException::class,
        IllegalStateException::class,
        DataIntegrityViolationException::class]) // It's a bad idea to handle these errors globally (is it suitable for demo?)
    fun handleRuntimeErrors(ex: Exception?, request: WebRequest?): ResponseEntity<Any?>? {
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }
}