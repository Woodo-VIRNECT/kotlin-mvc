package com.example.mvc.controller.delete

import com.example.mvc.model.Result
import com.example.mvc.model.UserRequest
import com.example.mvc.model.UserResponse
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

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
@Validated
class DeleteApiController {

    @DeleteMapping("/delete-mapping")
    fun deleteMappingObject(
        @RequestParam name: String,

        @NotNull(message = "age 값이 누락되었음")
        @Min(value = 20, message = "age 는 20보다 커야 합니다.")
        @RequestParam age: Int
    ): String {
        return name + "" + age
    }

    @DeleteMapping("/delete-mapping/name/{name}/age/{age}")
    fun deleteMappingPath(@Size(min = 2, max = 10, message = "name 길이는 2에서 10사이입니다.")
                          @NotNull(message = "name 값이 누락되었음")
                          @PathVariable name:String,

                          @NotNull(message = "age 값이 누락되었음")
                          @Min(value = 20, message = "age 는 20보다 커야 합니다.")
                          @PathVariable age: Int):String{
        return name + "" + age
    }
}