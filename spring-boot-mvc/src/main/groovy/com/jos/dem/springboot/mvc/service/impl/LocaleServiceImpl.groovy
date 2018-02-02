package com.jos.dem.springboot.mvc.service.impl

import javax.servlet.http.HttpServletRequest

import org.springframework.context.MessageSource
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

import com.jos.dem.springboot.mvc.helper.LocaleResolver
import com.jos.dem.springboot.mvc.service.LocaleService

@Service
class LocaleServiceImpl implements LocaleService {

  @Autowired
  MessageSource messageSource
  @Autowired
  LocaleResolver localeResolver

  String getMessage(String code, HttpServletRequest request){
    messageSource.getMessage(code, null, localeResolver.resolveLocale(request))
  }

}