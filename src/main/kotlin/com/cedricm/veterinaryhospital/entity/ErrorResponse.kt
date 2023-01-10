package com.cedricm.veterinaryhospital.entity

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.http.HttpStatus
import java.util.*

class ErrorResponse(
  status: HttpStatus,
  var message: String,
  var stacktrace: String? = null,
) {
  var code: Int
  var status: String
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  val timestamp: Date = Date()

  init {
    code = status.value()
    this.status = status.name
  }
}