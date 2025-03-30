package com.russianroadman.chatix_core.utils

import org.springframework.core.io.DefaultResourceLoader
import java.io.BufferedInputStream
import java.io.InputStream
import java.nio.charset.StandardCharsets

object AppIoUtils {

    @JvmStatic
    fun loadResourceText(location: String): String {
        return loadResource(location) { resourceStream ->
            resourceStream.readAllBytes().toString(StandardCharsets.UTF_8)
        }
    }

    @JvmStatic
    inline fun <R> loadResource(location: String, load: (BufferedInputStream) -> R): R {
        return loadAll(DefaultResourceLoader().getResource(location).inputStream, load)
    }

    @JvmStatic
    inline fun <R> loadAll(inputStream: InputStream, load: (BufferedInputStream) -> R): R {
        return inputStream.use {
            BufferedInputStream(inputStream).use { bufferedInputStream ->
                load(bufferedInputStream)
            }
        }
    }

}