package com.russianroadman.chatix_core.service

import com.russianroadman.chatix_core.utils.AppCastUtils
import com.russianroadman.chatix_core.utils.AppQueryUtils
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Service

@Service
class AppQueryService(
    private val em: EntityManager
) {

    /**
     * Метод для пагинации запроса, и применения функции на каждую из частей
     * @param typedQuery запрос
     * @param type тип результата запроса
     * @param pageSize размер страницы для пагинации
     * @param action функция, которая будет выполнена с каждой частью результата запроса в качестве параметра
     */
    fun <T : Any> paginatedQueryWithAction(
        typedQuery: String,
        type: Class<T>,
        pageSize: Int,
        action: (List<T>) -> Unit
    ) {
        var pageNumber = 0
        var result: List<T>
        do {
            result = em
                .createQuery(typedQuery, type)
                .setFirstResult(pageNumber * pageSize)
                .setMaxResults(pageSize)
                .resultList
            action(result)
            pageNumber++
        } while (result.size >= pageSize)
    }

    /**
     * Метод для пагинации запроса
     * @param typedQuery запрос
     * @param type тип результата запроса
     * @param pageSize размер страницы для пагинации
     * @return список страниц запроса
     */
    fun <T : Any> paginatedQuery(typedQuery: String, type: Class<T>, pageSize: Int): List<List<T>> {
        var pageNumber = 0
        val resultList = mutableListOf<List<T>>()
        var result: List<T>
        do {
            result = em
                .createQuery(typedQuery, type)
                .setFirstResult(pageNumber * pageSize)
                .setMaxResults(pageSize)
                .resultList
            resultList.add(result)
            pageNumber++
        } while (result.size >= pageSize)
        return resultList
    }

    /**
     * Выполняет нативный SQL запрос и приводит результат запроса к списку объектов заданного типа.
     *
     * @param sql нативный SQL запрос
     * @param type тип к которому нужно привести каждый элемент списка
     * @param params параметры запроса
     * @return список объектов заданного типа
     */
    fun <T : Any> executeResultList(sql: String, type: Class<T>, params: Map<String, Any>): List<T> {
        val fixedQuery = AppQueryUtils.escapeQueryColons(sql, params.keys)
        val query = em.createNativeQuery(fixedQuery)
        params.forEach {
            query.setParameter(it.key, it.value)
        }
        return query
            .resultList
            .map {
                AppCastUtils.toDto(type, it as Array<*>)
            }
    }

    /**
     * Выполняет нативный SQL запрос и приводит результат запроса к списку объектов заданного типа.
     *
     * @param queryName имя запроса из [AppQueryUtils.SQL_DEFAULT_LOCATION]
     * @param type тип к которому нужно привести каждый элемент списка
     * @param params параметры запроса
     * @return список объектов заданного типа
     */
    fun <T : Any> executeResultListByQueryName(queryName: String, type: Class<T>, params: Map<String, Any>): List<T> {
        return executeResultList(
            AppQueryUtils.getQuery(queryName),
            type,
            params
        )
    }

    /**
     * Выполняет нативный SQL запрос и приводит результат запроса в заданный тип
     *
     * @param sql нативный SQL запрос
     * @param entity тип к которому нужно привести результат
     * @param params параметры запроса
     * @return объект заданного типа
     */
    fun <T : Any> executeSingleResult(sql: String, entity: Class<T>, params: Map<String, Any>): T {
        return executeResultList(sql, entity, params).first()
    }

    /**
     * Выполняет нативный SQL запрос и приводит результат запроса в заданный тип
     *
     * @param sql нативный SQL запрос
     * @param entity тип к которому нужно привести результат
     * @param params параметры запроса
     * @return объект заданного типа
     */
    fun <T : Any> executeSingleResultOptional(sql: String, entity: Class<T>, params: Map<String, Any>): T? {
        return executeResultList(sql, entity, params).firstOrNull()
    }

}