package com.example.mvc.controller.delete

import com.example.mvc.model.Result
import com.example.mvc.model.UserRequest
import com.example.mvc.model.UserResponse
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
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
class DeleteApiController {

    @DeleteMapping("/delete-mapping")
    fun deleteMappingObject(
        @RequestParam name: String,
        @RequestParam age: Int
    ): String {
        return name + "" + age
    }

    @DeleteMapping("/delete-mapping/name/{name}/age/{age}")
    fun deleteMappingPath(@PathVariable name:String, @PathVariable age: Int):String{
        return name + "" + age
    }
}