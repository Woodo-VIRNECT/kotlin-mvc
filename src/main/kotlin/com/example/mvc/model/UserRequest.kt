package com.example.mvc.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.*

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

    @field:NotEmpty
    @field:Size(min = 2, max = 8)
    var name: String? = null,

    @field:PositiveOrZero // 0이상의 양수
    var age: Int? = null,

    @field:Email    // email 양식
    var email: String? = null,

    @field:NotBlank // 공백 검증
    var address: String? = null,

    @field:Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}\$")    // 정규식 검증
    var phoneNumber: String? = null,

    var createdAt: String? = null   // yyyy-MM-dd HH:mm:ss
) {

    @AssertTrue(message = "생성일자의 패턴은 yyyy-MM-dd HH:mm:ss 여야 합니다.")
    private fun inValidCreatedAt(): Boolean {
        return try {
            LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            true
        }catch (e : Exception){
            false
        }
    }

}
