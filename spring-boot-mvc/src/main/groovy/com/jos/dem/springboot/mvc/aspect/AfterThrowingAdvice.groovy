package com.jos.dem.springboot.mvc.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.AfterThrowing
import org.springframework.stereotype.Component
import com.jos.dem.springboot.mvc.exception.BusinessException

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Aspect
@Component
class AfterThrowingAdvice {

  Logger log = LoggerFactory.getLogger(this.class)

  @AfterThrowing(pointcut = "execution(* com.jos.dem.springboot.mvc.service..**.*(..))", throwing = "ex")
  void doRecoveryActions(RuntimeException ex){
    log.info "Wrapping exception: ${ex}"
    throw new BusinessException(ex.message, ex)
  }

}

