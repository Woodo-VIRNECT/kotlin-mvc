package com.example.mvc.annotation

import com.example.mvc.validator.StringFormatDateTimeValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

/**
 * Project        : mvc
 * DATE           : 2023/03/08
 * AUTHOR         : dnejdzlr2 (Woodo Lee)
 * EMAIL          : dnejdzlr2@virnect.com
 * DESCRIPTION    :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/03/08      dnejdzlr2          최초 생성
 */
@Constraint(validatedBy = [StringFormatDateTimeValidator::class])
/* StringFormatDateTimeValidator 을 이용해서 검증한다  */
@Target(
    /* filed, getter, setter 에 관해서 pattern 정의 한다 */
    AnnotationTarget.FIELD,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME) /* 런타임에서 발생하도록 */
@MustBeDocumented
annotation class StringFormatDateTime(
    val pattern: String = "yyyy-MM-dd HH:mm:ss",
    val message: String = "시간 형식이 유효하지 않습니다",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
)