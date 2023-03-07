package com.example.mvc.controller.page

import com.example.mvc.model.UserRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Project        : mvc
 * DATE           : 2023/03/07
 * AUTHOR         : dnejdzlr2 (Woodo Lee)
 * EMAIL          : dnejdzlr2@virnect.com
 * DESCRIPTION    :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/03/07      dnejdzlr2          최초 생성
 */
@Controller
class PageController {

    @GetMapping("/main")
    fun main(): String {
        println("init main")
        return "main.html"
    }

    @ResponseBody
    @GetMapping("/test")
    fun response(): UserRequest {
        // @ResponseBody : RestController 가 아닌 곳(controller) 에서 JSON 응답을 내릴때 사용한다.
        return UserRequest().apply {
            this.name = "steve"
            this.phoneNumber = "11222331"
        }

    }

}