package com.example.mvc.controller.post

import com.example.mvc.model.UserRequest
import org.springframework.web.bind.annotation.PostMapping
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
class PostApiController {

    @PostMapping("/post-mapping/object")
    fun postMappingObject(@RequestBody userRequest: UserRequest): UserRequest {
        // json -> object
        println(userRequest);

        // object -> json
        return userRequest;
    }
}