package com.jos.dem.springboot.mvc.service

import javax.servlet.http.HttpServletRequest

interface LocaleService {
  String getMessage(String code, HttpServletRequest request)
}