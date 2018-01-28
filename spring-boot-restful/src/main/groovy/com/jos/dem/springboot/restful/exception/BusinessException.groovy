package com.jos.dem.springboot.restful.exception

class BusinessException extends RuntimeException {

  BusinessException(String message){
    super(message)
  }

  BusinessException(String message, Throwable cause){
    super(message, cause)
  }

}
