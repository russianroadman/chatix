package com.russianroadman.chatix_core.utils

object AppQueryUtils {

    const val SQL_DEFAULT_LOCATION = "classpath:sql"
    const val SQL_EXTENSION = ".sql"

    /**
     * Получить текст запроса из sql-файла с указанием пути к ресурсу
     *
     * @param name имя файла, расширение не указывается
     * @param location расположение ресурса
     * @return текст запроса, загруженный из ресурса
     */
    fun getQuery(name: String, location: String): String {
        return AppIoUtils.loadResourceText("$location/$name$SQL_EXTENSION")
    }

    /**
     * Получить текст запроса из sql-файла
     * Путь к ресурсу используется по умолчанию
     *
     * @param name имя файла, расширение не требуется
     * @return текст запроса, загруженный из ресурса
     *
     * @see AppQueryUtils.SQL_DEFAULT_LOCATION
     */
    fun getQuery(name: String): String {
        return getQuery(withoutFileExtension(name), SQL_DEFAULT_LOCATION)
    }

    /**
     * Получить текст запроса из sql-файла с указанием пути к ресурсу
     *
     * @param clazz класс, [Class.getSimpleName] которого совпадает с именем файла
     * @param location расположение ресурса
     * @return текст запроса, загруженный из ресурса
     */
    fun getQueryForClass(clazz: Class<*>, location: String): String {
        return getQuery(clazz.simpleName, location)
    }

    /**
     * Получить текст запроса из sql-файла
     * Путь к ресурсу используется по умолчанию
     *
     * Пример использования внутри kotlin класса для вставки sql-скрипта из файла с таким же названием как и сам класс:
     *
     * `AppQueryUtils.getQueryForClass(javaClass)`
     *
     * @param clazz класс, [Class.getSimpleName] которого совпадает с именем файла
     * @return текст запроса, загруженный из ресурса
     *
     * @see AppQueryUtils.SQL_DEFAULT_LOCATION
     */
    fun getQueryForClass(clazz: Class<*>): String {
        return getQuery(clazz.simpleName)
    }

    /**
     * Эскейпит все двоедочия в запросе, кроме двоеточий перед параметрами запроса
     * @param query текст запроса
     * @param paramNames список параметров запроса
     * @param escapeWith эскейп-символ, который будет подставлен перед двоеточиями, по умолчанию "\"
     */
    fun escapeQueryColons(query: String, paramNames: Iterable<String>, escapeWith: String = "\\"): String {
        var escaped = query
            .replace(":", "$escapeWith:")
        paramNames.forEach {
            escaped = escaped.replace("$escapeWith:$it", ":$it")
        }
        return escaped
    }

    /**
     * Убрать расширение файла из названия
     * @param fileName имя файла
     * @param extension расширение которое нужно убрать (без точки), по умолчанию sql
     * @return имя файла без расширения, если оно есть
     */
    private fun withoutFileExtension(fileName: String, extension: String = "sql"): String {
        return fileName.replace(".$extension", "")
    }

}
