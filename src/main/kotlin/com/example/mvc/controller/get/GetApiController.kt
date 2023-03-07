package com.example.mvc.controller.get

import com.example.mvc.model.UserRequest
import org.springframework.web.bind.annotation.*

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
class GetApiController {

    @GetMapping("/hello")
    fun hello(): String {
        return "hello kotlin"
    }

    @GetMapping("/get-mapping/path-variable/{name}")
    fun pathVariable(@PathVariable name: String): String {
        println("name = [${name}]")
        return name;
    }

    @GetMapping("/get-mapping/query-param")
    fun queryParam(
        @RequestParam name: String,
        @RequestParam age: Int,
    ): String {
        return name + " " + age;
    }

    @GetMapping("/get-mapping/query-param-object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println("userRequest = ${userRequest}")
        return userRequest;
    }

    @GetMapping("/get-mapping/query-param-map")
    fun queryParamMap(@RequestParam map : Map<String, Any>): Map<String, Any> {
        println("map = ${map}")
        return map;
    }
}