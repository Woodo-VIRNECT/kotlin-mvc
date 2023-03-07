package com.example.mvc.controller.put

import com.example.mvc.model.Result
import com.example.mvc.model.UserRequest
import com.example.mvc.model.UserResponse
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping/object")
    fun putMappingObject(@RequestBody userRequest: UserRequest): UserResponse {
        // 0. response
        return UserResponse().apply {
            // 1. result
            this.result = Result().apply {
                    this.resultCode= "OK"
                    this.resultMessage = "성공"
                }
        }.apply {
            this.description = "~~~~~"
        }.apply {
            var userList = mutableListOf<UserRequest>()
            userList.add(userRequest)
            userList.add(UserRequest().apply {
                this.age = 1
                this.address = "www"
                this.email = "dnejdzlr2"
                this.name= "rio"
                this.phoneNumber = "2088"
            })
            userList.add(UserRequest().apply {
                this.age = 20
                this.address = "www"
                this.email = "dnejdzlr2"
                this.name= "rio2"
                this.phoneNumber = "2088"
            })
            this.userRequest = userList
        }
    }
}