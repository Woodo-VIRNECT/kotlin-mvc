package com.example.mvc.model

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

/**
 * Project        : mvc
 * DATE           : 2023/02/23
 * AUTHOR         : dnejdzlr2 (Woodo Lee)
 * EMAIL          : dnejdzlr2@virnect.com
 * DESCRIPTION    :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/02/23      dnejdzlr2          최초 생성
 */
data class UserRequest(
    var name:String?=null,
    var age:Int?=null,
    var address:String?=null,
    var email:String?=null,
    var phoneNumber:String?=null
)
