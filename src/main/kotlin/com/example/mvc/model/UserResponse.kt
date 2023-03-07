package com.example.mvc.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

/**
 * Project        : mvc
 * DATE           : 2023/03/03
 * AUTHOR         : dnejdzlr2 (Woodo Lee)
 * EMAIL          : dnejdzlr2@virnect.com
 * DESCRIPTION    :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/03/03      dnejdzlr2          최초 생성
 */
data class UserResponse(
    var result:Result?=null,
    var description:String?=null,

    @JsonProperty("user")
    var userRequest:MutableList<UserRequest>?=null,
)

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class Result(
    var resultCode:String?=null,
    var resultMessage:String?=null,
)