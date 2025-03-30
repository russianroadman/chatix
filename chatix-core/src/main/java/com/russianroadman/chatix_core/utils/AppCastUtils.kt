package com.russianroadman.chatix_core.utils

import kotlin.jvm.internal.Reflection
import kotlin.reflect.full.primaryConstructor

object AppCastUtils {

    @JvmStatic
    inline fun <reified T : Any> toDtoList(listOfArrays: List<Array<*>>): List<T> {
        return listOfArrays.map { toDto(it) }
    }

    @JvmStatic
    inline fun <reified T: Any> toDto(array: Array<*>): T {
        val constructor = T::class.constructors.first()
        val arguments = constructor.parameters.mapIndexed { index, parameter ->
            parameter to array[index]
        }
        return constructor.callBy(arguments.toMap())
    }

    @JvmStatic
    @Suppress("UNCHECKED_CAST")
    fun <T : Any> toDto(type: Class<T>, array: Array<*>): T {
        val kClass = Reflection.createKotlinClass(type)
        val constructor = kClass.primaryConstructor!!

        val arguments = constructor.parameters.mapIndexed { index, parameter ->
            parameter to array[index]
        }

        return constructor.callBy(arguments.toMap()) as T
    }

}